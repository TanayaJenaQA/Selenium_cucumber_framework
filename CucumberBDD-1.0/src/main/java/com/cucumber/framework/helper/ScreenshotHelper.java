package com.cucumber.framework.helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.pageobjects.BasePage;

public class ScreenshotHelper extends BasePage implements BaseObjects{

	protected static String screenshotPath;
	
	public String takeScreenShot(String scenarioName) throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourcePath = ts.getScreenshotAs(OutputType.FILE);
			String destinationPath = System.getProperty("user.dir") +"\\target\\failedScreenshots\\" +
					dateTimeutilsObj.getCurrentDateTime("dd-MM-yyyy") + "\\" + scenarioName+"_"+testCaseId + "_"+
					dateTimeutilsObj.getCurrentDateTime("HH_mm_ss")+".png";
			File screenshotPath = new File(destinationPath);
			FileUtils.copyFile(sourcePath, screenshotPath);
			return destinationPath;
		} catch (WebDriverException e) {
			Assert.fail("Unable to take screenShot");
		}
		return null;
	}
}
