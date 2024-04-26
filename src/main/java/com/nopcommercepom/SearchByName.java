package com.nopcommercepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchByName extends BaseClass {

	public WebDriver driver;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement getfullname;

	@FindBy(xpath = "//input[@name='SearchFirstName']")
	private WebElement searchbyname;

	@FindBy(xpath = "//button[@id='search-customers']")
	private WebElement searchbtn;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement validatename;

	public SearchByName(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public String getGetfirstname() {

		String name = getfullname.getText();
		String[] split = name.split(" ");
		String getfname = split[0];
		return getfname;
	}

	public WebElement getSearchbyname() {
		return searchbyname;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public String getValidatename() {
		String validname = validatename.getText();
		String[] split = validname.split(" ");
		String name = split[0];
		return name;
	}

}
