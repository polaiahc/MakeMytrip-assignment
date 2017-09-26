package com.pramati.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Hello world!
 * 
 */
public class ProductPage extends PageObject {
	
	public ProductPage(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
	}
	
	
	@FindBy(xpath=".//*[@id='save']")
	private WebElement save;
	
	
	@FindBy(xpath="//a[@class='delete remove-address']")
	private WebElement removeAddress;
	
	@FindBy(xpath="//h1[@class='pdp-title']")
	private WebElement productTitle;
	
	
	@FindBy(xpath="//textarea[@name='address']")
	private WebElement address;
	
	
	@FindBy(xpath="//input[@name='locality']")
	private WebElement locality;
	
	@FindBy(xpath="//button[text()='PLACE ORDER']")
	private WebElement placeOrder;


	@FindBy(xpath="//p[@class='size-buttons-unified-size' and text()='40']")
	private WebElement size;
	
	@FindBy(xpath="//span[@class='gray']")
	private WebElement bagCount;
	
	@FindBy(xpath="//span[text()='ADD TO BAG']")
	private WebElement addToBag;
	
	@FindBy(xpath="//span[@class='myntraweb-sprite desktop-iconBag sprites-bag']")
	private WebElement bag;
	

	public WebElement getSize() {
		return size;
	}

	public WebElement getBagCount() {
		return bagCount;
	}

	public void setBagCount(WebElement bagCount) {
		this.bagCount = bagCount;
	}

	public WebElement getAddToBag() {
		return addToBag;
	}

	public WebElement getPlaceOrder() {
		return placeOrder;
	}

	public WebElement getBag() {
		return bag;
	}

	public WebElement getProductTitle() {
		return productTitle;
	}

	public String confirmationHeader(){
		return driver.getTitle();
	}
	
}
