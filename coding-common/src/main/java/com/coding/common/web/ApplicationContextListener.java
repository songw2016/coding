package com.coding.common.web;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: ApplicationContextListener
 *  创建时间: 17-11-7 下午2:04
 *  最后更新时间： 17-11-1 下午1:05
 *   Author: mayuliang
 **************************************************************************************************/

public class ApplicationContextListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(ApplicationContextListener.class);

    static {
        System.setProperty("java.awt.headless", "true");
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    }

    public void contextInitialized(ServletContextEvent context) {
        try {
            logger.info(".........初始化系统参数开始..................");
            ApplicationContext atx = WebApplicationContextUtils.getWebApplicationContext(context.getServletContext());
            WEBApp.SPRING_CONTEXT = atx;

            context.getServletContext().setAttribute("staticV", WEBApp.getValue("static.version"));
            if ("DEV".equals(WEBApp.getValue("dev.version"))) {
                context.getServletContext().setAttribute("staticV", System.currentTimeMillis());
            }
            context.getServletContext().setAttribute("webUrl", WEBApp.getValue("web.url"));
            context.getServletContext().setAttribute("staticUrl", WEBApp.getValue("static.url"));
            String realPath = context.getServletContext().getRealPath("");
            if (realPath == null) {
                realPath = "/";
            }
            if (!realPath.endsWith("/")) {
                realPath += "/";
            }
            if (StringUtils.isNotBlank(realPath)) {
                WEBApp.APP_PATH = realPath;
            }
            logger.info("..........初始化系统参数结束..................");
        } catch (Exception e) {
            logger.error("加载配置信息失败！" + e.getMessage(), e);
            throw new RuntimeException("加载配置信息失败！" + e.getMessage(), e);
        }
    }
}
