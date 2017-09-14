package com.pramati.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.pramati.util.BaseTest;

public class HomePage extends BaseTest {

	public static WebDriver driver;
	public HomePage(WebDriver Wdriver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='login']")
	private WebElement signinLink;

	public WebElement getSigninLink() {
		return signinLink;
	}

	public void setSigninLink(WebElement signinLink) {
		this.signinLink = signinLink;
	}

	@FindBy(xpath = "//input[@name='email']")
	private WebElement eUserName;

	@FindBy(xpath = "//span[@class='myntraweb-sprite desktop-iconUser sprites-user']")
	private WebElement eLoginButton;

	public WebElement geteLoginButton() {
		return eLoginButton;
	}

	public void seteLoginButton(WebElement eLoginButton) {
		this.eLoginButton = eLoginButton;
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement ePassword;

	@FindBy(xpath = ".//*[@id='desktop-header-cnt']/div[2]/div[3]/input")
	private WebElement eSignIn;

	public WebElement geteSignIn() {
		return eSignIn;
	}

	public void seteSignIn(WebElement eSignIn) {
		this.eSignIn = eSignIn;
	}

	@FindBy(xpath = "//a[text()='Sign-out' and contains(@id,'logout')]")
	private WebElement logoutButton;

	// --------------------------------------------------------------

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

	public boolean login() throws Exception {

		driver.findElement(By.xpath(".//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//a[text()='login']")).click();
		
		
		return true;

	}

	public static void main(String[] args) throws Exception {

		BaseTest baseTest = new BaseTest(driver);
		baseTest.startBrowser("https://www.myntra.com/");

	}
}
