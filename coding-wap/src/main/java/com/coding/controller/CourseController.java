package com.coding.controller;

import com.coding.traning.biz.service.CourseService;
import com.coding.traning.model.HandlerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-wap
 *  文件名称: CourseController
 *  创建时间: 17-11-7 下午2:09
 *  最后更新时间： 17-11-2 下午3:43
 *   Author: mayuliang
 **************************************************************************************************/
@Controller
@RequestMapping(value = "/course")
public class CourseController {

    /**
     * 日志对象
     */
    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;

    /**
     * 活动列表页面
     */
    @RequestMapping(value = "/page/list")
    public String listPage(HttpServletRequest request, Model model) {


        return "course/list";
    }

    /**
     * 活动详情页面
     */
    @RequestMapping(value = "/page/view/{actId}")
    public String viewcourse(@PathVariable String actId, Model model) {

        return "course/view";
    }
    /**
     * 活动详情页面
     */
    @RequestMapping(value = "/page/book/{actId}")
    public String bookcourse(@PathVariable String actId, Model model) {

        return "course/book";
    }

    /**
     * 成功页面
     */
    @RequestMapping(value = "/page/success/{bookNum}")
    public String success(@PathVariable String bookNum, Model model) {

        return "course/success";
    }
    /**
     * 活动新建
     */
    @RequestMapping(value = "/page/new")
    public String newActivity() {

        return "course/new";
    }
    /**
     * 活动新建
     */
    @RequestMapping(value = "/page/search")
    public String search() {

        return "order";
    }
    /**
     * 活动列表  更多数据加载
     */
    @RequestMapping(value = "/data/querMore", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HandlerResult querMore(HttpServletRequest request) throws IOException {
        HandlerResult result = HandlerResult.newInstance();
        return result;
    }

    /**
     * 创建活动
     */
    @RequestMapping(value = "/data/submit", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HandlerResult submit(HttpServletRequest request) throws IOException {
        HandlerResult result = HandlerResult.newInstance();
        return result;
    }
}
