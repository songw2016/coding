package com.coding.traning.common.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: MyAuthenticator
 *  创建时间: 17-11-14 下午4:44
 *  最后更新时间： 17-11-14 下午4:44
 *   Author: mayuliang
 **************************************************************************************************/

public class MyAuthenticator extends Authenticator {
    String userName=null;
    String password=null;

    public MyAuthenticator(){
    }
    public MyAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, password);
    }
}
