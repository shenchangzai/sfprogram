package com.xu.common.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {
	       
	public static final  long MILLISECOND_DAY = 1000 * 60 * 60 * 24;
	public static final  String YYYYMMDDHHMMSSSSS = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final  String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final  String YYYYMMDDHHMMSS_SHORT = "yyyyMMddHHmmss";
	public static final  String YYYYMMDDHHMMSS_LONG = "yyyy年MM月dd日HH时mm分";
	public static final  String HHMMSS = "HH:mm:ss";
	public static final  String HH = "HH";
	public static final  String HHMM = "HH:mm";
	public static final  String HHMM_SHORT = "HHmm";
	public static final  String YYYYMMDDHH = "yyyy-MM-dd HH";
	public static final  String YYYYMMDDHH_SHORT = "yyyyMMddHH";
	public static final  String YYYYMMDDHHMM_SHORT = "yyyyMMddHHmm";
	public static final  String YYYYMM = "yyyyMM";
	public static final  String YYYYMMDD_SHORT = "yyyyMMdd";
	public static final  String YYYYMMDD = "yyyy-MM-dd";
	public static final String YYYYMMDDHHMMSS_REGEXP = "^(?x:(?:[0-9]{1,4}(?<!^0?0?0?0))-(?:0?[1-9]|1[0-2])-(?:0?[1-9]|1[0-9]|2[0-8]|(?:(?<=-(?:0?[13578]|1[02])-)(?:29|3[01]))|(?:(?<=-(?:0?[469]|11)-)(?:29|30))|(?:(?<=(?:(?:[0-9]{0,2}(?!0?0)(?:[02468]?(?<![13579])[048]|[13579][26]))|(?:(?:[02468]?[048]|[13579][26])00))-0?2-)(?:29))))\\s(((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\:([0-5]?[0-9]))))$";// 日期正则表达式
	public static final String YYYYMMDD_REGEXP = "^(?x:(?:[0-9]{1,4}(?<!^0?0?0?0))-(?:0?[1-9]|1[0-2])-(?:0?[1-9]|1[0-9]|2[0-8]|(?:(?<=-(?:0?[13578]|1[02])-)(?:29|3[01]))|(?:(?<=-(?:0?[469]|11)-)(?:29|30))|(?:(?<=(?:(?:[0-9]{0,2}(?!0?0)(?:[02468]?(?<![13579])[048]|[13579][26]))|(?:(?:[02468]?[048]|[13579][26])00))-0?2-)(?:29))))";
	public static final  String UTC_SHORT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final  Pattern UTCPattern = Pattern.compile("(?x:(?:[0-9]{1,4}(?<!^0?0?0?0))-(?:0?[1-9]|1[0-2])-(?:0?[1-9]|1[0-9]|2[0-8]|(?:(?<=-(?:0?[13578]|1[02])-)(?:29|3[01]))|(?:(?<=-(?:0?[469]|11)-)(?:29|30))|(?:(?<=(?:(?:[0-9]{0,2}(?!0?0)(?:[02468]?(?<![13579])[048]|[13579][26]))|(?:(?:[02468]?[048]|[13579][26])00))-0?2-)(?:29))))T(((0?[0-9])|([1][0-9])|([2][0-3])):([0-5]?[0-9])((:([0-5]?[0-9]))))((\\.([0-9]{1,3})))Z");

	public static final String HHMMSS_REGEXP = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";// 时分秒正则表达式

	
	public static Date now(){
		return  new Date();
	}

	
    public static Date getFirstDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static Date getLastDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * @return firstDay:00:00:00
     */
    public static Date getFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * @param date
     * @return nextDay:00:00:00
     */
    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * @return lastDay:23:59:59
     */
    public static Date getLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public static Date getFirstDayOfNextMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static long buildTimestamp() {
        return System.currentTimeMillis() / 1000;
    }
    /**
	 * 减去一定天数后的日期
	 */
	public static Date getDateMinus(int date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		// 让日期减date天
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)
				- date);
		return calendar.getTime();
	}

	/**
	 * @param formatStr
	 *            日期格式字符串
	 * @return String 日期的字符串型式
	 */
	public static String getSysDate(String formatStr) {

		String dateStr = null;
		try {
			SimpleDateFormat sfTemp = new SimpleDateFormat(formatStr);
			dateStr = sfTemp.format(new Date());
			return dateStr;
		} catch (Exception e) {
		}
		return dateStr;

	}

	/**
	 * 获取未来格式时间
	 * 
	 * @param formatStr
	 * @param future
	 * @return
	 */
	public static String getDate4future(String formatStr, Long future) {
		String dateStr = null;
		try {
			Date date = new Date(System.currentTimeMillis() + future * 1000);
			SimpleDateFormat sfTemp = new SimpleDateFormat(formatStr);
			dateStr = sfTemp.format(date);
			return dateStr;
		} catch (Exception e) {
		}
		return dateStr;
	}

	/**
	 * @param formatStr
	 *            日期格式字符串
	 * @param date
	 *            日期
	 * @return String 日期的字符串型式
	 */
	public static String getSysDate(String formatStr, Date date) {

		String dateStr = null;
		try {
			SimpleDateFormat sfTemp = new SimpleDateFormat(formatStr);
			dateStr = sfTemp.format(date);
			return dateStr;
		} catch (Exception e) {
		}
		return dateStr;

	}

	/**
	 * 日期比较
	 * 
	 * @param beginTime
	 *            开始时间的字符串
	 * @param endTime
	 *            结束时间的字符串
	 * @param formatStr
	 *            日期格式字符串
	 * @return true：开始时间大于等于结束时间返回true, false：返回false
	 */
	public static boolean dateComparison(String beginTime, String endTime,
			String formatStr) {

		if (beginTime == null || endTime == null) {
			return false;
		}
		try {
			if (format(beginTime, formatStr).getTime() >= format(endTime,
					formatStr).getTime()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 日期比较
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return true：开始时间大于等于结束时间返回true, false：返回false
	 */
	public static boolean dateComparison(Date beginTime, Date endTime) {

		if (beginTime == null || endTime == null) {
			return false;
		}
		try {
			if (beginTime.getTime() >= endTime.getTime()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
	

	/**
	 * 将时间字符串0000.00.00 00:00:00格式化成字符串yyyyMMddHHmmss
	 * 
	 * @param dateStr
	 *            日期字符串 例如：0000.00.00 00:00:00
	 * @param formatDate
	 *            格式化字符串，例如：yyyy.MM.dd HH:mm:ss
	 * @param formatStr
	 *            　格式化字符串，例如：yyyy.MM.dd HH:mm:ss
	 * @return String类型 yyyyMMddHHmmss
	 */
	public static String formatStr(String dateStr, String formatDate,
			String formatStr) {
		Date dd = format(dateStr, formatDate);
		String str = formatter(dd, formatStr);
		return str;
	}

	/**
	 * @param dateStr
	 *            日期字符串 例如：0000-00-00 00:00:00
	 * @param formatStr
	 *            格式化字符串，例如：yyyy-MM-dd HH:mm:ss
	 * @return Date 日期类型
	 */
	public static Date format(String dateStr, String formatStr) {

		SimpleDateFormat sf = null;
		java.util.Date dd = null;
		try {
			sf = new SimpleDateFormat(formatStr);
			sf.setLenient(false);
			dd = sf.parse(dateStr);
		} catch (Exception e) {
			dd = null;
		}
		return dd;
	}

	/**
	 * 用诸如2007-01-02 00:00:00构造
	 */
	public static Calendar toCalendar(String s) {

		Calendar c = getStartOf(Calendar.getInstance());
		c.set(Integer.parseInt(s.substring(0, 4)),
				Integer.parseInt(s.substring(5, 7)) - 1,
				Integer.parseInt(s.substring(8, 10)),
				Integer.parseInt(s.substring(11, 13)),
				Integer.parseInt(s.substring(14, 16)),
				Integer.parseInt(s.substring(17, 19)));
		return c;
	}

	/**
	 * 获取指定日期的起始时间
	 */
	public static Calendar getStartOf(final Calendar calendar) {

		return new GregorianCalendar(calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Calendar getCurrentDateTime() {

		return Calendar.getInstance();
	}

	/**
	 * 2011-4-18 905471 判断传入的日期格式是否符合格式
	 */
	public static boolean isMatch(String date, Pattern pattern) {
		if (date == null || "".equals(date)) {
			return false;
		}
		return pattern.matcher(date).matches();
	}

	/**
	 * 获取指定时间前几个月的零时，零分，零秒时间点
	 * 
	 * @return
	 */
	public static Date getDate(int m, Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)
				- m, calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return calendar.getTime();
	}

	/**
	 * 获取指定时间前几个月的时间
	 * 
	 * @param m
	 * @param date
	 * @return
	 */
	public static Date getLastDate(int m, Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, m); // 将日期提前一个月
		return calendar.getTime();

	}
	
	/**
	 * 获取几天后的日期
	 * @param m
	 * @param date
	 * @return
	 */
	public static Date getDayOffDate(int m, Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, m);
		return calendar.getTime();
	}

	/**
	 * 获取指定时间零时，零分，零秒时间点
	 * 
	 * @return
	 */
	public static Date getDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return calendar.getTime();
	}

	/**
	 * 获取指定时间零时，零分，零秒时间点
	 * 
	 * @return
	 */
	public static Date getDate(Date date, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH) + num, 0, 0, 0);
		return calendar.getTime();
	}

	/**
	 * 在UTC时间的基本上+8
	 * 
	 * @param dateStr
	 *            :日期字符串 例如：0000-00-00 00:00:00
	 * @param formatStr
	 *            :格式化字符串，例如：yyyy-MM-dd'T'HH:mm:ssZ
	 * @return Date 日期类型
	 */
	public static Date getDateByUTC(String dateStr, String formatStr) {

		SimpleDateFormat sf = null;
		java.util.Date dd = null;
		try {
			sf = new SimpleDateFormat(formatStr);
			sf.setLenient(false);
			dd = sf.parse(dateStr);
			// 减去时区偏移量
			dd.setTime(dd.getTime() + getZoneOffset());
		} catch (Exception e) {
			dd = null;
		}
		return dd;
	}

	/**
	 * 获取时间偏移量
	 * 
	 * @return
	 */
	public static long getZoneOffset() {
		java.util.Calendar cal = java.util.Calendar.getInstance();

		// 2、取得时间偏移量：
		int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);

		// 3、取得夏令时差：
		int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
		return zoneOffset + dstOffset;
	}

	/**
	 * 目前只适配yyyy-MM-dd HH:mm:ss格式时间 yyyy-MM-dd HH:mm:ss格式时间 截取HH:mm:ss
	 * 
	 * @param time
	 * @return HH:mm:ss
	 */
	public static String getHourTime(String time) {
		Pattern p = Pattern.compile(YYYYMMDDHHMMSS_REGEXP);
		Matcher m = p.matcher(time);

		// 匹配SerConstants.YYYYMMDDHHMMSS_REGEXP
		if (m.matches()) {
			Pattern pattern = Pattern.compile("\\s"); // 正则表达式
			String[] strs = pattern.split(time); // 操作字符串 得到返回的字符串数组
			String temp = null;
			try {
				temp = strs[1];
			} catch (ArrayIndexOutOfBoundsException e) {

			}
			return temp;
		}

		return null;
	}

	/**
	 * 判断第一个时间是否在两个时间之间
	 * 
	 * @param firstTime
	 * @param hourTime
	 * @param hourTime2
	 * @return
	 */
	public static boolean dateIsBetWeen(String firstTime, String hourTime,
			String hourTime2) {
		if (DateUtil.dateComparison(firstTime, hourTime, DateUtil.HHMMSS)
				&& DateUtil.dateComparison(hourTime2, firstTime,
						DateUtil.HHMMSS)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断当前日期是否在指定日期之间
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static boolean betweenDate(String beginDate, String endDate){
		if(beginDate == null || endDate == null){
			return false;
		}
		try{
			if (DateUtil.dateComparison(getSysDate(YYYYMMDD), beginDate, DateUtil.YYYYMMDD)
					&& DateUtil.dateComparison(endDate, getSysDate(YYYYMMDD),
							DateUtil.YYYYMMDD)) {
				return true;
			}
			return false;
			
		}catch (Exception e){
		}
		return false;
	}

	/**
	 * 获取前一小时的时间
	 * 
	 * @return
	 */
	public static Calendar getCurrentTimeB4AnHour() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, -1);

		return cal;
	}

	/**
	 * 小时分钟转换成毫秒
	 * 
	 * @param time
	 * @return
	 */
	public static Long transformHourSecond(String time) {
		Long millisecond = 0L;
		if (null == time) {
			return millisecond;
		}
		Pattern p = Pattern.compile(HHMMSS_REGEXP);
		Matcher m = p.matcher(time);
		if (!m.matches()) {
			return millisecond;
		}
		String[] times = time.split(":");
		millisecond = (Long.parseLong(times[0]) * 3600
				+ Long.parseLong(times[1]) * 60 + Long.parseLong(times[2])) * 1000;
		return millisecond;
	}

	/**
	 *
	 * @param time
	 * @return
	 */
	public static String getTimeString(long time) {

		Date date = new Date(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				YYYYMMDDHHMMSS_SHORT);
		return simpleDateFormat.format(date);
	}

	/**
	 *返回时间 yyyy年MM月dd日HH时mm分
	 * @param time
	 * @return
	 */
	public static String getTimeStringByLong(long time) {

		Date date = new Date(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				YYYYMMDDHHMMSS_LONG);
		return simpleDateFormat.format(date);
	}
	
	/**
	 * yyyy-MM-dd HH:mm:ss 返回时间的 HH:mm:ss
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static String getTimeString(Date date) {

		try {
			String dateStr = formatter(date, YYYYMMDDHHMMSS);
			dateStr = dateStr.substring(11, 19);
			return dateStr;
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 返回时间的yyyy-MM-dd HH:mm:ss 
	 *
	 * @return
	 */
	public static String getDateTimeString(Date date) {

		try {
			String dateStr = formatter(date, YYYYMMDDHHMMSS);
			return dateStr;
		} catch (Exception e) {
		}
		return null;
	}

	public static String formatter(Date date, String format) {
		if(date!=null){
			SimpleDateFormat sf = new SimpleDateFormat(format);
			return sf.format(date);
		}else{
			return "";
		}
		
	}
}
