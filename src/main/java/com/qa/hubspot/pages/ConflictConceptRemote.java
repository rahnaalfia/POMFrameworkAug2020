package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class ConflictConceptRemote extends BasePage   {

	WebDriver driver;
	ElementUtil elementUtil;


	// 2. page class constructor:
	public ConflictConceptRemote(WebDriver driver) {
		// Rahna Comment:Base Code
		this.driver = driver;
		// Rahna Comment:Refactoring
		elementUtil = new ElementUtil(driver);
	}

public void r1()
	{
		System.out.println("r1");
		
		
		
	}
	
	public void r2()
	{
		System.out.println("r1");
		
		
		
	}

}
