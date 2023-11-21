package stepdefinitions;



import java.util.Properties;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;

public class Hooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	
	
	@Before(order = 0) 
	public void getProperty()
	{
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
	}

	@Before (order = 1)
	public void launchBrowser()
	{
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		driver.manage().window().maximize();
	}
	@After(order = 0)
	public void teardownandScreenshot()
	{
		//System.out.println("Scenario status ======>"+scenario.getSteps());
		// byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
       // scenario.attach(screenshot, "image/png",scenario.getName());  
		//String screenshotName = scenario.getName().replaceAll("", "_");
		//byte[] sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		//scenario.attach(sourcepath, "image/png", screenshotName);        
		driver.quit();
		
	}
	/*
	@After(order =1)
	public void teardown()
	{
		
		if(scenario.isFailed())
		{
			//String screenshotName = scenario.getName().replaceAll("", "_");
			//byte[] sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			//scenario.attach(sourcepath, "image/png", screenshotName);
		}
	}
	
	
	@After(order = 0)
	public void teardownandScreenshot(Scenario scenario)
	{
		//System.out.println("Scenario status ======>"+scenario.getSteps());
		// byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
       // scenario.attach(screenshot, "image/png",scenario.getName());  
		//String screenshotName = scenario.getName().replaceAll("", "_");
		//byte[] sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		//scenario.attach(sourcepath, "image/png", screenshotName);        
		driver.quit();
		
	}
	@After(order =1)
	public void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			//String screenshotName = scenario.getName().replaceAll("", "_");
			//byte[] sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			//scenario.attach(sourcepath, "image/png", screenshotName);
		}
	}*/
	

}
