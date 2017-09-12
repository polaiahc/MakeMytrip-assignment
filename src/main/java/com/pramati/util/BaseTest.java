package com.pramati.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	 public static  String driverPath = "E:/";
	 public static  WebDriver driver;
	 
	 
	    /**
		 * @author Maheshg 
		 * Constructor method to initialize WebDriver
		 * @param wDriver
		 * Session WebDriver
		 */
		public BaseTest(WebDriver wDriver){
			driver =  wDriver;
		}

	
	public boolean startBrowser(String url) throws Exception {
		
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		return true;
		
	}
	
	public boolean closeBrowser() throws Exception {
		driver.quit();
		return true;
		
	}
	public static void main(String []args) throws Exception {
		
		BaseTest baseTest=new BaseTest(driver);
		baseTest.startBrowser("https://www.myntra.com/");
		
	}
}
