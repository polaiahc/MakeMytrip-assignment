package com.pramati.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class ConfigEngine {
	private Properties props;

	/**
	 * Constructor method to initialize the Property object.
	 * 
	 */
	public ConfigEngine() {		
		props = new Properties(); 
	}

	/**
	 * Set configuration file to properties.
	 * 
	 * @param properties_File
	 * 			Name of the property that we expect the value.
	 * @return
	 * 			true if file set to properties. Otherwise false. 
	 */
	public boolean setConfigFileToProperties(String properties_File) {
		try{
			File file = new File(properties_File);
			InputStream input = new FileInputStream(file);
			props.load(input);
			return true;
		}catch(Exception exp){
			
			return false;
		}
	}

	/**
	 * Return the value of the property which name is passed as parameter
	 * @param propertyName
	 *            Name of the property that we expect the value
	 * @return Value of the property which name is passed as parameter.
	 *         <code>null</code> if the property doesn't exist.
	 */
	
	public String getValue(String propertyName) {
		try {
			//get the property value
			String property = props.getProperty(propertyName, null);
			if (property == null) {
			
				return null;
			}
			return property;
		} catch (Exception exp) {
		
			return null;
		}
	}
}