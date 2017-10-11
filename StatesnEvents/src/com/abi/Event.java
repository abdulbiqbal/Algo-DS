package com.abi;

/**
 * Event Model Class
 * 
 * @author abdulbiqbal
 *
 */
public class Event {
	
	public Event(String name) {
		super();
		this.name = name;
	}

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "Event: " + name;
	}
	
	@Override
	public boolean equals(Object event) {
	   return name.equals(((Event)event).name);
	}

}
