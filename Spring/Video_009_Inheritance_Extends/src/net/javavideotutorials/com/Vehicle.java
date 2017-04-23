package net.javavideotutorials.com;


//	3 pillars of Object-oriented programming
//
//Inheritance
//Encapsulation
//Polymorphism
//
//Inheritance
//- allows you to define relationships between objects
//- example, hierarchies
//	top level : Vehicle
//	lower levels : Car, Bus, Motorcycle
//
//	- every Car "is a" Vehicle
//	- every Bus "is a" Vehicle
//	- every Motorcycle "is a" Vehicle
//	- but not every Vehicle "is a" Bus
//	- ergo, Vehicle can be a top level hierarchy member
//
//Inheritance can be defined in 2 ways
//- interface {contract}
//- abstract class {can define functionality, not mandatory that objects change or use}
//
//- interfaces define the methods to be implemented, no code
//	- classes that implement the interface will implement the code
//
//- interfaces are implemented by classes, can implement multiple interfaces
//- abstract classes are extended by classes
//


public abstract class Vehicle {

	public abstract Integer getNumSeats();
	public abstract Integer getNumWheels();
	
	public String getFuelType() {
		return "Gas";
	}

	@Override
	public String toString() {
		String toString = "\n\tNum Seats : " + getNumSeats() 
						+ "\n\tNumber of Wheels : " + getNumWheels()
						+ "\n\tFuel Type :" + getFuelType();
		return toString;
	}

}
