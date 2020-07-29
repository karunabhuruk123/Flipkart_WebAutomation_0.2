package com.flipkart.qa.testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod

	public void setUp() {

		loginPage = new LoginPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
