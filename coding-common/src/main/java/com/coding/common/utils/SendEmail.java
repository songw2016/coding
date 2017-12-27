package com.coding.common.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: SendEmail
 *  创建时间: 17-11-14 下午4:21
 *  最后更新时间： 17-11-14 下午4:21
 *   Author: mayuliang
 **************************************************************************************************/

public class SendEmail {
    public static void main(String args[]) throws Exception {
        File dir = new File("D:\\我的资料库\\Pictures\\计师042八周年聚会");
        int i = 0;
        for (File file : dir.listFiles()) {
            Thumbnails.of(file).size(800, 600).toFile(new File("D:\\我的资料库\\Pictures\\计师042八周年聚会", i + ".jpg"));
            i++;
        }

    }
}
