package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	{
		System.out.println("browser value id" +browser);
		
		if (browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		if (browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else
		{
			System.out.println("Enter the correct browser");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	

}
