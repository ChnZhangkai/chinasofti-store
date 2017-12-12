package com.chinasofti.mall.batch.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期相关工具类
 * 
 * @author yedawang
 *
 */
public class DateUtils {

	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

	private final static String DATE_FORMAT_1 = "yyyyMMdd";
	private final static String DATE_TIME_FORMAT_1 = "yyyy-MM-dd HH:mm:ss:SSS";

	/**
	 * 判断时间格式 格式必须为“YYYY-MM-dd” 2004-2-30 是无效的 2003-2-29 是无效的
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isValidDate(String str) {
		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT_1);
		try {
			Date date = (Date) formatter.parse(str);
			return str.equals(formatter.format(date));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_1);
		return sdf.format(now);
	}

	/**
	 * 当前时间 - 7天
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getSubSevenDays(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_1);
		try {
			Date date = sdf.parse(dateStr);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, -7);
			Date before7Date = calendar.getTime();
			return sdf.format(before7Date);
		} catch (ParseException e) {
			logger.error("日期转化失败:" + e.getMessage());
			e.printStackTrace();
			return "";
		}

	}
	/**
	 * 获取当前日期 yyyyMMdd
	 * @param date
	 * @return
	 */
	public static String getNowDate(Date date) {
		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT_1);
		String now = formatter.format(date);
		return now;
	}
}
