package com.coding.biz.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-service
 *  文件名称: CourseMapper
 *  创建时间: 17-11-1 下午1:04
 *  最后更新时间： 17-11-1 下午1:04
 *   Author: mayuliang
 **************************************************************************************************/
@Repository
public interface CourseMapper {
    List<Map<String,Object>> queryCourseList(Map<String, String> param);

    List<Map<String,Object>> queryOrerList(Map<String, String> param);
}
