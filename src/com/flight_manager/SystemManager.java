package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used as master class for Fight-Manager application.
 * @author Faruk Becirovic (VenomF)
 * @version 1.0
 *
 */

public class SystemManager {

	private List<Airport> listOfAirports;
	private List<Flight> listOfFlights;
	private List<Airline> listOfAirlines;
	
	/**
	 * Default contstructor for this class, instantiates all fields of thi instance.
	 */
	
	public SystemManager() {
		this.listOfAirlines=new ArrayList<Airline>();
		this.listOfAirports=new ArrayList<Airport>();
		this.listOfFlights=new ArrayList<Flight>();
	}
	
	/**
	 * Method used for creating new Airport object.
	 * @param name Name of Airport to be created
	 * @return object of type Airport just instantiated.
	 */

	public Airport createAirport(String name) {
		boolean validName=true;
		Airport newAirport;

		if(name.length()==3) {
			for(int i=0; i<listOfAirports.size(); i++)
				if(listOfAirports.get(i).getName()==name)
					validName=false;
		}else
			validName=false;

		if(validName) {
			newAirport=new Airport(name);
			listOfAirports.add(newAirport);
			return newAirport;
		}else
			return null;
	}
	
	/**
	 * Method used for creating new Airline object.
	 * @param name Name of new Airline to be created
	 * @return Airline just created
	 */

	public Airline createAirline(String name) {
		boolean validName=true;
		Airline newAirline;

		if(name.length()<6) {
			for(int i=0; i<listOfAirlines.size(); i++)
				if(listOfAirlines.get(i).getName()==name)
					validName=false;
		}else
			return null;

		if(validName) {
			newAirline=new Airline(name);
			listOfAirlines.add(newAirline);
			return newAirline;
		}else
			return null;
	}
	
	/**
	 * Method used for creating new Flight object.
	 * @param airline
	 * @param origin
	 * @param destination
	 * @param id
	 * @return just created instance of Flight object
	 */

	public Flight createFlight(Airline airline, String origin, String destination, Integer id) {
		Flight newFlight=new Flight(airline, origin, destination, id);
		listOfFlights.add(newFlight);
		return newFlight;
	}
	
	/**
	 * Method used for creating new Seats objects for a Flight placed in ArrayList.
	 * @param flightID Unique number for every Flight
	 * @param numberOfSeatsPerRow Integer specifying number of seats in every row
	 * @return true if Seat objects creates, false otherwise
	 */

	public boolean createSeats(Integer flightID, Integer numberOfSeatsPerRow) {
		Flight flight = null;
		ArrayList<Seat> listOfSeats = new ArrayList<>();

		for(int i=0; i<listOfFlights.size(); i++)
			if(listOfFlights.get(i).getId()==flightID)
				flight=listOfFlights.get(i);

		char row=64;
		for(int i=0; i<6; i++) {
			row++;
			for(int j=1; j<=numberOfSeatsPerRow; j++)
				listOfSeats.add(new Seat("" + row, j));
		}

		try {
			flight.setSeats(listOfSeats);
			return true;
		}catch(NullPointerException e) {
			System.out.println("Navedeni let ne postoji.");
			return false;
		}
	}
	
	/**
	 * Finds all available flights between two cities.
	 * @param origin starting location
	 * @param destination finish location
	 * @return List of available Flight objects that have same origin and destination fields as method parameters
	 */

	public List<Flight> findAvailableFlights(String origin, String destination){
		List<Flight> availableFlights=new ArrayList<Flight>();

		for(int i=0; i<listOfFlights.size(); i++) {
			if(listOfFlights.get(i).getOrigin()==origin && listOfFlights.get(i).getDestination()==destination)
				availableFlights.add(listOfFlights.get(i));
		}

		return availableFlights;
	}
	
	/**
	 * Books seat on desired FLight
	 * @param FlightID unique number of Flight
	 * @param seatNumber number of desire seat in row
	 * @param row desired row for seating position
	 * @return true if Seat is booked, false otherwise
	 */

	public boolean bookSeat(Integer FlightID,int seatNumber,String row) {
		Flight desiredFlight=null;

		try {
			for(int i=0; i<listOfFlights.size(); i++)
				if(listOfFlights.get(i).getId().equals(FlightID))
					desiredFlight=listOfFlights.get(i);

			for(int i=0; i<desiredFlight.getSeats().size(); i++)
				if(desiredFlight.getSeats().get(i).getRow()==row && desiredFlight.getSeats().get(i).getSeatNumber()==seatNumber) {
					if(desiredFlight.getSeats().get(i).isAvailable()) {
						desiredFlight.getSeats().get(i).setAvailable(false);
						return true;
					}
				}
		}catch(NullPointerException e) {
			System.out.println("Desired flight does not exist.");
		}

		return false;
	}
	
	/**
	 * Used to find Airline
	 * @param name name of Airline that needs to be found
	 * @return desired Airline if it exists, null if there is no such object created
	 */

	public Airline findAirline(String name) {
		for(int i=0; i<listOfAirlines.size(); i++)
			if(listOfAirlines.get(i).getName()==name)
				return listOfAirlines.get(i);

		return null;
	}

}
