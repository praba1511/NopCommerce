package com.nopcommercepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class login extends BaseClass {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement login;
	
	@FindBy(xpath = "//div[@class='content-header']")
	private WebElement dashboardpage;

	
	public login(WebDriver driver2) {
		
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
	
	public String getDashboardpage() {
		
		String text = dashboardpage.getText();
		return text;
	}
	
	
	
	
	
	
	
	
	

}
