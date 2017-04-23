package net.javavideotutorials.com;

public class Car extends Vehicle {

	// the @Override annotation is a visual clue that this is an interface
	// change each method to pertain to the particular class

	@Override
	public Integer getNumSeats() {
		return 5;
	}

	@Override
	public Integer getNumWheels() {
		return 4;
	}

}
