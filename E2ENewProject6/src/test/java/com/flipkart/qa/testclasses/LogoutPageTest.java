package com.flipkart.qa.testclasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.LogoutPage;

public class LogoutPageTest extends TestBase {

	LogoutPage logout;

	@BeforeMethod
	public void setUp() {

		logout = new LogoutPage();

	}

	//This Test will logout from url
	@Test
	public void LogoutTest() {

		logout.clickOnLogout();
		
	}

	@Test
	public void TearDown()
	{
		driver.quit();
	}
}
