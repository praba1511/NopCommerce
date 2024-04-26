package com.nopcommercepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class addNewCustomer extends BaseClass {
	
	public WebDriver driver;

	@FindBy(xpath = "(//li[@class='nav-item has-treeview'])[4]")
	private WebElement customermenu;
	
	@FindBy(xpath = "//p[text()=' Customers']")
	private WebElement customer;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement addnewbtn;

	public addNewCustomer(WebDriver driver2) {
		
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomermenu() {
		return customermenu;
	}

	public WebElement getCustomer() {
		return customer;
	}

	public WebElement getAddnewbtn() {
		return addnewbtn;
	}
	
	
	
	
}
