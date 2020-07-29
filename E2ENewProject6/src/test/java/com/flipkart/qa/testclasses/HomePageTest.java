package com.flipkart.qa.testclasses;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@Test(dataProvider = "getData", priority = 1, description = "This Test will login to Flipkart")

	public void Login(String user, String pwd) throws InterruptedException {
		
		loginPage = new LoginPage();
		homePage = loginPage.login(user, pwd);
		Thread.sleep(4000);

	}

	@Test(priority = 2, description = "This Test will verify Home Page label")

	public void verifyHomePageLabelTest() {

		Assert.assertTrue(homePage.verifyHomePageLabel(), "Flipkart");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "karuna.bhuruk@gmail.com";
		data[0][1] = "Flipkart@123";

		return data;
	}
}
