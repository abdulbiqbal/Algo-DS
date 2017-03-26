package com.abi.parking.model;

/**
 * @author Abdul
 *
 */
public class Car {
	
	String registraionNumber;
	String colour;	
	Slot slot;
	
	public Car(String registraionNumber, String colour) {
		this.registraionNumber = registraionNumber;
		this.colour = colour;
	}
	public String getRegistraionNumber() {
		return registraionNumber;
	}
	public void setRegistraionNumber(String registraionNumber) {
		this.registraionNumber = registraionNumber;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}

}
