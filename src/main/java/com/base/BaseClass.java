package com.base;


	
	import java.awt.Desktop;
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

//	import com.aventstack.extentreports.ExtentReports;
//	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class BaseClass {

		protected static WebDriver driver;
//		public static ExtentReports extentReports;
//		public static ExtentSparkReporter sparkReporter;
		public static File file;

		public static WebDriver browserLaunch(String browserName) {

			if (browserName.equalsIgnoreCase("chrome")) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("incognito");
				driver = new ChromeDriver(options);
			} else if (browserName.equalsIgnoreCase("Edge")) {

				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("FireFox")) {

				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();

			return driver;
		}

		public static void launchURL(WebDriver driver, String URL) {

			try {
				driver.get(URL);

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		public static void clickOneElement(WebDriver driver, WebElement element) {
			try {

				new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(element));
				element.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		public static void inputvalues(WebDriver driver, WebElement element, String value) {

			try {
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
				element.sendKeys(value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		protected void clearData(WebDriver driver, WebElement element) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element))
						.clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void screenShot(WebDriver driver, String name) {

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File store = new File("C:\\Users\\mseth\\eclipse-workspace\\Cucumber_Maven_IPT\\Screenshot\\" + name + ".png");

			try {
				org.openqa.selenium.io.FileHandler.copy(source, store);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// wait

		public static void expliciWaitVisible(WebDriver driver, WebElement element) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void staticWait(long sec) {
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public static void implicitWait(long time, TimeUnit seconds) {

			try {
				driver.manage().timeouts().implicitlyWait(time, seconds);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public static void sendKeys(By name, String text) {
			driver.findElement(name).sendKeys(text);
		}

		public static void click(By name) {
			driver.findElement(name);
		}

//		public void extendreportStart() {
//			extentReports = new ExtentReports();
//			file = new File("C:\\Users\\mseth\\eclipse-workspace\\Maven_TestNG_IPT\\Reports");
//			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
//			extentReports.attachReporter(sparkReporter);
//		}
//
//		public void extendreportTearDown() throws IOException {
//
//			extentReports.flush();
//			file = new File("C:\\\\Users\\\\mseth\\\\eclipse-workspace\\\\Maven_TestNG_IPT\\\\Reports\\Index.html");
//			Desktop.getDesktop().browse((file).toURI());
//		}

		public String takeScreenshot() throws IOException {

			TakesScreenshot screenshot = (TakesScreenshot) driver;
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmSS").format(new Date());
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			File des = new File("ScreenShot\\.png" + " " + timeStamp + ".png");
			FileUtils.copyFile(src, des);
			return des.getAbsolutePath();
		}
	}



