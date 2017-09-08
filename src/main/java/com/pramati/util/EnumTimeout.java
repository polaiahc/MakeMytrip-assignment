package com.pramati.util;

public class EnumTimeout {

	/**
	 * Thread wait Timeout
	 *
	 */
	public enum ThreadTimeOut {
		ONE_SECOND("One_second"), 
		TWO_SECOND("Two_second"), 
		FIVE_SECOND("Five_second");
		private final String sAbbreviation;
		private ThreadTimeOut(String abbreviation) {
			this.sAbbreviation = abbreviation;
		}

		/**
		 * This method returns the database type
		 * 
		 * @return DBType
		 */
		public String getDBType() {
			return sAbbreviation;
		}
	}

	/**
	 * WebElement wait Timeout
	 *
	 */
	public enum WebElementTimeOut {
		ELEMENT_PRESENT_WAIT("element_present_wait"), 
		ELEMENT_NOT_PRESENT_WAIT("element_not_present_wait");
		private final String sAbbreviation;
		private WebElementTimeOut(String abbreviation) {
			this.sAbbreviation = abbreviation;
		}

		/**
		 * This method returns the database type
		 * 
		 * @return DBType
		 */
		public String getDBType() {
			return sAbbreviation;
		}
	}
	
	/**
	 * Window wait Timeout
	 *
	 */
	public enum WindowTimeOut {
		WINDOW_PRESENT_WAIT("window_present_wait");
		private final String sAbbreviation;
		private WindowTimeOut(String abbreviation) {
			this.sAbbreviation = abbreviation;
		}

		/**
		 * This method returns the database type
		 * 
		 * @return DBType
		 */
		public String getDBType() {
			return sAbbreviation;
		}
	}
}