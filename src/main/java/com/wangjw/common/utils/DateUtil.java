package com.wangjw.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
* @author 作者:wangjiawen
* @version 创建时间: 2019年9月9日 下午7:44:58
* 类功能说明 
*/
public class DateUtil {
	
	/**
	 * 
	 * @param futureDate
	 * @return
	 * 求未来日期离今天还剩的天数
	 *//*
	public int getRemainDays(Date futureDate) {
		return (int)(futureDate.getTime()-new Date().getTime())/1000/3600/24;	
	}*/
	
	
	
	/***
	 * 求未来日期离今天还剩的天数
	 */
	
	public static int getDaysByFuture (Date future) {
		//未来日期的毫秒数
		long end = future.getTime();
		//当前日期的毫秒数
		long now = new Date().getTime();
		
		if(now > end)
			throw new RuntimeException("传入的日期不是为未来日期");
		//向上取整
		  return  (int) (Math.ceil((end - now ) /1000 /24/60/60.0)) ;
		
	}
	
	
	/**
	 * 
	 * 求过去日期离今天过去的天数
	 */
	public static int getDaysByDeparted (Date departed) {
		
		//未来日期的毫秒数
				long last = departed.getTime();
				//当前日期的毫秒数
				long now = new Date().getTime();
				
				if(now < last)
					throw new RuntimeException("传入的日期不是为过去日期");
				//向上取整
				  return  (int) (Math.ceil((now -last ) /1000 /24/60/60.0)) ;
	}
	
	/**
	 * 3.4.4判断是否为当天
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	
	/**
	 * 3.4.4判断是否为当月
	 * @param date
	 * @return
	 */
	public static boolean isCurrentMonth(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	/**
	 * 3.4.7给定时间对象，初始化到该月初的1日0时0分0秒0毫秒
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthStart(Date date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String string = format.format(date);//199809
		String monthStart = string + "01 00:00:00";
		format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return format.parse(monthStart);
	}
	
	
	/**
	 * 3.4.7给定时间对象，初始化到该月末的最后一秒  比如 2019/11/30 23:59:59 
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthEnd(Date date) throws ParseException {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 0);
		//calendar.set(Calendar.HOUR, 0);
		
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime(); 
		
	}

	/**
	 * 
	 * @param birthday
	 * @return
	 * 
	 *  根据传入的日期获取年龄
	 */
	public static int getAge(Date birthday) {
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(birthday);
		
		//得到出生的年
		int birthYear = instance.get(Calendar.YEAR);
		int birthMonth = instance.get(Calendar.MONTH);
		int birthDate = instance.get(Calendar.DAY_OF_MONTH);
		
		//获取当前的年月日
		instance.setTime(new Date());
		int currentYear = instance.get(Calendar.YEAR);
		int currentMonth = instance.get(Calendar.MONTH);
		int currentDate = instance.get(Calendar.DAY_OF_MONTH);
		
		int age = currentYear-birthYear;
		if(currentMonth<birthMonth) {
			age--;
		}else if(currentMonth==birthMonth && currentDate<birthDate){
			age --;
		}
		
		return age;
		
	}
	
}
