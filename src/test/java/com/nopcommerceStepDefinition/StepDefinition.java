package com.nopcommerceStepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;
import com.nopcommercepom.CustomerInfo;
import com.nopcommercepom.SearchByEmail;
import com.nopcommercepom.SearchByName;
import com.nopcommercepom.addNewCustomer;
import com.nopcommercepom.login;
import com.runner.NopCommerceRunner;

import com.utility.ReadDataFromExcel;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

	public static WebDriver driver = NopCommerceRunner.driver;

	public static login login = new login(driver);

	public static addNewCustomer addnew = new addNewCustomer(driver);

	public static CustomerInfo info = new CustomerInfo(driver);

	public static SearchByEmail mail = new SearchByEmail(driver);

	public static SearchByName name = new SearchByName(driver);

	public static ReadDataFromExcel readdata = new ReadDataFromExcel();

	@Given("Browser launch and maximize browser")
	public void browser_launch_and_maximize_browser() {

		driver.manage().window().maximize();

	}

	@Before
	public void beforeHook(Scenario s) {

		String name = s.getName();
		String ID = s.getId();

		System.out.println("Scenario name : " + name + "Scenario ID: " + ID);
	}

	@Given("admin landed on the nopcommerce login page using {string} URL")
	public void admin_landed_on_the_nopcommerce_login_page_using_url(String url) {

		launchURL(driver, url);
	}

	@When("admin enter email {string} in the email field")
	public void admin_enter_email_in_the_email_field(String email) {

		implicitWait(30, TimeUnit.SECONDS);
		clearData(driver, login.getEmail());
		inputvalues(driver, login.getEmail(), email);
	}

	@When("admin enter password {string} in the password field")
	public void admin_enter_password_in_the_password_field(String password) {

		clearData(driver, login.getPassword());
		inputvalues(driver, login.getPassword(), password);
	}

	@When("click login")
	public void click_login() {

		clickOneElement(driver, login.getLogin());

	}

	@When("admin navigates to nopcommerce dasboard page")
	public void admin_navigates_to_nopcommerce_dasboard_page() {

		Assert.assertEquals(login.getDashboardpage(), "Dashboard");

	}

	@When("admin click customer menu")
	public void admin_click_customer_menu() {

		staticWait(3000);
		clickOneElement(driver, addnew.getCustomermenu());

	}

	@When("select customers to add new customer")
	public void select_customers_to_add_new_customer() {

		staticWait(3000);
		clickOneElement(driver, addnew.getCustomer());
	}

	@When("click add new button")
	public void click_add_new_button() {

		staticWait(3000);
		clickOneElement(driver, addnew.getAddnewbtn());

	}

	@Then("Admin navigates to the customer page")
	public void admin_navigates_to_the_customer_page() {

		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Add a new customer / nopCommerce administration");

	}

	@When("add customer details")
	public void add_customer_details() throws AWTException, InvalidFormatException, IOException {

		inputvalues(driver, info.getEmail(), readdata.getemail());
		inputvalues(driver, info.getPassword(), readdata.getpassword());
		inputvalues(driver, info.getFname(), readdata.getfirstName());
		inputvalues(driver, info.getLname(), readdata.getlasttName());
		clickOneElement(driver, info.getGender());
		inputvalues(driver, info.getDob(), readdata.getdob());
		inputvalues(driver, info.getCompany(), readdata.getcompany());
		clickOneElement(driver, info.getNewsletter());
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	@When("click save")
	public void click_save() {

		clickOneElement(driver, info.getSave());

	}

	@Then("admin validate the customer information added successfully")
	public void admin_validate_the_customer_information_added_successfully() {

		System.out.println(info.getAdditionsuccess());

		String additionsuccess = info.getAdditionsuccess();

	//	Assert.assertEquals(additionsuccess, "The new customer has been added successfully.");

	}

	@Then("admin logout")
	public void admin_logout() {

//		clickOneElement(driver, info.getLogout());
	}

	@Given("when admin click customer menu")
	public void when_admin_click_customer_menu() {

		staticWait(6000);
		clickOneElement(driver, addnew.getCustomermenu());
		clickOneElement(driver, addnew.getCustomermenu());

	}

	@When("select customer option from menu tree")
	public void select_customer_option_from_menu_tree() {

		staticWait(3000);
		clickOneElement(driver, addnew.getCustomer());
	}

	@When("Search customer by email")
	public void search_customer_by_email() {

		inputvalues(driver, mail.getSearchbyemail(), mail.getEmail());

	}

	@When("click search")
	public void click_search() {

		clickOneElement(driver, mail.getSearchbtn());

	}

	@Then("validate the customer info")
	public void validate_the_customer_info() {

		Assert.assertEquals(mail.getValidateinfo(), mail.getEmail());

	}

	@When("Search customer by firstname")
	public void search_customer_by_firstname() {

		staticWait(3000);
		clickOneElement(driver, addnew.getCustomermenu());
		clickOneElement(driver, addnew.getCustomermenu());
		staticWait(3000);
		clickOneElement(driver, addnew.getCustomer());

		inputvalues(driver, name.getSearchbyname(), name.getGetfirstname());
		clickOneElement(driver, name.getSearchbtn());
		Assert.assertEquals(name.getValidatename(), name.getGetfirstname());

	}

	@After
	public void afterhooks(Scenario s) throws Throwable {

		String name = s.getName();
		Status status = s.getStatus();
		screenShot(driver, name);
		System.out.println("***Status of the scenario:  " + name + " : " + status + "*******");
	}
}
