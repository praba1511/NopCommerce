package com.nopcommercepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CustomerInfo extends BaseClass {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//input[@name='Email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@name='FirstName']")
	private WebElement fname;
	
	@FindBy(xpath = "//input[@name='LastName']")
	private WebElement lname;
	
	@FindBy(xpath = "(//input[@name='Gender'])[2]")
	private WebElement gender;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	private WebElement dob;
	
	@FindBy(xpath = "//input[@name='Company']")
	private WebElement company;
	
	@FindBy(xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[1]")
	private WebElement newsletter;
	
	@FindBy(xpath = "//button[@name='save']")
	private WebElement save;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement additionsuccess;
	
	@FindBy(xpath = "(//li[@class='nav-item'])[4]")
	private WebElement logout;

	public WebElement getLogout() {
		return logout;
	}

	public CustomerInfo(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getNewsletter() {
		return newsletter;
	}

	public WebElement getSave() {
		return save;
	}

	public String getAdditionsuccess() {
		
		String text = additionsuccess.getText();
		return text;
	}
	
	

}
