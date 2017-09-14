package com.pramati.util;

import org.openqa.selenium.By;
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
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			
		}

	
	public boolean startBrowser(String url) throws Exception {
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		return true;
		
	}
	
	public boolean browserInit(String url) {
		driver = new ChromeDriver();
		driver.navigate().to(url);
		return true;
		
	}
	
	public boolean login(String userName,String password) throws Exception {
		driver.findElement(By.xpath(".//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//a[text()='login']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='mountRoot']/div/div/div/form/fieldset[2]/button")).click();
		return true;
		
	}
	public boolean closeBrowser() throws Exception {
		driver.manage().deleteAllCookies();
		driver.quit();
		return true;
		
	}
	
	
	public boolean signOut() throws Exception {
		driver.findElement(By.xpath(".//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//div[@class='desktop-accInfoSection']")).click();
		driver.manage().deleteAllCookies();
		driver.quit();
		return true;
		
	}
}
