package com.cucumber.framework.common;

import com.cucumber.framework.pageobjects.homepage.RegistrationPage;
import com.cucumber.framework.utility.DateTimeUtility;
import com.cucumber.framework.utility.ExcelReaderUtility;
import com.cucumber.framework.utility.JavaScriptUtility;
import com.cucumber.framework.utility.ReportUtility;
import com.cucumber.framework.utility.ScreenshotUtility;

public interface BaseObjects {
	
	/** Declare an object for each class, to access the non-static methods and non-static variables in other classes */
	
	Waits waitsObj = new Waits();
	ExcelReaderUtility excelReaderObj = new ExcelReaderUtility();
	ReportUtility reportHelperObj = new ReportUtility();
	DateTimeUtility dateTimeutilsObj = new DateTimeUtility();
	JavaScriptUtility javaScriptutilsObj = new JavaScriptUtility();
	ScreenshotUtility screenshotHelperObj = new ScreenshotUtility();
	RegistrationPage registrationPageObj = new RegistrationPage();
}
