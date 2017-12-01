package com.chinasofti.mall.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @ClassName: 	StringDateUtil
* @Description: 日期类型字符串格式转换
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月14日 下午12:20:38 
*/
public class StringDateUtil {
	
	public static final String sqlFormat = "yyyyMMddHHmmss";
	public static final String pageFormat = "yyyy-MM-dd HH:mm:ss";
	public static final String sqlShortFormat = "yyyyMMdd";
	public static final String pageShortFormat = "yyyy-MM-dd";
	
	/**
	* @Title: convertToSqlFormat
	* @Description: 将yyyy-MM-dd HH:mm:ss日期字符串装换成yyyyMMddHHmmss日期字符串
	* @param dateStr yyyy-MM-dd HH:mm:ss类型日期字符串
	* @return String
	* @throws
	*/
	public static String convertToSqlFormat(String dateStr) {
		try {
			Date parseDate = new SimpleDateFormat(pageFormat).parse(dateStr);
			return new SimpleDateFormat(sqlFormat).format(parseDate);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	* @Title: convertToPageFormat
	* @Description: 将yyyyMMddHHmmss日期字符串装换成yyyy-MM-dd HH:mm:ss日期字符串
	* @param dateStr	yyyyMMddHHmmss类型日期字符串
	* @return String
	* @throws
	*/
	public static String convertToPageFormat(String dateStr) {
		try {
			Date parseDate = new SimpleDateFormat(sqlFormat).parse(dateStr);
			return new SimpleDateFormat(pageFormat).format(parseDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	* @Title: convertToSqlShortFormat
	* @Description: 将yyyy-MM-dd日期字符串装换成yyyyMMdd日期字符串
	* @param dateStr	yyyy-MM-dd类型日期字符串
	* @return String
	* @throws
	*/
	public static String convertToSqlShortFormat(String dateStr) {
		try {
			Date parseDate = new SimpleDateFormat(pageShortFormat).parse(dateStr);
			return new SimpleDateFormat(sqlShortFormat).format(parseDate);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Date类型转换为yyyyMMddHHmmss日期字符串
	 * @param date
	 * @return
	 */
	public static String convertDateToLongString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String longStringDate = sdf.format(date);
		return longStringDate;
	}
	/**获取当前日期转换为
	 * "yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static String getStringTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}
}
