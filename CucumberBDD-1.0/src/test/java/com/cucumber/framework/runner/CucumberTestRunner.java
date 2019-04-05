package com.cucumber.framework.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
		                   "html:target\\defaultReport\\CucumberResult.html",
		                   "json:target\\defaultReport\\CucumberResult.json",
		                   "junit:target\\defaultReport\\CucumberResult.xml",
		                   "rerun:target\\failedTestcase\\FailedTestCases.txt",
		                   "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target\\extentReport\\CucumberExtent.html"},

		features = {"src\\test\\resources\\featurefiles\\regressionsuite\\TestCase.feature"},
		glue = {"com.cucumber.stepdefinations"},
		dryRun = false,
		monochrome=true,
		strict = true)
		//tags= {"@regression"})
public class CucumberTestRunner {}