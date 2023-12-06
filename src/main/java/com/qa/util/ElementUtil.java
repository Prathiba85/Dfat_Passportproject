package com.qa.util;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;
	private Select select;
	private Actions act;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;
		act = new Actions(driver);

	}
	// *******************************Main Functions called in test
	// Steps***********************************//
	// ******************TextBox*******************************//

	public void doSendKeys(By locator, String value) {
		WebElement ele = getElement(locator);
		waitForElementToBeClickable(locator).sendKeys(value);

	}

	// do sendKeys with wait checkstaleElement
	public void doSendKeysWithWaitCheckStaleElementException(By locator, String value) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StaleElementHandleBylocator(locator, value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	// ***************************buttons *****************************//

	public void doClick(By locator) {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		waitForElementPresence(locator, 20);
		getElement(locator).click();
	}

	public void clickelement(By locator) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StaleElementforClickablebutton(locator);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		

	}

	public void clickelementtoValidate(By locator) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StaleElementforvalidatebutton(locator);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	// Checkbox

	public void clickElementbyJavaScriptExecutorCheckStaleElement(By locator) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StaleElementCheckForcheckbox(locator);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// Radio Button
	public void clickradiobutton(By locator) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StaleElementCheckForradiobutton(locator);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	// scroll
	public void scrollToElementbyJavaScriptExecutor(By locator) {
		
		StaleElementCheckForScrollToElement(locator);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}
	public int getNumberofElements(By errorlocator)
	{
		List <WebElement> ele =  getElements(errorlocator);
		
		
		return ele.size();
	}
	
	public boolean isErrorDisplayedInElement(By errorlocator)
	{
		List <WebElement> ele =  getElements(errorlocator);
		
		System.out.println("Size of the element missing "+ele.size());
		if (ele.size()>0)
		{
			return true;
		}
		return false;
	}

