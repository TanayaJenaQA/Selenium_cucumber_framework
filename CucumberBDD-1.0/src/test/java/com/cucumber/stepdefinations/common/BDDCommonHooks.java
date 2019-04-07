package com.cucumber.stepdefinations.common;

import java.io.IOException;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.helper.TestBase;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BDDCommonHooks extends TestBase implements BaseObjects {

	@Before()
	public void BeforeRun(Scenario scenario) throws IOException {
		//launchBrowser();
	}

	@After()
	public void AfterRun(Scenario scenario) throws IOException {
		reportHelperObj.loadReportFile();
		if (scenario.isFailed()) {
			Reporter.addScreenCaptureFromPath(screenshotHelperObj.takeScreenShot(scenario.getName()));
		}
		tearDown();
	}
}
