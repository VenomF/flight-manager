package com.flight_manager;

/**
 * 
 * @author Faruk Becirovic (VemonF)
 * @version 1.0
 *
 */

public class Seat {
	// row ("A", "B", "C", "D", "E", "F")
	private String row;

	// seat number ex. 1,5,16
	private Integer seatNumber;

	//is it booked, or it is available
	private boolean available;
	
	/**
	 * 
	 * @param row Row in wich this Seat is located
	 * @param seatNumber number of this Seat in row
	 */

	public Seat(String row, Integer seatNumber) {
		this.row=row;
		this.seatNumber=seatNumber;
		this.available=true;
	}
	
	/**
	 * 
	 * @return row of this Seat
	 */
	public String getRow() {
		return row;
	}
	/**
	 * 
	 * @return seat number for this Seat
	 */
	public Integer getSeatNumber() {
		return seatNumber;
	}
	/**
	 * 
	 * @return true if Seat is available false otherwise.
	 */
	public boolean isAvailable() {
		return available;
	}
	/**
	 * @param available change availability of the seat
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

}
