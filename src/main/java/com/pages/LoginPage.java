package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;

public class LoginPage  {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	private By txt_Emailaddress = By.xpath("//input[@name='UserName']");
	
	private By txt_Password = By.xpath("//input[@name='Password']");
	
	
	private By btn_Submit = By.xpath("//input[@type='submit']");
	
	public void launchApplicaiton()
	{
	
	DriverFactory.getDriver().get("https://online.passports.gov.au");
	
	}
	public void enterEmail(String email)
	{
		eleUtil.doSendKeys(txt_Emailaddress,email);
	}
	
	public void enterPassword(String password)
	{
	
		eleUtil.doSendKeys(txt_Password,password);
		
		}
	
	public HomePage clickLogin()
	{
		
		driver.findElement(btn_Submit).click();
		return new HomePage(driver);
	}
	
	
}
