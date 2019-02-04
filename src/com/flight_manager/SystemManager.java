package com.flight_manager;

import java.util.ArrayList;
import java.util.List;

public class SystemManager {

	private List<Airport> listOfAirports;
	private List<Flight> listOfFlights;
	private List<Airline> listOfAirlines;
	
	public SystemManager() {
		this.listOfAirlines=new ArrayList<Airline>();
		this.listOfAirports=new ArrayList<Airport>();
		this.listOfFlights=new ArrayList<Flight>();
	}

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

	public Flight createFlight(Airline airline, String origin, String destination, Integer id) {
		Flight newFlight=new Flight(airline, origin, destination, id);
		listOfFlights.add(newFlight);
		return newFlight;
	}

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

	public List<Flight> findAvailableFlights(String origin, String destination){
		List<Flight> availableFlights=new ArrayList<Flight>();

		for(int i=0; i<listOfFlights.size(); i++) {
			if(listOfFlights.get(i).getOrigin()==origin && listOfFlights.get(i).getDestination()==destination)
				availableFlights.add(listOfFlights.get(i));
		}

		return availableFlights;
	}

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

	public Airline findAirline(String name) {
		for(int i=0; i<listOfAirlines.size(); i++)
			if(listOfAirlines.get(i).getName()==name)
				return listOfAirlines.get(i);

		return null;
	}

}
