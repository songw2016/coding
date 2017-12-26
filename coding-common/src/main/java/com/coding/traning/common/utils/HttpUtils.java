package com.coding.traning.common.utils;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: HttpUtils
 *  创建时间: 17-11-21 下午2:47
 *  最后更新时间： 17-11-21 下午2:47
 *   Author: mayuliang
 **************************************************************************************************/

public class HttpUtils {
    public static boolean isMobileDevice(String requestHeader) {
        /**
         * android : 所有android设备
         * mac os : iphone ipad
         * windows phone:Nokia等windows系统的手机
         */
        String[] deviceArray = new String[]{"android", "mac os", "windows phone"};
        if (requestHeader == null) return false;
        requestHeader = requestHeader.toLowerCase();
        for (int i = 0; i < deviceArray.length; i++) {
            if (requestHeader.indexOf(deviceArray[i]) > 0) {
                return true;
            }
        }
        return false;
    }
}
