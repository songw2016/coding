package com.coding.controller;

import com.coding.common.mail.MailSenderInfo;
import com.coding.common.mail.SimpleMailSender;
import com.coding.model.HandlerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-web
 *  文件名称: IndexController
 *  创建时间: 17-11-7 下午2:27
 *  最后更新时间： 17-11-7 下午2:14
 *   Author: mayuliang
 **************************************************************************************************/
@Controller
@RequestMapping(value = "")
public class IndexController {

    /**
     * 日志对象
     */
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    /**
     * 首页介绍
     */
    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "index";
    }


    /**
     * 发送邮件
     */
    @RequestMapping(value = "/sendEmail", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HandlerResult resume(Model model, String eMail, String name, String phone, String msg) throws Exception {


        //这个类主要是设置邮件
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.139.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("18761645505@139.com");
        //您的邮箱密码
        mailInfo.setPassword("mayu5014213");
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
        // sms.sendTextMail(mailInfo);//发送文体格式
        //发送html格式
        SimpleMailSender.sendHtmlMail(mailInfo);
        return HandlerResult.newInstance();
    }


}
