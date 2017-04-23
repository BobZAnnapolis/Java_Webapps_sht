package net.javavideotutorials.com;

public class Motorcycle extends Vehicle {

	// the @Override annotation is a visual clue that this is an interface
	// change each method to pertain to the particular class

	@Override
	public Integer getNumSeats() {
		return 2;
	}

	@Override
	public Integer getNumWheels() {
		return 2;
	}

}
