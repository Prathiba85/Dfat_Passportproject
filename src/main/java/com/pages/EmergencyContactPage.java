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



public class EmergencyContactPage  {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private ExcelUtil exutil;

	public EmergencyContactPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		exutil = new ExcelUtil();

	}
	private By txt_EmergencyFamilyName = By.xpath("//input[@id='Q431']");
	private By txt_EmergencyGivenNames = By.xpath("//input[@id='Q432']");
	private By drp_Relationship = By.xpath("//select[@id='Q872']");
	private By drp_RelationList = By.xpath("//select[@id='Q872']//option");


	
	private By chk_NoMatch = By.xpath("//input[contains(@id,'Q83-A123')and @type='checkbox']");
	private By txt_AddressLine1 = By.xpath("//input[contains(@name,'Q44')and @type='text']");
	private By txt_Suburb = By.xpath("//input[contains(@name,'Q17')and @type='text']");
	private By txt_StateTerritory = By.xpath("//select[contains(@name,'Q19')]//option");
	private By txt_PostCode = By.xpath("//input[contains(@name,'Q20')and @type='text']");
	private By drp_States = By.xpath("//select[contains(@name,'Q19')]");
	
	private By chk_MobileNumber = By.xpath("//input[contains(@name,'Q14')and @type='text']");

	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");
	private By lnk_emergencycontactpage = By.xpath("//a[text()='Emergency contact details']");

	

	public void enterEmergencyContactDetails() {
		
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_EmergencyFamilyName, "Sundararaj");
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_EmergencyGivenNames, "Prabhu");
		//eleUtil.clickelement(drp_Relationship);
		eleUtil.scrollToElementbyJavaScriptExecutor(drp_Relationship);
		eleUtil.clickElementByJSlocator(drp_Relationship);
		eleUtil.doSelectValueFromDropDown(drp_RelationList, "Friend");
		eleUtil.clickElementbyJavaScriptExecutorCheckStaleElement(chk_NoMatch);
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_AddressLine1, "10 McDonald Street");
		

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_Suburb, "Chifley");

		eleUtil.doSelectValueFromDropDown(txt_StateTerritory, "ACT");

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_PostCode, "2606");

		eleUtil.doSendKeysWithWaitCheckStaleElementException(chk_MobileNumber, "0433681633");
		
		eleUtil.clickelement(btn_NextPage);
		
	}


	public void clickEmergencycontactpage() {
	
		eleUtil.clickelement(lnk_emergencycontactpage);
	}

}
