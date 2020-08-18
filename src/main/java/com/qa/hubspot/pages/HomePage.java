package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By header = By.cssSelector("h1.private-header__heading");
	By logo = By.xpath("//*[@id='hs-nav-v4--logo']");	
	By accountmenu = By.xpath("//a[@id='account-menu']");
	By signout = By.xpath("//a[@id='signout']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		elementUtil.waitForElementPresent(header);

	}

	public String getHomePageTitle() {

		// Rahna Comment:Base Code
		// return driver.getTitle();
		// Rahna Comment:Refactoring 1
		return elementUtil.doGetTitle();
	}

	public boolean verifyHomePageHeader() {
		// Rahna Comment:Base Code
		//return driver.findElement(header).isDisplayed();
		// Rahna Comment:Refactoring 1
		return elementUtil.doIsDisplayed(header);
	}

	public String getHomePageHeader() {
		// Rahna Comment:Base Code
		//return driver.findElement(header).getText();
		// Rahna Comment:Refactoring 1
		return elementUtil.doGetText(header);
	}

	public boolean verifyApplicationLogo() {
		// Rahna Comment:Base Code
		//return driver.findElement(logo).isDisplayed();
		// Rahna Comment:Refactoring 1
		return elementUtil.doIsDisplayed(logo);
	}
	
	
	public LoginPage signout() {
		// Rahna Comment:Refactoring1
		elementUtil.doClick(accountmenu);
		elementUtil.doClick(signout);
		// Rahna Comment:Refactoring1
		// Page chaining Model
		return new LoginPage(driver);

	}
	


}
