package com.qa.hubspot.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class to initialize driver and properties
 */
public class BasePage {

	WebDriver driver;
	Properties prop;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	/**
	 * this method is used to initialize the driver on the basis of browser name
	 * 
	 * @param browser
	 * @return driver
	 * @throws InterruptedException
	 */
	public WebDriver init_driver(Properties prop) {
		// Rahna Comment:Base Code
		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			// Rahna Comment:Refactoring
			tldriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			// Rahna Comment:Refactoring
			tldriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver = new SafariDriver();
			// Rahna Comment:Refactoring
			tldriver.set(new SafariDriver());

		} else {
			System.out.println("Please pass the correct browser name....");
		}

		//driver.manage().window().fullscreen();
		//driver.manage().deleteAllCookies();
		
		// Rahna Comment:Refactoring
		
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	/**
	 * this method is used to initialize the properties from config.properties
	 * file...
	 * 
	 * @return prop
	 */
	public Properties init_properties() {
		// Rahna Comment:Base Code
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("/Users/rahnaalfia/Documents/Rahna/Workspace/FrameworkMania/"
					+ "src/main/java/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	public String getScreenshot() {
		// File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
}
