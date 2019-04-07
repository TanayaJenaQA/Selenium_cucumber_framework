package com.cucumber.framework.common;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.framework.helper.TestBase;

public class Waits extends TestBase implements BaseObjects {

	/* Method waitForPageLoad: To wait for loading the page with given time
	 * @param timeInSeconds  : integer : Time in seconds
	 */
	public void waitForPageLoad(int timeInSeconds) throws InterruptedException {
		Thread.sleep(timeInSeconds * 1000);
	}

	/* Method waitForPageLoad: To wait for loading the page
	 */
	public void waitForPageLoad() throws InterruptedException {
		try {
			if (!javaScriptutilsObj.isPageCompletelyLoaded()) {
				waitForPageLoad(mediumTime);
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	/* Method implicityWaitForPageLoad: To implicitly wait for loading the page with in given time
	 * @param timeInSeconds  : integer : Time in seconds
	 */
	public void implicityWaitForPageLoad(int timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	/* Method waitForElementIsClickable: To wait for the element to be clickable
	 * @param waitTimeInSeconds  : integer : Time in seconds
	 * @param locator  : String : Locator of the element
	 */
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

	/* Method waitForElementIsInvisible: To wait for the element to be invisible
	 * @param waitTimeInSeconds  : integer : Time in seconds
	 * @param locator  : String : Locator of the element
	 */
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

	/* Method waitForElementIsVisible: To wait for the element to be visible
	 * @param waitTimeInSeconds  : integer : Time in seconds
	 * @param locator  : String : Locator of the element
	 */
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

	/* Method waitForFrameAndSwitchToIt: To wait for the frame and switch to it
	 * @param waitTimeInSeconds  : integer : Time in seconds
	 * @param locator  : String : Name or ID of the frame
	 */
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
