package com.cucumber.framework.common;

import com.cucumber.framework.helper.ExcelReader;
import com.cucumber.framework.helper.LoggerHelper;
import com.cucumber.framework.helper.ReportHelper;
import com.cucumber.framework.helper.ScreenshotHelper;
import com.cucumber.framework.pageobjects.RegistrationPage;
import com.cucumber.framework.utils.DateTimeutils;
import com.cucumber.framework.utils.JavaScriptutils;

public interface BaseObjects {
	
	/** Declare an object for each class, to access the non-static methods and non-static variables in other classes */
	
	Waits waitsObj = new Waits();
	ExcelReader excelReaderObj = new ExcelReader();
	ReportHelper reportHelperObj = new ReportHelper();
	LoggerHelper loggerHelperObj = new LoggerHelper();
	DateTimeutils dateTimeutilsObj = new DateTimeutils();
	JavaScriptutils javaScriptutilsObj = new JavaScriptutils();
	ScreenshotHelper screenshotHelperObj = new ScreenshotHelper();
	RegistrationPage registrationPageObj = new RegistrationPage();
}
