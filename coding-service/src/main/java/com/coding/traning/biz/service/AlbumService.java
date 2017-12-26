package com.coding.traning.biz.service;

import com.coding.traning.biz.dao.AlbumMapper;
import com.coding.traning.common.mail.MailSenderInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-service
 *  文件名称: AlbumService
 *  创建时间: 17-11-21 下午1:12
 *  最后更新时间： 17-11-21 下午1:12
 *   Author: mayuliang
 **************************************************************************************************/
@Service
public class AlbumService {
    @Autowired
    public AlbumMapper albumMapper;

    public void saveSendMail(MailSenderInfo mailInfo) {
        albumMapper.saveSendMail(mailInfo);
    }

    public List<Map<String, Object>> queryAlbumList(Map<String, Object> param) {
        return albumMapper.queryAlbumList(param);
    }

    public PageInfo<Map<String, Object>> queryAlbumPage(Map<String, Object> param) {
        int start = Integer.valueOf(param.get("start").toString());
        int end = Integer.valueOf(param.get("end").toString());
        PageHelper.startPage(start, end - start);
        List<Map<String, Object>> list = albumMapper.queryAlbumList(param);
        PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
        page.setPageSize(end - start);
        page.setStartRow(start); //
        return page;
    }

    @Transactional
    public void batchSavePic(List<Map<String, String>> listImagePath) {
        for(Map<String,String> mm :listImagePath){
            albumMapper.savePic(mm);
        }
    }
}
