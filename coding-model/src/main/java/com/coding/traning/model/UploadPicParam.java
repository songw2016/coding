package com.coding.traning.model;

import java.io.Serializable;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-model
 *  文件名称: UploadPicParam
 *  创建时间: 17-11-21 上午9:48
 *  最后更新时间： 17-11-21 上午9:48
 *   Author: mayuliang
 **************************************************************************************************/

public class UploadPicParam implements Serializable{

    public String getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    private String index;

    public void setIndex(String index) {
        this.index = index;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;
    private String title;
    private String desc;


}
