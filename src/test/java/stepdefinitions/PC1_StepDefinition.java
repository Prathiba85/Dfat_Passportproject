package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.ConfirmingCitizenshipPage;
import com.pages.ContactDetailsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PersonalDetailsPage;
import com.pages.PreviousPassportPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PC1_StepDefinition {

	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	HomePage homepage;
	PersonalDetailsPage personalpage;
	ContactDetailsPage contactdetailspage;
	PreviousPassportPage previouspassportpage;
	ConfirmingCitizenshipPage  citizenshippage;

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
		contactdetailspage = new ContactDetailsPage(DriverFactory.getDriver());
		contactdetailspage= personalpage.enterPersonalDetails();

	}

	@When("I enter contact details")
	public void i_enter_contact_details() {
		previouspassportpage = new PreviousPassportPage(DriverFactory.getDriver());
		previouspassportpage = contactdetailspage.enterContactDetails();

	}
	@When("I enter previous passport details")
	public void i_enter_previous_passport_details() {
		  citizenshippage = new ConfirmingCitizenshipPage(DriverFactory.getDriver());
		  citizenshippage= previouspassportpage.chooseHadAustralianPassport();
	}

	@When("I choose Do you have Australian Birth Certificate as {string}")
	public void i_choose_do_you_have_australian_birth_certificate_as(String string) {
		citizenshippage.haveAustralianBirthCertificate("No");
	}

	@When("I choose Do you have an Austraial Citizenship Certificate as {string}")
	public void i_choose_do_you_have_an_austraial_citizenship_certificate_as(String string) {
		citizenshippage.haveAustralianBirthCertificate("Yes");
	 
	}

	@When("I enter Citizenshipdetails")
	public void i_enter_citizenshipdetails() {
	  
	}

	@When("I confirm Identity")
	public void i_confirm_identity() {
	   
	}

	@When("I confirm Referee details")
	public void i_confirm_referee_details() {
	   
	}

	@When("I enter Emergency contact details")
	public void i_enter_emergency_contact_details() {
	   
	}

	@When("I confirm Passport fees")
	public void i_confirm_passport_fees() {
	   
	}

	@When("I review application and click Next")
	public void i_review_application_and_click_next() {
	  
	}

	@Then("I can confirm that PC1 applicaiton is launched successfully")
	public void i_can_confirm_that_pc1_applicaiton_is_launched_successfully() {
	   
	}

}
