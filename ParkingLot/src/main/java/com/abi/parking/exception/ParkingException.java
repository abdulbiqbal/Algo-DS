package com.abi.parking.exception;

/**
 * @author Abdul
 *
 */
public class ParkingException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7115030203751314865L;
	
	
	/**
	 * @param message
	 */
	public ParkingException(String message){
		super(message);
	}
	

}
