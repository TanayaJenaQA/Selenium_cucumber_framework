package com.cucumber.stepdefinations;

import java.io.IOException;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.pageobjects.BasePage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BDDCommonHooks extends BasePage implements BaseObjects {

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
