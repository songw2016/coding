package com.coding.traning.alipay.config;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: AlipayConfig
 *  创建时间: 17-11-2 下午12:17
 *  最后更新时间： 17-11-2 下午12:17
 *   Author: mayuliang
 **************************************************************************************************/

public class AlipayConfig {
    // 商户appid
    public static String APPID = "";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String NOTIFY_URL = "http://127.0.0.1/coding-wap/alipay/api/notify";
    //商户可以自定义同步跳转地址
    public static String RETURN_URL = "http://127.0.0.1/coding-wap/alipay/api/return_url";
    // 请求网关地址
    public static String URL = "https://openapi.alipay.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjrEVFMOSiNJXaRNKicQuQdsREraftDA9Tua3WNZwcpeXeh8Wrt+V9JilLqSa7N7sVqwpvv8zWChgXhX/A96hEg97Oxe6GKUmzaZRNh0cZZ88vpkn5tlgL4mH/dhSr3Ip00kvM4rHq9PwuT4k7z1DpZAf1eghK8Q5BgxL88d0X07m9X96Ijd0yMkXArzD7jg+noqfbztEKoH3kPMRJC2w4ByVdweWUT2PwrlATpZZtYLmtDvUKG/sOkNAIKEMg3Rut1oKWpjyYanzDgS7Cg3awr1KPTl9rHCazk15aNYowmYtVabKwbGVToCAGK+qQ1gT3ELhkGnf3+h53fukNqRH+wIDAQAB";
    // 日志记录目录
    public static String LOG_PATH = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";
}
