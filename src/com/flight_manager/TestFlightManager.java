package com.flight_manager;

import java.util.Scanner;

/**
 * Class holds UI for Flight-Manager application.
 * This class has no data fields, cannot be instantiated
 * @author Faruk Becirovic (VenomF)
 *
 */

public class TestFlightManager {
	
	/**
	 * Main clas for Flight-Manager application.
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int ctrl=0;

		while(ctrl!=5) {
			System.out.println("1.) Create airport \n2.) Create airline \n3.) Create flight \n4.) Book a seat on a flight \n5.) Exit");
			ctrl=input.nextInt();
			SystemManager sysMgr=new SystemManager();

			switch (ctrl) {
			case 1 : 
				System.out.println("Input new airport's name.");
				String name=input.next();
				sysMgr.createAirport(name);
				break;

			case 2 :
				System.out.println("Input new airline's name.");
				name=input.next();
				sysMgr.createAirline(name);
				break;

			case 3 :
				System.out.println();
				System.out.println("Input airline.");
				name=input.next();
				Airline airline=sysMgr.findAirline(name);
				System.out.println("Input place of origin.");
				String origin=input.next();
				System.out.println("Input destination.");
				String destination=input.next();
				int id=(int)(Math.random()*1000);
				sysMgr.createFlight(airline, origin, destination, id);
				break;

			case 4 :
				System.out.println("Input flight id.");
				id=input.nextInt();
				System.out.println("Input desired row and seat number.");
				String row="" + input.next().charAt(0);
				int seatNum=input.nextInt();
				sysMgr.bookSeat(id, seatNum, row);
				break;

			case 5 :
				break;
			}

			input.close();
		}

	}

}
