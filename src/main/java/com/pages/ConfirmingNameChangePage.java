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

import com.qa.util.ElementUtil;
import com.qa.util.ExcelUtil;



public class ConfirmingNameChangePage  {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private ExcelUtil exutil;
	
	public ConfirmingNameChangePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

		exutil = new ExcelUtil();

	}
	private By rdn_Yesnamechange = By.xpath("//input[@id='Q188-A240']]");
	private By rdn_Nonamechange = By.xpath("//input[@id='Q188-A241']");
	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");	
	
		public void istherenamechange(String ans )
		{
			
			if(ans.equals("No"))
			{
			eleUtil.clickradiobutton(rdn_Nonamechange);
			}
			eleUtil.clickelement(btn_NextPage);
		}
		
		
		
	
}
