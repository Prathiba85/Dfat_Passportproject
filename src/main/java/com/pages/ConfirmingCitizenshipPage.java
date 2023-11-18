package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.ElementUtil;
import com.qa.util.ExcelUtil;





public class ConfirmingCitizenshipPage  {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	private ExcelUtil exutil;
	public ConfirmingCitizenshipPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

		exutil = new ExcelUtil();

	}

	private By  rdb_birth=By.xpath("");
		//Page - 5 Citizenship
	private By rdb_BirthCertificateYes = By.xpath("//input[@id='Q992-A1499']");
	private By rdb_BirthCertificateNo = By.xpath("//input[@id='Q992-A1500']");
	private By rdb_CitizenshipCertificateYes = By.xpath("//input[@id='Q964-A1460']");
	private By rdb_CitizenshipCertificateNo = By.xpath("//input[@id='Q964-A1461']");	
	private By rdb_CitizenshipTypeCitizenship = By.xpath("//input[@id='Q81-A116']");
	//Australian Citizenship details
	private By txt_CitizenshipFamilyName = By.xpath("//input[contains(@name,'Q3')and @type='text']");
	
	private By txt_CitizenshipGivenName = By.xpath("//input[contains(@name,'Q4')and @type='text']");	
	private By txt_CitizenshipDOB = By.xpath("//input[contains(@name,'Q5')and @type='text']");	
	private By txt_CitizenshipNumber = By.xpath("//input[contains(@name,'Q6')and @type='text']");	
	private By txt_CitizenshipAquiredDate = By.xpath("//input[contains(@name,'Q8')and @type='text']");	
	private By txt_CitizenshipIssuedDate = By.xpath("//input[contains(@name,'Q14')and @type='text']");	
	private By btn_Validate= By.xpath("//button[contains(@id,'Q9')]");	
	
		//Foreign Passport Details
	private By rdn_Foreign_passport= By.xpath("/input[(@id='Q1003-A1520')");	
	private By txt_FPFamilyName= By.xpath("//input[(@id='Q1274')]");	
	private By txt_FPGivenNames= By.xpath("//input[(@id='Q1275')]");	
	private By txt_FPDOB= By.xpath("//input[(@id='Q1278')]");	
	private By rdn_Male= By.xpath("//input[(@id='Q1280-A1907')]");	
	private By rdn_Female= By.xpath("//input[(@id='Q1280-A1908')]");
	private By rdn_undefined= By.xpath("//input[(@id='Q1280-A1909')]");
	private By txt_PlaceOfBirth= By.xpath("//input[(@id='Q1277')]");
	private By btn_NextPage= By.xpath("//input[@id='btnNextBottom']");

		
	public void haveAustralianBirthCertificate(String ans)
	{
	
		if(ans.equals("Yes"))
		{
			eleUtil.clickradiobutton(rdb_BirthCertificateYes);
			
			
		}
		if(ans.equals("No"))
		{
		
			eleUtil.clickradiobutton(rdb_BirthCertificateNo);
		}
	}
	
