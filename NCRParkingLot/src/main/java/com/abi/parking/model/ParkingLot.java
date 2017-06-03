package com.abi.parking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Abdul
 *
 */
public class ParkingLot {
	
	PriorityQueue<Slot> availableSlots;	
	List<Slot> slots;	
	List<Car> parkedCars;	
	
	
	public ParkingLot(int noOfSlots){		
		slots = new ArrayList<>(noOfSlots);		
		for (int i = 0; i < noOfSlots; i++) {
			slots.add(new Slot(i+1));
		}
		parkedCars = new ArrayList<>();
		availableSlots = new PriorityQueue<>(noOfSlots);
		availableSlots.addAll(slots);
	}
	

	public PriorityQueue<Slot> getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(PriorityQueue<Slot> availableSlots) {
		this.availableSlots = availableSlots;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public List<Car> getParkedCars() {
		return parkedCars;
	}

	public void setParkedCars(List<Car> parkedCars) {
		this.parkedCars = parkedCars;
	}

}
