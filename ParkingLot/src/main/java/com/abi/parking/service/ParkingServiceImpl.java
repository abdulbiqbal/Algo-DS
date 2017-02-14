package com.abi.parking.service;

import java.util.List;
import java.util.stream.Collectors;

import com.abi.parking.exception.ParkingException;
import com.abi.parking.model.Car;
import com.abi.parking.model.ParkingLot;
import com.abi.parking.model.Slot;

/**
 * @author Abdul
 *
 */
public class ParkingServiceImpl implements ParkingService {
	
	@Override
	public ParkingLot createParkingLot(int noOfSlots) {
		return new ParkingLot(noOfSlots);
	}

	@Override
	public Slot park(ParkingLot parkingLot, Car car) {
		Slot slot = null;
		
		if(parkingLot == null)
			throw new ParkingException("Invalid Parking Lot");
		
		slot = parkingLot.getAvailableSlots().poll();
		if(slot == null)
			throw new ParkingException("Sorry, parking lot is full");
		else{
			car.setSlot(slot);
			slot.setCar(car);
			parkingLot.getParkedCars().add(car);
		}
		
		
		
		return slot;
	}

	@Override
	public Car leave(ParkingLot parkingLot, int slotNumber) {
		Slot slot = null;
		
		if(parkingLot == null)
			throw new ParkingException("Invalid Parking Lot");
		
		try{
			slot = parkingLot.getSlots().get(slotNumber-1);
		}catch(Exception e){
			throw new ParkingException("Invalid Slot Number");
			
		}
		if(slot.getCar() == null)
			throw new ParkingException("Slot already Empty");
		
		Car car = slot.getCar();
		slot.setCar(null);
		parkingLot.getAvailableSlots().add(slot);
		parkingLot.getParkedCars().remove(car);
		
		return car;
			
	}

	@Override
	public List<Slot> status(ParkingLot parkingLot) {
		if(parkingLot == null)
			throw new ParkingException("Invalid Parking Lot");
		
		return parkingLot.getSlots();
	}

	@Override
	public Car findCar(ParkingLot parkingLot, String regNumber) {
		if(parkingLot == null)
			throw new ParkingException("Invalid Parking Lot");
		for (Car  car : parkingLot.getParkedCars()) {
			if(car.getRegistraionNumber().equalsIgnoreCase(regNumber))
				return car;
		}
		
		throw new ParkingException("Not found");
	}

	@Override
	public List<Car> findCarOfColour(ParkingLot parkingLot, String colour) {
		if(parkingLot == null)
			throw new ParkingException("Invalid Parking Lot");
		
		return parkingLot.getParkedCars().stream()
			.filter(car -> colour. equalsIgnoreCase(car.getColour()))
			.collect(Collectors.toList());
		
	}

	

}
