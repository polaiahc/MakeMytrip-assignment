package com.pramati.test;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pramati.pages.HomePage;


/**
 * Unit test for simple App.
 */

public class ApplicationLoginTest {
	
	private WebDriver driver = null;
	public static String sHomeWindowId = null;

	/**
	 * Constructor method for initialization of data and objects.
	 * 
	 * @param wDriver
	 */
	public ApplicationLoginTest(WebDriver wDriver){
		this.driver =  wDriver;
	}

	 
	@BeforeTest
	public void setUp() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();

	}
	
	
	@Test
	public boolean login(List<String> dataParamList) {
		//login
		String sUserName = dataParamList.get(0);
		String sPassword = dataParamList.get(1);
	
		HomePage ObjloginPage = PageFactory.initElements(driver, HomePage.class);
		
		
		return false;

		
	}

	/**
	 * Logout from the application
	 * 
	 * @param dataParamList
	 * @return
	 */
	@AfterTest
	public boolean logout(List<String> dataParamList) {
		return false;
	}
}