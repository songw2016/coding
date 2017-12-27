package com.coding.common;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: DataEncrypt
 *  创建时间: 17-11-1 下午1:04
 *  最后更新时间： 17-10-31 下午1:55
 *   Author: mayuliang
 **************************************************************************************************/

public class DataEncrypt {
	private static volatile DataEncrypt a;

	  public static DataEncrypt b()
	  {
	    if (a == null)
	    {
	      synchronized (DataEncrypt.class)
	      {
	        if (a == null)
	        {
	          a = new DataEncrypt();
	        }
	      }
	    }
	    return a;
	  }

	  public static String encrypt(String text)
	  {
	    StandardPBEStringEncryptor encryptor;
	    (
	      encryptor = new StandardPBEStringEncryptor())
	      .setPassword("1234567980Abcwyz#");
	    return encryptor.encrypt(text);
	  }

	  public static String decrypt(String ciphertext)
	  {
	    StandardPBEStringEncryptor encryptor;
	    (
	      encryptor = new StandardPBEStringEncryptor())
	      .setPassword("1234567980Abcwyz#");
	    return encryptor.decrypt(ciphertext);
	  }
	  
	  public static void main(String args[]){
		  System.out.println(DataEncrypt.encrypt("root"));
		  System.out.println(DataEncrypt.encrypt("mms123"));
		  
		  System.out.println(DataEncrypt.decrypt("jXYWT3D4 6k/7ncqaJya/bBO6tGgfBpA"));
		  System.out.println(DataEncrypt.decrypt("78ByHsz2dMZwZpEN7zhjrg=="));
		  
				  
	  }
}
