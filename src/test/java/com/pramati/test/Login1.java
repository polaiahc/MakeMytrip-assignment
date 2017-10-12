package com.pramati.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login1 {

	protected static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		String driverPath = "E:/";
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Navigate to URL
		driver.get("https://usertest.sciquest.com/apps/Router/Login?OrgName=Pittsburgh");
		// Maximize the window.
		driver.manage().window().maximize();
		// Enter UserName
		driver.findElement(By.id("UserName")).sendKeys("dbt55");
		// Enter Password
		driver.findElement(By.id("Password")).sendKeys("password");
		// Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Click on 'Sign In' button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Click on Compose Mail.

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@title='FISHER SCIENTIFIC COMPANY LLC']")));

		driver.findElement(By.xpath("//img[@title='FISHER SCIENTIFIC COMPANY LLC']")).click();
		
		System.out.println("Title :"+driver.getTitle());

		System.out.println("Title :"+driver.getPageSource());
		
		driver.switchTo().frame(1);
		
		driver.findElement(By.cssSelector("#SearchBox")).sendKeys("Acid");
		System.out.println("SearchBox  :"+driver.findElement(By.cssSelector("#SearchBox")));
		System.out.println("crossed the point");
		
		WebElement element = driver.findElement(By.cssSelector("#qa_Chemicals_6"));
//		Actions action = new Actions(driver);
//		action.moveToElement(element).click().perform();
		element.click();
		
		driver.findElement(By.cssSelector(".main_link")).click();
		Thread.sleep(3000);
		
		
//		WebElement fr = driver.findElement(By.xpath("//frameset"));

//		driver.switchTo().frame(fr);
		
		/*WebElement fr1 = driver.findElement(By.xpath("//frame[@src='PunchoutTransition?supplierId=3825401&punchoutOperation=create&RequestContext=Showcase&tmstmp=1507201124771']"));

		driver.switchTo().frame(fr1);
		WebDriverWait waitCmicals = new WebDriverWait(driver, 10);
		waitCmicals.until(ExpectedConditions.visibilityOfElementLocated(By.id("qa_Chemicals_6")));

		driver.findElement(By.id("qa_Chemicals_6")).click();*/
		
		/*WebElement element = driver.findElement(By.id("SearchBox"));
		element.sendKeys("Hi boss");
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		System.out.println("Title2  :"+driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Acids and Bases']")).click();*/
		
		

		/*
		 * driver.findElement(By.xpath("//div[@class='z0']/div")).click(); // Click on
		 * the image icon present in the top right navigational Bar
		 * driver.findElement(By.xpath("//div[@class='gb_1 gb_3a gb_nc gb_e']/div/a")).
		 * click(); // Click on 'Logout' Button
		 * driver.findElement(By.xpath("//*[@id='gb_71']")).click();
		 */
		// Close the browser.
		driver.close();
	}
}