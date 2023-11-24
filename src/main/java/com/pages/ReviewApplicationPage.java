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

public class ReviewApplicationPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private ExcelUtil exutil;

	public ReviewApplicationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		exutil = new ExcelUtil();

	}

	private By txtFamilyname = By.xpath("//span[text()='Family name to appear in passport']/following::span[1]");
	private By txtGivennames = By.xpath("//span[text()='Given names to appear in passport']/following::span[1]");
	private By txt_DOB = By.xpath("//span[text()='Date of birth']/following::span[1]");
	private By txt_PassportType = By.xpath("//span[text()='Passport type']/following::span[1]");

	private By txt_FeeType = By.xpath("//span[text()='Fee type']/following::span[1]");
	private By txt_FeeAmount = By.xpath("//span[text()='Fee amount']/following::span[1]");

	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");
	
	
	private By lnk_reviewapplication = By.xpath("//a[text()='Review application']");
	
	private By btn_Back = By.xpath("//input[@value='Back']");

	public String getActualFamilname() {

		// eleUtil.scrollToElementbyJavaScriptExecutor(txtFamilname);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleUtil.clickelement(lnk_reviewapplication);
		String actualFamilyname = eleUtil.doGetText(txtFamilyname);
		System.out.println("actualFamilyname"+actualFamilyname);
		return actualFamilyname;

	}

	public String expectedFamilyname() {
		
		String ExpectedFamilyname = exutil.getTestData("FAMILYNAME");

		return ExpectedFamilyname;
	}

	public String getActualGivennames() {

		//eleUtil.scrollToElementbyJavaScriptExecutor(txtFamilyname);

		String actualFamilyname = eleUtil.doGetText(txtGivennames);
		 System.out.println("Actual Given Name is "+actualFamilyname);
		return actualFamilyname;

	}

	public String expectedGivennames() {
		String ExpectedFamilyname = exutil.getTestData("GIVENNAMES");

		return ExpectedFamilyname;
	}

	public String getActualDOB() {

		// eleUtil.scrollToElementbyJavaScriptExecutor(txtFamilname);

		String actualDOB = eleUtil.doGetText(txt_DOB);
		 System.out.println("Actual DOB is "+actualDOB);
		return actualDOB;

	}

	public String expectedDOB() {
		String ExpectedDOB = exutil.getTestData("DOB");

		return ExpectedDOB;
	}

	public String getActualPassportType() {

		String passportType = eleUtil.doGetText(txt_PassportType);

		return passportType;

	}

	public String getActualFeeType() {

		String actualfeeType = eleUtil.doGetText(txt_FeeType);

		return actualfeeType;

	}
	
	public String getActualFeeAmount() {

		String actualfeeAmount = eleUtil.doGetText(txt_FeeAmount);

		return actualfeeAmount;

	}

	public void clicknext() {
		
		eleUtil.clickelement(lnk_reviewapplication);

		eleUtil.clickelement(btn_NextPage);
		
		 try { System.out. println("**********************************Application Number is  *********************"+"S1475860"); 
		 String ApplicaitonNumber = "S1475860";
		// exutil.insertGenerateFormNumber(ApplicaitonNumber); 
		 } 
		 catch (Exception e) {
		 }
		 
		// return new ContactDetailsPage(driver);
		
		eleUtil.clickelement(lnk_reviewapplication);
	}

}
