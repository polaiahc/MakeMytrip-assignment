package com.pramati.test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.pramati.util.BaseTest;


/**
 * Unit test for simple App.
 * 
 */

public class ApplicationLoginTest{
	
	public static WebDriver driver;
	public static BaseTest baseTest;
	
	
	 
	@BeforeTest()
	public static void setUP() throws Exception {
	   baseTest=new BaseTest(driver); 
	}

	@Test()
	public static void LoginMyntra() throws Exception {
		baseTest.browserInit("https://www.myntra.com/");
		baseTest.login("mahesh.rc25@gmail.com", "Siva@123");
		Thread.sleep(10000);
		}
	
	
	@AfterTest()
	public static void tearDown() throws Exception {
		baseTest.signOut();
		System.out.println("END");
	   
	   
	}
}