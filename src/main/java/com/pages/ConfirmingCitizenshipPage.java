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

public class ConfirmingCitizenshipPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private ExcelUtil exutil;

	public ConfirmingCitizenshipPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

		exutil = new ExcelUtil();

	}

	private By rdb_birth = By.xpath("");
	// Page - 5 Citizenship
	private By rdb_BirthCertificateYes = By.xpath("//input[@id='Q992-A1499']");
	private By rdb_BirthCertificateNo = By.xpath("//input[@id='Q992-A1500']");
	private By rdb_CitizenshipCertificateYes = By.xpath("//input[@id='Q964-A1460']");
	private By rdb_CitizenshipCertificateNo = By.xpath("//input[@id='Q964-A1461']");
	private By rdb_CitizenshipTypeCitizenship = By.xpath("//input[@id='Q81-A116']");
	// Australian Citizenship details
	private By txt_CitizenshipFamilyName = By.xpath("//input[contains(@name,'Q3')and @type='text']");

	private By txt_CitizenshipGivenName = By.xpath("//input[contains(@name,'Q4')and @type='text']");
	private By txt_CitizenshipDOB = By.xpath("//input[contains(@name,'Q5')and @type='text']");
	private By txt_CitizenshipNumber = By.xpath("//input[contains(@name,'Q6')and @type='text']");
	private By txt_CitizenshipAquiredDate = By.xpath("//input[contains(@name,'Q8')and @type='text']");
	private By txt_CitizenshipIssuedDate = By.xpath("//input[contains(@name,'Q14')and @type='text']");
	private By btn_Validate = By.xpath("//button[contains(@id,'Q9')]");

	private By btn_Verified = By.xpath("//h4[text()='Verified']");

	// Foreign Passport Details
	private By rdn_Foreign_passport = By.xpath("//input[(@id='Q1003-A1520')]");
	private By txt_FPFamilyName = By.xpath("//input[(@id='Q1274')]");
	private By txt_FPGivenNames = By.xpath("//input[(@id='Q1275')]");
	private By txt_FPDOB = By.xpath("//input[(@id='Q1278')]");
	private By rdn_Male = By.xpath("//input[(@id='Q1280-A1907')]");
	private By rdn_Female = By.xpath("//input[(@id='Q1280-A1908')]");
	private By rdn_undefined = By.xpath("//input[(@id='Q1280-A1909')]");
	private By txt_PlaceOfBirth = By.xpath("//input[(@id='Q1277')]");

	// commemorative certificate objects
	private By rdn_CommemorativeCertificateNo = By.xpath("//input[@id='Q2135-A3587']");
	private By rdn_CommemorativeCertificateYes = By.xpath("//input[@id='Q2135-A3586']");

	// ParentsName
	private By btn_NextPage = By.xpath("//input[@id='btnNextBottom']");

	// BirthCerificateParentsName
	private By rdn_BCParentNameYes = By.xpath("//input[@id='Q2154-A3625']");
	private By rdn_BCParentNameNo = By.xpath("//input[@id='Q2154-A3626']");
	//BirthCertificate Page Objects
	private By txt_StateTerritory = By.xpath("//select[contains(@name,'Q19')]//option");
	private By txt_familyname = By.xpath("//input[contains(@name,'Q10') and @type ='text']");
	private By txt_givennames = By.xpath("//input[contains(@name,'Q9') and @type ='text']");
	private By rdn_BirhtCertificateMale = By.xpath("//input[contains(@id,'Q40-A63') and @type ='radio']");
	private By rdn_BirhtCertificateFemale = By.xpath("//input[contains(@id,'Q40-A64') and @type ='radio']");
	private By rdn_BirhtCertificateIntersex = By.xpath("//input[contains(@id,'Q40-A65') and @type ='radio']");
	private By txt_DOB = By.xpath("//input[contains(@name,'Q11') and @type ='text']");
	private By txt_POB = By.xpath("//input[contains(@name,'Q58') and @type ='text']");
	private By txt_BirthRegisterNumber = By.xpath("//input[contains(@name,'Q3') and @type ='text']");
	private By txt_DOBRegister = By.xpath("//input[contains(@name,'Q17') and @type ='text']");
	private By txt_CertificateNumber = By.xpath("//input[contains(@name,'Q14') and @type ='text']");
	private By txt_CertificateIssueDate = By.xpath("//input[contains(@name,'Q51') and @type ='text']");
	
	public void haveAustralianBirthCertificate(String ans) {

		if (ans.equals("Yes")) {
			eleUtil.clickradiobutton(rdb_BirthCertificateYes);

		}
		if (ans.equals("No")) {

			eleUtil.clickradiobutton(rdb_BirthCertificateNo);
		}
	}

	public void haveCitizenshipCertificate(String ans) {

		if (ans.equals("Yes")) {

			eleUtil.clickradiobutton(rdb_CitizenshipCertificateYes);
		} else {

			eleUtil.clickradiobutton(rdb_CitizenshipCertificateNo);
		}
	}

	public void haveCommemorativeCertificate(String ans) {

		if (ans.equals("Yes")) {

			eleUtil.clickradiobutton(rdn_CommemorativeCertificateYes);
		} else {

			eleUtil.clickradiobutton(rdn_CommemorativeCertificateNo);
		}
	}

	public void doBitrthCertificateShowParentsName(String ans) {

		if (ans.equals("Yes")) {

			eleUtil.clickradiobutton(rdn_BCParentNameYes);
		} else {

			eleUtil.clickradiobutton(rdn_BCParentNameNo);
		}

	}
	
	public void enterBirthCertificateDetails()
		
	{
		eleUtil.scrollToElementbyJavaScriptExecutor(txt_StateTerritory);
		eleUtil.doSelectValueFromDropDown(txt_StateTerritory, exutil.getTestData("BIRTHCERTIFICATEISSUESTATE"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_familyname, exutil.getTestData("FAMILYNAME"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_givennames, exutil.getTestData("GIVENNAMES"));
		
		
		String sex = exutil.getTestData("SEX");

		if (sex.equals("M")) {
			eleUtil.clickradiobutton(rdn_BirhtCertificateMale);

		}
		if (sex.equals("F")) {
			eleUtil.clickradiobutton(rdn_BirhtCertificateFemale);

		} else {
			eleUtil.clickradiobutton(rdn_BirhtCertificateIntersex);

		}
		
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_DOB, exutil.getTestData("DOB"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_POB, exutil.getTestData("POB"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_BirthRegisterNumber, exutil.getTestData("BIRTH_CERTIFICATE_NUMBER"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_DOBRegister , exutil.getTestData("BIRTH_CERTIFICATE_REGISTERED_DATE"));

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_CertificateIssueDate, exutil.getTestData("BIRTH_CERTIFICATE_ISSUEDATE"));
		eleUtil.clickelement(btn_NextPage);
	}

	public void chooseCitizenshipType() {
		eleUtil.clickradiobutton(rdb_CitizenshipTypeCitizenship);

	}

	public void enterCitizenshipDetails() {
		

		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_CitizenshipFamilyName,
				exutil.getTestData("FAMILYNAME"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_CitizenshipGivenName,
				exutil.getTestData("GIVENNAMES"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_CitizenshipDOB, exutil.getTestData("DOB"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_CitizenshipNumber,
				exutil.getTestData("CERTIFICATENUMBER"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_CitizenshipAquiredDate,
				exutil.getTestData("DATEACQUIRED"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_CitizenshipIssuedDate,
				exutil.getTestData("DATEISSUED"));
		eleUtil.clickelementtoValidate(btn_Validate);

		// eleUtil.doClick((btn_Validate));
	}

	public void enterSupportingDocumentDetails(String DocumentEvidence) {

		if (DocumentEvidence.equals("Foreign Passport")) {

			// eleUtil.clickradiobutton(rdn_Foreign_passport);

			eleUtil.clickradiobutton(rdn_Foreign_passport);
		}
	}

	public void enterForeignPassportDetails() {
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_FPFamilyName, exutil.getTestData("FAMILYNAME"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_FPGivenNames, exutil.getTestData("GIVENNAMES"));
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_FPDOB, exutil.getTestData("DOB"));

		String sex = exutil.getTestData("SEX");

		if (sex.equals("M")) {
			eleUtil.clickradiobutton(rdn_Male);

		}
		if (sex.equals("F")) {
			eleUtil.clickradiobutton(rdn_Female);

		} else {
			eleUtil.clickradiobutton(rdn_undefined);

		}

		eleUtil.scrollToElementbyJavaScriptExecutor(txt_PlaceOfBirth);
		eleUtil.doSendKeysWithWaitCheckStaleElementException(txt_PlaceOfBirth, exutil.getTestData("POB"));

		eleUtil.clickelement(btn_NextPage);
	}

}
