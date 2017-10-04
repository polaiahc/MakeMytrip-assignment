package com.pramati.test;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pramati.base.BaseTest;
import com.pramati.dp.AccountMgmtDP;
import com.pramati.pages.AddressPage;
import com.pramati.pages.HomePage;
import com.pramati.pages.ProductPage;

public class AccountMgmtTest extends BaseTest  {
	
	@Test(priority = 1, groups = { "Smoke","Sanity" }, dataProvider = "appLogin", dataProviderClass = AccountMgmtDP.class ,description="Login to the myntra application.")
	public void myntra_Sign(String url,String email, String password,String validationMessage) throws Exception{
		HomePage signUpPage =PageFactory.initElements(driver, HomePage.class);
		signUpPage.getUrl(url);
		Assert.assertTrue(signUpPage.isInitialized(),"Sign in link is presented.");
		signUpPage.login(email, password);
		Assert.assertEquals(validationMessage, signUpPage.confirmationHeader());
	}	
	
	
	@Test(priority = 2, groups = { "Smoke","Sanity" }, dataProvider = "appLogout", dataProviderClass = AccountMgmtDP.class ,description="Logout from myntra application.")
	public void myntra_Logout(String url,String email, String password,String validationMessage) throws Exception{
	
		HomePage signUpPage =PageFactory.initElements(driver, HomePage.class);
		signUpPage.getUrl(url);
		Assert.assertTrue(signUpPage.isInitialized(),"Sign in link is presented.");
		signUpPage.login(email, password);
		signUpPage.signOut();
		Assert.assertEquals(validationMessage, signUpPage.confirmationHeader());
	}	
	
	
	@Test(priority = 3, groups = { "Smoke","Sanity" }, dataProvider = "appsignUp", dataProviderClass = AccountMgmtDP.class ,description="singup for new user in myntra application.")
	public void myntra_SignUp(String url,String email, String password,String validationMessage,String mobile) throws Exception{
		
		HomePage signUpPage =PageFactory.initElements(driver, HomePage.class);
		signUpPage.getUrl(url);
		Assert.assertTrue(signUpPage.isInitialized(),"Sign in link is presented.");
		signUpPage.getSigninHome().click();
		Thread.sleep(10000);
		signUpPage.getSignUpLink().click();
		signUpPage.getUserName().sendKeys(email);
		signUpPage.getPassword().sendKeys(password);
		signUpPage.getMobile().sendKeys(mobile);
		signUpPage.getMale().click();
		signUpPage.getRegister().click();
		Assert.assertEquals("Register", signUpPage.confirmationHeader());
		signUpPage.signOut();
		Assert.assertEquals(validationMessage, signUpPage.confirmationHeader());
	}	
	
	
	@Test(priority = 4, groups = { "Smoke","Sanity" }, dataProvider = "appLogout", dataProviderClass = AccountMgmtDP.class ,description="Add new Address to Account.")
	public void myntra_ChangeShippingAddress(String url,String email, String password,String validationMessage) throws Exception{
	
		HomePage signUpPage =PageFactory.initElements(driver, HomePage.class);
		signUpPage.getUrl(url);
		Assert.assertTrue(signUpPage.isInitialized(),"Sign in link is presented.");
		signUpPage.login(email, password);
		Thread.sleep(10000);
		signUpPage.getHomeLogutLink().click();
		signUpPage.getSavedAddresses().click();
		Thread.sleep(10000);
		Assert.assertEquals("My Addresses", signUpPage.confirmationHeader());
		
		AddressPage addressPage =PageFactory.initElements(driver, AddressPage.class);
		addressPage.getAddNewAddress().click();
		addressPage.getPincode().sendKeys("500072");
		addressPage.getName().sendKeys("dk bose");
		addressPage.getAddress().sendKeys("Balaji Nagar.");
		addressPage.getLocality().sendKeys("Kukatpally");
		addressPage.getMobile().sendKeys("9090909090");
		addressPage.getHome().click();
		addressPage.getSave().click();
		
		Thread.sleep(10000);
		Assert.assertEquals("My Addresses", addressPage.confirmationHeader());
	}	
	
	
	
