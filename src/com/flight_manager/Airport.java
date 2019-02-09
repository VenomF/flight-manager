package com.flight_manager;

/**
 * 
 * @author Faruk Becirovic (VenomF)
 * @version 1.0
 *
 */

public class Airport {

	private String name;
	
	/**
	 * 
	 * @param name Name of Object type Airport to be instantiated
	 */

	Airport(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return name og this instance of Airport as a String
	 */

	public String getName() {
		return name;
	}

}
