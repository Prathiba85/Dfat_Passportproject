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

import com.qa.util.ElementUtil;
import com.qa.util.ExcelUtil;

public class PreviousPassportPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private ExcelUtil exutil;

	public PreviousPassportPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		exutil = new ExcelUtil();

	}

	private By rd_HadPReviousPassport_Yes = By.xpath("//input[@id='Q62-A93']");
	private By rd_HadPReviousPassport_NO = By.xpath("//input[@id='Q62-A96']");
	private By rd_presentPreviousPassport_Yes = By.xpath("//input[@id='Q1119-A1719']");
	private By rd_databreach_No = By.xpath("//input[@id='Q2337-A4198']");

	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");
	// passport details

	private By txt_Familyname = By.xpath("//input[contains(@name,'Q7')and @data-type='Text']");
	private By txt_Givenname = By.xpath("//input[contains(@name,'Q2')and @data-type='Text']");
	private By txt_DOB = By.xpath("//input[contains(@name,'Q5') and @type ='text']");
	private By rd_Male = By.xpath("//input[contains(@id,'Q4-A4') and @type ='radio']");
	private By rd_Female = By.xpath("//input[contains(@id,'Q4-A5') and @type ='radio']");
	private By rd_Intersex = By.xpath("//input[contains(@id,'Q4-A6') and @type ='radio']");
	private By txt_Issuedate = By.xpath("//input[contains(@id,'Q28') and @type ='text']");
	private By txt_Expirydate = By.xpath("//input[contains(@id,'Q29') and @type ='text']");
	private By txt_passportnumber = By.xpath("//input[contains(@id,'Q1') and @type ='text']");
	private By btn_validate = By.xpath("//button[contains(@id,'Q6') and @type ='button']");

	// page objects for error

	private By Allerror = By.xpath("//span[contains(@id,'error')]");
	private By error_HadPassport = By.xpath("//span[contains(@id,'Q62-A93')and @class='wrn']");
	private By error_PresentPreviousPassport = By.xpath("//span[contains(@id,'Q1119-A171')and @class='wrn']");
	private By error_DataBreach = By.xpath("//span[contains(@id,'error_Q2337-A4197')and @class='wrn']");
	private By error_Familyname = By.xpath("//span[contains(@id,'Q7')and @class='wrn']");
	private By error_Givennames = By.xpath("//span[contains(@id,'Q2')and @class='wrn'][1]");
	private By error_DOB = By.xpath("//span[contains(@id,'Q5')and @class='wrn']");
	private By error_Sex = By.xpath("//span[contains(@id,'Q4-A4')and @class='wrn']");
	private By error_passportNumber = By.xpath("//span[contains(@id,'Q1')and @class='wrn']");
	private By error_issueDate = By.xpath("//span[contains(@id,'Q28')and @class='wrn']");
	private By error_expiryDate = By.xpath("//span[contains(@id,'Q29')and @class='wrn']");
	private By validationError = By.xpath("//h4[contains(text(),'errors')]");

	//
	private String AnsHandPasspossport;
	private String AnsPresentPreviousPassort;
	private String AnsDataBreach;

	public void HadPreviouspassport(String ans) {
		AnsHandPasspossport = ans;
		if (AnsHandPasspossport.equals("Yes")) {
			eleUtil.clickradiobutton(rd_HadPReviousPassport_Yes);
		}
	}

	public void ableToPresentPreviousPassportDetails(String ans) {
		AnsPresentPreviousPassort = ans;
		if (AnsPresentPreviousPassort.equals("Yes")) {
			 eleUtil.clickradiobutton(rd_presentPreviousPassport_Yes);
		}
	}

	public void chooseHadAustralianPassport() {

		eleUtil.clickradiobutton(rd_HadPReviousPassport_NO);
		eleUtil.clickelement(btn_NextPage);

	}

	public void isAppliedforDataBreach(String ans) {
		AnsDataBreach = ans;
		if (AnsDataBreach.equals("No")) {
			eleUtil.clickradiobutton(rd_databreach_No);
		}

	}

	public void enterPreviousPassportdetails() {
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Familyname,
		exutil.getTestData("FAMILYNAME"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Givenname,
		exutil.getTestData("GIVENNAMES"));
		enterSex();

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_DOB,
		exutil.getTestData("DOB"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_passportnumber,exutil.getTestData("PREVIOUSPASSPORTNUMBER"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Issuedate,
		exutil.getTestData("ISSUEDATE"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Expirydate,
		exutil.getTestData("EXPIRYDATE"));
		eleUtil.clickelementtoValidate(btn_validate);
		
		//checkAlertmessage();
		eleUtil.clickelement(btn_NextPage);
	}

	public void checkAlertmessage() {
		while ((eleUtil.Alertsize(Allerror) > 0)) {

			if (eleUtil.isErrorDisplayedInElement(error_HadPassport) == true) {
				if (AnsHandPasspossport.equals("Yes")) {
					eleUtil.clickradiobutton(rd_HadPReviousPassport_Yes);
				}

			}

			if (eleUtil.isErrorDisplayedInElement(error_PresentPreviousPassport) == true) {

				if (AnsPresentPreviousPassort.equals("Yes")) {
					eleUtil.clickradiobutton(rd_presentPreviousPassport_Yes);
				}
			}

			if (eleUtil.isErrorDisplayedInElement(error_DataBreach) == true) {

				if (AnsDataBreach.equals("No")) {
					eleUtil.clickradiobutton(rd_databreach_No);
				}
				if (eleUtil.isErrorDisplayedInElement(txt_Familyname) == true) {
					eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Familyname,
							exutil.getTestData("FAMILYNAME"));
				}
				if (eleUtil.isErrorDisplayedInElement(error_Givennames) == true) {
					eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Givenname,
							exutil.getTestData("GIVENNAMES"));
				}

				if (eleUtil.isErrorDisplayedInElement(error_DOB) == true) {
					eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_DOB, exutil.getTestData("DOB"));
				}

				if (eleUtil.isErrorDisplayedInElement(error_Sex) == true) {
					enterSex();
				}
				if (eleUtil.isErrorDisplayedInElement(error_passportNumber) == true) {
					eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_passportnumber,exutil.getTestData("PREVIOUSPASSPORTNUMBER"));

				}
				if (eleUtil.isErrorDisplayedInElement(error_issueDate) == true) {
					eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Issuedate,
							exutil.getTestData("ISSUEDATE"));
				}
				if (eleUtil.isErrorDisplayedInElement(error_expiryDate) == true) {
					eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Expirydate,exutil.getTestData("EXPIRYDATE"));
				}
				if (eleUtil.isErrorDisplayedInElement(validationError) == true) {
					eleUtil.clickelementtoValidate(btn_validate);
				}
			}
		}
	}

	public void enterSex() {
		String sex = exutil.getTestData("SEX");
		if (sex.equals("M")) {
			eleUtil.clickradiobutton(rd_Male);

		}
		if (sex.equals("F")) {
			eleUtil.clickradiobutton(rd_Female);

		}
		if (sex.equals("I")) {
			eleUtil.clickradiobutton(rd_Intersex);

		}
	}
}
