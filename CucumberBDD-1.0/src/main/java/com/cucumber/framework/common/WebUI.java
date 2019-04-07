package com.cucumber.framework.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.framework.helper.TestBase;

public class WebUI extends TestBase implements BaseObjects {
	
	/* Method enterText: To enter any text into input type text field
	 * @param locator  : String : Locator of the text field
	 * @param inputText: String : Text that you want to enter
	 */	 
	public static void enterText(String locator, String inputText) {
		if (waitsObj.waitForElementIsVisible(locator, longTime)) {
			findWebElement(locator).clear();
			findWebElement(locator).sendKeys(inputText);
		} else
			Assert.fail("\n Enter text into locator : " + locator + " ************* Failed");
	}
	
	/* Method enterTextByJavaScript: To enter any text into input type text field using java script
	 * @param locator  : String : Locator of the text field
	 * @param inputText: String : Text that you want to enter
	 */	
	public static void enterTextByJavaScript(String locator, String inputText) {
		if (waitsObj.waitForElementIsVisible(locator, longTime)) {
			javaScriptutilsObj.enterTextByJS(locator, inputText);
		} else
			Assert.fail("\n Enter text into locator : " + locator + " ************* Failed");
	}

	/* Method enterTextCharByChar: To enter any text into input type text field character by character
	 * @param locator  : String : Locator of the text field
	 * @param inputText: String : Text that you want to enter
	 */	
	public static void enterTextCharByChar(String locator, String inputText) {
		if (waitsObj.waitForElementIsVisible(locator, longTime)) {
			char[] convertedCharArray = inputText.toCharArray();
			findWebElement(locator).clear();
			for (int iCount = 0; iCount < convertedCharArray.length; iCount++) {
				findWebElement(locator).sendKeys(String.valueOf(convertedCharArray[iCount]));
			}
		} else
			Assert.fail("\n Enter text char by char into locator : " + locator + " ************* Failed");
	}

	/* Method enterTextAndPressEnterKey: To enter any text into input type text field and press <Enter> key
	 * @param locator  : String : Locator of the text field
	 * @param inputText: String : Text that you want to enter
	 */
	public static void enterTextAndPressEnterKey(String locator, String inputText) {
		action = new Actions(driver);
		if (waitsObj.waitForElementIsVisible(locator, longTime)) {
			findWebElement(locator).sendKeys(inputText);
			action.sendKeys(Keys.ENTER).build().perform();
		} else
			Assert.fail("\n Enter text and press <Enter> Key with locator : : " + locator + " ************* Failed");
	}

	/* Method clickOnElement: To click on button or option or menu
	 * @param locator  : String : Locator of the element that you want to click
	 */
	public static void clickOnElement(String locator) {
		if (findWebElement(locator).isDisplayed())
			findWebElement(locator).click();
		else
			Assert.fail("\n Click on element with locator : " + locator + " ************* Failed");
	}
	
	/* Method clickOnElementByJavaScript: To click on button or option or menu using java script
	 * @param locator  : String : Locator of the element that you want to click
	 */
	public static void clickOnElementByJavaScript(String locator) {
		if (findWebElement(locator).isDisplayed())
			javaScriptutilsObj.clickOnElementByJS(locator);
		else
			Assert.fail("\n Click on element with locator : " + locator + " ************* Failed");
	}
	
	/* Method doubleClickOnElement: To double click on button or option or menu
	 * @param locator  : String : Locator of the element that you want to click
	 */
	public static void doubleClickOnElement(String locator) {
		action = new Actions(driver);
		if (findWebElement(locator).isDisplayed())
			action.doubleClick(findWebElement(locator)).build().perform();
		else
			Assert.fail("\n Double click on element with locator : " + locator + " ************* Failed");
	}

	/* Method contextClick: Focus and right click on element
	 * @param locator  : String : Locator of the element that you want to double click
	 */
	public static void contextClick(String locator) {
		action = new Actions(driver);
		if (waitsObj.waitForElementIsVisible(locator, longTime))
			action.contextClick(findWebElement(locator)).build().perform();
		else
			Assert.fail("\n Context click on element with locator : " + locator + " ************* Not Found");
	}

