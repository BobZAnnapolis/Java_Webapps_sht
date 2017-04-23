package net.javavideotutorials.com;

public class Runnable {
	
	public static void main(String[] args)
	{
		// you CANNOT instantiate an interface
		// could say Car c = new Car(); but "better" to do it this way, displays Inheritance concept
		//
		// polymorphism - the behavior of the generic "aVehicle" var changes based upon the Class() on right side
		//
		Vehicle aVehicleC = new Car();
		Vehicle aVehicleB = new Bus();
		Vehicle aVehicleM = new Motorcycle();
		System.out.println("aVehicleC.toString() " + aVehicleC.toString());
		System.out.println("aVehicleB.toString() " + aVehicleB.toString());
		System.out.println("aVehicleM.toString() " + aVehicleM.toString());
	}
}
