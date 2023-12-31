package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;

import com.qa.util.ElementUtil;
import com.qa.util.ExcelUtil;

public class PersonalDetailsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private ExcelUtil exutil;

	public PersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

		exutil = new ExcelUtil();
	}

	// Application page -1

	private By txt_Title = By.xpath("//a[@id='lnkHomeMenuItem']");
	private By lnk_StartApplication = By.xpath("//span[text()='Start renewal/passport application']");
	private By chk_Australia = By.xpath("//input[@type='radio'and@id='Q2-A3']");
	private By chk_Adult = By.xpath("//input[@type='radio'and @id='Q1-A1']");
	private By chk_Next = By.xpath("//input[@type='submit']");

	// Application page -2
	private By rdn_myself = By.xpath("//input[@id ='Q15-A17']");
	private By txt_familyname = By.xpath("//input[@name='Q37']");
	private By txt_givennames = By.xpath("//input[@placeholder='FirstName SecondName etc']");
	private By txt_countryOfBirth = By.xpath("//input[@id ='Q47']");
	private By chk_persondetailsMale = By.xpath("//input[@id = 'Q41-A54']");
	private By chk_persondetailsFemale = By.xpath("//input[@id = 'Q41-A55']");
	private By chk_persondetailsIntersex = By.xpath("//input[@id = 'Q41-A56']");
	private By txt_DOB = By.xpath("//input[@id = 'Q42']");
	private By txt_ParentsFamilyName = By.xpath("//input[@id='Q847']");
	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");
//	page objects for error
	
	private By Allerror = By.xpath("//span[contains(@id,'error')]");
	private By error_Familyname = By.xpath("//span[@id='error_Q37']");
	private By error_Givenname = By.xpath("//span[@id='error_Q40']");
	
	private By error_sex = By.xpath("//span[@id='error_Q41-A54']");
	private By error_COB = By.xpath("//span[@id='error_Q47']");
	private By parent_Familyname = By.xpath("//span[@id='error_Q847']");
	
	// private By Alert = By.xpath("//span[text()=' This is a required field']");
	public String getHomePageTitle() {
		return eleUtil.doGetText(txt_Title);

	}

	public void chooseLodgementLocation(String location) {
		eleUtil.scrollPageDown();
		if (location.equals("Australia")) {
			eleUtil.clickradiobutton(chk_Australia);
		}

	}

	public void chooseAdultApplicant(String Applicant) {
		if (Applicant.equals("Adult")) {
			eleUtil.scrollToElementbyJavaScriptExecutor(chk_Adult);
			eleUtil.clickradiobutton(chk_Adult);
		}

	}

	public void clickNext() {

		eleUtil.scrollToElementbyJavaScriptExecutor(chk_Next);
		eleUtil.clickelement(chk_Next);

	}

	public void chooseApplicant(String applicant) {
		if (applicant.equalsIgnoreCase("Other Adult")) {
			// eleUtil.waitForElementPresence(rdn_myself, 30);
			// eleUtil.clickradiobutton(rdn_myself);
		}
	}

	public void setTestData(String ApplicationType) {
		if (ApplicationType.equals("PC1_CitizenshipCertificate")) {
			String Sheetname = "PC1_CitizenshipCertificate";
			exutil.setTestDataSheet(Sheetname);

		}

		if (ApplicationType.equals("PC7_PassportRenewal")) {
			String Sheetname = "PC7_PassportRenewal";
			exutil.setTestDataSheet(Sheetname);

		}
		
		if (ApplicationType.equals("PC1_BirthCertificate")) {
			String Sheetname = "PC1_BirthCertificate";
			exutil.setTestDataSheet(Sheetname);

		}

	}

	public void enterPersonalDetails() {

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_familyname, exutil.getTestData("FAMILYNAME"));

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_givennames, exutil.getTestData("GIVENNAMES"));

		enterSex();

		eleUtil.scrollPageDown();
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_DOB, exutil.getTestData("DOB"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_countryOfBirth, exutil.getTestData("COB"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_ParentsFamilyName, exutil.getTestData("FAMILYNAME"));
		//checkAlertmessage();
		eleUtil.clickelement(btn_NextPage);
		

	}
	
	public void enterSex()
	{
		String sex = exutil.getTestData("SEX");
		if (sex.equals("M")) {
			eleUtil.clickradiobutton(chk_persondetailsMale);

		}
		if (sex.equals("F")) {
			eleUtil.clickradiobutton(chk_persondetailsFemale);

		}
		if (sex.equals("I")) {
			eleUtil.clickradiobutton(chk_persondetailsIntersex);

		}
	}
	
	public void checkAlertmessage()
	{
		while(eleUtil.Alertsize(Allerror)>1)
		{
			
		
		if (eleUtil.isErrorDisplayedInElement(error_Familyname)==true)
		{
			eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_familyname, exutil.getTestData("FAMILYNAME"));
			
		}
		
		
		
		if (eleUtil.isErrorDisplayedInElement(error_Givenname)==true)
		{
			eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_givennames, exutil.getTestData("GIVENNAMES"));
			//eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_givennames, "test");
		}
		
		if (eleUtil.isErrorDisplayedInElement(error_sex)==true)
		{
			enterSex();
		}
		
		if(eleUtil.isErrorDisplayedInElement(error_COB)==true)
		{
			eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_countryOfBirth, exutil.getTestData("COB"));
			
		}
		
		
		if(eleUtil.isErrorDisplayedInElement(parent_Familyname)==true)
		{
			eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_ParentsFamilyName, exutil.getTestData("FAMILYNAME"));
			
		}
		}
	}

}
