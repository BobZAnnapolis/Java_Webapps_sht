package net.javavideotutorials.com;

public class Bus extends Vehicle {

	// the @Override annotation is a visual clue that this is an interface
	// change each method to pertain to the particular class

	@Override
	public Integer getNumSeats() {
		return 30;
	}

	@Override
	public Integer getNumWheels() {
		return 10;
	}

	@Override
	public String getFuelType() {
		return "Diesel";
	}

}
