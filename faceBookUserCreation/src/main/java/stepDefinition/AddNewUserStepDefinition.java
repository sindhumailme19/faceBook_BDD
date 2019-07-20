package stepDefinition;

import java.util.List;
import java.util.Map;

import commonLibrary.CommonLibrary;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddNewUserStepDefinition extends CommonLibrary{
	
	String REGISTER_PAGE_VERIFY = "//span[text()='Create an account'] - XPATH";
	String FIRSTNAME = "//input[@name='firstname'] - XPATH";
	String SURNAME = "//input[@name='lastname'] - XPATH";
	String EMAIL = "//input[@name='reg_email__'] - XPATH";
	String EMAIL_CONFIRMATION = "//input[@name='reg_email_confirmation__'] - XPATH";
	String NEWPASSWORD = "//input[@name='reg_passwd__'] - XPATH";
	String DATE = "//select[@name='birthday_day'] - XPATH";
	String MONTH = "//select[@name='birthday_month'] - XPATH";
	String YEAR = "//select[@name='birthday_year'] - XPATH";
	String SEX_FEMALE = "//label[text()='Female'] - XPATH";
	String SIGNUP_BUTTON = "//div[@id='reg_form_box']//button[text()='Sign Up'] - XPATH";
	String USERNAME_AFTER_SIGNUP = "//*[@title='Profile']//span/span - XPATH";
	String SIGNON_EMAIL = "//input[@name='email'] - XPATH";
	String SIGNON_PASSWORD = "//input[@name='pass'] - XPATH";
	String LOGIN_BUTTON = "//label[@id='loginbutton'] - XPATH";
	
	@Given("^User is already on Facebook Registration Page$")
	public void user_is_already_on_Facebook_Registration_Page(DataTable registraionPageVerify) throws Throwable {
		launchBrowserAndEnterURL();
		Thread.sleep(10000);
		List<Map<String, String>> data = registraionPageVerify.asMaps(String.class, String.class);
		String expectedValue = readExcel(data.get(0).get("WorkBook"), data.get(0).get("Sheet"),
				data.get(0).get("ColumName"));
		verifyExpected(REGISTER_PAGE_VERIFY, expectedValue);
	}

	@When("^User enters all the mandatory registration fields$")
	public void user_enters_all_the_mandatory_registration_fields(DataTable enterRegistrationData) throws Throwable {
		List<Map<String, String>> enterRegistrationValues = enterRegistrationData.asMaps(String.class, String.class);
		String firstName = readExcel(enterRegistrationValues.get(0).get("WorkBook"), enterRegistrationValues.get(0).get("Sheet"),
				enterRegistrationValues.get(0).get("ColumName"));
		String surName = readExcel(enterRegistrationValues.get(1).get("WorkBook"), enterRegistrationValues.get(1).get("Sheet"),
				enterRegistrationValues.get(1).get("ColumName"));
		String emailAddress = readExcel(enterRegistrationValues.get(2).get("WorkBook"), enterRegistrationValues.get(2).get("Sheet"),
				enterRegistrationValues.get(2).get("ColumName"));
		String newPassword = readExcel(enterRegistrationValues.get(3).get("WorkBook"), enterRegistrationValues.get(3).get("Sheet"),
				enterRegistrationValues.get(3).get("ColumName"));
		String birthDate = readExcel(enterRegistrationValues.get(4).get("WorkBook"), enterRegistrationValues.get(4).get("Sheet"),
				enterRegistrationValues.get(4).get("ColumName"));
		String birthMonth = readExcel(enterRegistrationValues.get(5).get("WorkBook"), enterRegistrationValues.get(5).get("Sheet"),
				enterRegistrationValues.get(5).get("ColumName"));
		String birthYear = readExcel(enterRegistrationValues.get(6).get("WorkBook"), enterRegistrationValues.get(6).get("Sheet"),
				enterRegistrationValues.get(6).get("ColumName"));
		
		enterText(FIRSTNAME, firstName);
		enterText(SURNAME, surName);
		enterText(EMAIL, emailAddress);
		enterText(EMAIL_CONFIRMATION, emailAddress);
		enterText(NEWPASSWORD, newPassword);
		selectByVisibleText(DATE, birthDate);
		selectByVisibleText(MONTH, birthMonth);
		selectByVisibleText(YEAR, birthYear);
		click(SEX_FEMALE);
	}

	@When("^User clicks on the Sign Up button$")
	public void user_clicks_on_the_Sign_Up_button() throws Throwable {
		click(SIGNUP_BUTTON);
	}

	@Then("^Facebook account successfully created$")
	public void facebook_account_successfully_created(DataTable successfulSignUp) throws Throwable {
		List<Map<String, String>> userNameVerification = successfulSignUp.asMaps(String.class, String.class);
		String userName = readExcel(userNameVerification.get(0).get("WorkBook"), userNameVerification.get(0).get("Sheet"),
				userNameVerification.get(0).get("ColumName"));
		
		verifyExpected(USERNAME_AFTER_SIGNUP, userName);
		closeAllWindows();
	}

	@Given("^User is already on Facebook Login Page$")
	public void user_is_already_on_Facebook_Login_Page(DataTable homePage) throws Throwable {
		launchBrowserAndEnterURL();
		Thread.sleep(5000);
		List<Map<String, String>> data = homePage.asMaps(String.class, String.class);
		String expectedValue = readExcel(data.get(0).get("WorkBook"), data.get(0).get("Sheet"),
				data.get(0).get("ColumName"));
		verifyExpected(REGISTER_PAGE_VERIFY, expectedValue);
	}

	@When("^User logged with created Username and Password$")
	public void user_logged_with_created_Username_and_Password(DataTable enterLoginValues) throws Throwable {
		List<Map<String, String>> enterValues = enterLoginValues.asMaps(String.class, String.class);
		String email = readExcel(enterValues.get(0).get("WorkBook"), enterValues.get(0).get("Sheet"),
				enterValues.get(0).get("ColumName"));
		String password = readExcel(enterValues.get(1).get("WorkBook"), enterValues.get(1).get("Sheet"),
				enterValues.get(1).get("ColumName"));
		
		
		enterText(SIGNON_EMAIL, email);
		enterText(SIGNON_PASSWORD, password);
	}

	@When("^Click on log In button$")
	public void click_on_log_In_button() throws Throwable {
		click(LOGIN_BUTTON);
	}

	@Then("^User successfully logged with created Facebook user$")
	public void user_successfully_logged_with_created_Facebook_user(DataTable signIN) throws Throwable {
		List<Map<String, String>> userNameVerification = signIN.asMaps(String.class, String.class);
		String userName = readExcel(userNameVerification.get(0).get("WorkBook"), userNameVerification.get(0).get("Sheet"),
				userNameVerification.get(0).get("ColumName"));
		
		verifyExpected(USERNAME_AFTER_SIGNUP, userName);
		closeAllWindows();
	}



}
