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

public class DeclarationPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private ExcelUtil exutil;

	public DeclarationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		exutil = new ExcelUtil();

	}

	private By btn_Back = By.xpath("//input[@value='Back']");

	public void clickback() {
		eleUtil.scrollPageDown();

		//eleUtil.clickelement(btn_Back);
		eleUtil.clickElementbyJavaScriptExecutorCheckStaleElement(btn_Back);
	}

}
