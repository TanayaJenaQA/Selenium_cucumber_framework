package com.cucumber.framework.helper;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cucumber.framework.common.BrowserType;
import com.cucumber.framework.common.GlobalVariables;
import com.cucumber.framework.utility.PropertyFileReaderUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends GenericHelper {

	/* Method launchBrowser : To launch the browser based on data from property file
	 */
	public static boolean launchBrowser() throws IOException {
		try {
			LOG.debug("Browsr launched");
			LOG.info("info");
			LOG.warn("warn");
			
			LOG.error("error message updated");
			projectdirectory = System.getProperty("user.dir");

			if (PropertyFileReaderUtility.getBrowser() == BrowserType.Chrome) {
				if (!PropertyFileReaderUtility.getBrowserVersion().equalsIgnoreCase("Latest")) {
					WebDriverManager.chromedriver().version(PropertyFileReaderUtility.getBrowserVersion()).setup();
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

			} else if (PropertyFileReaderUtility.getBrowser() == BrowserType.FireFox) {
				if (!PropertyFileReaderUtility.getBrowserVersion().equalsIgnoreCase("Latest")) {
					WebDriverManager.firefoxdriver().version(PropertyFileReaderUtility.getBrowserVersion()).setup();
					driver = new FirefoxDriver();
				} else {
					WebDriverManager.firefoxdriver().setup();
					GlobalVariables.browserVersion = WebDriverManager.firefoxdriver().getDownloadedVersion();
					driver = new FirefoxDriver();
				}
			} else if (PropertyFileReaderUtility.getBrowser() == BrowserType.IE) {
				if (!PropertyFileReaderUtility.getBrowserVersion().equalsIgnoreCase("Latest")) {
					WebDriverManager.iedriver().version(PropertyFileReaderUtility.getBrowserVersion()).setup();
					driver = new InternetExplorerDriver();
				} else {
					WebDriverManager.iedriver().setup();
					GlobalVariables.browserVersion = WebDriverManager.iedriver().getDownloadedVersion();
					driver = new InternetExplorerDriver();
				}
			} else if (PropertyFileReaderUtility.getBrowser() == BrowserType.Edge) {
				if (!PropertyFileReaderUtility.getBrowserVersion().equalsIgnoreCase("Latest")) {
					WebDriverManager.edgedriver().version(PropertyFileReaderUtility.getBrowserVersion()).setup();
					driver = new EdgeDriver();
				} else {
					WebDriverManager.edgedriver().setup();
					GlobalVariables.browserVersion = WebDriverManager.edgedriver().getDownloadedVersion();
					driver = new EdgeDriver();
				}
			}
			driver.get(PropertyFileReaderUtility.getUrl());
			driver.manage().window().maximize();
			waitsObj.waitForPageLoad();
		} catch (Exception e) {
			Assert.fail("No Browser Launched\n" + e.getMessage());
		}
		return iStatus = true;
	}

	/* Method tearDown : To terminate or close the opened browser
	 */
	public static void tearDown() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("Unable to close the browser");
		} finally {
			// killDriver();
		}
	}

	/* Method killDriver : To kill all the browser drivers from taskmanager
	 */
	public static void killDriver() {
		String exeFileName = null;
		try {
			if (PropertyFileReaderUtility.getBrowser() == BrowserType.Chrome) {
				exeFileName = "chrome.exe";
				Runtime.getRuntime().exec("taskkill /f /im chrome.exe");
			} else if (PropertyFileReaderUtility.getBrowser() == BrowserType.FireFox) {
				exeFileName = "irefox.exe";
				Runtime.getRuntime().exec("taskkill /f /im firefox.exe");
			} else if (PropertyFileReaderUtility.getBrowser() == BrowserType.IE) {
				exeFileName = "iexplore.exe";
				Runtime.getRuntime().exec("taskkill /f /im iexplore.exe");
			} else if (PropertyFileReaderUtility.getBrowser() == BrowserType.Edge) {
				exeFileName = "edge.exe";
				Runtime.getRuntime().exec("taskkill /f /im edge.exe");
			}
		} catch (Exception e) {
			System.out.println("Unable to kill " + exeFileName + " driver");
		}
	}
}
