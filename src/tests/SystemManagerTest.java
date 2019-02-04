package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.flight_manager.Airline;
import com.flight_manager.Airport;
import com.flight_manager.Flight;
import com.flight_manager.SystemManager;

public class SystemManagerTest {
	
	String validName="Nm1";
	String invalidName="Name2Name";
	SystemManager sysmgr;
	Airline airline;
	Airport airport;
	Flight flight;
	
	@Before
	public void SetUp() {
		sysmgr=new SystemManager();
		airport=sysmgr.createAirport(validName);
		airline=sysmgr.createAirline(validName);
		flight=sysmgr.createFlight(airline, validName, invalidName, (int)(Math.random()*1000));
	}

	@Test
	public void createAirport_passValidName_returnAirport() {
		assertNotNull(airport);
	}
	
	@Test
	public void createAirport_passInvalidName_returnNull() {
		Airport airport=sysmgr.createAirport(invalidName);
		assertNull(airport);
	}
	
	@Test
	public void createAirport_passAlredyUsedName_returnNull() {
		Airport airport2=sysmgr.createAirport(validName);
		assertNull(airport2);
	}
	
	@Test
	public void createAirline_passValidName_returnAirline() {
		assertNotNull(airline);
	}
	
	@Test
	public void createAirline_passInvalidName_retrunNull() {
		Airline airline=sysmgr.createAirline(invalidName);
		assertNull(airline);
	}
	
	@Test
	public void createAirline_passAlredyUsedName_returnNull() {
		Airline airline2=sysmgr.createAirline(validName);
		assertNull(airline2);
	}
	
	@Test
	public void createFlight_passValidArguments_returnFlight() {
		assertNotNull(flight);
	}
	
	@Test
	public void createSeats_passValidArguments_setSeatsOnFlight() {
		boolean created=sysmgr.createSeats(flight.getId(), 30);
		assertTrue(created);
	}
	
	@Test
	public void createSeats_passInvalidFlightID_throwNullPointerException() {
		boolean created=sysmgr.createSeats(flight.getId()+1, 30);
		assertFalse(created);
	}
	
	@Test
	public void findAvailableFlights_passValidArguments_returnArrayList() {
		List<Flight> list=sysmgr.findAvailableFlights(validName, invalidName);
		assertTrue(list.size()>=1);
	}
	
	@Test
	public void bookSeat_passValidArguments_returnTrue() {
		sysmgr.createSeats(flight.getId(), 30);
		boolean booked=sysmgr.bookSeat(flight.getId(), flight.getSeats().get(0).getSeatNumber(), flight.getSeats().get(0).getRow());
		assertTrue(booked);
	}
	
	@Test
	public void bookSeat_passUnexistingSeat_returnFalse() {
		sysmgr.createSeats(flight.getId(), 30);
		boolean booked=sysmgr.bookSeat(flight.getId(), 40, "A");
		assertFalse(booked);
	}
	
	@Test
	public void bookSeat_searchForUnavailableSeat_returnFalse() {
		sysmgr.createSeats(flight.getId(), 30);
		flight.getSeats().get(19).setAvailable(false);
		boolean booked=sysmgr.bookSeat(flight.getId(), 20, "A");
		assertFalse(booked);
	}
	
	@Test
	public void bookSeat_passInvalidFlightID_assertFalse() {
		sysmgr.createSeats(flight.getId(), 30);
		boolean booked=sysmgr.bookSeat(flight.getId()+1, 20, "A");
		assertFalse(booked);
	}
	
	@Test
	public void findAirline_passValidName_returnAirline() {
		Airline findAirline=sysmgr.findAirline(validName);
		assertNotNull(findAirline);
	}
	
	@Test
	public void findAirline_passInvalidName_returnNull() {
		Airline findAirline=sysmgr.findAirline(invalidName);
		assertNull(findAirline);
	}

}