	@Test(priority =5, groups = { "Smoke","Sanity" }, dataProvider = "appLogout", dataProviderClass = AccountMgmtDP.class ,description="Add new Address to Account.")
	public void myntra_RemoveAddress(String url,String email, String password,String validationMessage) throws Exception{
	
		HomePage signUpPage =PageFactory.initElements(driver, HomePage.class);
		signUpPage.getUrl(url);
		Assert.assertTrue(signUpPage.isInitialized(),"Sign in link is presented.");
		signUpPage.login(email, password);
		Thread.sleep(10000);
		signUpPage.getHomeLogutLink().click();
		signUpPage.getSavedAddresses().click();
		Thread.sleep(10000);
		Assert.assertEquals("My Addresses", signUpPage.confirmationHeader());
		
		AddressPage addressPage =PageFactory.initElements(driver, AddressPage.class);
		
		addressPage.getWebElement("dk bose").click();
		Thread.sleep(10000);
		Assert.assertEquals("My Addresses", addressPage.confirmationHeader());
	}	
	
	
	
	@Test(priority =6, groups = { "Smoke","Sanity" }, dataProvider = "appLogout", dataProviderClass = AccountMgmtDP.class ,description="Add new Address to Account.")
	public void myntra_NoOfProductsPerPageTest(String url,String email, String password,String searchString) throws Exception{
	
		HomePage signUpPage =PageFactory.initElements(driver, HomePage.class);
		signUpPage.getUrl(url);
		Assert.assertTrue(signUpPage.isInitialized(),"Sign in link is presented.");
		signUpPage.login(email, password);
		Thread.sleep(10000);
		signUpPage.getSearchBox().sendKeys(searchString);
		signUpPage.getSearchBoxSubmit().click();
		Thread.sleep(10000);
		String products=signUpPage.getTotalProducts().getText();
		System.out.println("products ::"+products);
		Assert.assertEquals("Online Shopping For Women Men Boy Girl Fashion & Lifestyle Myntra - Buy Online Shopping For Women Men Boy Girl Fashion & Lifestyle Myntra online in India", signUpPage.confirmationHeader());
		Assert.assertNotNull(products);
		
		
	}	                               
	
	
	@Test(priority =7, groups = { "Smoke","Sanity" }, dataProvider = "appLogout", dataProviderClass = AccountMgmtDP.class ,description="Add new Address to Account.")
	public void myntra_OrderCODTest(String url,String email, String password,String searchString) throws Exception{
	
		HomePage signUpPage =PageFactory.initElements(driver, HomePage.class);
		signUpPage.getUrl(url);
		Assert.assertTrue(signUpPage.isInitialized(),"Sign in link is presented.");
		signUpPage.login(email, password);	
		Thread.sleep(10000);
		signUpPage.getSearchBox().sendKeys("2032637");
		signUpPage.getSearchBoxSubmit().click();
		Thread.sleep(10000);
		Assert.assertEquals("Buy WROGN Men Blue & Brown Slim Fit Checked Casual Shirt - Shirts for Men | Myntra", signUpPage.confirmationHeader());
		ProductPage productPage =PageFactory.initElements(driver, ProductPage.class);
		Assert.assertEquals(productPage.getProductTitle().getText(), "WROGN Men Blue & Brown Slim Fit Checked Casual Shirt");
		
		productPage.getSize().click();
		productPage.getAddToBag();
		productPage.getBag().click();
		productPage.getPlaceOrder();
		Thread.sleep(10000);
		
	}	
	
	
	
