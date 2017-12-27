package com.coding.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-model
 *  文件名称: HandlerResult
 *  创建时间: 17-11-1 下午1:04
 *  最后更新时间： 17-10-31 下午1:32
 *   Author: mayuliang
 **************************************************************************************************/

public class HandlerResult implements Serializable {
	
	

	public static final String CODE_SUCCESS = "0";
	public static final String CODE_ERROR = "1";
	// 返回编码
	private String retCode;// 0 成功 1 失败
	// 返回消息
	private String resMsg;
	// 返回结果集
	private Object retObj;
	public HandlerResult() {
		this.retCode  = CODE_SUCCESS;
		this.retObj   = nullJsonString();
	}
	/**
	 * 初始化一个空的数据，某些页面超时返回数据问题　ajax session超时退出登录页面
	 * @return
	 */
	static Map<String,Object>  nullJsonString(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageNum", 1);
		map.put("pageSize", 1);
		map.put("list",new ArrayList<Object>());
		return map;
	}
	public static HandlerResult newInstance() {
		HandlerResult result = new HandlerResult();
		result.setRetCode(CODE_SUCCESS);
		result.setRetObj(nullJsonString());//
		return result;
	}

	public static HandlerResult newInstance(String retCode) {
		HandlerResult result = new HandlerResult();
		result.setRetCode(retCode);
		result.setRetObj(nullJsonString());//
		return result;
	}

	@Override
	public String toString() {
		return "HandlerResult [retCode=" + retCode + ", resMsg=" + resMsg + ", retObj=" + retObj + "]";
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public Object getRetObj() {
		return retObj;
	}

	public void setRetObj(Object retObj) {
		this.retObj = retObj;
	}
}
