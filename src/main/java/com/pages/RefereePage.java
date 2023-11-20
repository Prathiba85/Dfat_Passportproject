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

public class RefereePage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private ExcelUtil exutil;

	public RefereePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		exutil = new ExcelUtil();

	}

	private By chk_Confirm = By.xpath("//input[contains(@id,'Q26-A41')]");

	private By chk_Declare = By.xpath("//input[contains(@id,'Q94-A118')]");

	// Referee Details
	private By txt_RefereeFamilyName = By.xpath("//input[contains(@id,'Q9')and @type='text']");
	private By txt_RefereeGivenNames = By.xpath("//input[contains(@id,'Q10')and @type='text']");
	private By txt_RefereeGenderMale = By.xpath("//input[contains(@id,'A15')]");
	private By txt_RefereeDOB = By.xpath("//input[contains(@id,'Q12')]");

	// Referee Address
	private By chk_NoMatch = By.xpath("//input[contains(@id,'Q83-A123')and @type='checkbox']");
	private By txt_AddressLine1 = By.xpath("//input[contains(@name,'Q44')and @type='text']");
	private By txt_Suburb = By.xpath("//input[contains(@name,'Q17')and @type='text']");
	private By txt_StateTerritory = By.xpath("//select[contains(@name,'Q19')]//option");
	private By txt_PostCode = By.xpath("//input[contains(@name,'Q20')and @type='text']");
	private By drp_States = By.xpath("//select[contains(@name,'Q19')]");
	private By txt_ResidentialAddress = By
			.xpath("//input[@class='address-input ui-autocomplete form-control ui-autocomplete-input']");

	// Referee Time
	private By txt_Refereeyears = By.xpath("//input[contains(@name,'Q20')and @inputmode='decimal']");
	private By txt_RefereeMonths = By.xpath("//input[contains(@name,'Q21')and @inputmode='decimal']");

	// Referee Passport details
	private By txt_FPFamilyName = By.xpath("//input[contains(@id,'Q7')and @type='text']");
	private By txt_FPGivenNames = By.xpath("//input[contains(@id,'Q2')and @maxlength='31']");
	private By txt_FPDOB = By.xpath("//input[@id='Q5']");

	private By rdn_Male = By.xpath("//input[@id='Q1280-A1907']");
	private By rdn_Female = By.xpath("//input[@id='Q1280-A1908']");

	private By rdn_undefined = By.xpath("//input[@id='Q1280-A1909']");

	private By txt_PlaceOfBirth = By.xpath("//input[(@id='Q1277')]");

	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");

	// Referee Identity
	private By chk_IdentityPassport = By.xpath("//input[contains(@id,'Q30-A47')and @type='radio']");

	// Referee passport details
	private By txt_RefereePassportFamilyName = By.xpath("//input[contains(@id,'Q7')]");

	private By txt_RefereePassportGivenName = By
			.xpath("//input[contains(@id,'Q2') and @type='text' and @maxlength='31']");

	private By txt_RefereePassportDOB = By.xpath("//input[contains(@id,'Q5') and @type='text']");

	private By rdn_RefereeGenderMale = By.xpath("//input[contains(@id,'Q4-A4')]");
	private By txt_RefereePassportNumber = By.xpath(
			"//input[contains(@id,'Q1_change')]/preceding-sibling::input[contains(@id,'Q1')and @data-parent='True']");

	private By txt_RefereePassportIssueDate = By.xpath("//input[contains(@id,'Q28') and @type='text']");

	private By txt_RefereePassportExpiryDate = By.xpath("//input[contains(@id,'Q29') and @type='text']");

	private By txt_RefereeMobileNumber = By.xpath("//label[contains(text(),'Mobile')]/following::input[contains(@id,'Q14')]");

	public void enterRefereedetails() {
		eleUtil.clickElementbyJavaScriptExecutorCheckStaleElement(chk_Confirm);
		eleUtil.clickElementbyJavaScriptExecutorCheckStaleElement(chk_Declare);
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereeFamilyName, "Sundararaj");
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereeGivenNames, "Prabhu");
		eleUtil.clickradiobutton(txt_RefereeGenderMale);
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereeDOB, "28/02/1982");
		eleUtil.clickElementbyJavaScriptExecutorCheckStaleElement(chk_NoMatch);
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_AddressLine1, "10 McDonald Street");
		eleUtil.scrollToElementbyJavaScriptExecutor(txt_Suburb);

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Suburb, "Chifley");

		eleUtil.doSelectValueFromDropDown(txt_StateTerritory, "ACT");

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_PostCode, "2606");

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Refereeyears, "9");
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereeMonths, "6");

		eleUtil.clickradiobutton(chk_IdentityPassport);

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereePassportFamilyName, "Sundararaj");
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereePassportGivenName, "Prabhu");
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereePassportDOB, "28/02/1982");
		eleUtil.clickradiobutton(rdn_RefereeGenderMale);
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereePassportNumber, "PA9073698");

		// Referee Passport Issue date and Expiry date
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereePassportIssueDate, "27/08/2019");
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereePassportExpiryDate, "27/08/2029");

		// Referee Mobile number
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_RefereeMobileNumber, "0433681633");
		eleUtil.clickelement(btn_NextPage);

	}

}
