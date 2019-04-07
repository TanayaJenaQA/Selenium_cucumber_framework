package com.cucumber.framework.helper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.common.GlobalVariables;

public  class GenericHelper extends GlobalVariables implements BaseObjects {

	/* Method findWebElement : To return webelement based on locator
	 * @param argument : String : Locator of the element
	 */
	public static WebElement findWebElement(String locator) {
		try {
			element = null;
			if (driver.findElement(By.id(locator)).isDisplayed()) {
				element = driver.findElement(By.id(locator));
				return element;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.name(locator)).isDisplayed()) {
				element = driver.findElement(By.name(locator));
				return element;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.className(locator)).isDisplayed()) {
				element = driver.findElement(By.className(locator));
				return element;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.linkText(locator)).isDisplayed()) {
				element = driver.findElement(By.linkText(locator));
				return element;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.cssSelector(locator)).isDisplayed()) {
				element = driver.findElement(By.cssSelector(locator));
				return element;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.partialLinkText(locator)).isDisplayed()) {
				element = driver.findElement(By.partialLinkText(locator));
				return element;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.xpath(locator)).isDisplayed()) {
				element = driver.findElement(By.xpath(locator));
				return element;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.tagName(locator)).isDisplayed()) {
				element = driver.findElement(By.tagName(locator));
				return element;
			}
		} catch (Exception e) {// ignore exception
		}
		if (element == null) {
			Assert.fail("\n Locator : " + locator + " ************** Not Found");
		}
		return null;
	}

	/* Method findWebElements : To return webelements based on locator
	 * @param argument : String :  Locator of the element
	 */
	public static List<WebElement> findWebElements(String locator) {
		try {
			List<WebElement> elements = new ArrayList<>();
			if (driver.findElement(By.id(locator)).isDisplayed()) {
				elements = driver.findElements(By.id(locator));
				return elements;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.name(locator)).isDisplayed()) {
				elements = driver.findElements(By.name(locator));
				return elements;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.className(locator)).isDisplayed()) {
				elements = driver.findElements(By.className(locator));
				return elements;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.linkText(locator)).isDisplayed()) {
				elements = driver.findElements(By.linkText(locator));
				return elements;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.cssSelector(locator)).isDisplayed()) {
				elements = driver.findElements(By.cssSelector(locator));
				return elements;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.partialLinkText(locator)).isDisplayed()) {
				elements = driver.findElements(By.partialLinkText(locator));
				return elements;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.xpath(locator)).isDisplayed()) {
				elements = driver.findElements(By.xpath(locator));
				return elements;
			}
		} catch (Exception e) {// ignore exception
		}
		try {
			if (driver.findElement(By.tagName(locator)).isDisplayed()) {
				elements = driver.findElements(By.tagName(locator));
				return elements;
			}
		} catch (Exception e) {// ignore exception
		}
		if (element == null) {
			Assert.fail("\n Locator : " + locator + " ************** Not Found");
		}
		return null;
	}

}
