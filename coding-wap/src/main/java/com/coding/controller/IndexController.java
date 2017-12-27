package com.coding.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-wap
 *  文件名称: IndexController
 *  创建时间: 17-11-7 下午2:09
 *  最后更新时间： 17-11-1 下午1:05
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
     */
    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "index";
    }

}
