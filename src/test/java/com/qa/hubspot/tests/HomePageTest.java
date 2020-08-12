package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utility.Constants;

//@Listeners(ExtentReportListener.class)
public class HomePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	SoftAssert softAssert;

	// Pre Condiiton
	@BeforeTest
	public void setUp() {
		System.out.println("Start of the test.......");
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		softAssert = new SoftAssert();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE,"Incorrect Home Page Title...");
	}
	
	@Test(priority = 2)
	public void verifyHomePageAppLogo() {
		Assert.assertTrue(homePage.verifyApplicationLogo(), "Application Logo Not Present...");
	}

	/*
	 * Rahna Comment:Sometime there will be more than 1 assert, in a testcase. 
	 * If one tests fails, others wont be executed. This called Hard Assert 
	 * Overcome this we use Soft Assert
	 */
	
	@Test(priority = 3)
	public void verifyHomePageHeaderValueTest() {
		softAssert.assertTrue(homePage.verifyHomePageHeader());
		Assert.assertTrue(homePage.verifyHomePageHeader());
		String headerValue = homePage.getHomePageHeader();
		System.out.println("home page header is: " + headerValue);
		// To make Test Fail
		//Assert.assertEquals(headerValue, Constants.INVALID_HOME_PAGE_HEADER,"Incorrect Home Page Header...");
		// To make Test Pass
		Assert.assertEquals(headerValue, Constants.HOME_PAGE_HEADER, "Incorrect Home Page Header...");
		System.out.println("end of the test.......");
		// The below line is important ,If using Soft Assertion
		softAssert.assertAll();
	}
	
	@Test(priority = 4)
	public void verifySignout() {
		homePage.signout();
		
	}

	// Post Condition
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
	
	
}
