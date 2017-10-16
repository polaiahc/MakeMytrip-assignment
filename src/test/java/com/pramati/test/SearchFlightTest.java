package com.pramati.test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.pramati.base.BaseTest;
import com.pramati.dp.SearchFlightDP;
import com.pramati.pages.HomePage2;

public class SearchFlightTest extends BaseTest  {
	
	@Test(dataProvider = "searchFlight", dataProviderClass = SearchFlightDP.class)
	public void searchFlightTest(String url,String FromLocation, String toLocation, String startHour) throws Exception{
		HomePage2 makeMytripHomePage =PageFactory.initElements(driver, HomePage2.class);
		makeMytripHomePage.getUrl(url);
		Thread.sleep(2000);
		makeMytripHomePage.serchFlight(FromLocation, toLocation,Integer.parseInt(startHour));
	
	}	
	
	
}
