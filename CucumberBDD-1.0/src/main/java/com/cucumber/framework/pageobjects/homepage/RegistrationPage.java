package com.cucumber.framework.pageobjects.homepage;

import java.io.IOException;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.common.WebUI;
import com.cucumber.framework.helper.TestBase;
public class RegistrationPage extends TestBase implements BaseObjects {

	private String input_FirstName="firstname";
	private String input_LastName="lastname";
	private String radio_Sex="//input[@id='sex-1' and @value='Female']";
	private String radio_Exp="exp-2";
	private String input_Date="datepicker";
	private String dropdown_country="continents";
	private String button_Submit ="submit";
	
	
	public void fillForm(String testdataReference) throws IOException {
		excelReaderObj.readTestCaseID(testdataReference);
		WebUI.enterText(input_FirstName, excelReaderObj.getTestData("firstname"));
		WebUI.enterText(input_LastName, excelReaderObj.getTestData("lastname"));
		WebUI.selectRadioButton(radio_Sex);
		WebUI.selectRadioButton(radio_Exp);
		WebUI.enterText(input_Date, excelReaderObj.getTestData("datepicker"));
		WebUI.selectDropDownByText(dropdown_country, excelReaderObj.getTestData("continents"));
	}
	
	public void clickSubmit() {
		WebUI.clickOnElement(button_Submit);
	}
}
