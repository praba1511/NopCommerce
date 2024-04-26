package com.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;
import com.property.ConfigReader;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\java\\com\\features\\nopCommerce.feature",
		"src\\test\\java\\com\\features\\nopcommercesearchbyemailandname.feature"},
glue = "com.nopcommerceStepDefinition",

//tags = "@tag1",

plugin = {"pretty", "html:HTMLReports/nopCommerce.html", 
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"		
}
		
)

public class NopCommerceRunner {
	
	public static WebDriver driver;
	
	public static ConfigReader reader = new ConfigReader();
	@BeforeClass
	public static void set_up() {
		driver = BaseClass.browserLaunch(reader.getBrowser());
	}
	
	@AfterClass
	public static void tear_down() {
		
		driver.close();
	}

}
