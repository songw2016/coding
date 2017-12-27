package com.coding.biz.dao;

import com.coding.common.mail.MailSenderInfo;
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
public interface AlbumMapper {
    void saveSendMail(MailSenderInfo mailInfo);

    List<Map<String,Object>> queryAlbumList(Map<String, Object> param);

    long queryAlbumCount(Map<String, Object> param);

    void savePic(Map<String, String> mm);
}
