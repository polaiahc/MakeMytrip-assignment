package com.pramati.pages;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage2 extends PageObject {

	static Pattern TIME_PATTERN = Pattern.compile("^([0-9]+)\\:([0-9]+)$");

	public HomePage2(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
	}

	@FindBy(xpath = "//*[@id='hp-widget__sfrom']")
	private WebElement xFromLocation;

	public WebElement getxFromLocation() {
		return xFromLocation;
	}

	@FindBy(xpath = "//*[@id='hp-widget__sTo']")
	private WebElement xToLocation;

	public WebElement getxToLocation() {
		return xToLocation;
	}

	@FindBy(id = "hp-widget__depart")
	private WebElement iDepartDate;

	public WebElement getiDepartDate() {
		return iDepartDate;
	}

	@FindBy(xpath = ".//*[@id='js-child_counter']/li[1]")
	private WebElement xChildCount;

	public WebElement getxChildCount() {
		return xChildCount;
	}

	@FindBy(xpath = "//*[@class='close_pax pull-right']")
	private WebElement xPassengerSelection;

	public WebElement getxPassengerSelection() {
		return xPassengerSelection;
	}

	@FindBy(xpath = "//label[contains(text(), 'My dates are flexible')]/../../../div[1]//a[@title='Next']/following-sibling::div/span[1]")
	private WebElement xSelectDate;

	public WebElement getxSelectDate() {
		return xSelectDate;
	}

	@FindBy(xpath = "(//span[text()='Next'])[1]")
	private WebElement xNextArrow;

	public WebElement getxNextArrow() {
		return xNextArrow;
	}

	@FindBy(xpath = "//label[text()='one way']")
	private WebElement oneWayButton;

	public WebElement getOneWayButton() {
		return oneWayButton;
	}

	@FindBy(xpath = "//label[contains(text(), 'My dates are flexible')]/../../../div[1]//a[@title='Next']/following-sibling::div/span[1]")
	private WebElement xDatePicker;

	public WebElement getxDatePicker() {
		return xDatePicker;
	}

	@FindBy(xpath = "//table/..//div/span[contains(text(),'Decem')]/../../..//td/a[contains(text(), '25')]")
	private WebElement xSDate;

	@FindBy(xpath = "//*[@id='hp-widget__paxCounter']")
	private WebElement xPassenger;

	public WebElement getxPassenger() {
		return xPassenger;
	}

	public WebElement getxSDate() {
		return xSDate;
	}

	@FindBy(xpath = "//*[@id='js-adult_counter']/li[1]")
	private WebElement xAdultCount;

	public WebElement getxAdultCount() {
		return xAdultCount;
	}

	@FindBy(xpath = "//*[@class='close_pax pull-right']")
	private WebElement xPassengerSelectionButton;

	public WebElement getxPassengerSelectionButton() {
		return xPassengerSelectionButton;
	}

	@FindBy(xpath = "//*[@id='searchBtn']")
	private WebElement xSearchButton;

	public WebElement getxSearchButton() {
		return xSearchButton;
	}

	@FindBy(xpath = "//div[@class='main col-lg-9 col-md-9 col-sm-12 col-xs-12']")
	private WebElement xFlightInfo;

	public WebElement getxFlightInfo() {
		return xFlightInfo;
	}

	@FindBy(xpath = "//div/span[contains(text(), 'Book')]/../..")
	private WebElement xFlightDetails;

	@FindBy(xpath = "//div/span[contains(text(), 'Book')]")
	private WebElement searchResultSize;

	public WebElement getsearchResultSize() {
		return searchResultSize;
	}

	public WebElement getxflightDetails() {
		return xFlightDetails;
	}

	@FindBy(xpath = "//div/p/a[contains(text(), 'Book')]/../../../div[3]/span[1]")
	private WebElement xFlightDepTime;

	public WebElement getxFlightDepTime() {
		return xFlightDepTime;
	}

	public boolean serchFlight(String FromLocation, String toLocation, int startHour) throws Exception {
		driver.manage().window().maximize();
		this.oneWayButton.click();
		this.xFromLocation.clear();
		this.xFromLocation.sendKeys(FromLocation);
		this.xToLocation.clear();
		this.xToLocation.sendKeys(toLocation);
		this.iDepartDate.click();
		Thread.sleep(2000);
		String textMonth = this.xDatePicker.getText();
		if (textMonth != "December") {
			this.xNextArrow.click();
			String textMonth2 = this.xDatePicker.getText();
			// if(textMonth2=="December") {
			// this.xSDate.click();
			// System.out.println("ddfgjhgchdh");
			// }
		}
		this.xSDate.click();

		this.xPassenger.click();
		this.xAdultCount.click();
		this.xChildCount.click();
		this.xPassengerSelectionButton.click();
		this.xSearchButton.click();
		Thread.sleep(2000);

		List<WebElement> flights_Size=driver.findElements(By.xpath("//div/p/a[contains(text(),'Book')]"));

		int num_of_flights = flights_Size.size();

		System.out.println("Number of flights display : " + num_of_flights);

		for (int j = 1; j <= num_of_flights; j++) {

			String data = driver.findElement(By.xpath("//div[contains(@class, 'sponsored_list_wrapper')][" + j + "]"))
					.getText();

			String[] flightDetails = data.split("\n");

			for (int i = 0; i < flightDetails.length; i++) {

				Matcher matcher = TIME_PATTERN.matcher(flightDetails[i]);
				if (matcher.matches()) {
					int hour = Integer.parseInt(matcher.group(1));
					if (hour == startHour) {
						System.out.println(Arrays.asList(flightDetails));
					}
					break;
				}
			}

		}
		return true;

	}


	public boolean getUrl(String url) {
		driver.get(url);
		return true;
	}

}
