package com.pramati.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(id="Email")
	private WebElement eUserName;

	@FindBy(id="next")
	private WebElement eNextButton;
	
	@FindBy(id="Passwd")
	private WebElement ePassword;

	@FindBy(id="signIn")
	private WebElement eSignIn;
	
	@FindBy(xpath="//a[text()='Sign-out' and contains(@id,'logout')]")
	private WebElement logoutButton;

	//--------------------------------------------------------------		

	public WebElement getUserName() {
		return eUserName;
	}
	
	public WebElement getNextButton() {
		return eNextButton;
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
}
