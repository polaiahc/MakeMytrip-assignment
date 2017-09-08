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

		/*if (objGenericLib.isElementVisible(ObjloginPage.getNextButton())) {
			Log.Info("Application invoke successful.");
		} else {
			Log.Fail("Application invoke failed.");
			return false;
		}
		try {
			objGenericLib.clearAndEnterText(ObjloginPage.getUserName(), sUserName);
			objGenericLib.clickAndWait(ObjloginPage.getNextButton(), ThreadTimeOut.ONE_SECOND);
			objGenericLib.threadSleep(ThreadTimeOut.ONE_SECOND);
			if (!objGenericLib.isElementVisible(ObjloginPage.getPassword())) {
				if(objGenericLib.isElementPresentByXpath("//*[text()='Please enter a valid email address. ']")){
					Log.Fail("Application login failed. Because of Invalid User Id.");
					return false;
				}
			}			

			objGenericLib.clearAndEnterText(ObjloginPage.getPassword(), sPassword);

			objGenericLib.clickAndWait(ObjloginPage.getSignInButton(), ThreadTimeOut.ONE_SECOND);
			objGenericLib.threadSleep(ThreadTimeOut.ONE_SECOND);

			ApplicationLogin.sHomeWindowId = objGenericLib.getWindow();

			if(objGenericLib.isElementPresentByXpath("//span[contains(text(),\"The email and password you entered don't match\")]")){
				Log.Fail("Application login failed. The email and password you entered don't match.");
				return false;
			}else if(objGenericLib.isElementPresentByXpath("//*[@class='error-msg']")){
				if(objGenericLib.getWebElement("//*[@class='error-msg']").isDisplayed()){
					Log.Fail("Application login failed. " + objGenericLib.getWebElementText("//*[@class='error-msg']"));
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			Log.Fail("Unable to enter login details, Please refer screenshot");
			return false;
		}*/
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