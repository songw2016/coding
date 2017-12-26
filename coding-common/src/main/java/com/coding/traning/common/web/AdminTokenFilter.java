package com.coding.traning.common.web;

import com.coding.traning.model.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: AdminTokenFilter
 *  创建时间: 17-11-7 下午2:04
 *  最后更新时间： 17-11-1 下午1:05
 *   Author: mayuliang
 **************************************************************************************************/

public class AdminTokenFilter extends OncePerRequestFilter {
	private Logger logger = LoggerFactory.getLogger(AdminTokenFilter.class);

	/**
	 * 不需要验证就可以通过的
	 */
	private String excludeURL;

	public String getExcludeURL() {
		return excludeURL;
	}

	public void setExcludeURL(String excludeURL) {
		this.excludeURL = excludeURL;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain fc)
			throws ServletException, IOException {

		String requestURL = request.getRequestURI().toString();
		String ctxPath = request.getContextPath();
		// 去除ContextPath
		requestURL = requestURL.replaceAll(ctxPath, "");
		if ("/".indexOf(requestURL) >= 0) {
			logger.debug("不需求登录拦截直接跳过");
			fc.doFilter(request, response);
			return;
		}
		if (requestURL.indexOf("/assets/") >= 0) {
			logger.debug("静态资源文件直接跳过");
			fc.doFilter(request, response);
			return;
		}
		if (excludeURL.indexOf(requestURL) >= 0) {
			logger.debug("不需求登录拦截直接跳过");
			fc.doFilter(request, response);
			return;
		}
		boolean identification = true;
		// TOKENKEY
		String loginName = SSOUtils.getInfoForCookie(SSOUtils.COKIE_TOKEN, request);
		if (StringUtils.isBlank(loginName) ) {
			// 用户未登录
			logger.debug("用户未登录");
			identification = false;
			this.isXMLHttpRequest("timeout", request, response);
		} else {
			// check login status
			Map<String,Object> userInfo = (Map<String,Object>) request.getSession().getAttribute(SSOUtils.SESSION_ADMIN);
			if (userInfo != null) {
				// 刷新缓存中Session 对象的失效时间
				request.getSession().setAttribute(SSOUtils.SESSION_ADMIN, userInfo);
			} else {
				// 用户未登录
				logger.debug("用户未登录");
				identification = false;
				this.isXMLHttpRequest("timeout", request, response);
			}
		}

		if (identification == true) {
			fc.doFilter(request, response);
		}
	}

	private void isXMLHttpRequest(String errorCode, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String header = request.getHeader("X-Requested-With");
		if ("XMLHttpRequest".equals(header)) {
			if ("404".equals(errorCode)) {// 页面不存在
				request.getRequestDispatcher("/notExists").forward(request, response);
			} else {// 用户未登录
				request.getRequestDispatcher("/notLogin").forward(request, response);
			}
		} else {
			if ("404".equals(errorCode)) {
				request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/views/error/tologin.jsp").forward(request, response);
			}
		}
		return;
	}
}