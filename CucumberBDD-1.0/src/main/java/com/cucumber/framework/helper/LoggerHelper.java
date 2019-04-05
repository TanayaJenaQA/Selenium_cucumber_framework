package com.cucumber.framework.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.pageobjects.BasePage;

public class LoggerHelper extends BasePage implements BaseObjects {
	
	public static final Logger LOG = LogManager.getLogger();
}
