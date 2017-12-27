package com.coding.controller;

import com.coding.biz.service.AlbumService;
import com.coding.common.mail.MailSenderInfo;
import com.coding.common.mail.SimpleMailSender;
import com.coding.common.utils.HttpUtils;
import com.coding.common.web.WEBApp;
import com.coding.model.HandlerResult;
import com.coding.model.UploadPicParam;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-web
 *  文件名称: AlbumController
 *  创建时间: 17-11-21 下午1:09
 *  最后更新时间： 17-11-21 上午10:02
 *   Author: mayuliang
 **************************************************************************************************/
@Controller
@RequestMapping(value = "/album")
public class AlbumController {

    /**
     * 日志对象
     */
    private static final Logger log = LoggerFactory.getLogger(AlbumController.class);
    @Autowired
    private AlbumService albumService;

    /**
     * 发送邮件
     */
    @RequestMapping(value = "/sendEmail", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HandlerResult sendEmail(Model model, String eMail, String name, String phone, String msg) throws Exception {
        //这个类主要是设置邮件
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.139.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("18761645505@139.com");
        mailInfo.setPassword("mayu5014213");//您的邮箱密码
        mailInfo.setFromAddress("18761645505@139.com");

        mailInfo.setToAddress("mayuliang@xwtec.cn");
        mailInfo.setSubject("有人需要你联系");
        StringBuffer sb = new StringBuffer();
        sb.append("<table>");
        sb.append("<th>").append("<td>姓名</td><td>邮箱</td><td>手机</td>").append("</th>");
        sb.append("<tr>").append("<td>").append(name).append("</td><td>").append(eMail).append("</td><td>").append(phone).append("</td>").append("</tr>");
        sb.append("<tr>").append("<td colspan=\"3\">").append(msg).append("</td>").append("</tr>");
        sb.append("</table>");
        mailInfo.setContent(sb.toString());
        //这个类主要来发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        sms.sendHtmlMail(mailInfo);//发送html格式
        albumService.saveSendMail(mailInfo);
        return HandlerResult.newInstance();
    }

    /**
     * 图片上传
     */
    @RequestMapping(value = "/upload/page")
    public String upload(Model model, HttpServletRequest request) {
        return "album/upload";
    }
    /**
     * 南通计师042 js042 马坝2003届 mb2003
     */
    @RequestMapping(value = "/show/{type}")
    public String show(Model model, @PathVariable String type, HttpServletRequest request) {
        String requestHeader = request.getHeader("user-agent");

        Map<String, Object> param = Maps.newHashMap();
        if (HttpUtils.isMobileDevice(requestHeader)) {
            param.put("pageSize", 3);
            param.put("pageNum", 1);
        } else {
            param.put("pageNum", 1);
            param.put("pageSize", 6);
        }
        param.put("type", type);
        PageInfo<Map<String, Object>> page = albumService.queryAlbumPage(param);
        model.addAttribute("type", type);
        model.addAttribute("total", page.getTotal());
        model.addAttribute("pageSize", page.getPageSize());
        model.addAttribute("listPic", page.getLastPage());

        return "album/simple";
    }


    /**
     */
    @RequestMapping(value = "/upload/submit", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HandlerResult submit(UploadPicParam bean, @RequestParam(value = "file", required = false) MultipartFile[] multiprtFile, HttpServletRequest request) {
        HandlerResult hr = HandlerResult.newInstance();
        List<Map<String, String>> listImagePath = Lists.newArrayList();

        String pathRoot = WEBApp.getValue("album.path") + "/" + bean.getType();
        String url = WEBApp.getValue("album.url") + "/" + bean.getType();
        for (MultipartFile mf : multiprtFile) {
            if (!mf.isEmpty()) {
                String picId = UUID.randomUUID().toString().replace("-", "");
                Map<String, String> picMap = Maps.newHashMap();
                //生成uuid作为文件名称
                //获得文件类型（可以判断如果不是图片，禁止上传）
                String contentType = mf.getContentType();
                if (contentType.startsWith("image")) {
                    if (!new File(pathRoot).exists()) {
                        new File(pathRoot).mkdirs();
                    }
                    File out = new File(pathRoot, picId + ".jpg");
                    try {
                        Thumbnails.of(mf.getInputStream()).size(800, 600).toFile(out);
                    } catch (Exception e) {
                        log.warn("文件上传失败");
                    }
                    picMap.put("F_PIC_ID", picId);
                    picMap.put("F_NAV_INDEX", bean.getIndex());
                    picMap.put("F_ITEM_TYPE", bean.getType());
                    picMap.put("F_PIC_URL", url + "/" + picId + ".jpg");
                    picMap.put("F_ITEM_TITLE", bean.getTitle());
                    picMap.put("F_ITEM_DESC", bean.getDesc());

                    listImagePath.add(picMap);
                }
            }
        }
        albumService.batchSavePic(listImagePath);
        hr.setRetObj("批量上传文件："+listImagePath.size());
        return hr;
    }

    /**
     */
    @RequestMapping(value = "/queryPicMore", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HandlerResult queryPicMore(String type, String pageNum, HttpServletRequest request) throws Exception {
        HandlerResult hr = HandlerResult.newInstance();
        String requestHeader = request.getHeader("user-agent");

        Map<String, Object> param = Maps.newHashMap();
        if (HttpUtils.isMobileDevice(requestHeader)) {
            param.put("pageSize", 3);
        } else {
            param.put("pageSize", 6);
        }
        param.put("pageNum", pageNum);
        param.put("type", type);

        PageInfo<Map<String, Object>> page = albumService.queryAlbumPage(param);
        hr.setRetObj(page);
        return hr;
    }

    /**
     * 南通计师042 js042
     * 马坝2003届 mb2003
     */
    @RequestMapping(value = "/album/simple/{type}")
    public String albumSimple(Model model, @PathVariable String type, HttpServletRequest request) {
        try {
            int total = 0;
            int pageSize = 6;
            String requestHeader = request.getHeader("user-agent");
            if (HttpUtils.isMobileDevice(requestHeader)) {
                pageSize = 3;
            }
            List<Map<String, String>> list = Lists.newArrayList();
            try {
                File dir = new File(WEBApp.getValue("album.path"), type);

                if (dir.exists()) {
                    File files[] = dir.listFiles();
                    total = files.length;
                    String url = WEBApp.getValue("album.url") + "/" + type + "/";
                    for (int i = 0; i < total && i < pageSize; i++) {
                        Map<String, String> ma = Maps.newHashMap();
                        ma.put("picUrl", url + i + ".jpg");
                        ma.put("picTitle", url + i + ".jpg");
                        ma.put("picDesc", "");
                        list.add(ma);
                    }
                } else {
                    total = 0;
                }
            } catch (Exception e) {
                total = 0;
            }

            model.addAttribute("albumUrl", WEBApp.getValue("album.url"));
            model.addAttribute("type", type);
            model.addAttribute("total", total);
            model.addAttribute("pageSize", pageSize);
            model.addAttribute("listPic", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "album/simple";
    }




    /**
     * 个人博客
     */
    @RequestMapping(value = "/blog/{path}")
    public String blog(Model model, @PathVariable String path) {
        if (StringUtils.isEmpty(path)) {
            path = "theme1";
        }
        return "blog/" + path;
    }

    /**
     * 个人简历
     */
    @RequestMapping(value = "/resume/{path}")
    public String resume(Model model, @PathVariable String path) {
        if (StringUtils.isEmpty(path)) {
            path = "theme1";
        }
        return "resume/" + path;
    }
}
