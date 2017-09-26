package com.pramati.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

	
	public HomePage(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
	}
	
	@FindBy(xpath = "//span[@class='myntra-logo']")
	private WebElement myntraLogo;

	@FindBy(xpath = "//html/head/title[1]")
	private WebElement header;
	
	@FindBy(xpath = "//a[text()='login']")
	private WebElement signinLink;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement eUserName;

	@FindBy(xpath = "//span[@class='myntraweb-sprite desktop-iconUser sprites-user']")
	private WebElement eLoginButton;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement ePassword;

	@FindBy(xpath = ".//*[@id='desktop-header-cnt']/div[2]/div[3]/input")
	private WebElement eSignIn;

	@FindBy(xpath = "//a[text()='Sign-out' and contains(@id,'logout')]")
	private WebElement logoutButton;
	
	@FindBy(xpath="//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]/span[1]")
	private WebElement signinHome;

	@FindBy(xpath=".//*[@id='mountRoot']/div/div/div/form/fieldset[2]/button")
	private WebElement signIN;
	
	@FindBy(xpath="//div[@class='desktop-userIconsContainer']")
	private WebElement signOut;
	
	@FindBy(xpath="//a[text()='Sign up']")
	private WebElement signUpLink;
	
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobile;
	
	@FindBy(xpath="//label[text()='Male']")
	private WebElement Male;
	

	@FindBy(xpath="//lable[text()='Female']")
	private WebElement Female;
	
	@FindBy(xpath="//button[text()='REGISTER']")
	private WebElement register;
	
	@FindBy(xpath="//div[text()=' Logout ']")
	private WebElement myntraLogut;

	@FindBy(xpath="//div[@class='desktop-userIconsContainer']")
	private WebElement homeLogutLink;
	
	@FindBy(xpath="//div[text()='Saved Addresses']")
	private WebElement savedAddresses;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//a[@class='desktop-submit']")
	private WebElement searchBoxSubmit;
	
	@FindBy(xpath="//span[@class='horizontal-filters-sub']")
	private WebElement totalProducts;
	
	// --------------------------------------------------------------

	public WebElement getTotalProducts() {
		return totalProducts;
	}

	public WebElement getSearchBoxSubmit() {
		return searchBoxSubmit;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSavedAddresses() {
		return savedAddresses;
	}

	public WebElement getHomeLogutLink() {
		return homeLogutLink;
	}
	
	public WebElement getMyntraLogut() {
		return myntraLogut;
	}

	public WebElement getRegister() {
		return register;
	}

	public WebElement getFemale() {
		return Female;
	}

	public WebElement getMobile() {
		return mobile;
	}
	
	public WebElement getMale() {
		return Male;
	}

	public WebElement getSigninHome() {
		return signinHome;
	}

	public WebElement getSignUpLink() {
		return signUpLink;
	}
	
	public WebElement geteLoginButton() {
		return eLoginButton;
	}

	public WebElement geteSignIn() {
		return eSignIn;
	}

	public WebElement getSigninLink() {
		return signinLink;
	}

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
	
	
	public WebElement getMyntraLogo() {
		return myntraLogo;
	}
	
	// ----------------  Methods of Page ----------------------------------------------	
	
	public boolean isInitialized() {
		return signinHome.isDisplayed();
	}
	
	public String confirmationHeader(){
		return driver.getTitle();
	}
	
	
	public boolean getUrl(String url){
		driver.get(url);
		return true;
	}
	public boolean login(String userName,String password) throws Exception {
		
		driver.manage().window().maximize();
		this.signinHome.click();
		this.signinLink.click();
		this.eUserName.sendKeys(userName);
		this.ePassword.sendKeys(password);
		this.signIN.click();
		return true;
		
	}
	
	public boolean signOut() throws Exception {
		
		driver.manage().window().maximize();
		Thread.sleep(10000);
		this.homeLogutLink.click();
		this.myntraLogut.click();
		return true;
	}
		
}
