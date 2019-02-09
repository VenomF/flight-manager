package com.flight_manager;

import java.util.ArrayList;

/**
 * Class is used to instantiate objects of type Flight.
 * @author Faruk Becirovic (VenomF) 
 *
 */

public class Flight {
	//unique ID
	private Integer id;

	//which airline owns this flight
	@SuppressWarnings("unused")
	private Airline airline;

	//from which airport flight takes of
	@SuppressWarnings("unused")
	private Airport airport;

	//all seats in this flight
	private ArrayList<Seat> seats;

	//city where it takes off from
	private String origin;

	//city where the flight is going
	private String destination;
	
	/**
	 * 
	 * @param airline Airline that runs this Flight
	 * @param origin City in wich Flight starts
	 * @param destination City where Flight lands
	 * @param id Unique number assigned to every Flight
	 */

	Flight(Airline airline, String origin, String destination, Integer id) {
		this.airline=airline;
		this.id=id;
		this.origin=origin;
		this.destination=destination;
	}
	
	/**
	 * 
	 * @return Unique identification number of this Flight as object type Integer
	 */

	public Integer getId() {
		return id;
	}
	
	/**
	 * 
	 * @return ArrayList containing all Seats on this Flight
	 */

	public ArrayList<Seat> getSeats() {
		return seats;
	}
	
	/**
	 * 
	 * @param seats sets Seats ArrayList of this instance to ArrayList passed as argument to method.
	 */

	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	
	/**
	 * 
	 * @return City of origin for this instance.
	 */

	public String getOrigin() {
		return origin;
	}
	
	/**
	 * 
	 * @return City if destination for this instance.
	 */

	public String getDestination() {
		return destination;
	}

}
