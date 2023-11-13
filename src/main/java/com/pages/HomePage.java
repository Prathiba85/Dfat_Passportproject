package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;
import com.qa.util.JavaScriptUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	private By txt_Title = By.xpath("//a[@id='lnkHomeMenuItem']");
	private By lnk_StartApplication = By.xpath("//span[text()='Start renewal/passport application']");

	public String getHomePageTitle() {
		String title = driver.findElement(txt_Title).getText();
		return title;

	}

	public void clickStartApplicaiton() {
	
		eleUtil.doClick(lnk_StartApplication);
		
	}

}
