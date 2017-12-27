package com.coding.biz.service;

import com.coding.biz.dao.CodingAdminMapper;
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
 *  创建时间: 17-11-21 下午1:12
 *  最后更新时间： 17-11-21 下午1:12
 *   Author: mayuliang
 **************************************************************************************************/
@Service
public class CodingAdminService {

    @Autowired
    CodingAdminMapper codingAdminMapper;

    public List<Map<String, Object>> queryCodingUser(Map<String, Object> param) {
        return codingAdminMapper.queryCodingUser(param);
    }
    public List<Map<String, Object>> queryMenuList(Map<String, Object> param) {
        return codingAdminMapper.queryMenuList(param);
    }

    public PageInfo<Map<String, Object>> queryCodingUserPage(Map<String, Object> param) {
        int start = Integer.valueOf(param.get("start").toString());
        int end = Integer.valueOf(param.get("end").toString());
        PageHelper.startPage(start, end - start);
        List<Map<String, Object>> list = codingAdminMapper.queryCodingUser(param);
        PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
        page.setPageSize(end - start);
        page.setStartRow(start); //
        return page;
    }
}
