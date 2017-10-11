package com.abi;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class FSMTest {
	
	FSM instance;
	
	@Before
	public void setup(){
		this.instance = new FSM();
		
		Set<State> initialStates = new HashSet<>();
		State state1 = new State("state1");
		State state2 = new State("state2");
		State state3 = new State("state3");
		Event event1 = new Event("event1");
		Event event2 = new Event("event2");
		
		state1.getTransitions().put(event1, state3);
		
		initialStates.add(state1);		
		initialStates.add(state2);
		
		this.instance.setInitialStates(initialStates);
		
	}
	
	@Test(expected=FSMException.class)
	public void test(){
		this.instance.initialize("state3");
	}

}