	@Test(priority =8, groups = { "Smoke","Sanity" }, dataProvider = "AddMultpleProductsToCart", dataProviderClass = AccountMgmtDP.class ,description="Add product to card and verifying items count.")
	public void myntra_AddMultpleProductsToCartTest(String url,String email, String password,String searchString) throws Exception{
	
		HomePage signUpPage =PageFactory.initElements(driver, HomePage.class);
		signUpPage.getUrl(url);
		Assert.assertTrue(signUpPage.isInitialized(),"Sign in link is presented.");
		signUpPage.login(email, password);
	
		Thread.sleep(10000);
		signUpPage.getSearchBox().sendKeys("2032637");
		signUpPage.getSearchBoxSubmit().click();
		Thread.sleep(10000);
		Assert.assertEquals("Buy WROGN Men Blue & Brown Slim Fit Checked Casual Shirt - Shirts for Men | Myntra", signUpPage.confirmationHeader());
		ProductPage productPage =PageFactory.initElements(driver, ProductPage.class);
		Assert.assertEquals(productPage.getProductTitle().getText(), "WROGN Men Blue & Brown Slim Fit Checked Casual Shirt");
		productPage.getSize().click();
		productPage.getAddToBag();
		productPage.getBag().click();
		
		Thread.sleep(10000);
		
		System.out.println("Bage Count : "+productPage.getBagCount().getText());
		HomePage signUpPage2 =PageFactory.initElements(driver, HomePage.class);
		signUpPage2.getMyntraLogo().click();
		signUpPage2.getSearchBox().sendKeys("2032637");
		signUpPage2.getSearchBoxSubmit().click();
		Thread.sleep(10000);
		Assert.assertEquals("Buy WROGN Men Blue & Brown Slim Fit Checked Casual Shirt - Shirts for Men | Myntra", signUpPage.confirmationHeader());
		ProductPage productPage2 =PageFactory.initElements(driver, ProductPage.class);
		Assert.assertEquals(productPage.getProductTitle().getText(), "WROGN Men Blue & Brown Slim Fit Checked Casual Shirt");
		
		productPage2.getSize().click();
		productPage2.getAddToBag();
		productPage2.getBag().click();
		
		Thread.sleep(10000);
		System.out.println("Bage Count : "+productPage.getBagCount().getText());
	}	
	
	
	
	
	@Test(priority =8, groups = { "Smoke","Sanity" }, dataProvider = "AddMultpleProductsToCart", dataProviderClass = AccountMgmtDP.class ,description="Add product to card and verifying items count.")
	public void myntra_serchForOrderStatusTest(String url,String email, String password,String searchString) throws Exception{
	
		HomePage signUpPage =PageFactory.initElements(driver, HomePage.class);
		signUpPage.getUrl(url);
		Assert.assertTrue(signUpPage.isInitialized(),"Sign in link is presented.");
		signUpPage.login(email, password);
	
		Thread.sleep(10000);
		signUpPage.getSearchBox().sendKeys("2032637");
		signUpPage.getSearchBoxSubmit().click();
		Thread.sleep(10000);
		Assert.assertEquals("Buy WROGN Men Blue & Brown Slim Fit Checked Casual Shirt - Shirts for Men | Myntra", signUpPage.confirmationHeader());
		ProductPage productPage =PageFactory.initElements(driver, ProductPage.class);
		Assert.assertEquals(productPage.getProductTitle().getText(), "WROGN Men Blue & Brown Slim Fit Checked Casual Shirt");
		productPage.getSize().click();
		productPage.getAddToBag();
		productPage.getBag().click();
		
		Thread.sleep(10000);
		
		System.out.println("Bage Count : "+productPage.getBagCount().getText());
		HomePage signUpPage2 =PageFactory.initElements(driver, HomePage.class);
		signUpPage2.getMyntraLogo().click();
		signUpPage2.getSearchBox().sendKeys("2032637");
		signUpPage2.getSearchBoxSubmit().click();
		Thread.sleep(10000);
		Assert.assertEquals("Buy WROGN Men Blue & Brown Slim Fit Checked Casual Shirt - Shirts for Men | Myntra", signUpPage.confirmationHeader());
		ProductPage productPage2 =PageFactory.initElements(driver, ProductPage.class);
		Assert.assertEquals(productPage.getProductTitle().getText(), "WROGN Men Blue & Brown Slim Fit Checked Casual Shirt");
		
		productPage2.getSize().click();
		productPage2.getAddToBag();
		productPage2.getBag().click();
		
		Thread.sleep(10000);
		System.out.println("Bage Count : "+productPage.getBagCount().getText());
	}
}
