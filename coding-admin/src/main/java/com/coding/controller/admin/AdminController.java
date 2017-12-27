package com.coding.controller.admin;

import com.coding.biz.service.CodingAdminService;
import com.coding.common.web.SSOUtils;
import com.coding.model.HandlerResult;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-admin
 *  文件名称: IndexController
 *  创建时间: 17-11-22 上午9:15
 *  最后更新时间： 17-11-21 下午2:48
 *   Author: mayuliang
 **************************************************************************************************/
@Controller
@RequestMapping(value = "/")
public class AdminController {

    /**
     * 日志对象
     */
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private CodingAdminService codingAdminService;

    /**
     * 后台管理登录页
     */
    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }


    /**
     * 后台管理首页
     */
    @RequestMapping(value = "/main")
    public String index(Model model, HttpServletRequest request) {
        String loginName = SSOUtils.getLoginName(request);
        Map<String, Object> param = Maps.newHashMap();
        param.put("loginName", loginName);
        List<Map<String, Object>> list = codingAdminService.queryMenuList(param);

        model.addAttribute("treeList", getTreeList(list));
        return "main";
    }

    private List<Map<String, Object>> getTreeList(List<Map<String, Object>> list) {
        List<Map<String, Object>> teeList = Lists.newArrayList();
        Map<String, List<Map<String, Object>>> temp = Maps.newHashMap();
        for (Map<String, Object> mm : list) {
            if (mm.get("MENU_TYPE").toString().equals("0")) {
                teeList.add(mm);
            }
            if (mm.get("MENU_TYPE").toString().equals("1")) {
                String menuParent = mm.get("MENU_PARENT").toString();
                List<Map<String, Object>> sub = temp.get("MENU_PARENT" + menuParent);
                if (sub == null) {
                    sub = Lists.newArrayList();
                }
                sub.add(mm);
                temp.put("MENU_PARENT" + menuParent, sub);
            }
        }
        List<Map<String, Object>> teeList2 = Lists.newArrayList();
        for (Map<String, Object> mm : teeList) {
            String menuNum = mm.get("MENU_NUM").toString();
            mm.put("items", temp.get("MENU_PARENT" + menuNum));
            teeList2.add(mm);
        }
        return teeList2;
    }

    /**
     * 后台管理欢迎页面
     */
    @RequestMapping(value = "/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    /**
     * 后台管理登录认证
     */
    @RequestMapping(value = "/notExists", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HandlerResult notExists(HttpServletRequest request, String loginName, String loginPwd, String loginCode) {
        HandlerResult result = HandlerResult.newInstance();
        return result;
    }

    /**
     * 后台管理登录认证
     */
    @RequestMapping(value = "/notLogin", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HandlerResult notLogin(HttpServletRequest request, String loginName, String loginPwd, String loginCode) {
        HandlerResult result = HandlerResult.newInstance();
        return result;
    }

    /**
     * 后台管理登录认证
     */
    @RequestMapping(value = "/loginCheck", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HandlerResult loginCheck(HttpServletRequest request, HttpServletResponse response, String loginName, String loginPwd) {
        HandlerResult result = HandlerResult.newInstance();
        Map<String, Object> param = Maps.newHashMap();
        param.put("loginName", loginName);
        param.put("loginPwd", loginPwd);
        List<Map<String, Object>> list = codingAdminService.queryCodingUser(param);
        if (list.size() > 0) {
            SSOUtils.setSSOLogin(request, response, list.get(0));
        } else {
            result.setRetCode(HandlerResult.CODE_ERROR);
            result.setResMsg("用户名或者密码不存在");
        }

        return result;
    }
}
