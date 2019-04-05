package com.cucumber.framework.common;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.framework.pageobjects.BasePage;

public class Waits extends BasePage implements BaseObjects {

	public void waitForPageLoad(int timeInSeconds) throws InterruptedException {
		Thread.sleep(timeInSeconds * 1000);
	}

	public void waitForPageLoad() throws InterruptedException {
		try {
			if (!javaScriptutilsObj.isPageCompletelyLoaded()) {
				waitForPageLoad(mediumTime);
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void implicityWaitForPageLoad(int timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	public boolean waitForElementIsClickable(String locator, int waitTimeInSeconds) {
		try {
			element = findWebElement(locator);
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean waitForElementIsInvisible(String locator, int waitTimeInSeconds) {

		try {
			element = findWebElement(locator);
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean waitForElementIsVisible(String locator, int waitTimeInSeconds) {
		try {
			element = findWebElement(locator);
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean waitForFrameAndSwitchToIt(String locator, int waitTimeInSeconds) {
		try {
			element = findWebElement(locator);
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
