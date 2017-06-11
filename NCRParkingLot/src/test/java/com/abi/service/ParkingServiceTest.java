package com.abi.service;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.abi.parking.exception.ParkingException;
import com.abi.parking.model.Car;
import com.abi.parking.model.ParkingLot;
import com.abi.parking.model.Slot;
import com.abi.parking.service.ParkingService;
import com.abi.parking.service.ParkingServiceImpl;

/**
 * @author Abdul
 *
 */
public class ParkingServiceTest {
	
	
	static final int SLOT_COUNT = 6;
	ParkingService instance;	
	ParkingLot parkingLot = null;
	@Before
	public void setup(){
		instance = new ParkingServiceImpl();
		
	}
	
	@Test
	public void testCreate(){
		parkingLot = instance.createParkingLot(SLOT_COUNT);
		assertNotNull(parkingLot);
		assertEquals(SLOT_COUNT, parkingLot.getSlots().size());
		assertEquals(new Integer(SLOT_COUNT), parkingLot.getSlots().get(5).getNumber());
		assertEquals(SLOT_COUNT,parkingLot.getAvailableSlots().size());
	}
	
	@Test(expected = ParkingException.class)  
	public void testParkNull(){
		instance.park(null, new Car("KA-01-HH-1234", "White"));
	}
	
	@Test
	public void testParkSuccess(){
		parkingLot = instance.createParkingLot(SLOT_COUNT);
		assertNotNull(parkingLot);
		Slot slot = instance.park(parkingLot, new Car("KA-01-HH-1234", "White"));
		assertNotNull(slot);
		assertEquals(new Integer(1), slot.getNumber());
		assertEquals(SLOT_COUNT - 1,parkingLot.getAvailableSlots().size());
	}
	
	@Test(expected = ParkingException.class)  
	public void testParkFull(){
		parkingLot = instance.createParkingLot(1);
		assertNotNull(parkingLot);
		instance.park(parkingLot, new Car("KA-01-HH-1234", "White"));
		instance.park(parkingLot, new Car("KA-01-HH-9999", "White"));
	}
	
	@Test(expected = ParkingException.class)  
	public void testLeaveNull(){
		instance.leave(null, 1);
	}
	
	@Test 
	public void testLeaveSuccess(){
		parkingLot = instance.createParkingLot(SLOT_COUNT);
		assertNotNull(parkingLot);
		Slot slot = instance.park(parkingLot, new Car("KA-01-HH-1234", "White"));
		assertNotNull(slot);
		Car car = instance.leave(parkingLot, slot.getNumber());
		assertEquals("KA-01-HH-1234", car.getRegistraionNumber());
		assertEquals(SLOT_COUNT,parkingLot.getAvailableSlots().size());
	}
	
	@Test(expected = ParkingException.class)  
	public void testLeaveInvalidSlot1(){
		parkingLot = instance.createParkingLot(SLOT_COUNT);
		assertNotNull(parkingLot);
		Slot slot = instance.park(parkingLot, new Car("KA-01-HH-1234", "White"));
		assertNotNull(slot);
		Car car = instance.leave(parkingLot, 2);
	}
	
	@Test(expected = ParkingException.class)  
	public void testLeaveInvalidSlot2(){
		parkingLot = instance.createParkingLot(SLOT_COUNT);
		assertNotNull(parkingLot);
		Slot slot = instance.park(parkingLot, new Car("KA-01-HH-1234", "White"));
		assertNotNull(slot);
		Car car = instance.leave(parkingLot, 7);
	}
	
	@Test(expected = ParkingException.class)  
	public void testStatusNull(){
		instance.status(null);
	}
	
	@Test 
	public void testStatusSuccess(){
		parkingLot = instance.createParkingLot(SLOT_COUNT);
		assertNotNull(parkingLot);
		Slot slot = instance.park(parkingLot, new Car("KA-01-HH-1234", "White"));
		List<Slot> slots = instance.status(parkingLot);
		assertNotNull(slots);
		assertEquals(slot, slots.get(0));
	}
	
	@Test(expected = ParkingException.class)  
	public void testFindCarsNull1(){
		instance.findCar(null, "KA-01-HH-1234");
	}
	
	@Test(expected = ParkingException.class)  
	public void testFindCarsNull2(){
		parkingLot = instance.createParkingLot(SLOT_COUNT);
		Slot slot = instance.park(parkingLot, new Car("KA-01-HH-1234", "White"));
		Car car = instance.findCar(parkingLot, "KA-01-HH-9999");
	}
	
	@Test  
	public void testFindCarsSuccess(){
		parkingLot = instance.createParkingLot(SLOT_COUNT);
		Slot slot = instance.park(parkingLot, new Car("KA-01-HH-1234", "White"));
		Car car = instance.findCar(parkingLot, "KA-01-HH-1234");
		assertEquals("KA-01-HH-1234", car.getRegistraionNumber());
	}
	
	@Test(expected = ParkingException.class)  
	public void testFindCarOfColourNull1(){
		instance.findCarOfColour(null, "White");
	}
	
	@Test
	public void testFindCarOfColourNull2(){
		parkingLot = instance.createParkingLot(SLOT_COUNT);
		Slot slot = instance.park(parkingLot, new Car("KA-01-HH-1234", "White"));
		List<Car> cars = instance.findCarOfColour(parkingLot, "Black");
		assertEquals(0, cars.size());
	}
	
	@Test
	public void testFindCarOfColour(){
		parkingLot = instance.createParkingLot(SLOT_COUNT);
		Slot slot = instance.park(parkingLot, new Car("KA-01-HH-1234", "White"));
		List<Car> cars = instance.findCarOfColour(parkingLot, "White");
		assertEquals(1, cars.size());
	}

}