	/* Method waitAndClickOnElement: wait for the element before click
	 * @param locator  : String : Locator of the element that you want to click
	 * @param waitTimeInSeconds  : integer : wait time in second
	 */
	public static void waitAndClickOnElement(String locator, int waitTimeInSeconds) {
		if (waitsObj.waitForElementIsClickable(locator, waitTimeInSeconds))
			findWebElement(locator).click();
		else
			Assert.fail("\n Click on element with locator : " + locator + " ************* Failed");
	}

	/* Method waitAndDoubleClickOnElement: To wait for the element before double click
	 * @param locator  : String : Locator of the element that you want to double click
	 * @param waitTimeInSeconds  : integer : wait time in second
	 */
	public static void waitAndDoubleClickOnElement(String locator, int waitTimeInSeconds) {
		action = new Actions(driver);
		if (waitsObj.waitForElementIsClickable(locator, waitTimeInSeconds))
			action.doubleClick(findWebElement(locator)).build().perform();
		else
			Assert.fail("\n Double click on element with locator : " + locator + " ************* Failed");
	}
	
	/* Method selectOrUnselectCheckBox: To select and unselect the check box
	 * @param locator  : String : Locator of the check box that you want to select or unselect 
	 */
	public static void selectOrUnselectCheckBox(String locator) {
		if (findWebElement(locator).isDisplayed())
			findWebElement(locator).click();
		else
			Assert.fail("\n Select on check box with locator : " + locator + " ************* Failed");
	}

	/* Method selectRadioButton: To select radio button
	 * @param locator  : String : Locator of the radio button that you want to select
	 */
	public static void selectRadioButton(String locator) {
		if (findWebElement(locator).isDisplayed())
			findWebElement(locator).click();
		else
			Assert.fail("\n Select radio button with locator : " + locator + " ************* Failed");
	}

	/* Method selectDropDownByValue: To select the dropdown value 
	 * @param dropdownLocator  : String : Locator of the dropdown
	 * @param value  : String :Value that you want to select from the dropdown
	 */
	public static void selectDropDownByValue(String dropdownLocator, String value) {
		try {
			select = new Select(findWebElement(dropdownLocator));
			select.selectByValue(value);
		} catch (Exception e) {
			Assert.fail("\n Unable to select value :" + value + " from dropdown :" + dropdownLocator);
		}
	}

	/* Method selectDropDownByText: To select the dropdown value 
	 * @param dropdownLocator  : String : Locator of the dropdown
	 * @param text  : String :Text that you want to select from the dropdown
	 */
	public static void selectDropDownByText(String dropdownLocator, String text) {
		try {
			select = new Select(findWebElement(dropdownLocator));
			select.selectByVisibleText(text);
		} catch (Exception e) {
			Assert.fail("\n Unable to select text :" + text + " from dropdown :" + dropdownLocator);
		}
	}

	/* Method selectDropDownByIndex: To select the dropdown value 
	 * @param dropdownLocator  : String : Locator of the dropdown
	 * @param index  : String :Index that you want to select from the dropdown
	 */
	public static void selectDropDownByIndex(String dropdownLocator, int index) {
		try {
			select = new Select(findWebElement(dropdownLocator));
			select.deselectByIndex(index);
		} catch (Exception e) {
			Assert.fail("\n Unable to select index :" + index + " from dropdown :" + dropdownLocator);
		}
	}

	/* Method selectDropDownByJavaScript: To select the dropdown value by using javascript
	 * @param dropdownLocator  : String : Locator of the dropdown
	 * @param value  : String :Value that you want to select from the dropdown
	 */
	public static void selectDropDownByJavaScript(String dropdownLocator, String value) {
		try {
			javaScriptutilsObj.selectDropDownByJS(dropdownLocator, value);
		} catch (Exception e) {
			Assert.fail("\n Unable to select value :" + value + " from dropdown :" + dropdownLocator);
		}
	}

	/* Method getSelectedDropdownValue: To get selected value from dropdown
	 * @param locator  : String : Locator of the dropdown
	 */
	public static String getSelectedDropdownValue(String locator) {
		try {
			select = new Select(findWebElement(locator));
			String selectedValue = select.getFirstSelectedOption().getText();
			return selectedValue;
		} catch (Exception e) {
			return null;
		}
	}
	
