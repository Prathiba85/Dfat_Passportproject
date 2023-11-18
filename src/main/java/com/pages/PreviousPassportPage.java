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

	private By rd_HadPReviousPassport_NO = By.xpath("//input[@id='Q62-A96']");

	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");

	public ConfirmingCitizenshipPage chooseHadAustralianPassport() {
		
		eleUtil.clickradiobutton(rd_HadPReviousPassport_NO);
		eleUtil.clickelement(btn_NextPage);
		return new ConfirmingCitizenshipPage(driver);

	}
}
