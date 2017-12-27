package com.coding.biz.service;

import com.coding.biz.dao.CourseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-service
 *  文件名称: CourseService
 *  创建时间: 17-11-1 下午1:04
 *  最后更新时间： 17-11-1 下午1:04
 *   Author: mayuliang
 **************************************************************************************************/
@Service
public class CourseService {
    @Autowired
    public CourseMapper courseMapper;

    public List<Map<String, Object>> queryCourseList(Map<String, String> param) {
        return courseMapper.queryCourseList(param);
    }

    public PageInfo<Map<String, Object>> queryCoursePage(Map<String, String> param) {
        int start = Integer.valueOf(param.get("start").toString());
        int end = Integer.valueOf(param.get("end").toString());
        PageHelper.startPage(start, end - start);
        List<Map<String, Object>> list = courseMapper.queryCourseList(param);
        PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
        page.setPageSize(end - start);
        page.setStartRow(start); //
        return page;
    }

    public List<Map<String, Object>> queryOrerList(Map<String, String> param) {
        return courseMapper.queryOrerList(param);
    }

    public PageInfo<Map<String, Object>> queryOrderPage(Map<String, String> param) {
        int start = Integer.valueOf(param.get("start").toString());
        int end = Integer.valueOf(param.get("end").toString());
        PageHelper.startPage(start, end - start);
        List<Map<String, Object>> list = courseMapper.queryOrerList(param);
        PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
        page.setPageSize(end - start);
        page.setStartRow(start); //
        return page;
    }

}
