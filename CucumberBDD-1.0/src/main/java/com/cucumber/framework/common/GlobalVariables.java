package com.cucumber.framework.common;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GlobalVariables {
	
	/* * Declare all global and common variables here*/	
	
	public static WebDriver driver;
	public static WebElement element;
	public static boolean iStatus;
	public static String errorMessage;
	public static List<WebElement> elements;
	public static String browser;
	public static String browserVersion;
	public static String url;
	public static String username;
	public static String password;
	public static SimpleDateFormat dateFormat;
	public static String propertyFilePath;
	public static String projectdirectory;
	public static FileInputStream inputstream;
	public static String parentWindowName;
	public static String screenshotPath;
	public static Properties property;	
	public static Date date;
	public static Select select;
	public static Actions action;
	public static int smallTime = 3;
	public static int mediumTime = 5;
	public static int longTime = 10;	
	public static int veryLongTime = 15;
	public static String testCaseId ;
	public static JavascriptExecutor javaScriptExecutor;	
	public static Map<String, String> testdatReader ;
	public static final Logger LOG = LogManager.getLogger();
}