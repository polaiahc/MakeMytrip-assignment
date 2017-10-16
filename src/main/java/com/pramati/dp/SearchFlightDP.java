package com.pramati.dp;

import org.testng.annotations.DataProvider;

public class SearchFlightDP {

	/**
	 * @author Polaiah
	 * 
	 */

	@DataProvider
	public static Object[][] searchFlight() {

		String[] arr = { "https://www.makemytrip.com/", "Hyderabad", "Bangalore", "9" };

		Object[][] dataSet = new Object[][] { arr };
		return dataSet;
	}
}
