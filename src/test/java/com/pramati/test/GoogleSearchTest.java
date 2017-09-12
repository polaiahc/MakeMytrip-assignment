package com.pramati.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class GoogleSearchTest {
	
	 public static String driverPath = "E:/";
	 public static WebDriver driver;
	 
		public static void main(String []args) throws InterruptedException {
			
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to("https://www.myntra.com/");
			driver.manage().window().maximize();
			
			WebElement element = driver.findElement(By.xpath(".//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]/span[1]"));
			 
	        Actions action = new Actions(driver);
	 
	        action.moveToElement(element).build().perform();
	
			driver.findElement(By.className("desktop-linkButton")).click();
			
			Thread.sleep(2000);
			}
		
}