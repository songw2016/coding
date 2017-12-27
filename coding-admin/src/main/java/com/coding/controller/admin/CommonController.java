package com.coding.controller.admin;

import com.coding.traning.biz.service.CodingAdminService;
import com.coding.traning.common.web.SSOUtils;
import com.coding.traning.model.HandlerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping(value = "/demo")
public class CommonController {

    /**
     * 日志对象
     */
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);



    /**
     * 后台管理登录页
     */
    @RequestMapping(value = "/workbench")
    public String workbench(Model model) {
        return "demo/workbench";
    }


    /**
     * 后台管理首页
     */
    @RequestMapping(value = "/document")
    public String document(Model model, HttpServletRequest request) {

        return "demo/decument";
    }


    /**
     * 后台管理欢迎页面
     */
    @RequestMapping(value = "/table")
    public String table(Model model) {
        return "demo/table";
    }


    /**
     * 后台管理欢迎页面
     */
    @RequestMapping(value = "/form")
    public String form(Model model) {
        return "demo/form";
    }

}
