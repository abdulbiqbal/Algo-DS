package com.abi;

public interface FSMBuilder {

	
	/**
	 * Method build an FSM instance
	 * @return
	 */
	FSM build();

	/**
	 * Function add a new State to a FSM
	 * @param name
	 * @return
	 */
	FSMBuilder addState(String name);

	/**
	 * Function to add a state as a Initial State
	 * 
	 * @param name of an existing State
	 * @return
	 */
	FSMBuilder addInitialState(String name);

	/**
	 *  Function to add a state as a Terminal State
	 *  
	 * @param name
	 * @return
	 */
	FSMBuilder addTerminalState(String name);

	/**
	 * Adds an event to a FSM
	 * @param name
	 * @return
	 */
	FSMBuilder addEvent(String name);

	
	/**
	 * Adds a transition in a FSM
	 * 
	 * @param sourceStatename
	 * @param eventName
	 * @param destinationStatename
	 * @return
	 */
	FSMBuilder addTransition(String sourceStatename, String eventName, String destinationStatename);

}
