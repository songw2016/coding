package com.coding.common.utils;

import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: WxPayUtils
 *  创建时间: 17-11-7 下午2:07
 *  最后更新时间： 17-11-1 下午1:05
 *   Author: mayuliang
 **************************************************************************************************/

public class WxPayUtils {
	/**
	 * 构建微信支付的签名
	 * 
	 * @param sortMap
	 * @return
	 */
	public static String wxPaySign(SortedMap<String, Object> sortMap, String apiKey) {
		StringBuilder sign = new StringBuilder();
		if (sortMap != null && !sortMap.isEmpty()) {
			Set<Entry<String, Object>> paramSet = sortMap.entrySet();
			for (Entry<String, Object> entry : paramSet) {
				String key = entry.getKey();
				String value = String.valueOf(entry.getValue());
				if (!"null".equals(value) && !"".equals(value)) {
					sign.append(key);
					sign.append("=");
					sign.append(value);
					sign.append("&");
				}
			}
		}
		// 商户api的key
		sign.append("key=").append(apiKey);
		return Md5Util.MD5Encode(sign.toString(), "utf-8").toUpperCase();
	}
}