//Waits

	// 04
	public WebElement waitForElementPresence(By locator, int timeoutInSeconds) {

		return new WebDriverWait(driver, timeoutInSeconds).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

//--------------------------------------------Sub Fuctions Called by Main functions --------------------------//

	public void scrollPageDown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public boolean ischeckselected(By locator) {
		WebElement element = getElement(locator);
		element.getAttribute("checked");
		if ((element.getAttribute("checked").equals("checked"))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRadiobuttonselected(By locator) {
		WebElement element = getElement(locator);

		if ((element.isSelected())) {

			return true;
		}

		return false;
	}

	public WebElement getElement(By locator) {
		WebElement ele = driver.findElement(locator);
		return ele;
	}

// Waits

	public void StaleElementforClickablebutton(By locator) {
		WebElement element;
		int count = 0;
		boolean clicked = false;
		while (count < 10 && !clicked) {
			try {
				waitForElementToBeClickable(locator);
				WebElement ele = getElement(locator);
				clickElementByJS(ele);
				clicked = true;
			} catch (UnhandledAlertException e) {
				waitForElementToBeClickable(locator);
				WebElement ele = getElement((locator));
				clickElementByJS(ele);
				count = count + 1;

			} catch (Exception e) {
				waitForElementToBeClickable(locator);
				WebElement ele = getElement((locator));
				clickElementByJS(ele);
				count = count + 1;

			}
		}

	}

	public void StaleElementforvalidatebutton(By locator) {

		
		
		// System.out.println("Validation Text Before Click " + ValidationText);
		clickElementByJSlocator(locator);

		// System.out.println("Validation Text After " + ValidationText);

	}

	public WebElement waitForElementToBeClickable(By locator) {
		return new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public String doGetText(By locator) {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = null;
		int textlength = 0;
		int count = 0;

		do {
			try {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// waitForElementVisible(locator,60);
				text = getElement(locator).getText();
				textlength = text.length();
				count++;

			} catch (NoSuchElementException e) {
				text = getElement(locator).getText();
				textlength = text.length();
			}
		} while ((textlength == 0) && (count < 10));

		return text;
	}

	public void StaleElementHandleBylocator(By locator, String value) {
		// driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement element;
		element = getElement(locator);
		int count = 0;
		String textentered;
		// System.out.println("Before after entry "+textentered.isBlank());
		do {
			try {
				waitForElementToBeClickable(locator);
				element = getElement(locator);
				element.clear();
				element.sendKeys(value);
				element.sendKeys(Keys.ARROW_DOWN);
				element.sendKeys(Keys.ENTER);
			
				textentered = element.getText();

			} catch (UnhandledAlertException e) {
				waitForElementToBeClickable(locator);
				element = getElement(locator);
				element.sendKeys(value);
				element.sendKeys(Keys.ARROW_DOWN);
				element.sendKeys(Keys.ENTER);
				
				textentered = element.getText();

			} catch (ElementNotInteractableException e) {
				waitForElementToBeClickable(locator);
				element = getElement(locator);
				element.sendKeys(value);
				element.sendKeys(Keys.ARROW_DOWN);
				element.sendKeys(Keys.ENTER);
				
				textentered = element.getText();

			} catch (NoSuchElementException e) {
				waitForElementToBeClickable(locator);
				element = getElement(locator);
				element.sendKeys(value);
				element.sendKeys(Keys.ARROW_DOWN);
				element.sendKeys(Keys.ENTER);
				
				textentered = element.getText();

			} catch (Exception e) {
				waitForElementToBeClickable(locator);
				element = getElement(locator);
				element.sendKeys(value);
				element.sendKeys(Keys.ARROW_DOWN);
				element.sendKeys(Keys.ENTER);
				
				textentered = element.getText();

			}
			count = count + 1;
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// System.out.println("textentered" + textentered);
			// System.out.println("textentered length " + textentered.trim().isEmpty());

		} while ((count < 15 && ((textentered.trim().isEmpty()) == false)));

	}

	public void StaleElementCheckForradiobutton(By locator) {

		WebElement element = element = getElement(locator);

		int count = 0;
		// String notselected = null ;
		String selectedvalue = "null";
		// System.out.println("Intial value "+element.getAttribute("checked"));

		do {
			try {
				waitForElementToBeClickable(locator);
				element = getElement(locator);
				// System.out.println("Initial Radio button valueat start " +
				// element.getAttribute("checked"));
				clickElementByJS(element);

				selectedvalue = element.getAttribute("checked");

				count++;
			} catch (StaleElementReferenceException e) {
				waitForElementToBeClickable(locator);
				element = getElement(locator);
				clickElementByJS(element);
				selectedvalue = element.getAttribute("checked");
				count++;
			} catch (UnhandledAlertException e) {
				waitForElementToBeClickable(locator);
				element = getElement(locator);
				clickElementByJS(element);
				selectedvalue = element.getAttribute("checked");
				count++;
			} catch (Exception e) {
				waitForElementToBeClickable(locator);
				element = getElement(locator);
				clickElementByJS(element);
				selectedvalue = element.getAttribute("checked");
				count++;
			}

			// System.out.println("Final Radio button value " +
			// element.getAttribute("checked"));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		} while (((count < 10) && (selectedvalue.equals(null))));

	}

	public void StaleElementCheckForScrollToElement(By locator) {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		int count = 0;
		boolean scrollto = true;
		boolean clicked = false;
		while (count < 10 && (clicked == false)) {
			try {
				WebElement ele = getElement(locator);
				waitForElementToBeClickable(locator);
				scrollIntoView(ele);
				clicked = true;
			} catch (Exception e) {
				WebElement ele = getElement(locator);
				waitForElementToBeClickable(locator);

				scrollIntoView(ele);
				clicked = true;

			}
			count = count + 1;

			// System.out.println("Value of clicked " + clicked);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		}

	}

	// ********************* Below Functions are not used but can be used if needed
	// *******************************//////

	public String doGetTitle(By locator) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return getElement(locator).getText();

	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSelectValueFromDropDown(By locator, String value) {

		try {
			Thread.sleep(1000);
			waitForElementToBeClickable(locator);
			List<WebElement> optionsList = getElements(locator);

			// System.out.println(optionsList.size());

			for (WebElement e : optionsList) {
				String text = e.getText();
				// System.out.println(text);
				if (text.equals(value)) {
					e.click();
					break;
				}

			}
		} catch (Exception e1) {
			waitForElementToBeClickable(locator);
			List<WebElement> optionsList = getElements(locator);

			// System.out.println(optionsList.size());

			for (WebElement e : optionsList) {
				String text = e.getText();
				// System.out.println(text);
				if (text.equals(value)) {
					e.click();
					break;
				}

			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	// wait

	public boolean getText(By locator) {
		WebElement element = getElement(locator);
		if (element.getText().equals(null)) {
			return false;
		}
		return true;

	}

	public int Alertsize(By locator) {
		List<WebElement> AlertPresent = getElements(locator);
		
			System.out.println("Alert Size"+AlertPresent.size());
			
		return AlertPresent.size();
	}

	public void entersendKeys(By locator, String value) {
		WebElement element = getElement(locator);

		waitForElementToBeClickable(locator);
		element = getElement(locator);
		element.clear();
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);

	}

	public void doClickWithWait(By locator) {
		waitForElementToBeClickable(locator).click();
	}

	public String getElementTextWithWait(By locator, int timeOut) {
		return waitForElementPresence(locator, timeOut).getText();
	}

	public WebElement waitForElementVisible(By locator, int timeOut) {
		// WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementignorestatleElement(By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(locator));

		return getElement(locator);
	}

	// Click Element by Java script executor

	public void StaleElementCheckForcheckbox(By locator) {
		WebElement element;

		int count = 0;
		boolean status = false;

		while ((count < 10) && ((status == false))) {
			try {
				element = getElement(locator);
				waitForElementToBeClickable(locator);
				clickElementByJS(element);
				status = element.isSelected();

			} catch (NoSuchElementException e) {
				element = getElement(locator);
				waitForElementToBeClickable(locator);
				clickElementByJS(element);
				status = element.isSelected();

			} catch (UnhandledAlertException e) {
				element = getElement(locator);
				waitForElementToBeClickable(locator);
				clickElementByJS(element);
				status = element.isSelected();

			}

			catch (Exception e) {
				element = getElement(locator);
				waitForElementToBeClickable(locator);
				clickElementByJS(element);
				status = element.isSelected();

			}

			count++;
			
		}

	}

	public void sendKeysbyJavaScriptExecutor(By locator, String value) {

		WebElement ele = getElement(locator);
		scrollIntoView(ele);

	}

	public void enterData(By locator, WebDriver driver, int timeouts, String value) {
		waitForElementToBeClickable(locator);
		// doSendKeysWithWait(locator, timeouts, value);
	}

	public static void clickByLocator(final By locator, WebDriver webDriver) {

		final long startTime = System.currentTimeMillis();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(90000, TimeUnit.MILLISECONDS)
				.pollingEvery(5500, TimeUnit.MILLISECONDS);
		// .ignoring( StaleElementReferenceException.class );
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				try {
					webDriver.findElement(locator).click();
					return true;
				} catch (StaleElementReferenceException e) { // try again
					return false;
				}
			}
		});
		webDriver.manage().timeouts().implicitlyWait(startTime, TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		// log("Finished click after waiting for " + totalTime + " milliseconds.");
	}

	public void doSendKeysWithStaleElement(By locator, String value, WebDriver driver) {
		waitForElementignorestatleElement(locator);
		// StaleElementHandleBylocator(locator);
		// clickByLocator(locator,driver );
		WebElement element = getElement(locator);
		element.sendKeys(value);
		element.sendKeys(Keys.ARROW_DOWN);
		element.sendKeys(Keys.ENTER);

	}

	/*
	 * 
	 * Javascript Utils
	 */
	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

	}

	public String getTitleByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title;").toString();
	}

	public void goBackByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(-1)");
	}

	public void goForwardByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(1)");
	}

	public void refreshBrowserByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	public void generateAlert(String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}

	public void generateConfirmPopUp(String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("confirm('" + message + "')");
	}

	public String getPageInnerText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void clickElementByJSlocator(By locator) {
		WebElement element = getElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void sendKeysUsingWithId(String id, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
		// document.getElementById('input-email').value ='tom@gmail.com'
	}

	public void sendKeys(WebElement element, String value) {
//		JavascriptExecutor js = (JavascriptExecutor) driver;

		element.sendKeys(value);
//		element.sendKeys(Keys.ARROW_DOWN);
//		element.sendKeys(Keys.ENTER);

	}

	public void scrollPageDown(String height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, '" + height + "')");
	}

	public void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void drawBorder(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

}
