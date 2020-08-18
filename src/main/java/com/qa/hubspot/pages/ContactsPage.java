package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. Page Objects / By Locators
	By emailID = By.id("username");


	// 2. page class constructor:
	public ContactsPage(WebDriver driver) {
		// Rahna Comment:Base Code
		this.driver = driver;
		// Rahna Comment:Refactoring
		elementUtil = new ElementUtil(driver);
	}



}
