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

public class ConfirmingIdentityPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private ExcelUtil exutil;

	public ConfirmingIdentityPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

		exutil = new ExcelUtil();

	}

	private By chk_Nodocument = By.xpath("//input[@id='Q188-A241']");
	private By chk_ProofOfAgePhotoCard = By.xpath("//input[contains(@id,'Q4-A6')]");
	private By drp_State = By.xpath("//select[contains(@id,'Q190') ]");
	private By txt_StateTerritory = By.xpath("//select[contains(@id,'Q190')]//option");
	private By chk_CreditCard = By.xpath("//input[contains(@id,'Q7-A16') ][1]");

	private By chk_yesResidentialEvidence = By.xpath("//input[contains(@id,'Q87')]");

	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");

	public void clickCategoryAdoc(String CategoryAdoc) {

		if (CategoryAdoc.equals("Proof of age/photcard")) {
			eleUtil.clickElementbyJavaScriptExecutorCheckStaleElement(chk_ProofOfAgePhotoCard);
		}

		eleUtil.doSelectValueFromDropDown(txt_StateTerritory, exutil.getTestData("STATE"));

	

	}

	public void clickCategoryBdoc(String CategoryBdoc) {
		

		if ((CategoryBdoc.equals("Credit Card"))) {
			
			eleUtil.clickElementbyJavaScriptExecutorCheckStaleElement(chk_CreditCard);
		}

	}

	public void isaddressresidenceavailable(String ans) {
		
		if (ans.equals("Yes")) {
			
			eleUtil.clickradiobutton(chk_yesResidentialEvidence);
		}
		eleUtil.scrollToElementbyJavaScriptExecutor(btn_NextPage);
		eleUtil.clickelement(btn_NextPage);
	}
}
