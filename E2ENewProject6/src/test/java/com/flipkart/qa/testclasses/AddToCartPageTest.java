package com.flipkart.qa.testclasses;

import java.util.Iterator;
import java.util.Set;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.AddToCartPage;
import com.flipkart.qa.pages.HomePage;

public class AddToCartPageTest extends TestBase {

	AddToCartPage addToCart;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {

		addToCart = new AddToCartPage();
		homePage = new HomePage();

	}

	// This Test will add product to cart and place order
	@Test
	public void AddToCartTest() throws InterruptedException {
		
		


		homePage.searchProduct();
		Thread.sleep(4000);

		homePage.selectRandomProduct();

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		Thread.sleep(4000);
		
		addToCart.AddToCart();
		Thread.sleep(4000);
		addToCart.PlaceOrder();
		Thread.sleep(4000);
		driver.switchTo().window(parentId);

	}
	

}
