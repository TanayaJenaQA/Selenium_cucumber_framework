package com.cucumber.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

import com.cucumber.framework.common.BaseObjects;
import com.cucumber.framework.common.BrowserType;
import com.cucumber.framework.common.GlobalVariables;
import com.cucumber.framework.helper.TestBase;

public class PropertyFileReaderUtility extends TestBase implements BaseObjects {

	/* Method getPropertiesFile : To return properties from the property file
	 */
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
	
	/* Method getBrowser : To return browser type from the property file
	 */
	public static BrowserType getBrowser() throws IOException {
		GlobalVariables.browser = null;
		GlobalVariables.browser = getPropertiesFile().getProperty("browser");
		return BrowserType.valueOf(GlobalVariables.browser);
	}

	/* Method getBrowserVersion : To return browser version from the property file
	 */
	public static String getBrowserVersion() throws IOException {
		GlobalVariables.browserVersion = null;
		GlobalVariables.browserVersion = getPropertiesFile().getProperty("version");
		return GlobalVariables.browserVersion;
	}

	/* Method getUserName : To return user name from the property file
	 */
	public static String getUserName() throws IOException {
		GlobalVariables.username = null;
		GlobalVariables.username = getPropertiesFile().getProperty("username");
		return GlobalVariables.username;
	}

	/* Method getPassword : To return password from the property file
	 */
	public static String getPassword() throws IOException {
		GlobalVariables.password = null;
		GlobalVariables.password = getPropertiesFile().getProperty("password");
		return GlobalVariables.password;
	}

	/* Method getUrl : To return url from the property file
	 */
	public static String getUrl() throws IOException {
		GlobalVariables.url = null;
		GlobalVariables.url = getPropertiesFile().getProperty("Url");
		return GlobalVariables.url;
	}
}
