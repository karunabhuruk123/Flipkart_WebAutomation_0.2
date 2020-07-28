package com.flipkart.qa.pages;

import java.util.List;
import java.util.Random;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.qa.base.TestBase;



public class HomePage extends TestBase {

	// Page Factory:

	@FindBy(className = "LM6RPg")
	WebElement searchBox;

	@FindBy(xpath = "//*[@class='_1e_EAo']")
	WebElement homePageLabel;

	@FindBy(xpath = "//*[text()='My Account']")
	WebElement myAccount;

	@FindBy(xpath = "//*[text()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//div[@class='_3wU53n']")
	List<WebElement> randomProductLink;

	// Initializing Page Objects:

	public HomePage() {

		PageFactory.initElements(driver, this);
		
	}

	// Actions:


	public boolean verifyHomePageLabel() {
		return homePageLabel.isDisplayed();

	}

	
	public void searchProduct() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(
		                    ExpectedConditions.visibilityOf(searchBox));

		searchBox.sendKeys("camera");
		searchBox.sendKeys(Keys.ENTER);
	}

	

	public void selectRandomProduct() throws InterruptedException {
		
		Thread.sleep(4000);

		List<WebElement> links = randomProductLink;
		links.get(new Random().nextInt(links.size())).click();

	}

	

}
