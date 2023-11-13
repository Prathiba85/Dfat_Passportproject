package com.qa.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;
	private Select select;
	private Actions act;
	private JavaScriptUtil jsUtil;


	public ElementUtil(WebDriver driver) {

		this.driver = driver;
		act = new Actions(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	public void doSendKeys(By locator, String value) {
		// TODO Auto-generated method stub
		WebElement ele = getElement(locator);
		//ele.clear();
		ele.sendKeys(value);
		
	}
	
	public WebElement getElement(By locator) {
		WebElement ele = driver.findElement(locator);
		return ele;
	}

	public void doClick(By locator) {
		waitForElementPresence(locator,driver, 10);
		getElement(locator).click();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	public String doGetTitle(By locator) {
		  return getElement(locator).getText();
		
		
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	

	public void doSelectValueFromDropDown(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);

		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}

		}
	}

	//wait
	public WebElement waitForElementPresence(By locator,WebDriver driver, int timeoutInSeconds) {
					
		
	  return new WebDriverWait(driver, timeoutInSeconds).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public WebElement waitforElementClickable (By locator,WebDriver driver,int timeoutInSeconds)
	{
		return new WebDriverWait(driver, timeoutInSeconds).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void doSendKeysWithWait(By locator, int timeOut, String value) {
		waitForElementPresence(locator,driver, timeOut);
		WebElement element = getElement(locator);
		element.sendKeys(value);
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);
		
	}

	public void doClickWithWait(By locator, int timeOut) {
		waitForElementPresence(locator,driver, timeOut).click();
	}

	public String getElementTextWithWait(By locator, int timeOut) {
		return waitForElementPresence(locator,driver, timeOut).getText();
	}
	public WebElement waitForElementVisible(By locator, int timeOut) {
		//WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(locator));
		//return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Click Element by Java script executor
	public void clickElementbyJavaScriptExecutor(By locator)
	{
		
		WebElement ele = getElement(locator);
		jsUtil.scrollIntoView(ele);
		jsUtil.clickElementByJS(ele);
	}
	
	public void scrollToElementbyJavaScriptExecutor(By locator)
	{
		
		WebElement ele = getElement(locator);
		jsUtil.scrollIntoView(ele);
	}
	
	public void sendKeysbyJavaScriptExecutor(By locator, String value)
	{
		
		WebElement ele = getElement(locator);
		jsUtil.scrollIntoView(ele);
		jsUtil.sendKeys(ele,value);
	}
	
	public void enterData(By locator,WebDriver driver, int timeouts,String value)
	{
		waitforElementClickable(locator, driver, 50);
		doSendKeysWithWait(locator, timeouts, value);
	}
	
	
	
	
}
