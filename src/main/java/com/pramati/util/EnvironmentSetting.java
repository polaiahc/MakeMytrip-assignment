package com.pramati.util;

	/**
	 * @author Maheswara Reddy
	 */

public class EnvironmentSetting {

	private String sAutomationConfigFileName = "testSettings.properties";
	private String sConfigFile;
	private ConfigEngine objConfigEngine;
	
	public EnvironmentSetting() {
		sConfigFile = System.getProperty("user.dir") + "\\resources\\" + sAutomationConfigFileName;
		objConfigEngine = new ConfigEngine();
		objConfigEngine.setConfigFileToProperties(sConfigFile);
	}

	
	/**
	 * Retrieve automation configuration information from automation configuration properties file
	 * @param sAutoConfigDataKey
	 * @return
	 */
	
	public String getConfigInfo(String sAutoConfigDataKey)  {
		return objConfigEngine.getValue(sAutoConfigDataKey);
	}
}