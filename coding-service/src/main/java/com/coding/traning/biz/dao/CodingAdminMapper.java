package com.coding.traning.biz.dao;

import com.coding.traning.common.mail.MailSenderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-service
 *  文件名称: AlbumMapper
 *  创建时间: 17-11-21 下午1:12
 *  最后更新时间： 17-11-21 下午1:12
 *   Author: mayuliang
 **************************************************************************************************/
@Repository
public interface CodingAdminMapper {


    List<Map<String,Object>> queryCodingUser(Map<String, Object> param);

    List<Map<String,Object>> queryMenuList(Map<String, Object> param);


}
