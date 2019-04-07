package com.cucumber.stepdefinations.common;

import com.cucumber.framework.helper.TestBase;

import cucumber.api.java.en.Given;

public class CommonSteps {
	@Given("^User is log in to the toolsQA application$")
	public void user_is_log_in_to_the_toolsQA_application() throws Throwable {
		TestBase.launchBrowser();
	}
}
