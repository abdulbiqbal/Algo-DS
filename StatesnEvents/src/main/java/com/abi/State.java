package com.abi;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

/**
 * State Model Class
 * 
 * @author abdulbiqbal
 *
 */
public class State{
	
	public State(String name){
		super();
		this.name = name;
		this.transitions = new HashMap<>();
	}
	
	private String name;
	private Map<Event,State> transitions;	
	

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
	
	public boolean isTerminal(){
		if(MapUtils.isEmpty(transitions))
			return true;
		return false;
	}
	
	@Override
	public String toString(){
		return "State: " + name;
	}
	
	@Override
	public boolean equals(Object state) {
	   return name.equals(((State)state).name);
	}

}
