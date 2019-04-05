package com.cucumber.framework.pageobjects;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cucumber.framework.common.BrowserType;
import com.cucumber.framework.common.GlobalVariables;
import com.cucumber.framework.helper.GenericHelper;
import com.cucumber.framework.helper.PropertyFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage extends GenericHelper {

	public static boolean launchBrowser() throws IOException {
		try {
			LOG.debug("debug");
			LOG.info("info");
			LOG.warn("warn");
			LOG.error("error message updated");
			projectdirectory = System.getProperty("user.dir");

			if (PropertyFileReader.getBrowser() == BrowserType.Chrome) {
				if (!PropertyFileReader.getBrowserVersion().equalsIgnoreCase("Latest")) {
					WebDriverManager.chromedriver().version(PropertyFileReader.getBrowserVersion()).setup();
					ChromeOptions option = new ChromeOptions();
					option.addArguments("disable-infobars");
					driver = new ChromeDriver(option);
				} else {
					WebDriverManager.chromedriver().setup();
					GlobalVariables.browserVersion = WebDriverManager.chromedriver().getDownloadedVersion();
					ChromeOptions option = new ChromeOptions();
					option.addArguments("disable-infobars");
					driver = new ChromeDriver(option);
				}

			} else if (PropertyFileReader.getBrowser() == BrowserType.FireFox) {
				if (!PropertyFileReader.getBrowserVersion().equalsIgnoreCase("Latest")) {
					WebDriverManager.firefoxdriver().version(PropertyFileReader.getBrowserVersion()).setup();
					driver = new FirefoxDriver();
				} else {
					WebDriverManager.firefoxdriver().setup();
					GlobalVariables.browserVersion = WebDriverManager.firefoxdriver().getDownloadedVersion();
					driver = new FirefoxDriver();
				}
			} else if (PropertyFileReader.getBrowser() == BrowserType.IE) {
				if (!PropertyFileReader.getBrowserVersion().equalsIgnoreCase("Latest")) {
					WebDriverManager.iedriver().version(PropertyFileReader.getBrowserVersion()).setup();
					driver = new InternetExplorerDriver();
				} else {
					WebDriverManager.iedriver().setup();
					GlobalVariables.browserVersion = WebDriverManager.iedriver().getDownloadedVersion();
					driver = new InternetExplorerDriver();
				}
			} else if (PropertyFileReader.getBrowser() == BrowserType.Edge) {
				if (!PropertyFileReader.getBrowserVersion().equalsIgnoreCase("Latest")) {
					WebDriverManager.edgedriver().version(PropertyFileReader.getBrowserVersion()).setup();
					driver = new EdgeDriver();
				} else {
					WebDriverManager.edgedriver().setup();
					GlobalVariables.browserVersion = WebDriverManager.edgedriver().getDownloadedVersion();
					driver = new EdgeDriver();
				}
			}
			driver.get(PropertyFileReader.getUrl());
			driver.manage().window().maximize();
			waitsObj.waitForPageLoad();
		} catch (Exception e) {
			Assert.fail("No Browser Launched\n" + e.getMessage());
		}
		return iStatus = true;
	}

	public static void tearDown() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("Unable to close the browser");
		} finally {
			// killDriver();
		}
	}

	public static void killDriver() {
		String exeFileName = null;
		try {
			if (PropertyFileReader.getBrowser() == BrowserType.Chrome) {
				exeFileName = "chrome.exe";
				Runtime.getRuntime().exec("taskkill /f /im chrome.exe");
			} else if (PropertyFileReader.getBrowser() == BrowserType.FireFox) {
				exeFileName = "irefox.exe";
				Runtime.getRuntime().exec("taskkill /f /im firefox.exe");
			} else if (PropertyFileReader.getBrowser() == BrowserType.IE) {
				exeFileName = "iexplore.exe";
				Runtime.getRuntime().exec("taskkill /f /im iexplore.exe");
			} else if (PropertyFileReader.getBrowser() == BrowserType.Edge) {
				exeFileName = "edge.exe";
				Runtime.getRuntime().exec("taskkill /f /im edge.exe");
			}
		} catch (Exception e) {
			System.out.println("Unable to kill " + exeFileName + " driver");
		}
	}
}
