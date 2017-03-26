package com.abi.parking.service;

import java.util.List;

import com.abi.parking.model.Car;
import com.abi.parking.model.ParkingLot;
import com.abi.parking.model.Slot;

/**
 * @author Abdul
 *
 */
public interface ParkingService {
	
	/**
	 * @param noOfSlots
	 * @return
	 */
	public ParkingLot createParkingLot(int noOfSlots);
	
	/**
	 * @param parkingLot
	 * @param car
	 * @return
	 */
	public Slot park(ParkingLot parkingLot, Car car);
	/**
	 * @param parkingLot
	 * @param slotNumber
	 * @return
	 */
	public Car leave(ParkingLot parkingLot, int slotNumber);
	/**
	 * @param parkingLot
	 * @return
	 */
	public List<Slot> status(ParkingLot parkingLot);
	
	/**
	 * @param parkingLot
	 * @param regNumber
	 * @return
	 */
	public Car findCar(ParkingLot parkingLot,String regNumber);
	/**
	 * @param parkingLot
	 * @param colour
	 * @return
	 */
	public List<Car> findCarOfColour(ParkingLot parkingLot,String colour);
	
	
	

}
