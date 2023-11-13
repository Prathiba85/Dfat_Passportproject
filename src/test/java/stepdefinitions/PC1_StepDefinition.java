package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PersonalDetailsPage;
import com.qa.factory.DriverFactory;

import AppHooks.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PC1_StepDefinition {

	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	HomePage homepage;
	PersonalDetailsPage personalpage;

	@Given("I enter valid username as {string} and password as {string}")
	public void i_enter_valid_username_as_and_password_as(String email, String password) {
		loginpage.launchApplicaiton();
		loginpage.enterEmail(email);
		loginpage.enterPassword(password);
	}

	@When("I click login")
	public void i_click_login() {
		homepage = new HomePage(DriverFactory.getDriver());
		homepage = loginpage.clickLogin();

	}

	@Then("user is logged in Successfully")
	public void user_is_logged_in_Successfully() {
		String actual_title = homepage.getHomePageTitle();
		// System.out.println(actual_title);
		Assert.assertEquals(actual_title, "Home");
	}

	@Given("I click Start renewal\\/passport")
	public void i_click_Start_renewal_passport() {
		homepage.clickStartApplicaiton();

	}

	@Given("I read test data for testcase for PC1")
	public void i_read_test_data_for_testcase_for_pc1() {
		personalpage = new PersonalDetailsPage(DriverFactory.getDriver());
		personalpage.chooseLodgementLocation();
		personalpage.chooseAdultApplicant();
		personalpage.clickNext();
	}

	@When("I select that I am completing the application for {string}")
	public void i_select_that_i_am_completing_the_application_for(String Applicant) {
		personalpage.chooseApplicant(Applicant);
	}

	@When("I enter personal details")
	public void i_enter_personal_details() {
		personalpage.enterPersonalDetails();

	}

	@When("I enter contact details")
	public void i_enter_contact_details() {

	}

	/*
	 * @When("I enter test data as per TestData Spreadsheet") public void
	 * i_enter_test_data_as_per_TestData_Spreadsheet() {
	 * opaspd.chooseLodgementLocation(); opaspd.chooseAdultApplicant();
	 * opaspd.clickNext(); //page-2 opaspd.clickMyself();
	 * opaspd.enterFamilyName(PC1_TestData.FamilyName);
	 * opaspd.enterGivenName(PC1_TestData.GivenName);
	 * opaspd.selectSex(PC1_TestData.Sex); opaspd.enterDOB(PC1_TestData.DOB);
	 * opaspd.enterCountryOfBirth(PC1_TestData.CountryOfBirth);
	 * opaspd.enterParentsFamilyName(PC1_TestData.FamilyName);
	 * opaspd.clickNextPage2(); //Page-3
	 * opascd.enterResendentialAddress("8 McDonald Street","Chifley","ACT","2606" );
	 * opascd.chooseNoAlternateDeliveryOption(); opascd.enterMobileNumber(); //Page4
	 * opaspp.chooseHadAustralianPassport(); //Citizenship details
	 * opascp.haveAustralianBirthCertificate("No");
	 * opascp.haveCitizenshipCertificate("Yes"); opascp.chooseCitizenshipType();
	 * opascp.enterCitizenshipDetails(PC1_TestData.Citizenship_FamilyName,
	 * PC1_TestData.Citizenship_GivenName,PC1_TestData.Citizenship_DOB,
	 * PC1_TestData.Citizenship_CertificateNumber, PC1_TestData.DateAquired,
	 * PC1_TestData.DateIssued);
	 * opascp.enterSupportingDocumentDetails("Foreign Passport");
	 * opascp.enterForeignPassportDetails(PC1_TestData.FOREIGNPASSPORT_FAMILYNAME,
	 * PC1_TestData.FOREIGNPASSPORT_GIVENNAMES,PC1_TestData.FOREIGNPASSPORT_DOB,
	 * PC1_TestData.FOREIGNPASSPORT_SEX ,
	 * PC1_TestData.FOREIGNPASSPORT_PLACEOFBIRTH); //Confirm Identity
	 * opascc.istherenamechange("No");
	 * 
	 * //System.out.println(PC1_TestData.FOREIGNPASSPORT_DOB); //Emergency contact
	 * details //ap.enterEmergencyContactDetails(PC1_TestData.EmergencyFamilyName,
	 * PC1_TestData.EmergencyGivenName,PC1_TestData.Relationship);
	 * opascid.clickCategoryAdoc("Proof of age/photcard");
	 * opascid.clickCategoryBdoc("Credit Card");
	 * opascid.isaddressresidenceavailable("Yes");
	 * 
	 * //Referee details opasrp.enterRefereedetails(); //Emergency contact page
	 * opadecp.enterEmergencyContactDetails(); //Fees Page
	 * 
	 * String actual_fees = opasfp.getfees();
	 * Assert.assertEquals(actual_fees,"A$325.00");
	 * 
	 * }
	 * 
	 * @Then("I can successfully lodge PC1 application online.") public void
	 * i_can_successfully_lodge_PC1_application_online() {
	 * 
	 * }
	 * 
	 * @Then("I can successfully complete the application") public void
	 * i_can_successfully_complete_the_application() {
	 * 
	 * Map<String, String> map=commonFunction.GetAllData(); String
	 * xyz=map.get("FAMILYNAME").toString(); // ExtentReportLogger.log(xyz); string
	 * val=null; if(stringA.startsWith("@")) {
	 * val=CommonFunctions.getValueFromExcel("stringA"); }else {
	 * 
	 * }
	 * 
	 * }
	 */

}
