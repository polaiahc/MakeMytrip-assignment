package com.pramati.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	 public static  String driverPath = "E:/";
	 public static  WebDriver driver;
	 
	 
	  /*  *//**
		 * @author Maheshg 
		 * Constructor method to initialize WebDriver
		 * Session WebDriver
		 *//*
		public BaseTest(WebDriver wDriver){
			driver =  wDriver;	
		}*/

	
	public boolean startBrowser(String url) throws Exception {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
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
	
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//a[text()='login']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='mountRoot']/div/div/div/form/fieldset[2]/button")).click();
		return true;
		
	}
	
	
	public boolean signUp(String userName,String password, String mobile) throws Exception {
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		driver.findElement(By.xpath(".//*[@id='male']")).click();
		driver.findElement(By.xpath("//button[text()='REGISTER']")).click();
		return true;
		
	}
	public boolean searchProduct(String skuId) throws Exception {
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(skuId);
		driver.findElement(By.xpath(".//*[@id='desktop-header-cnt']/div[2]/div[3]/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='sizeButtonsContainer']/div[2]/button[2]")).click();
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		return true;
		
	}
	
	
	public boolean closeBrowser() throws Exception {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		return true;
		
	}
	
	
	public boolean signOut() throws Exception {
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//div[@class='desktop-accInfoSection']")).click();
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		return true;
		
	}
}
