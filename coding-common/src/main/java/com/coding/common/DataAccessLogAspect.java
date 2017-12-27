/**
 * 
 */
package com.coding.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: DataAccessLogAspect
 *  创建时间: 17-11-1 下午1:04
 *  最后更新时间： 17-10-31 下午1:55
 *   Author: mayuliang
 **************************************************************************************************/

/**
 * @author Administrator
 *
 */
public class DataAccessLogAspect {
	Logger logger = LoggerFactory.getLogger(DataAccessLogAspect.class);

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long time = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		time = System.currentTimeMillis() - time;
		logger.info("DataAccessLogAspect method: "
				+ pjp.getTarget().getClass().getName() + "."
				+ pjp.getSignature().getName() + " process time: " + time
				+ " ms");
		return retVal;
	}
}
