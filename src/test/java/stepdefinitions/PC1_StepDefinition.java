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

	

}
