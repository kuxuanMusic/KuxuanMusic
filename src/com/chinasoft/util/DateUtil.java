package com.chinasoft.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间Date转换工具类
 * @author Administrarors
 *
 */
public class DateUtil {
	private static SimpleDateFormat sdf;
	/**
	 * 时间转换成字符串
	 * @param date
	 * @return str
	 */
	public static String dateToString(Date date){
		 sdf = new SimpleDateFormat("yyyy-MM-dd");
		 String str = sdf.format(date);
		return str;
	}
	
	/**
	 * 字符串转换成时间Date
	 * @param str
	 * @return date
	 */
	public static Date stringToDate(String str){
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