     /* Method getAllOptionsFromDropDown: To get all options from dropdown
	 * @param locator  : String : Locator of the dropdown
	 */
	public static List<String> getAllOptionsFromDropDown(String locator) {
		List<String> allValue = new ArrayList<String>();
		try {			
			select = new Select(findWebElement(locator));
			List<WebElement> allElements = select.getOptions();
			for (WebElement webElement : allElements) {
				allValue.add(webElement.getText());
			}
			return allValue;
		} catch (Exception e) {
			return null;
		}
	}

	/* Method getWebElement: To get required web element from the locator
		 * @param locator  : String : Locator of the element 
    */
	public static WebElement getWebElement(String locator) {
		try {
			WebElement element = findWebElement(locator);
			return element;
		} catch (Exception e) {
			return null;
		}
	}

	/* Method getWebElements: To get all web elements which matches the locator
	 * @param locator  : String : Locator of the element 
     */
	public static List<WebElement> getWebElements(String locator) {
		try {
			return findWebElements(locator);
		} catch (Exception e) {
			return null;
		}
	}

	/* Method getElementText: To get text from the element
	 * @param locator  : String : Locator of the element 
    */
	public static String getElementText(String locator) {
		String text = null;
		if (findWebElement(locator).isDisplayed())
			text = findWebElement(locator).getText();
		else
			Assert.fail("\n Get text from  : " + locator + " ************* Failed");
		return text;
	}
	
	/* Method getElementTextByAttribute: To get text from the attribute of the element
	 * @param locator  : String : Locator of the element 
	 * @param attributeName  : String : attribute name for given locator 
    */
	public static String getElementTextByAttribute(String locator, String attributeName) {
		String value = null;
		if (findWebElement(locator).isDisplayed())
			value = findWebElement(locator).getAttribute(attributeName);
		else
			Assert.fail("\n Get attribute text from : " + locator + " ************* Failed");
		return value;
	}

	/* Method moveToElement: Move to Element
	 * @param locator  : String : Locator of the element that you want move
	 */
	public static void moveToElement(String locator) {
		try {
			action = new Actions(driver);
			action.moveToElement(findWebElement(locator)).build().perform();
		} catch (Exception e) {
			Assert.fail("\n Unable to move to locator " + locator + " ************* Failed");
		}
	}
	
    /* Method moveToElementAndClick: Move to Element and click on it
	 * @param locator  : String : Locator of the element that you want move and click on it
	 */
	public static void moveToElementAndClick(String locator) {
		try {
			action = new Actions(driver);
			action.moveToElement(findWebElement(locator)).click().build().perform();
		} catch (Exception e) {
			Assert.fail("\n Click on element with locator : " + locator + " ************* Failed");
		}
	}

	/* Method moveToElementAndDoubleClick: Move to Element and  double click on it
	 * @param locator  : String : Locator of the element that you want move and double click on it
	 */
	public static void moveToElementAndDoubleClick(String locator) {
		try {
			action = new Actions(driver);
			action.moveToElement(findWebElement(locator)).doubleClick().build().perform();
		} catch (Exception e) {
			Assert.fail("\n Double click on element with locator : " + locator + " ************* Failed");
		}
	}

	/* Method switchToNextWindow: Switch to immediate child window
	 */
	public static void switchToNextWindow() {
		try {			
			parentWindowName = null;
			parentWindowName = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for (String curWindow : allWindows) {
				driver.switchTo().window(curWindow);
			}
		} catch (Exception e) {
			Assert.fail("\n Switch to window ************* Failed");
		}
	}

	/* Method switchToParentWindow: Switch to immediate Parent window
	 */
	public static void switchToParentWindow() {
		try {			
			driver.switchTo().window(parentWindowName);
			parentWindowName = null;
		} catch (Exception e) {
			Assert.fail("\n Switch to parent window ************* Failed");
		}
	}

