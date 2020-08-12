package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.util.ElementUtil;
import com.qa.hubspot.utility.Constants;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. Page Objects / By Locators
	By emailID = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	// 2. page class constructor:
	public LoginPage(WebDriver driver) {
		// Rahna Comment:Base Code
		this.driver = driver;
		// Rahna Comment:Refactoring
		elementUtil = new ElementUtil(driver);
	}

	// 3. page actions/methods:
	public String getLoginPageTitle() {
		// Rahna Comment:Base Code
		// return driver.getTitle();

		// Rahna Comment:Refactoring
		elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
		return elementUtil.doGetTitle();
	}

	public boolean isSignUpLinkExists() {
		// Rahna Comment:Base Code
		// return driver.findElement(signUpLink).isDisplayed();

		// Rahna Comment:Refactoring
		return elementUtil.doIsDisplayed(signUpLink);
	}

	public HomePage doLogin(String username, String pwd) {
		// Rahna Comment:Base Code
		/*
		 * driver.findElement(emailID).sendKeys(username);
		 * driver.findElement(password).sendKeys(pwd);
		 * driver.findElement(loginButton).click(); try { Thread.sleep(8000);
		 * 
		 * } catch (InterruptedException e) { // TODO: handle exception }
		 */

		// Rahna Comment:Refactoring3
		elementUtil.doSendKeys(emailID, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);

		// Rahna Comment:Refactoring1
		// Page chaining Model
		return new HomePage(driver);

	}
	
	
	public void testDataProvider(String email, String firstName) {
		
		System.out.println("testDataProvider->"+ email);
		elementUtil.doSendKeys(emailID, email);
		System.out.println("testDataProvider->"+ firstName);
		elementUtil.doSendKeys(password, firstName);
	}

	public HomePage doLoginUsingDataProvider(String username, String pwd) {
		// Rahna Comment:Base Code
		/*
		 * driver.findElement(emailID).sendKeys(username);
		 * driver.findElement(password).sendKeys(pwd);
		 * driver.findElement(loginButton).click(); try { Thread.sleep(8000);
		 * 
		 * } catch (InterruptedException e) { // TODO: handle exception }
		 */

		// Rahna Comment:Refactoring3
		elementUtil.doSendKeys(emailID, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);

		// Rahna Comment:Refactoring1
		// Page chaining Model
		return new HomePage(driver);

	}

}
