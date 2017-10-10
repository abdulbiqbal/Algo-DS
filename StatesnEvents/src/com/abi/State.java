package com.abi;

import java.util.HashMap;
import java.util.Map;

/**
 * State Model Class
 * 
 * @author abdulbiqbal
 *
 */
public class State {
	
	public State(String name){
		super();
		this.name = name;
		this.transitions = new HashMap<>();
	}
	
	String name;
	Map<Event,State> transitions;	
	

	public Map<Event, State> getTransitions() {
		return transitions;
	}

	public void setTransitions(Map<Event, State> transitions) {
		this.transitions = transitions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
