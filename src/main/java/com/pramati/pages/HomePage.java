package com.pramati.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.pramati.util.BaseTest;

public class HomePage {

	public static  String driverPath = "E:/";
	public static   WebDriver driver;
	
		BaseTest baseTest ;
		
		
		public HomePage(WebDriver wDriver){
			driver =  wDriver;
		}

		@FindBy(xpath="//a[text()='login']")
		private WebElement signinLink;

		public WebElement getSigninLink() {
			return signinLink;
		}

		public void setSigninLink(WebElement signinLink) {
			this.signinLink = signinLink;
		}


		@FindBy(xpath="//input[@name='email']")
		private WebElement eUserName;

		@FindBy(xpath="//span[@class='myntraweb-sprite desktop-iconUser sprites-user']")
		private WebElement eLoginButton;
		
		public WebElement geteLoginButton() {
			return eLoginButton;
		}

		public void seteLoginButton(WebElement eLoginButton) {
			this.eLoginButton = eLoginButton;
		}


		@FindBy(xpath="//input[@name='password']")
		private WebElement ePassword;

		@FindBy(xpath="button[text()='Log in']")
		private WebElement eSignIn;
		
		public WebElement geteSignIn() {
			return eSignIn;
		}

		public void seteSignIn(WebElement eSignIn) {
			this.eSignIn = eSignIn;
		}


		@FindBy(xpath="//a[text()='Sign-out' and contains(@id,'logout')]") 
		private WebElement logoutButton;

		//--------------------------------------------------------------		

		public WebElement getUserName() {
			return eUserName;
		}
		
		public WebElement getLoginButton() {
			return eLoginButton;
		}

		public WebElement getPassword() {
			return ePassword;
		}

		public WebElement getSignInButton() {
			return eSignIn;
		}
		
		public WebElement getLogoutButton() {
			return logoutButton;
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

