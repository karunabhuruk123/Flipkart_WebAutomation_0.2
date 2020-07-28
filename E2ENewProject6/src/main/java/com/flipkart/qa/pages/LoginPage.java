package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.flipkart.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory

	@FindBy(css = "input[class='_2zrpKA _1dBPDZ']")
	WebElement username;

	@FindBy(css = "input[class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement password;

	@FindBy(css = "button[class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement submit;

	// Initializing Page Objects:

	public LoginPage() {

		PageFactory.initElements(driver, this);
		
	}

	// Actions:

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
	}

}
