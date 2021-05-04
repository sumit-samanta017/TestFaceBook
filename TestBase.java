package com.qa.testbase;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.GoogleAutomationPages1;
import com.qa.pages.Pages_AmazonCategorySearch;
import com.qa.pages.Pages_CountingMultipleWindows;
import com.qa.pages.Pages_FaceBook;
import com.qa.pages.Pages_GettingCountryNamesAmazon;
import com.qa.pages.Pages_ScrollAmazonPage;

// Test Fixture Class
public class TestBase {

	public WebDriver cDriver;
	public Actions act;
	public JavascriptExecutor js;
	public ChromeOptions options;
	public Map<String, Object> prefs;
	
	
	public GoogleAutomationPages1 gAP1; //Use for Google Automation
	
	public Pages_AmazonCategorySearch pagesAmazonCategory; // Use for Amazon Category Search
	
	public Pages_CountingMultipleWindows countMultipleWin; //Use for counting Multiple Windows of Citi Bank App
	
	public Pages_GettingCountryNamesAmazon getCountryNames; // Use for getting country names present in footer section of Amazon homepage
	
	public Pages_ScrollAmazonPage scrollAmazonPage; // Use for scroll Amazon Page
	
	public Pages_FaceBook fb; // Use for FaceBook

	@Parameters({"browser","url"})
	@BeforeClass
	public void setUp(String browser, String url) {

		if(browser.equalsIgnoreCase("chrome")) {

			options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Softwares\\Driver executables\\Chrome\\chromedriver.exe");
			cDriver = new ChromeDriver(options);

		}

		//gAP1 = new GoogleAutomationPages1(cDriver); //Used for Google Automation for searching Automation Testing
		
		// pagesAmazonCategory = new Pages_AmazonCategorySearch(cDriver); // Use for Amazon Category Search
		// countMultipleWin = new Pages_CountingMultipleWindows(cDriver); // Use for counting multiple windows of Citi Bank
		// getCountryNames = new Pages_GettingCountryNamesAmazon(cDriver); // Use for getting country names present in footer section of Amazon homepage
		
		
//		js = (JavascriptExecutor)cDriver; // use for scrolling
//		scrollAmazonPage = new Pages_ScrollAmazonPage(cDriver); // Use for scrolling amazon page project
		
		fb = new Pages_FaceBook(cDriver);
		cDriver.manage().window().maximize();
		cDriver.get(url);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		cDriver.quit();
		cDriver.close();
	}

}
