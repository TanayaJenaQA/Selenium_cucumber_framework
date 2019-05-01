package com.cucumber.stepdefinations.homepage;

import org.junit.runners.Parameterized.Parameters;

import com.cucumber.framework.common.BaseObjects;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ToolsQASteps implements BaseObjects {
	
	@When("^User enters valid personal information from \"([^\"]*)\"$")
	public void user_enters_valid_personal_information_from(String testDataReferenceId) throws Throwable {
		registrationPageObj.fillForm(testDataReferenceId);
	}
	@When("^User clicks the submit button$")
	public void user_clicks_the_submit_button() throws Throwable {
		registrationPageObj.clickSubmit();
	}

	@Then("^User validate the success message$")
	public void user_validate_the_success_message() throws Throwable {
		System.out.println("TestCase Executed");
	}
}
