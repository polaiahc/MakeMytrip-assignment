package com.pramati.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Hello world!
 * 
 */
public class AddressPage extends PageObject {
	
	public AddressPage(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
	}
	
	public String confirmationHeader(){
		return driver.getTitle();
	}
	
	@FindBy(xpath="//div[text()='Add a New Address']")
	private WebElement addNewAddress;
	
	
	@FindBy(xpath="//input[@name='pincode']")
	private WebElement pincode;

	@FindBy(xpath="//input[@name='name']")
	private WebElement name;
	
	@FindBy(xpath="//textarea[@name='address']")
	private WebElement address;
	
	
	@FindBy(xpath="//input[@name='locality']")
	private WebElement locality;
	
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobile;
	
	@FindBy(xpath="//span[text()='Home ']")
	private WebElement home;
	
	public WebElement getHome() {
		return home;
	}

	@FindBy(xpath=".//*[@id='save']")
	private WebElement save;
	
	
	@FindBy(xpath="//a[@class='delete remove-address']")
	private WebElement removeAddress;

	public WebElement getRemoveAddress() {
		return removeAddress;
	}
	
	public WebElement getWebElement(String Name) {
		
		WebElement webElem=driver.findElement(By.xpath("//span[text()='"+Name+"']"));
		return webElem;
    }
	
	
	public WebElement getSave() {
		return save;
	}
	
	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getLocality() {
		return locality;
	}

	public WebElement getAddress() {
		return address;
	}

	public void setAddress(WebElement address) {
		this.address = address;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getAddNewAddress() {
		return addNewAddress;
	}
}
