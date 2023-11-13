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
		eleUtil.enterData(txt_familyname, driver, 30,exutil.getTestData("FAMILYNAME") );
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		//FamilyName
	
		eleUtil.waitforElementClickable(txt_givennames, driver, 50);
		eleUtil.doSendKeysWithWait(txt_givennames,30,exutil.getTestData("GIVENNAMES"));
		eleUtil.sendKeysbyJavaScriptExecutor(txt_givennames,exutil.getTestData("GIVENNAMES"));
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
	
	
		
		//DOB
		//eleUtil.enterData(txt_DOB, driver, 100,exutil.getTestData("DOB") );
		//eleUtil.waitforElementClickable(txt_DOB, driver, 30);
		//eleUtil.scrollToElementbyJavaScriptExecutor(txt_DOB);
		eleUtil.sendKeysbyJavaScriptExecutor(txt_DOB,exutil.getTestData("DOB"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
		
			e1.printStackTrace();
		}
		eleUtil.waitForElementVisible(txt_countryOfBirth, 20);
		eleUtil.doSendKeysWithWait(txt_DOB,100,exutil.getTestData("DOB"));
		
		//Country Of Birth
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
		
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
	

}
