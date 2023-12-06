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

public class ContactDetailsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private ExcelUtil exutil;

	public ContactDetailsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		exutil = new ExcelUtil();
	}

	// Page 3
	private By drp_Country = By.xpath("//select[@name='F6a420645_9309_4af1_b1a3_ef159c00873d_Q4']");
	private By chk_NoMatch = By.xpath("//input[contains(@id,'Q83-A123')and @type='checkbox']");
	private By txt_AddressLine1 = By.xpath("//input[contains(@name,'Q44')and @type='text']");
	private By txt_Suburb = By.xpath("//input[contains(@name,'Q17')and @type='text']");
	private By txt_StateTerritory = By.xpath("//select[contains(@name,'Q19')]//option");
	private By txt_PostCode = By.xpath("//input[contains(@name,'Q20')and @type='text']");
	private By drp_States = By.xpath("//select[contains(@name,'Q19')]");
	private By txt_ResidentialAddress = By
			.xpath("//input[@class='address-input ui-autocomplete form-control ui-autocomplete-input']");
	private By chk_DeliveryAddress = By.xpath("//input[@id='Q311-A404']");
	private By chk_MobileNumber = By.xpath("//input[contains(@name,'Q14')and @type='text']");

	private By chk_AlternateContactNumber = By.xpath("//input[@id='Q526-A2918']");
	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");

//	page objects for error

	private By Allerror = By.xpath("//span[contains(@id,'error')]");
	private By error_AddressLine1 = By.xpath("//span[contains(@id,'Q44')and @class='wrn']");
	private By error_Suburb = By.xpath("//span[contains(@id,'Q17')and @class='wrn']");

	private By error_State = By.xpath("//span[contains(@id,'Q19')and @class='wrn']");
	private By error_Postcode = By.xpath("//span[contains(@id,'Q20')and @class='wrn']");
	private By error_DeliveryAddress = By.xpath("//span[contains(@id,'Q311-A403')and @class='wrn']");
	private By error_Mobilenumber = By.xpath("//span[contains(@id,'Q14')and @class='wrn']");

	public void enterContactDetails() {
		//eleUtil.scrollToElementbyJavaScriptExecutor(chk_NoMatch);
		eleUtil.clickElementbyJavaScriptExecutorCheckStaleElement(chk_NoMatch);

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_AddressLine1, "44 Sydney Ave");
		eleUtil.scrollToElementbyJavaScriptExecutor(txt_Suburb);

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Suburb, "Forrest");

		eleUtil.doSelectValueFromDropDown(txt_StateTerritory, "ACT");

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_PostCode, "2603");

		eleUtil.clickradiobutton(chk_DeliveryAddress);

		eleUtil.doSendKeysWithWaitCheckStaleElementException(chk_MobileNumber, "0433002845");

		//checkAlertmessage();

		eleUtil.clickelement(btn_NextPage);

	}

	public void checkAlertmessage() {
		//while ((eleUtil.Alertsize(Allerror) > 0)) {

			if (eleUtil.isErrorDisplayedInElement(error_AddressLine1) == true) {
				eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_AddressLine1, "44 Sydney Ave");

			}

			if (eleUtil.isErrorDisplayedInElement(error_Suburb) == true) {
				eleUtil.scrollToElementbyJavaScriptExecutor(txt_Suburb);
				eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Suburb, "Forrest");
			}

			if (eleUtil.isErrorDisplayedInElement(error_State) == true) {
				eleUtil.doSelectValueFromDropDown(txt_StateTerritory, "ACT");
			}

			if (eleUtil.isErrorDisplayedInElement(error_Postcode) == true) {
				eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_PostCode, "2603");

			}

			if (eleUtil.isErrorDisplayedInElement(error_DeliveryAddress) == true) {
				eleUtil.clickradiobutton(chk_DeliveryAddress);

			}
			if (eleUtil.isErrorDisplayedInElement(error_Mobilenumber) == true) {
				eleUtil.doSendKeysWithWaitCheckStaleElementException(chk_MobileNumber, "0433002845");

			}

		}
	//}
}
