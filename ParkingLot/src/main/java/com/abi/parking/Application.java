package com.abi.parking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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
public class Application {

	private static final String ARG_SEPARATOR = " ";
	private static final String TAB = "\t";
	File infile = null;
	ParkingLot parkingLot = null;
	boolean interactive = true;
	ParkingService parkingService = null;
	BufferedReader br;

	public static void main(String[] args) throws Exception {
		
		Application app = new Application();
		app.init(args);
		app.start();

	}

	void start() throws IOException {
		String command = null;

		do{
			try{
				command = readCommand();
				System.out.println(processCommand(command));
			}
			catch(ParkingException e){
				System.err.println(e.getMessage());
			}
		}while(command != null);
	}

	void init(String[] args) throws FileNotFoundException {
		if(args.length > 0){
			infile = getFile(args[0]);
		}		
		if(infile != null)
			interactive = false;		
		parkingService = new ParkingServiceImpl();

		if(interactive)
			br = new BufferedReader(new InputStreamReader(System.in));
		else
			br = new BufferedReader(new FileReader(infile));
	}

	private String processCommand(String command) {
		if(command == null || command.equals("") || command.equalsIgnoreCase("exit"))
			exit(0);
		String[] tokens = command.split(ARG_SEPARATOR);

		switch(tokens[0].toLowerCase()){

		case "create_parking_lot":	
			if(parkingLot == null){
				parkingLot = parkingService.createParkingLot(Integer.parseInt(tokens[1]));
				return "Created a parking lot with "+ parkingLot.getSlots().size() +" slots";
			}
			else
				throw new ParkingException("Parking Lot already created");
		case "park":
			Slot slot = parkingService.park(parkingLot, new Car(tokens[1],tokens[2]));
			return "Allocated slot number: " + slot.getNumber();
		case "leave":
			Car car = parkingService.leave(parkingLot,Integer.parseInt(tokens[1]));
			return "Slot number "+ car.getSlot().getNumber() +" is free";
		case "status":
			return buildStatus(parkingService.status(parkingLot));
		case "registration_numbers_for_cars_with_colour":
			return buildCarRegNumbers(parkingService.findCarOfColour(parkingLot, tokens[1]));
		case "slot_numbers_for_cars_with_colour":
			return builSlots(parkingService.findCarOfColour(parkingLot, tokens[1]));
		case "slot_number_for_registration_number":
			return parkingService.findCar(parkingLot, tokens[1]).getSlot().getNumber().toString();
		default:
			throw new ParkingException("Invalid Command: " + command);

		}

	}

	private String buildCarRegNumbers(List<Car> cars) {
		StringBuilder sb = new StringBuilder();
		for (Car car : cars) {
			sb.append(car.getRegistraionNumber()).append(", ");
		}
		
		if(sb.length() >0)
			sb.delete(sb.length()-2, sb.length()); // Remove last Comma
		return sb.toString();
	}
	
	private String builSlots(List<Car> cars) {
		StringBuilder sb = new StringBuilder();
		for (Car car : cars) {
			sb.append(car.getSlot().getNumber()).append(", ");
		}
		
		if(sb.length() >0)
			sb.delete(sb.length()-2, sb.length()); // Remove last Comma
		return sb.toString();
	}

	private String buildStatus(List<Slot> parkedCars) {
		StringBuilder sb = new StringBuilder("Slot No.\tRegistration No\tColour\r\n");
		
		for (Slot slot : parkedCars) {
			if(slot.getCar()!= null)
			sb.append(slot.getNumber() + TAB + slot.getCar().getRegistraionNumber() + TAB + 
					slot.getCar().getColour() + "\r\n");
		}
		sb.delete(sb.length()-2, sb.length()); // Remove last line delimiter
		return sb.toString();
	}

	private String readCommand() throws IOException {
		return br.readLine();
	}

	private File getFile(String fileName) {
		File file = new File(fileName);

		if(file.exists())
			return file;
		throw new ParkingException("File Not Found");
	}
	
	protected void exit(int status){
		System.exit(status);
	}

}
