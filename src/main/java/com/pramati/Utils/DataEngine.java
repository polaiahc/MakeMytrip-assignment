package com.pramati.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Maheswara Reddy
 */

public class DataEngine {
	private Connection connection = null;
	private Statement stmnt = null;

	/**
	 * Get data from excel file.
	 * 
	 * @param dataFileName
	 * @param columnname
	 * @param sheetname
	 * @param location
	 * @return
	 */
	public ResultSet getdata(String dataFileName, String columnname, String sheetname, String location) {
		ResultSet rs = null;
		String query = "";
		try {
			if (dataFileName.isEmpty()) {
				return null;
			}
			connection = connect(dataFileName);
			if (connection == null) {
				return null;
			}
			stmnt = connection.createStatement();
			if (stmnt == null) {
				return null;
			}

			if (columnname.equalsIgnoreCase("ALL")) {
				if (location == null || location.equalsIgnoreCase("")) {
					query = "select * from [" + sheetname + "$];";
				} else {
					query = "select * from [" + sheetname + "$] where " + location + ";";
				}
			} else {
				if (location == null || location.equalsIgnoreCase("")) {
					query = "select " + columnname + " from [" + sheetname + "$];";
				} else {
					query = "select " + columnname + " from [" + sheetname + "$] where " + location + ";";
				}
			}
			rs = stmnt.executeQuery(query);
		} catch (Exception ex) {

			return rs;
		}

		return rs;
	}

	/**
	 * Connect to excel file using JDBC:OBDC driver manager.
	 * @param dataFileName
	 * @return
	 */
	private Connection connect(String dataFileName) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// using DSN-less connection
			connection = DriverManager
					.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + dataFileName);
		} catch (Exception exp) {
			return null;
		}
		return connection;
	}

	/**
	 * Close the connection.
	 */
	public void closeConnection() {
		try {
			stmnt.close();
			connection.close();
		} catch (Exception exp) {
		}
	}
}