package com.cucumber.framework.utility;

import java.util.Calendar;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.common.GlobalVariables;
import com.cucumber.framework.common.WebUI;
import com.cucumber.framework.helper.TestBase;
import com.vimalselvam.cucumber.listener.Reporter;

public class ReportUtility extends TestBase implements BaseObjects {

	private boolean addedSystemInfo;

	/* Method loadReportFile : To load extent report config parameters
	 */
	public void loadReportFile() {
		Reporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\main\\resources\\configuration\\extent-config.xml");
		if (!addedSystemInfo) {
			setSystemInfoInExtentReport();
			addedSystemInfo = true;
		}
	}
	
	/* Method setSystemInfoInExtentReport : To set system informtion in extent report
	 */
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
