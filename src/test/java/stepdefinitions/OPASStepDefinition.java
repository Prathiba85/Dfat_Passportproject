package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.ConfirmingCitizenshipPage;
import com.pages.ConfirmingIdentityPage;
import com.pages.ConfirmingNameChangePage;
import com.pages.ContactDetailsPage;
import com.pages.DeclarationPage;
import com.pages.EmergencyContactPage;
import com.pages.FeesPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PersonalDetailsPage;
import com.pages.PreviousPassportPage;
import com.pages.RefereePage;
import com.pages.ReviewApplicationPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OPASStepDefinition {

	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	HomePage homepage;
	PersonalDetailsPage personalpage;
	ContactDetailsPage contactdetailspage;
	PreviousPassportPage previouspassportpage;
	ConfirmingCitizenshipPage citizenshippage;
	ConfirmingNameChangePage confirmingnamepage;
	ConfirmingIdentityPage confirmingidentitypage;
	RefereePage refereepage;
	EmergencyContactPage emergencycontactpage;
	FeesPage feepage;
	ReviewApplicationPage reviewpage;
	DeclarationPage declarepage;

	@Given("I enter valid username as {string} and password as {string}")
	public void i_enter_valid_username_as_and_password_as(String email, String password) {
		loginpage.launchApplicaiton();
		loginpage.enterEmail(email);
		loginpage.enterPassword(password);
	}

	@When("I click login")
	public void i_click_login() {
		homepage = new HomePage(DriverFactory.getDriver());
		loginpage.clickLogin();

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

	@Given("I read test data for testcase for {string}")
	public void i_read_test_data_for_testcase_for(String ApplicationType) {
		personalpage = new PersonalDetailsPage(DriverFactory.getDriver());
		personalpage.setTestData(ApplicationType);

	}

	@When("I select logement location as {string}")
	public void i_select_logement_location_as(String location) {
		personalpage.chooseLodgementLocation(location);

	}

	@When("I apply for a {string} application")
	public void i_apply_for_a_application(String Applicant) {
		personalpage.chooseAdultApplicant(Applicant);
		personalpage.clickNext();

	}

	@When("I select that I am completing the application for {string}")
	public void i_select_that_i_am_completing_the_application_for(String Applicant) {
		personalpage.chooseApplicant(Applicant);
	}

	@When("I enter personal details")
	public void i_enter_personal_details() {
		contactdetailspage = new ContactDetailsPage(DriverFactory.getDriver());
		personalpage.enterPersonalDetails();

	}

	@When("I enter contact details")
	public void i_enter_contact_details() {

		previouspassportpage = new PreviousPassportPage(DriverFactory.getDriver());
		contactdetailspage.enterContactDetails();

	}

	@When("I enter previous passport details")
	public void i_enter_previous_passport_details() {
		citizenshippage = new ConfirmingCitizenshipPage(DriverFactory.getDriver());
		citizenshippage = previouspassportpage.chooseHadAustralianPassport();
	}

	@When("I choose Do you have Australian Birth Certificate as {string}")
	public void i_choose_do_you_have_australian_birth_certificate_as(String string) {
		citizenshippage.haveAustralianBirthCertificate("No");
	}

	@When("I choose Do you have an Austraial Citizenship Certificate as {string}")
	public void i_choose_do_you_have_an_austraial_citizenship_certificate_as(String string) {
		citizenshippage.haveAustralianBirthCertificate("No");
		citizenshippage.haveCitizenshipCertificate("Yes");
		citizenshippage.chooseCitizenshipType();

	}

	@When("I enter Citizenshipdetails")
	public void i_enter_citizenshipdetails() {
		citizenshippage.enterCitizenshipDetails();
		citizenshippage.enterSupportingDocumentDetails("Foreign Passport");
		citizenshippage.enterForeignPassportDetails();
		confirmingnamepage = new ConfirmingNameChangePage(DriverFactory.getDriver());
		confirmingnamepage.istherenamechange("No");
	}

	@When("I confirm Identity")
	public void i_confirm_identity() {
		confirmingidentitypage = new ConfirmingIdentityPage(DriverFactory.getDriver());
		confirmingidentitypage.clickCategoryAdoc("Proof of age/photcard");
		confirmingidentitypage.clickCategoryBdoc("Credit Card");
		confirmingidentitypage.isaddressresidenceavailable("Yes");
	}

	@When("I confirm Referee details")
	public void i_confirm_referee_details() {
		refereepage = new RefereePage(DriverFactory.getDriver());
		refereepage.enterRefereedetails();

	}

	@When("I enter Emergency contact details")
	public void i_enter_emergency_contact_details() {
		emergencycontactpage = new EmergencyContactPage(DriverFactory.getDriver());
		emergencycontactpage.enterEmergencyContactDetails();

	}

	@When("I confirm Passport fees")
	public void i_confirm_passport_fees() {
		FeesPage feepage = new FeesPage(DriverFactory.getDriver());
	
		//String actualfees = feepage.getfees();
		//System.out.println("Actual fees "+actualfees);
		feepage.clicknext();
		
	}
	@When("if Referee Page is available click next")
	public void if_referee_page_is_available_click_next() {
		refereepage = new RefereePage(DriverFactory.getDriver());
		refereepage.click_Next();
	   
	}
	

	@Then("I can confirm that PC1 applicaiton is launched successfully")
	public void i_can_confirm_that_pc1_applicaiton_is_launched_successfully() {

	}

	// Pathway for PC7

	@When("I enter Have you had a Australian Passport as {string}")
	public void i_enter_have_you_had_a_australian_passport_as(String ans) {
		previouspassportpage.HadPreviouspassport(ans);

	}

	@When("I enter Are you able to present your most recently issued passport as {string}")
	public void i_enter_are_you_able_to_present_your_most_recently_issued_passport_as(String ans) {
		previouspassportpage.ableToPresentPreviousPassportDetails(ans);

	}

	@When("I enter Are you applying for data breach as {string}")
	public void i_enter_are_you_applying_for_data_breach_as(String ans) {
		previouspassportpage.isAppliedforDataBreach(ans);

	}

	@When("I enter previous passport details as per spreadsheet")
	public void i_enter_previous_passport_details_as_per_spreadsheet() {
		
		previouspassportpage.enterPreviousPassportdetails();

	}
	@When("I review application")
	public void i_review_application() {
		 reviewpage = new ReviewApplicationPage(DriverFactory.getDriver());
	    
	}

	@When("I confirm that Familyname is same as in test data sheet")
	public void i_confirm_that_familyname_is_same_as_in_test_data_sheet() {
	
	Assert.assertEquals(reviewpage.expectedFamilyname(),reviewpage.getActualFamilname() );
		
		
	    
	}

	@When("I confirm Givennames is same as in test data sheet")
	public void i_confirm_givennames_is_same_as_in_test_data_sheet() {
		Assert.assertEquals(reviewpage.expectedGivennames(),reviewpage.getActualGivennames() );
	    
	}

	@When("I confirm Date of Birth is  same as in test data sheet")
	public void i_confirm_date_of_birth_is_same_as_in_test_data_sheet() {
	
		Assert.assertEquals(reviewpage.expectedDOB(),reviewpage.getActualDOB());
	  
	}

	@When("I confirm that passport type is {string}")
	public void i_confirm_that_passport_type_is(String expectedPassportType) {
		Assert.assertEquals((expectedPassportType),reviewpage.getActualPassportType());
	
	}
	   

	@When("I confirm that fee type is {string}")
	public void i_confirm_that_fee_type_is(String feeType) {
		Assert.assertEquals((feeType),reviewpage.getActualFeeType());
	   
	}

	@When("I confirm fee amount {string}")
	public void i_confirm_fee_amount(String feeAmount) {
		Assert.assertEquals((feeAmount),reviewpage.getActualFeeAmount());
	   
	}

	@When("I click Next")
	public void i_click_next() {
		reviewpage.clicknext();
		//DeclarationPage declarepage= new DeclarationPage(DriverFactory.getDriver());
		//declarepage.clickback();
		
	}

	@Then("I can confirm that PC7 applicaiton is launched successfully")
	public void i_can_confirm_that_pc7_applicaiton_is_launched_successfully() {
		
	}
}
