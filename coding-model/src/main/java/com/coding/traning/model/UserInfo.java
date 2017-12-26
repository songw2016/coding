package com.coding.traning.model;

import java.io.Serializable;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-model
 *  文件名称: UserInfo
 *  创建时间: 17-11-1 下午1:04
 *  最后更新时间： 17-10-31 下午2:03
 *   Author: mayuliang
 **************************************************************************************************/

public class UserInfo implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 1L;
	private String loginNum;
	private String loginType;
	private String userName;
	private String userPass;
	private String linkPhone;
    private String proviceNum;
    private String proviceName;//省
    private String cityNum;
    private String cityName;//市
    private String areaNum;

	public String getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}


	public String getProviceNum() {
		return proviceNum;
	}

	public void setProviceNum(String proviceNum) {
		this.proviceNum = proviceNum;
	}

	public String getProviceName() {
		return proviceName;
	}

	public void setProviceName(String proviceName) {
		this.proviceName = proviceName;
	}

	public String getCityNum() {
		return cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaNum() {
		return areaNum;
	}

	public void setAreaNum(String areaNum) {
		this.areaNum = areaNum;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	private String areaName;//区县

}