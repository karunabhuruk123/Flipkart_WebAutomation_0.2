package com.flipkart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			String path=System.getProperty("user.dir");
			
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path+"\\src\\main\\java\\com\\flipkart\\qa\\config\\data.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	@BeforeTest
	@Parameters("browser")
	public static void initializeDriver(String browserName) {
		

		String path=System.getProperty("user.dir");

		//String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome"))

		{

			System.setProperty("webdriver.chrome.driver",path+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox"))

		{

			System.setProperty("webdriver.gecko.driver",path+"\\Drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();

		} else if (browserName.equals("IE"))

		{

			System.setProperty("webdriver.ie.driver", path+"\\Drivers\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		

	}

}
