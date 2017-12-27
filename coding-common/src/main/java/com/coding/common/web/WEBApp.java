package com.coding.common.web;

import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: WEBApp
 *  创建时间: 17-11-7 下午2:04
 *  最后更新时间： 17-11-1 下午1:05
 *   Author: mayuliang
 **************************************************************************************************/

public class WEBApp {

	public static String APP_PATH = "/";

	public static ApplicationContext SPRING_CONTEXT = null;

	private static WEBApp SINGLETON = new WEBApp();

	private static Map<String, String> pros = new HashMap<String, String>();

	public static void setPros(Map<String, String> pros) {
		WEBApp.pros = pros;
	}

	public static Map<String, String> getPros() {
		return pros;
	}


	private WEBApp() {
	}

	public static WEBApp getWEBApp() {
		if (SINGLETON == null) {
			SINGLETON = new WEBApp();
		}
		return SINGLETON;
	}

	public static String getValue(String key) {
		return pros.get(key);
	}

	public static void setValue(String key, String value) {
		pros.put(key, value);
	}

}