	/* Method switchToFrameByIndex: Switch to frame by index
	 *@param index  : int : Index of the frame
	 */
	public static void switchToFrameByIndex(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			Assert.fail("\n Switch to frame with index "+index+" ************* Failed");
		}
	}
	
	/* Method switchToFrameByNameOrID: Switch to frame by index
	 *@param nameOrId  : String : nameOrId of the frame
	 */
	public static void switchToFrameByNameOrID(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (Exception e) {
			Assert.fail("\n Switch to frame with name Or Id "+nameOrId+" ************* Failed");
		}
	}

	/* Method switchToParentFrame: Switch to immediate parent frame
	 */
	public static void switchToParentFrame() {
		try {
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			Assert.fail("\n Switch to parent frame ************* Failed");
		}
	}

	/* Method switchToDefaultContent: Switch to super parent frame
	 */
	public static void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			Assert.fail("\n Switch to default content ************* Failed");
		}
	}

	/* Method getCurrentURL: To get current URL
    */
	public static String getCurrentURL() {
		try {
			String currentUrl= driver.getCurrentUrl();
			return currentUrl;
		} catch (Exception e) {
			return null;
		}     
	}
	
	/* Method getDomainName: To get domain of URL
	 */
	public static String getDomainName() {
		try {			
			return javaScriptutilsObj.getDomainName();
		} catch (Exception e) {
			return null;
		}     
	}
  
	/* Method getPageTitle: To get page title of URL
	 */
	public static String getPageTitle() {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {
			return null;
		}
	}

	/* Method refreshPage: To refresh the current page
	 */
	public static void refreshPage() {
		driver.navigate().refresh();
		waitsObj.implicityWaitForPageLoad(10);
	}
	
	/* Method switchToAlertAndEnterText: To switch to alert and enter text to the alert
	 * @Param :timeInSeconds : int : Wait time in seconds
	 * @Param :text : String :Text you want to enter
	 */
	public static void switchToAlertAndEnterText(int timeInSeconds, String text) {
		try {
			waitsObj.implicityWaitForPageLoad(timeInSeconds);
			driver.switchTo().alert().sendKeys(text);
		} catch (Exception e) {
			Assert.fail("\n SendKeys into Alert popup failed");
		}
	}

	/* Method switchToAlertAndGetText: To switch to alert and get text from the alert
	 * @Param :timeInSeconds : int : Wait time in seconds
	 */
	public static String switchToAlertAndGetText(int timeInSeconds) {
		try {
			waitsObj.implicityWaitForPageLoad(timeInSeconds);
			String alertText = driver.switchTo().alert().getText();
			return alertText;
		} catch (Exception e) {
			return null;
		}
	}

	/* Method switchToAlertAndAccept: To switch to alert and accept the alert
	 * @Param :timeInSeconds : int : Wait time in seconds
	 */
	public static void switchToAlertAndAccept(int timeInSeconds) {
		try {
			waitsObj.implicityWaitForPageLoad(timeInSeconds);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Assert.fail("\n Accept of Alert failed");
		}
	}

	/* Method switchToAlertAndDismiss: To switch to alert and dismiss the alert
	 * @Param :timeInSeconds : int : Wait time in seconds
	 */
	public static void switchToAlertAndDismiss(int timeInSeconds) {
		try {
			waitsObj.implicityWaitForPageLoad(timeInSeconds);
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			Assert.fail("\n Dismiss of Alert failed");
		}
	}

	/* Method dragAndDropElements: To drag and drop an element
	 * @Param :fromLocator : String : From locator 
	 * @Param :toLocator : String : To locator 
	 */
	public static void dragAndDropElements(String fromLocator, String toLocator) {
		try {
			WebElement from = findWebElement(fromLocator);
			WebElement to = findWebElement(toLocator);
			action = new Actions(driver);
			action.dragAndDrop(from, to).build().perform();
		} catch (Exception e) {
			Assert.fail("\n Drag and drop element failed");
		}
	}
	
	/* Method scrollPageByPixel: To scroll the window up or down with pixels
	 * @Param :from : int : From pixel
	 * @Param :to : int : To pixel
	 */
	public static void scrollPageByPixel(int from, int to) {
	try {
		javaScriptutilsObj.scrollWindow(from, to);
		} catch (Exception e) {
			Assert.fail("\n scroll window by pixel failed");
		}
	}
}
