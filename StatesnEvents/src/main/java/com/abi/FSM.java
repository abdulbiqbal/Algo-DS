package com.abi;

import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Finite State Machine
 * @author abasit
 *
 */
public class FSM {
	
	private Set<State> initialStates;	
	private State currentState;
	private boolean initialized = false;
	
	
	public boolean isInitialized() {
		return initialized;
	}

	public Set<State> getInitialStates() {
		return initialStates;
	}

	public void setInitialStates(Set<State> initialStates) {
		this.initialStates = initialStates;
	}

	

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	
	/**
	 * Method to initialize the Finite State Machine
	 * @param stateName initial state name  of the FSM
	 */
	public void initialize(String stateName){
		if(StringUtils.isNotEmpty(stateName)){
			Optional<State> opState = this.initialStates.stream().filter(x->x.getName().equals(stateName)).findFirst();
			if(opState != null && opState.isPresent()){
				this.currentState = opState.get();
				this.initialized = true;
			}else{
				throw new FSMException("Invalid State: " + stateName);
			}
		}else{
			throw new FSMException("Invalid State");
		}
		
	}

	/**
	 * Method to process an Event
	 * @param input
	 */
	public void process(String input) {
		if(!this.initialized || this.currentState == null){
			throw new FSMException("FSM Not initialized");
		}
		
		if(StringUtils.isEmpty(input)){
			throw new FSMException("Invalid Event");
		}
		
		for (Entry<Event, State> entry : this.currentState.getTransitions().entrySet()) {
			if(entry.getKey().getName().equals(input)){
				this.currentState = entry.getValue();
				return;
			}
		}
		throw new FSMException("Invalid Event");
		
	}

	

}
