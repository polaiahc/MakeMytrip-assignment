package com.pramati.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pramati.base.BaseTest;
import com.pramati.dp.AccountMgmtDP;
import com.pramati.pages.HomePage;

public class SerachProduct extends BaseTest  {
	
	@Test(priority = 1, groups = { "Smoke","Sanity" }, dataProvider = "appLogin", dataProviderClass = AccountMgmtDP.class ,description="Login to the myntra application.")
	public void myntra_Sign(String url,String email, String password,String validationMessage) throws Exception{
		HomePage signUpPage =PageFactory.initElements(driver, HomePage.class);
		signUpPage.getUrl(url);
		Assert.assertTrue(signUpPage.isInitialized(),"Sign in link is presented.");
		signUpPage.login(email, password);
		Assert.assertEquals(validationMessage, signUpPage.confirmationHeader());
	}	
}