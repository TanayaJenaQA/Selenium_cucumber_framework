package com.cucumber.framework.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.helper.TestBase;

public class DateTimeUtility extends TestBase implements BaseObjects {

	/* Method getCurrentDateTime : To return system date and time
	 * @param format : String : Date time format
	 */
	public  String getCurrentDateTime(String format) {
		try {
			date = new Date();
			dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/* Method getPastDateTime : To return past system date and time
	 * @param dateTimeFormat : String :Date time format
	 * @param numberOfDaysBefore : int :Number of past days from today
	 */
	public  String getPastDateTime(String dateTimeFormat, int numberOfDaysBefore) {
		try {
			dateFormat = new SimpleDateFormat(dateTimeFormat);
			date = new Date(System.currentTimeMillis());
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, -numberOfDaysBefore);
			return dateFormat.format(cal.getTime());
		} catch (Exception e) {
			return null;
		}
	}

	/* Method getFutureDateTime : To return future system date and time
	 * @param dateTimeFormat : String :Date time format
	 * @param numberOfDaysAfter : int :Number of future days from today
	 */
	public  String getFutureDateTime(String dateTimeFormat, int numberOfDaysAfter) {
		try {
			dateFormat = new SimpleDateFormat(dateTimeFormat);
			date = new Date(System.currentTimeMillis());
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, +numberOfDaysAfter);
			return dateFormat.format(cal.getTime());
		} catch (Exception e) {
			return null;
		}
	}
}
