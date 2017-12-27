/**
 * 
 */
package com.coding.common.utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: DateUtil
 *  创建时间: 17-11-7 下午2:06
 *  最后更新时间： 17-11-1 下午1:05
 *   Author: mayuliang
 **************************************************************************************************/

/**
 * @author admin
 * 
 */
public class DateUtil {

	public static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DMS_DATEFORMAT = "yyyyMMddHHmmss";

	public static String getCurrentTime() {
		return new SimpleDateFormat(DATEFORMAT).format(new Date());
	}

	public static String getDmsTime() {
		return new SimpleDateFormat(DMS_DATEFORMAT).format(new Date());
	}
	public static void main(String argsp[]){
		System.out.println(DateUtil.getDmsTime());
	}
	/**
	 * 格式化日期 yyyy-MM-dd hh:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(DATEFORMAT).format(date);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param formatString
	 * @return
	 */
	public static String dateToString(Date date, String formatString) {
		if (date == null) {
			return "";
		}
		if (formatString == null || "".equals(formatString)) {
			formatString = DATEFORMAT;
		}
		return new SimpleDateFormat(formatString).format(date);
	}

	/**
	 * 格式化日期 yyyy-MM-dd hh:mm:ss
	 * 
	 * @param calendar
	 * @return
	 */
	public static String xmlDateToString(XMLGregorianCalendar calendar) {
		if (calendar == null) {
			return "";
		}
		return dateToString(xmlDate2Date(calendar));
	}

	/**
	 * 格式化日期
	 * 
	 * @param calendar
	 * @param formatString
	 * @return
	 */
	public static String xmlDateToString(XMLGregorianCalendar calendar, String formatString) {
		if (calendar == null) {
			return "";
		}
		if (formatString == null || "".equals(formatString)) {
			formatString = DATEFORMAT;
		}

		return new SimpleDateFormat(formatString).format(xmlDate2Date(calendar));
	}

	/**
	 * XMLGregorianCalendar
	 * 
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar dateToXmlDate() {
		return dateToXmlDate(new Date());
	}

	/**
	 * 将Date类转换为XMLGregorianCalendar
	 * 
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar dateToXmlDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		DatatypeFactory dtf = null;
		try {
			dtf = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
		}
		XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();
		dateType.setYear(cal.get(Calendar.YEAR));
		// 由于Calendar.MONTH取值范围为0~11,需要加1
		dateType.setMonth(cal.get(Calendar.MONTH) + 1);
		dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));
		dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));
		dateType.setMinute(cal.get(Calendar.MINUTE));
		dateType.setSecond(cal.get(Calendar.SECOND));
		return dateType;
	}

	/**
	 * 将XMLGregorianCalendar转换为Date
	 * 
	 * @param cal
	 * @return
	 */
	public static Date xmlDate2Date(XMLGregorianCalendar cal) {
		if (cal == null) {
			return null;
		}
		return cal.toGregorianCalendar().getTime();
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar dateToXmlDate(String date) throws ParseException {
		if (date == null || "".equals(date)) {
			return null;
		}
		return dateToXmlDate(new SimpleDateFormat(DATEFORMAT).parse(date));

	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date strToDate(String date, String pattern) {
		if (date == null || "".equals(date)) {
			return null;
		}
		try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date strToDate(String date) {
		return strToDate(date, DMS_DATEFORMAT);

	}
}
