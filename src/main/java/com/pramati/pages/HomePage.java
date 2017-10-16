package com.pramati.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver) {
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


	public WebElement getxflightDetails() {
		return xFlightDetails;
	}

	@FindBy(xpath="//div/p/a[contains(text(), 'Book')]/../../../div[3]/span[1]")
	private WebElement xFlightDepTime;

	public WebElement getxFlightDepTime() {
		return xFlightDepTime;
	}

	public boolean serchFlight(String FromLocation, String toLocation) throws Exception {
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

		//	List<WebElement> flightDetialsList=driver.findElements(By.xpath(xFlightDetails);

		
		String[] depTime=this.xFlightDepTime.getText().split(":");
		System.out.println(depTime[0]);
		
		int startTime=Integer.parseInt(depTime[0]);
		System.out.println(startTime);
		if(startTime>=9 || startTime<=10) {

			String flghtinfo = this.xFlightDetails.getText();
			System.out.println(flghtinfo);

			String[] flightDetails = flghtinfo.split("\n");
			System.out.println("Flight Name: "+flightDetails[0]);
			System.out.println("Flight Number: "+flightDetails[1]);
			System.out.println("Departure Time: "+flightDetails[2]);
			System.out.println("From: "+flightDetails[3]);
			System.out.println("Arrival Time: "+flightDetails[4]);
			System.out.println("To: "+flightDetails[5]);
			System.out.println("Duration: "+flightDetails[6]);
			System.out.println("Flight Type: "+flightDetails[7]);
			System.out.println("Amount: "+flightDetails[8]);
			System.out.println("---------------------------------------------------------------------------------------------------------");
		}


		/*else if(size>1) {

			for(int k=1; k<=size; k++) {


			String flghtinfo = this.xFlightDetails.getText();
			System.out.println(flghtinfo);

			String[] flightDetails = flghtinfo.split("\n");
			System.out.println("Flight Name: "+flightDetails[0]);
			System.out.println("Flight Number: "+flightDetails[1]);
			System.out.println("Departure Time: "+flightDetails[2]);
			System.out.println("From: "+flightDetails[3]);
			System.out.println("Arrival Time: "+flightDetails[4]);
			System.out.println("To: "+flightDetails[5]);
			System.out.println("Duration: "+flightDetails[6]);
			System.out.println("Flight Type: "+flightDetails[7]);
			System.out.println("Amount: "+flightDetails[8]);
			System.out.println("---------------------------------------------------------------------------------------------------------");
			}

		}else {
			System.out.println("no flights found");
		}




		/*
		 * String flightInfo=this.xFlightInfo.getText(); System.out.println(
		 * "---------------------------------------------------------------------------------------------------------"
		 * ); System.out.println("Flight info after search : "+flightInfo);
		 * 
		 * String flightAfterSeparator[]=flightInfo.split("Book"); System.out.println(
		 * "---------------------------------------------------------------------------------------------------------"
		 * ); System.out.println("Size of Array :"+ flightAfterSeparator.length);
		 * 
		 * for (int i=5;i<=flightAfterSeparator.length-2;i++) { System.out.println(
		 * "---------------------------------------------------------------------------------------------------------"
		 * ); System.out.println("areay_ "+i+"  ::"+flightAfterSeparator[i]); String[]
		 * flightInfoLine=flightAfterSeparator[i].split("\n");
		 * System.out.println("array :"+i+"----"+flightInfoLine[5]+"  --- "
		 * +flightInfoLine[6]+"  --- "+flightInfoLine[7]);
		 * 
		 * String [] startTime=flightInfoLine[5].split(":"); if(startTime.length==2) {
		 * int startHour=Integer.parseInt(startTime[0]);
		 * System.out.println("start hor: "+startHour); if(startHour==9 ) {
		 * System.out.println("Result:"+flightInfoLine[0]); } }
		 * 
		 * }
		 */
		return true;

	}

	private Object findElements(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getUrl(String url) {
		driver.get(url);
		return true;
	}

}
