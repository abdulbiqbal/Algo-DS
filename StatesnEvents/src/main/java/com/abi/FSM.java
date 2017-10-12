package com.abi;

public interface FSM {

	/**
	 * Method to initialize the Finite State Machine
	 * @param stateName initial state name  of the FSM
	 */
	void initialize(String stateName);

	/**
	 * Method to process an Event
	 * @param input
	 */
	void process(String input);

	boolean isInitialized();

	State getCurrentState();

}
