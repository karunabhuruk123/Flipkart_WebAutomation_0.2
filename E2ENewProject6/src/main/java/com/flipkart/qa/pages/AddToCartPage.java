package com.flipkart.qa.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.qa.base.TestBase;

public class AddToCartPage extends TestBase {

	// Page Factory:
	@FindBy(xpath = "//*[text()='ADD TO CART']")
	WebElement addToCart;

	@FindBy(xpath = "//*[text()='Place Order']")
	WebElement placeOrder;

	// Initializing Page Objects:

	public AddToCartPage() {

		PageFactory.initElements(driver, this);
	}

	public void AddToCart() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(
		                    ExpectedConditions.visibilityOf(addToCart));

		
		addToCart.click();

	}

	public void PlaceOrder() {
		
		new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(placeOrder));
		
		placeOrder.click();

	}

}
