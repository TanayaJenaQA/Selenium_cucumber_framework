package com.cucumber.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.pageobjects.BasePage;

public class DateTimeutils extends BasePage implements BaseObjects {

	public  String getCurrentDateTime(String format) {
		try {
			date = new Date();
			dateFormat = new SimpleDateFormat(format);
			return dateFormat.format(date);
		} catch (Exception e) {
			return null;
		}
	}

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
