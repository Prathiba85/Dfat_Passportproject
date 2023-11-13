package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;

import com.qa.util.ElementUtil;
import com.qa.util.ExcelUtil;
import com.qa.util.JavaScriptUtil;



public class PersonalDetailsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jutil;
	private ExcelUtil exutil;

	public PersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jutil = new JavaScriptUtil(driver);
		exutil= new ExcelUtil();
	}

	// Application page -1

	private By txt_Title = By.xpath("//a[@id='lnkHomeMenuItem']");
	private By lnk_StartApplication = By.xpath("//span[text()='Start renewal/passport application']");
	private By chk_Australia = By.xpath("//input[@type='radio'and@id='Q2-A3']");
	private By chk_Adult = By.xpath("//input[@type='radio'and @id='Q1-A1']");
	private By chk_Next = By.xpath("//input[@type='submit']");

	// Application page -2
	private By chk_myself = By.xpath("//input[@id ='Q15-A17']");
	private By txt_familyname = By.xpath("//input[@name='Q37']");
	private By txt_givennames = By.xpath("//input[@placeholder='FirstName SecondName etc']");
	private By txt_countryOfBirth = By.xpath("//input[@id ='Q47']");
	private By chk_persondetailsMale = By.xpath("//input[@id = 'Q41-A54']");
	private By chk_persondetailsFemale = By.xpath("//input[@id = 'Q41-A55']");
	private By chk_persondetailsIntersex = By.xpath("//input[@id = 'Q41-A56']");
	private By txt_DOB = By.xpath("//input[@id = 'Q42']");
	private By txt_ParentsFamilyName = By.xpath("//input[@id='Q847']");
	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");

	public String getHomePageTitle() {
		return eleUtil.doGetText(txt_Title);

	}

	public void chooseLodgementLocation() {

		jutil.scrollPageDown();
		eleUtil.waitForElementPresence(chk_Australia, driver, 30);
		eleUtil.clickElementbyJavaScriptExecutor(chk_Australia);

	}

	public void chooseAdultApplicant() {
		eleUtil.waitForElementPresence(chk_Adult, driver, 30);
		eleUtil.clickElementbyJavaScriptExecutor(chk_Adult);

	}

	public void clickNext() {

		eleUtil.waitForElementPresence(chk_Next, driver, 30);
		eleUtil.clickElementbyJavaScriptExecutor(chk_Next);

	}

	public void chooseApplicant(String applicant) {
		if (applicant.equalsIgnoreCase("Myself")) {
			eleUtil.waitForElementPresence(chk_myself, driver, 30);
			eleUtil.clickElementbyJavaScriptExecutor(chk_myself);
		}
	}
	
	public void enterPersonalDetails()
	{
	
		//FamilyName
		eleUtil.waitForElementPresence(txt_familyname, driver, 30);
		eleUtil.doSendKeysWithWait(txt_familyname, 30, exutil.getTestData("FAMILYNAME"));
		//SurName
		eleUtil.waitForElementPresence(txt_givennames, driver, 30);
		eleUtil.doSendKeysWithWait(txt_givennames, 30, exutil.getTestData("GIVENNAMES"));
		//Gender
		String sex = exutil.getTestData("SEX");
		if(sex.equals("M"))
		{
			eleUtil.clickElementbyJavaScriptExecutor(chk_persondetailsMale);
		}
		if(sex.equals("F"))
		{
			eleUtil.clickElementbyJavaScriptExecutor(chk_persondetailsFemale);
		}
		if(sex.equals("I"))
		{
			eleUtil.clickElementbyJavaScriptExecutor(chk_persondetailsIntersex);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//DOB
		eleUtil.scrollToElementbyJavaScriptExecutor(txt_DOB);
		//eleUtil.waitForElementVisible(txt_countryOfBirth, 20);
		eleUtil.doSendKeysWithWait(txt_DOB,80,exutil.getTestData("DOB"));
		
		//Country Of Birth
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		eleUtil.scrollToElementbyJavaScriptExecutor(txt_countryOfBirth);
		eleUtil.waitForElementVisible(txt_countryOfBirth, 20);
		eleUtil.doSendKeysWithWait(txt_countryOfBirth,80, exutil.getTestData("COB"));
		
		//Familyname At Birth
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		eleUtil.scrollToElementbyJavaScriptExecutor(txt_ParentsFamilyName);	eleUtil.doSendKeysWithWait(txt_ParentsFamilyName,80, exutil.getTestData("FAMILYNAME"));
		
		// Click next 
		eleUtil.scrollToElementbyJavaScriptExecutor(btn_NextPage);
		eleUtil.clickElementbyJavaScriptExecutor(btn_NextPage);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 
	 * public void clickMyself() { try { Thread.sleep(3000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } chk_myself.click(); }
	 * 
	 * public void enterFamilyName(String familyname) { try { Thread.sleep(3000); }
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * CommonFunctions.scrollintoView(txt_familyname, driver);
	 * CommonFunctions.clickElementByJS(txt_familyname, driver);
	 * txt_familyname.sendKeys(familyname); txt_familyname.sendKeys(Keys.RETURN);
	 * 
	 * 
	 * }
	 * 
	 * public void enterGivenName(String givenname) { try { Thread.sleep(3000); }
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } CommonFunctions.scrollintoView(txt_givennames,
	 * driver); CommonFunctions.clickElementByJS(txt_givennames, driver);
	 * txt_givennames.click(); txt_givennames.sendKeys(givenname);
	 * txt_givennames.sendKeys(Keys.RETURN);
	 * 
	 * }
	 * 
	 * public void selectSex(String sex) { //CommonFunctions.scrollToBottom(driver);
	 * //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); try {
	 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } if(sex.equals("M")) {
	 * CommonFunctions.scrollintoView(chk_persondetailsMale, driver);
	 * CommonFunctions.clickElementByJS(chk_persondetailsMale, driver);
	 * //chk_persondetailsMale.click(); } if(sex.equals("F")) {
	 * CommonFunctions.scrollintoView(chk_persondetailsFemale, driver);
	 * CommonFunctions.clickElementByJS(chk_persondetailsFemale, driver);
	 * //chk_persondetailsFemale.click(); } if(sex.equals("I")) {
	 * CommonFunctions.scrollintoView(chk_persondetailsIntersex, driver);
	 * CommonFunctions.clickElementByJS(chk_persondetailsIntersex, driver);
	 * //chk_persondetailsIntersex.click(); } }
	 * 
	 * public void enterDOB(String DOB) {
	 * //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); try {
	 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } CommonFunctions.scrollintoView(txt_DOB,
	 * driver); CommonFunctions.clickElementByJS(txt_DOB, driver);
	 * txt_DOB.sendKeys(DOB); txt_DOB.sendKeys(Keys.RETURN); } public void
	 * enterCountryOfBirth(String country) {
	 * //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); try {
	 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } //CommonFunctions.scrollToBottom(driver);
	 * CommonFunctions.scrollintoView(txt_countryOfBirth, driver);
	 * CommonFunctions.clickElementByJS(txt_countryOfBirth, driver);
	 * //txt_countryOfBirth.sendKeys(country);
	 * 
	 * txt_countryOfBirth.sendKeys(country);
	 * txt_countryOfBirth.sendKeys(Keys.RETURN); }
	 * 
	 * public void enterParentsFamilyName(String FamilyName) { try {
	 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 * //CommonFunctions.scrollToBottom(driver);
	 * CommonFunctions.scrollintoView(txt_ParentsFamilyName, driver);
	 * CommonFunctions.clickElementByJS(txt_ParentsFamilyName, driver);
	 * //txt_countryOfBirth.sendKeys(country);
	 * 
	 * txt_ParentsFamilyName.sendKeys(FamilyName);
	 * txt_ParentsFamilyName.sendKeys(Keys.RETURN); } public void clickNextPage2() {
	 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * CommonFunctions.scrollintoView( btn_NextPage2, driver);
	 * CommonFunctions.clickElementByJS( btn_NextPage2, driver);
	 * 
	 * 
	 * }
	 */

}
