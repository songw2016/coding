package com.coding.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: MMPropertyPlaceholderConfigurer
 *  创建时间: 17-11-1 下午1:04
 *  最后更新时间： 17-10-31 下午1:55
 *   Author: mayuliang
 **************************************************************************************************/

public class MMPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	protected void processProperties(
            ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		if ("true".equalsIgnoreCase(props.getProperty("jdbc.isdncrypt"))) {
			DataEncrypt.b();
			username = DataEncrypt.decrypt(username);
			password = DataEncrypt.decrypt(password);
		}
		props.setProperty("jdbc.username", username);
		props.setProperty("jdbc.password", password);
		super.processProperties(beanFactory, props);
	}

}
