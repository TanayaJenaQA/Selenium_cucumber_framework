package com.cucumber.stepdefinations;

import com.cucumber.framework.pageobjects.BasePage;

import cucumber.api.java.en.Given;

public class CommonSteps {
	@Given("^User is log in to the toolsQA application$")
	public void user_is_log_in_to_the_toolsQA_application() throws Throwable {
		BasePage.launchBrowser();
	}
}
