package com.lh.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class DateUtils {

	/**
	 * 格式化日期
	 * 
	 * @param dateStr
	 *        字符型日期
	 * @param format
	 *        格式
	 * @return 返回日期
	 */
	public static Date parseDate(String dateStr, String format) {
		Date date = null;
		try {
			DateFormat df = new SimpleDateFormat(format);
			String dt = dateStr.replaceAll("-", "/");
			if ((!dt.equals("")) && (dt.length() < format.length())) {
				dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]", "0");
			}
			date = (Date) df.parse(dt);
		} catch (Exception e) {}
		return date;
	}

	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy/MM/dd");
	}

	public static Date parseDate(java.sql.Date date) {
		return date;
	}

	public static java.sql.Date parseSqlDate(Date date) {
		if (date != null)
			return new java.sql.Date(date.getTime());
		else
			return null;
	}

	public static java.sql.Date parseSqlDate(String dateStr, String format) {
		Date date = parseDate(dateStr, format);
		return parseSqlDate(date);
	}

	public static java.sql.Date parseSqlDate(String dateStr) {
		return parseSqlDate(dateStr, "yyyy/MM/dd");
	}

	public static java.sql.Timestamp parseTimestamp(String dateStr, String format) {
		Date date = parseDate(dateStr, format);
		if (date != null) {
			long t = date.getTime();
			return new java.sql.Timestamp(t);
		} else
			return null;
	}

	public static java.sql.Timestamp parseTimestamp(String dateStr) {
		return parseTimestamp(dateStr, "yyyy-MM-dd  HH:mm:ss");
	}

	/**
	 * 格式化输出日期
	 *
	 * @param date
	 *        日期
	 * @param format
	 *        格式
	 * @return 返回字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				DateFormat df = new SimpleDateFormat(format);
				result = df.format(date);
			}
		} catch (Exception e) {}
		return result;
	}

	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 返回年份
	 *
	 * @param date
	 *        日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.YEAR);
	}

	/**
	 * 返回月份
	 *
	 * @param date
	 *        日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MONTH) + 1;
	}

	/**
	 * 返回日份
	 *
	 * @param date
	 *        日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回小时
	 *
	 * @param date
	 *        日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.HOUR_OF_DAY);
	}

	/**
	 * 返回分钟
	 *
	 * @param date
	 *        日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 *
	 * @param date
	 *        日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.SECOND);
	}

	/**
	 * 返回毫秒
	 *
	 * @param date
	 *        日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 返回字符型日期
	 *
	 * @param date
	 *        日期
	 * @return 返回字符型日期
	 */
	public static String getDate(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	/**
	 * 返回字符型时间
	 *
	 * @param date
	 *        日期
	 * @return 返回字符型时间
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	/**
	 * 返回字符型日期时间
	 *
	 * @param date
	 *        日期
	 * @return 返回字符型日期时间
	 */
	public static String getDateTime(Date date) {
		return format(date, "yyyy-MM-dd  HH:mm:ss");
	}

	/**
	 * 日期相加
	 *
	 * @param date
	 *        日期
	 * @param day
	 *        天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	/**
	 * 日期相减
	 *
	 * @param date
	 *        日期
	 * @param date1
	 *        日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	public static String formatTime(String times) {
		Date d = new Date(Long.parseLong(times));
		return format(d);
	}

	/**
	 * 以yyyyMMddHHmmss为格式
	 * 
	 * @param len
	 *        长度 超过14 时 随机生成
	 * @return
	 */
	public static String getDateStr(int len) {
		Date date = new Date();
		DateFormat dtLong = new SimpleDateFormat("yyyyMMddHHmmss");
		if (len > 13) {
			return dtLong.format(date) + DateUtils.getRandom(Math.max(0, len - 14));
		} else {
			return dtLong.format(date).substring(0, len);
		}
	}

	/**
	 * 产生随机
	 * 
	 * @return
	 */
	public static String getRandom(int len) {
		StringBuilder strBuilder = new StringBuilder();
		if (len > 0) {
			Random rad = new Random();
			for (int i = 0; i < len; i++) {
				strBuilder.append(rad.nextInt(10) + "");
			}
		}
		return strBuilder.toString();
	}

	/**
	 * 判断是否为今天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		if (date == null) {
			return false;
		}
		return DateUtils.format(date, "yyyyMMdd").equals(DateUtils.format(new Date(), "yyyyMMdd"));
	}
	
	/**
	 * 判断生日是否在百年之内
	 * @param date
	 * @return
	 */
	public static boolean isBirthday(Date born){
		Date now=new Date();
		GregorianCalendar gc=new GregorianCalendar(); 
		gc.setTime(now);
		gc.add(1, -100);
		Date date=gc.getTime();
		if(born.after(date)&&born.before(now)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 验证活动时间
	 * @param dateBefor
	 * @param dateAfter
	 * @return
	 */
	public static int isActiveCodeDate(Date dateBefor,Date dateAfter){
		Date now=new Date();
		if(null!=dateBefor&&now.before(dateBefor)){
			return 1;//活动未开始
		}else if(null!=dateAfter&&now.after(dateAfter)){
			return 2;//活动已结束
		}
		return 0;//活动正常
	}
}
