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

	public PreviousPassportPage enterContactDetails() {
		//eleUtil.scrollToElementbyJavaScriptExecutor(chk_NoMatch);
		eleUtil.clickElementbyJavaScriptExecutorCheckStaleElement(chk_NoMatch);
		
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_AddressLine1, exutil.getTestData("RESEDENTIALADDRESSINE1"));
		eleUtil.scrollToElementbyJavaScriptExecutor(txt_Suburb);
		
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Suburb, exutil.getTestData("SUBURB"));
		
		eleUtil.doSelectValueFromDropDown(txt_StateTerritory, exutil.getTestData("STATE"));
		
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_PostCode, exutil.getTestData("POSTCODE"));
		
		eleUtil.clickradiobutton(chk_DeliveryAddress);
		
		//eleUtil.scrollToElementbyJavaScriptExecutor(chk_MobileNumber);
		eleUtil.doSendKeysWithWaitCheckStaleElementException(chk_MobileNumber, "0433002845");
		
		
		//eleUtil.scrollToElementbyJavaScriptExecutor(btn_NextPage);
	
		eleUtil.clickelement(btn_NextPage);
		
		return new PreviousPassportPage(driver);
		
	}
}
