package com.cucumber.framework.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.common.BrowserType;
import com.cucumber.framework.common.GlobalVariables;
import com.cucumber.framework.pageobjects.BasePage;

public class PropertyFileReader extends BasePage implements BaseObjects {

	public static Properties getPropertiesFile() throws IOException {
		property = new Properties();
		try {
			propertyFilePath = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\configuration\\config.properties";
			inputstream = new FileInputStream(new File(propertyFilePath));
			property.load(inputstream);
			return property;
		} catch (Exception e) {
			Assert.fail("Property File Invoke Error \n" + e.getMessage());
		} finally {
			inputstream.close();
		}
		return null;
	}

	public static BrowserType getBrowser() throws IOException {
		GlobalVariables.browser = null;
		GlobalVariables.browser = getPropertiesFile().getProperty("browser");
		return BrowserType.valueOf(GlobalVariables.browser);
	}

	public static String getBrowserVersion() throws IOException {
		GlobalVariables.browserVersion = null;
		GlobalVariables.browserVersion = getPropertiesFile().getProperty("version");
		return GlobalVariables.browserVersion;
	}

	public static String getUserName() throws IOException {
		GlobalVariables.username = null;
		GlobalVariables.username = getPropertiesFile().getProperty("username");
		return GlobalVariables.username;
	}

	public static String getPassword() throws IOException {
		GlobalVariables.password = null;
		GlobalVariables.password = getPropertiesFile().getProperty("password");
		return GlobalVariables.password;
	}

	public static String getUrl() throws IOException {
		GlobalVariables.url = null;
		GlobalVariables.url = getPropertiesFile().getProperty("Url");
		return GlobalVariables.url;
	}
}
