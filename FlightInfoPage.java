package com.imaginea.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.imaginea.base.BaseClass;

public class FlightInfoPage extends BaseClass {
	
	//WebElements 
	public String xFromLocation="//*[@id='hp-widget__sfrom']"; 
	public String xToLocation="//*[@id='hp-widget__sTo']";
	
	public String oneWayButton="";
	
	public String iDepartDate="hp-widget__depart";
	
	
	public String xChildCount=".//*[@id='js-child_counter']/li[1]";
	
	public String xPassengerSelection="//*[@class='close_pax pull-right']";
	
	public String xSearchButton="//*[@id='searchBtn']";
	
	//month verification webelement
	public String xDatePicker="//label[contains(text(), 'My dates are flexible')]/../../../div[1]//a[@title='Next']/following-sibling::div/span[1]";
	
	//can pass the date and month as parameters
	public String xSelectDate="//table/..//div/span[contains(text(),'Decem')]/../../..//td/a[contains(text(), '25')]";
	
	//Next arrow
	public String xNextArrow="(//span[text()='Next'])[1]";
	
	//Methods
	
	
	
	public static void searchFlights(){
		
		driver.findElement(By.linkText("ON EWAY")).click();
		
		//ENTER FROM LOCATION
		driver.findElement(By.xpath(xFromLocation)).sendKeys("hyderabad");
		
		//provide to location
		driver.findElement(By.xpath(xToLocation)).sendKeys("Banglore");
		
		//clicking on depart date 
		driver.findElement(By.id(iDepartDate)).click();
		
		//Date picker - Month December verification
		if(driver.findElement(By.xpath(xDatePicker)).getText()!="December"){
			driver.findElement(By.xpath(xNextArrow)).click();
		}
		
		
		
	}
	

}
