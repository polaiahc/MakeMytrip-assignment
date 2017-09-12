package com.pramati.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pramati.pages.HomePage;
import com.pramati.util.BaseTest;


/**
 * Unit test for simple App.
 */

public class ApplicationLoginTest{
	
	public static WebDriver driver;
	public static BaseTest baseTest;
	public static HomePage homePage;
	
	 
	@BeforeTest()
	public static void setUP() throws Exception {
	   baseTest=new BaseTest(driver);
	   homePage=new HomePage(driver);
	   baseTest.startBrowser("https://www.myntra.com/");
		 
		

	}

	@Test()
	public static void LoginMyntra() throws Exception {
		
		
		homePage = PageFactory.initElements(driver, HomePage.class);

		homePage.getSignInButton().click();
        homePage.getSigninLink().click();
        homePage.getUserName().sendKeys("mahesh");
        homePage.getPassword().sendKeys("mahesh");
        homePage.geteSignIn().click();
		//homePage.mLogin("mahesh.rc25@gmail.com", "Siva@123");
		baseTest.closeBrowser();
		System.out.println("END");

	}
}