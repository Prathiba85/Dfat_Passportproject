package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;




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
		//String title = driver.findElement(txt_Title).getText();
		
		return eleUtil.doGetTitle(txt_Title);

	}

	public void clickStartApplicaiton() {
		eleUtil.scrollToElementbyJavaScriptExecutor(lnk_StartApplication);
		eleUtil.doClick(lnk_StartApplication);
		
	}

}
