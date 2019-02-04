package com.flight_manager;

public class Seat {
	// row ("A", "B", "C", "D", "E", "F")
	private String row;

	// seat number ex. 1,5,16
	private Integer seatNumber;

	//is it booked, or it is available
	private boolean available;

	public Seat(String row, Integer seatNumber) {
		this.row=row;
		this.seatNumber=seatNumber;
		this.available=true;
	}

	public String getRow() {
		return row;
	}
	public Integer getSeatNumber() {
		return seatNumber;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}

}