/*
	public void haveCitizenshipCertificate(String ans)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ans.equals("Yes"))
		{
			rdb_CitizenshipCertificateYes.click();
		}
		else
			rdb_CitizenshipCertificateNo.click();
	}
	
	public void chooseCitizenshipType()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rdb_CitizenshipTypeCitizenship.click();
	}
	
	public void enterCitizenshipDetails(String Citizenship_FamilyName, String Citizenship_GivenNames,String Citizenshi_DOB,String CitizenshipNumber,String CitizenshiAcquiredDate,String CertificateIssuedDate)
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Firstname
		CommonFunctions.scrollintoView(	txt_CitizenshipFamilyName, driver);
		CommonFunctions.clickElementByJS(txt_CitizenshipFamilyName, driver);
		txt_CitizenshipFamilyName.sendKeys(Citizenship_FamilyName);
		txt_CitizenshipFamilyName.sendKeys(Keys.ARROW_DOWN);
		txt_CitizenshipFamilyName.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Givennames
		CommonFunctions.scrollintoView(txt_CitizenshipGivenName, driver);
		CommonFunctions.clickElementByJS(txt_CitizenshipGivenName, driver);
		txt_CitizenshipGivenName.sendKeys(Citizenship_GivenNames);
		txt_CitizenshipGivenName.sendKeys(Keys.ARROW_DOWN);
		txt_CitizenshipGivenName.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DOB
		CommonFunctions.scrollintoView(txt_CitizenshipDOB, driver);
		CommonFunctions.clickElementByJS(txt_CitizenshipDOB, driver);
		txt_CitizenshipDOB.sendKeys(Citizenshi_DOB);
		txt_CitizenshipDOB.sendKeys(Keys.ARROW_DOWN);
		txt_CitizenshipDOB.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CitizenshipNumber
		CommonFunctions.scrollintoView(txt_CitizenshipNumber, driver);
		CommonFunctions.clickElementByJS(txt_CitizenshipNumber, driver);
		txt_CitizenshipNumber.sendKeys(CitizenshipNumber);
		txt_CitizenshipNumber.sendKeys(Keys.ARROW_DOWN);
		txt_CitizenshipNumber.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CitizenshipAquiredDate
		CommonFunctions.scrollintoView(txt_CitizenshipAquiredDate, driver);
		CommonFunctions.clickElementByJS(txt_CitizenshipAquiredDate, driver);
		txt_CitizenshipAquiredDate.sendKeys(CitizenshiAcquiredDate);
		txt_CitizenshipAquiredDate.sendKeys(Keys.ARROW_DOWN);
		txt_CitizenshipAquiredDate.sendKeys(Keys.ENTER);
		//CitizenshipIssued Date
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.scrollintoView(txt_CitizenshipIssuedDate, driver);
		CommonFunctions.clickElementByJS(txt_CitizenshipIssuedDate, driver);
		txt_CitizenshipIssuedDate.sendKeys(CertificateIssuedDate);
		txt_CitizenshipIssuedDate.sendKeys(Keys.ARROW_DOWN);
		txt_CitizenshipIssuedDate.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.scrollintoView(btn_Validate, driver);
		CommonFunctions.clickElementByJS(btn_Validate, driver);
		btn_Validate.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void enterSupportingDocumentDetails(String DocumentEvidence)
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.scrollintoView(rdn_Foreign_passport, driver);
		if(DocumentEvidence.equals("Foreign Passport"))
		{
			rdn_Foreign_passport.click();
		}
	}
	
	public void enterForeignPassportDetails(String FP_FamilyName,String FB_GivenNames,String DOB, String sex,String PlaceOfBirth)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.scrollintoView(txt_FPFamilyName, driver);
		CommonFunctions.clickElementByJS(txt_FPFamilyName, driver);
		txt_FPFamilyName.sendKeys(FP_FamilyName);
		txt_FPFamilyName.sendKeys(Keys.ARROW_DOWN);
		txt_FPFamilyName.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.scrollintoView(txt_FPGivenNames, driver);
		CommonFunctions.clickElementByJS(txt_FPGivenNames, driver);
		txt_FPGivenNames.sendKeys(FB_GivenNames);
		txt_FPGivenNames.sendKeys(Keys.ARROW_DOWN);
		txt_FPGivenNames.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CommonFunctions.scrollintoView(txt_FPDOB, driver);
		CommonFunctions.clickElementByJS(txt_FPDOB, driver);
		txt_FPDOB.sendKeys(DOB);
		txt_FPDOB.sendKeys(Keys.ARROW_DOWN);
		txt_FPDOB.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sex.equals("Male"))
		{
			CommonFunctions.scrollintoView(rdn_Male, driver);
			CommonFunctions.clickElementByJS(rdn_Male, driver);
			//chk_persondetailsMale.click();
		}
		if(sex.equals("Female"))
		{
			CommonFunctions.scrollintoView(rdn_Female, driver);
			CommonFunctions.clickElementByJS(rdn_Female, driver);
			//chk_persondetailsFemale.click();
		}
		else
		{
			CommonFunctions.scrollintoView(rdn_undefined, driver);
			CommonFunctions.clickElementByJS(rdn_undefined, driver);
			//chk_persondetailsIntersex.click();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CommonFunctions.scrollintoView(txt_PlaceOfBirth, driver);
		CommonFunctions.clickElementByJS(txt_PlaceOfBirth, driver);
		txt_PlaceOfBirth.sendKeys(PlaceOfBirth);
		txt_PlaceOfBirth.sendKeys(Keys.ARROW_DOWN);
		txt_PlaceOfBirth.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.scrollintoView(	btn_NextPage2, driver);
		CommonFunctions.clickElementByJS(btn_NextPage2, driver);
	}*/
	
	
}
