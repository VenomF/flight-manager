package com.flight_manager;

/**
 * This class is used to instantiate objects of type airline.
 * 
 * @version 1.0
 * @author Faruk Becirovic (VenomF)
 *
 */

public class Airline {

	private String name;
	
	/**
	 * @param name name of this instance Airline
	 */

	Airline(String name) {
		this.name=name;
	}
	
	/**
	 * @return name of this Airline as a String
	 */

	public String getName() {
		return name;
	}

}
