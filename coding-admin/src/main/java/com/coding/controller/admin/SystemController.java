package com.coding.controller.admin;

import com.coding.traning.biz.service.CodingAdminService;
import com.coding.traning.common.web.SSOUtils;
import com.coding.traning.model.HandlerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class SystemController {

    /**
     * 日志对象
     */
    private static final Logger log = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private CodingAdminService codingAdminService;

    /**
     * 菜单列表页面
     */
    @RequestMapping(value = "/menu/pagelist")
    public String menu(Model model) {
        return "menu/pagelist";
    }


}
