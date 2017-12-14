package com.chinasofti.mall.batch.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期相关工具类
 *
 * @author yedawang
 */
public class DateUtils {

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    private final static String DATE_FORMAT_1 = "yyyyMMdd";
    private final static String TIME_FORMAT_1 = "HHmmssSSS";
    private final static String DATE_TIME_FORMAT_1 = "yyyy-MM-dd HH:mm:ss:SSS";
    private final static String DATE_TIME_FORMAT_2 = "yyyyMMddHHmmssSSS";

    /**
     * 判断时间格式 格式必须为“YYYYMMdd” 2004230 是无效的 2003229 是无效的
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
     * 判断时间格式 格式必须为“YYYYMMddHHmmssSSS”
     *
     * @param str
     * @return
     */
    public static boolean isValidDate2(String str) {
        DateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT_2);
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
     *
     * @param date
     * @return
     */
    public static String getNowDate(Date date) {
        DateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT_2);
        String now = formatter.format(date);
        return now;
    }

    /**
     * 自定义日期yyyyMMdd 拼接当前的时间戳
     *
     * @param date
     * @return
     */
    public static String getDateTime(String date) {
        Date currentTime = new Date();
        DateFormat formatter = new SimpleDateFormat(TIME_FORMAT_1);
        return date + formatter.format(currentTime);
    }

    /**
     * 把日期的格式转为yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String transFormatToyyyyMMdd(String date) {
        return date.substring(0, 8);
    }
}
