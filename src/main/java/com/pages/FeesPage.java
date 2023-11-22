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



public class FeesPage  {
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
	


	public String getfees() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//eleUtil.clickelement(txt_fees);
		String passport_fees =  eleUtil.doGetText(txt_fees);
		eleUtil.clickelement(btn_NextPage);
		System.out.println("**********************************Application Number is  *********************"+"S1475860");
		return passport_fees;
	}

}
