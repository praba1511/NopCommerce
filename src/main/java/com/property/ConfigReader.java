package com.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static FileInputStream fi;

	public static Properties getTheProperty() {

		// 3 classes to read the file--->
		// intiate file
		// read the file
		// load the read file

		File f = new File(
				"C:\\Users\\mseth\\eclipse-workspace\\Cucumber_Maven_IPT\\src\\main\\java\\com\\property\\NopCommerce.properties");

		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}

	public static String getBrowser() {

		String browser = getTheProperty().getProperty("browser");
		
		System.out.println(browser);

		return browser;
	}

	public static void main(String[] args) {
		getBrowser();
	}
}
