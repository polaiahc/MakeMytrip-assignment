package com.pramati.dp;

import java.util.concurrent.ThreadLocalRandom;
import org.testng.annotations.DataProvider;
public class AccountMgmtDP {

	
	/**
	 * @author Maheswara Reddy
	 */  
	
	@DataProvider
	public static Object[][] appLogin() {
     
		String[] arr = {"https://www.myntra.com/","mahesh.rc25@gmail.com", "Siva@123","Login"};
		Object[][] dataSet = new Object[][] { arr };
		return dataSet;
	}

	@DataProvider
	public static Object[][] appLogout() { 
         
		String[] arr = {"https://www.myntra.com/","mahesh.rc25@gmail.com", "Siva@123","Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra"};
		Object[][] dataSet = new Object[][] { arr };
		return dataSet;
	}
	
	@DataProvider
	public static Object[][] appsignUp() {
         
		int randomNum = ThreadLocalRandom.current().nextInt(26, 10000 + 1);
		
		String[] arr = {"https://www.myntra.com/","mahesh.rc"+randomNum+"@gmail.com", "Siva@123","Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra","9922992299"};
		Object[][] dataSet = new Object[][] { arr };
		return dataSet;
	}
	@DataProvider
	public static Object[][] noOfProductsCount() {
         
		String[] arr = {"https://www.myntra.com/","mahesh.rc25@gmail.com", "Siva@123","Shirts"};
		Object[][] dataSet = new Object[][] { arr };
		return dataSet;
	}
}
