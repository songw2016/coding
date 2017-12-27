package com.coding.common.web;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: SSOUtils
 *  创建时间: 17-11-7 下午2:04
 *  最后更新时间： 17-11-1 下午1:05
 *   Author: mayuliang
 **************************************************************************************************/

public class SSOUtils {

    public static final String COKIE_TOKEN = "token";
    public static final String SESSION_ADMIN = "admin";

    /**
     * @param request
     * @return
     */
    public static String getMyIpAddr(HttpServletRequest request) {
        String strUserIp = "127.0.0.1";
        /** * */
        // Apache 代理 解决IP地址问题
        strUserIp = request.getHeader("X-Forwarded-For");
        if (strUserIp == null || strUserIp.length() == 0 || "unknown".equalsIgnoreCase(strUserIp)) {
            strUserIp = request.getHeader("Proxy-Client-IP");
        }
        if (strUserIp == null || strUserIp.length() == 0 || "unknown".equalsIgnoreCase(strUserIp)) {
            strUserIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (strUserIp == null || strUserIp.length() == 0 || "unknown".equalsIgnoreCase(strUserIp)) {
            strUserIp = request.getRemoteAddr();
        }
        if (strUserIp != null) {
            strUserIp = strUserIp.split(",")[0];
        } else {
            strUserIp = "127.0.0.1";
        }
        // ip6
        if (strUserIp.length() > 16) {
            strUserIp = "127.0.0.1";
        }
        return strUserIp;
    }

    public static String getInfoForCookie(String key, HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (key.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static Map<String, Object> getUserInfo(HttpServletRequest request) {
        return (Map<String, Object>) request.getSession().getAttribute(SSOUtils.SESSION_ADMIN);
    }

    public static String getLoginName(HttpServletRequest request) {
        Map<String, Object> mm = getUserInfo(request);
        return mm.get("LOGIN_NAME").toString();
    }

    public static void setSSOLogin(HttpServletRequest request, HttpServletResponse response, Map<String, Object> userInfo) {
        HttpSession session = request.getSession();
        String loginName = userInfo.get("LOGIN_NAME").toString();

        session.setAttribute(SSOUtils.SESSION_ADMIN, userInfo);

        Cookie nameCookie = new Cookie(COKIE_TOKEN, loginName);
        // 设置域
        nameCookie.setDomain(WEBApp.getValue("sys.domain"));
        // 设置cookie的有效时间
        nameCookie.setMaxAge(-1);
        nameCookie.setPath("/");
        response.addCookie(nameCookie);
    }

    /**
     * 登出操作
     *
     * @param request
     * @param response
     */
    public static void setSSOLogout(HttpServletRequest request, HttpServletResponse response) {
        // SSO服务器上保存用户登录状态
        request.getSession().removeAttribute(SSOUtils.SESSION_ADMIN);
        // 获取客户端cookies
        Cookie cookie = new Cookie(COKIE_TOKEN, null);
        // 设置域
        cookie.setDomain(WEBApp.getValue("sys.domain"));
        // 立即删除
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

    }
}
