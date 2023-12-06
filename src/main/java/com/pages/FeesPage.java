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

public class FeesPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private ExcelUtil exutil;

	public FeesPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		exutil = new ExcelUtil();

	}

	private By txt_fees = By.xpath("//div[@class='fee-option-content']//div[contains(text(),'A$')]");
	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");

	private By lnk_PassporttypeandFees = By.xpath("//a[text()='Passport type and fees']");

	private By Sec_PassportFees = By.xpath("//a[text()='Passport type and fees']");

	// span[@class='fee-option-header-content']
	public String getfees() {

		// eleUtil.scrollToElementbyJavaScriptExecutor(txt_fees);

		eleUtil.clickelement(lnk_PassporttypeandFees);
		String passport_fees = eleUtil.doGetText(txt_fees);
		System.out.println("Fee details from fee page " + passport_fees);

		return passport_fees;
	}

	public boolean checkfeeSection() {
		int size = eleUtil.getNumberofElements(Sec_PassportFees);

		if (size == 1) {
			return true;
		} else {
			return false;

		}

	}

	public void clicknext() {

		eleUtil.clickelement(btn_NextPage);
	}

	public void markTestDataasUsed() {
		System.out.println(exutil.getTestData("TestDataID"));
		String TestDataID = exutil.getTestData("TestDataID");

	}

}
