package com.pramati.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

protected static WebDriver driver;
public static  String driverPath = "E:/";

	@BeforeMethod
	public static void setUp(){
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void getUrl(String url){
		driver.get(url);
	}
	
	@AfterMethod
	public void cleanUp(){
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
	@AfterClass
	public static void tearDown(){
	
	}	
}
