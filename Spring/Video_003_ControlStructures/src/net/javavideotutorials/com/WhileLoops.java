package net.javavideotutorials.com;

import java.util.Calendar;
import java.util.Date;

public class WhileLoops {

	public static void main(String[] args) throws InterruptedException {

		// this will be the date/time right when it's executed
		Date today = new Date();
		System.out.println("Now : " + today);

		Calendar cal = Calendar.getInstance();
		cal.set(2014, 03, 18, 23, 8, 45);
	
		// while loop - same functionality gets accomplished
		// steps just moved into different places
		while ( today.before(cal.getTime()))
		{
			System.out.println("*** WAITING ***");
			Thread.sleep(1000);
			today = new Date();
			System.out.println(today);
		}
		System.out.println("\n\t*** DONE ***");
	}

}
