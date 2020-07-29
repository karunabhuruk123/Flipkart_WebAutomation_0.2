package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.qa.base.TestBase;

public class LogoutPage extends TestBase{

	// Page Factory:
	@FindBy(xpath ="//*[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath ="//*[text()='My Account']")
	WebElement myAccount;
	
	
	public LogoutPage() {

		PageFactory.initElements(driver, this);
		
	}
  
	// Initializing Page Objects:
	
	public void clickOnLogout()
	{
		Actions action = new Actions(driver);
		action.moveToElement(myAccount).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
	}
}
