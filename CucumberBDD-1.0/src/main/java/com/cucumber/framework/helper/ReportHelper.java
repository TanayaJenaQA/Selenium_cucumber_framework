package com.cucumber.framework.helper;

import java.util.Calendar;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.common.GlobalVariables;
import com.cucumber.framework.common.WebUI;
import com.cucumber.framework.pageobjects.BasePage;
import com.vimalselvam.cucumber.listener.Reporter;

public class ReportHelper extends BasePage implements BaseObjects {

	private boolean addedSystemInfo;
	
	public void loadReportFile() {
		Reporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\main\\resources\\configuration\\extent-config.xml");
		if (!addedSystemInfo) {
			setSystemInfoInExtentReport();
			addedSystemInfo = true;
		}
	}
	
	public void setSystemInfoInExtentReport() {
		Reporter.getExtentReport().setSystemInfo("Domain :", WebUI.getDomainName());
		Reporter.getExtentReport().setSystemInfo("Environment :", "Test");
		Reporter.getExtentReport().setSystemInfo("User :", System.getProperty("user.name"));
		Reporter.getExtentReport().setSystemInfo("OS Name :", System.getProperty("os.name"));
		Reporter.getExtentReport().setSystemInfo("OS Version :", System.getProperty("os.version"));
		Reporter.getExtentReport().setSystemInfo("Browser:", GlobalVariables.browser+"-"+GlobalVariables.browserVersion);
		Reporter.getExtentReport().setSystemInfo("TimeZone :", Calendar.getInstance().getTimeZone().getDisplayName());
	}
}
