package com.pramati.dp;

import org.testng.annotations.DataProvider;

public class LogInDP {

	
	/**
	 * @author Maheswara Reddy
	 */  
	
	@DataProvider
	public static Object[][] getSiteAccount() {
     
		String[] arr = { "200","00801MUNRUFHKPRB69wf","1036","1187010","naveen.rajendran@deem.com"};
		Object[][] dataSet = new Object[][] { arr };
		return dataSet;
	}

	@DataProvider
	public static Object[][] getBatchStatus() {
         
		String[] arr = { "200","1222","2016-03-14","COMPLETED"};
		Object[][] dataSet = new Object[][] { arr };
		return dataSet;
	}
	
	
	@DataProvider
	public static Object[][] getTransferStatus() {
         
		String[] arr = { "200","1237","1222","PAIDINFULL","3648841","2015-03-19","99910","2016-03-15","500.00"};
		Object[][] dataSet = new Object[][] { arr };
		return dataSet;
	}
}
