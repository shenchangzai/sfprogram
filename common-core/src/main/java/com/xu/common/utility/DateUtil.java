package com.xu.common.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	   
	private DateUtil(){}
	public static final  String YYYYMMDDHHMMSS_LONG = "yyyy年MM月dd日HH时mm分";

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
}
