package com.cucumber.framework.utility;

import org.openqa.selenium.JavascriptExecutor;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.helper.TestBase;

public class JavaScriptUtility extends TestBase implements BaseObjects {

	public void clickOnElementByJS(String locator) {
		element = findWebElement(locator);
		javaScriptExecutor = ((JavascriptExecutor) driver);
		javaScriptExecutor.executeScript("arguments[0].click();", element);
	}

	public void enterTextByJS(String locator, String value) {
		element = findWebElement(locator);
		javaScriptExecutor = ((JavascriptExecutor) driver);
		javaScriptExecutor.executeScript("arguments[0].value='" + value + "';", element);
	}

	public String getDomainName() {
		javaScriptExecutor = ((JavascriptExecutor) driver);
		String DomainName = javaScriptExecutor.executeScript("return document.domain;").toString();
		return DomainName;
	}

	public void scrollWindow(int from, int to) {
		javaScriptExecutor = ((JavascriptExecutor) driver);
		javaScriptExecutor.executeScript("window.scrollBy(" + from + "," + to + ")");
	}

	public boolean isPageCompletelyLoaded() {
		javaScriptExecutor = ((JavascriptExecutor) driver);
		String pageLoadStatus = javaScriptExecutor.executeScript("return document.readyState").toString();
		if (pageLoadStatus.equalsIgnoreCase("complete"))
			return true;
		else
			return false;
	}

	public void selectDropDownByJS(String locator, String value) {
		element = findWebElement(locator);
		javaScriptExecutor = ((JavascriptExecutor) driver);
		javaScriptExecutor.executeScript("arguments[0].value='" + value + "';", element);
	}
}
