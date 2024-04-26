package com.nopcommercepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchByEmail extends BaseClass{
	
	public WebDriver driver;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='SearchEmail']")
	private WebElement searchbyemail;
	
	@FindBy(xpath = "//button[@id='search-customers']")
	private WebElement searchbtn;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	private WebElement validateinfo;

	public SearchByEmail(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public String getEmail() {
		
		String getmail = email.getText();
		return getmail;
	}

	public WebElement getSearchbyemail() {
		return searchbyemail;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public String getValidateinfo() {
		
		String text = validateinfo.getText();
		return text;
	}
	
	
	
	

}
