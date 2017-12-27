package com.coding.common.utils;

import java.util.*;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: ShareCodeUtil
 *  创建时间: 17-11-7 下午2:06
 *  最后更新时间： 17-11-1 下午1:05
 *   Author: mayuliang
 **************************************************************************************************/

public class ShareCodeUtil {

	/*
	 * private static final char[] r = new char[] { 'A', 'B', 'C', 'D', 'E',
	 * 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
	 * 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
	 * 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
	 * 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	 */

	
	/** 自定义进制(0,1没有加入,容易与o,l混淆) */
	private static final char[] r1 = new char[] { 'q', 'w', 'e', '8', 'a', 's',
			'2', 'd', 'z', 'x', '9', 'c', '7', 'p', '5', 'i', 'k', '3', 'm',
			'j', 'u', 'f', 'r', '4', 'v', 'y', 'l', 't', 'n', '6', 'b', 'g',
			'h' };

	/** 自定义进制(0,1没有加入,容易与o,l混淆) */
	private static final char[] r2 = new char[] { 'a', 's', 'd', '9', 'f', 'g',
			'h', '2', 'j', 'k', 'l', '3', 'q', 'w', 'e', '4', 'r', 't', 'y',
			'5', 'u', 'i', '6', 'p', 'z', 'x', '7', 'c', 'v', 'b', '8', 'n',
			'm' };

	/** (不能与自定义进制有重复) */

	private static final char b = 'o';

	/** 进制长度 */
	private static final int binLen = r1.length;

	/** 序列最小长度 */
	private static final int s = 4;

	/**
	 * 根据ID生成六位随机码
	 * @param id 数据库主键
	 * @param type y-月嫂 信息 f-服务人员
	 * @return
	 */
	public static String toSerialCode(long id, String type) 
	{
		String code = "";
		if ("y".equals(type)) 
		{
			code = ShareCodeUtil.getCodeByR1(id);
		}
		if ("f".equals(type))
		{
			code = ShareCodeUtil.getCodeByR2(id);
		}
		return code;
	}

	/**
	 * 按照数组1随机排序
	 * @param id
	 * @return
	 */
	public static String getCodeByR1(long id)
	{
		char[] buf = new char[32];
		int charPos = 32;
		while ((id / binLen) > 0) 
		{
			int ind = (int) (id % binLen);
			buf[--charPos] = r1[ind];
			id /= binLen;
		}
		buf[--charPos] = r1[(int) (id % binLen)];
		String str = new String(buf, charPos, (32 - charPos));
		// 不够长度的自动随机补全
		if (str.length() < s) 
		{
			StringBuilder sb = new StringBuilder();
			sb.append(b);
			Random rnd = new Random();
			for (int i = 1; i < s - str.length(); i++) 
			{
				sb.append(r1[rnd.nextInt(binLen)]);
			}
			str += sb.toString();
		}
		return str;
	}

	/**
	 * 按照数组2随机排序
	 * @param id
	 * @return
	 */
	public static String getCodeByR2(long id) 
	{
		char[] buf = new char[32];
		int charPos = 32;
		while ((id / binLen) > 0) 
		{
			int ind = (int) (id % binLen);
			buf[--charPos] = r2[ind];
			id /= binLen;
		}
		buf[--charPos] = r2[(int) (id % binLen)];
		String str = new String(buf, charPos, (32 - charPos));
		// 不够长度的自动随机补全
		if (str.length() < s)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(b);
			Random rnd = new Random();
			for (int i = 1; i < s - str.length(); i++)
			{
				sb.append(r2[rnd.nextInt(binLen)]);
			}
			str += sb.toString();
		}
		return str;
	}

	/*
	public static long codeToId(String code) {
		char chs[] = code.toCharArray();
		long res = 0L;
		for (int i = 0; i < chs.length; i++) {
			int ind = 0;
			for (int j = 0; j < binLen; j++) {
				if (chs[i] == r1[j]) {
					ind = j;
					break;
				}
			}
			if (chs[i] == b) {
				break;
			}
			if (i > 0) {
				res = res * binLen + ind;
			} else {
				res = ind;
			}
		}
		return res;
	}
	*/

	public static void main(String[] args) 
	{
		String s = "";
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < 5000000; i++) 
		{
			s = ShareCodeUtil.toSerialCode(i, "y");
			list.add(s);
			set.add(s);
		}
		for (int i = 0; i < 5000000; i++) 
		{
			s = ShareCodeUtil.toSerialCode(i, "f");
			list.add(s);
			set.add(s);
		}
		System.out.println(list.size());
		System.out.println(set.size());

	}

}
