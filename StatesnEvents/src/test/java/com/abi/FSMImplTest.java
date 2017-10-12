package com.abi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class FSMImplTest {
	
	FSMImpl instance;
	
	@Before
	public void setup(){
		this.instance = new FSMImpl();
		
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
	public void testEmptyState(){
		this.instance.initialize("");
	}
	
	@Test(expected=FSMException.class)
	public void testInvalidInitialState1(){
		this.instance.initialize("stateX");
	}
	
	@Test(expected=FSMException.class)
	public void testInvalidInitialState2(){
		this.instance.initialize("state3");
	}
	
	@Test()
	public void testValidInitialState(){
		this.instance.initialize("state1");
		assertNotNull((this.instance.getCurrentState()));
		assertTrue(this.instance.isInitialized());
	}
	
	@Test(expected=FSMException.class)
	public void testUninitializedFSMProcessing(){
		this.instance.process("event1");
	}
	
	@Test(expected=FSMException.class)
	public void testEmptyEventProcess1(){
		this.instance.initialize("state1");
		this.instance.process(null);
	}
	
	@Test(expected=FSMException.class)
	public void testEmptyEventProcess2(){
		this.instance.initialize("state1");
		this.instance.process("");
	}
	
	@Test(expected=FSMException.class)
	public void testInvalidEventProcess(){
		this.instance.initialize("state1");
		this.instance.process("event2");
	}
	
	@Test()
	public void testValidEventProcess(){
		State stateX = new State("stateX"); 
		State stateY = new State("stateY");
		Event eventA = new Event("eventA");
		this.instance.getInitialStates().add(stateX);
		stateX.getTransitions().put(eventA, stateY);
		
		this.instance.initialize("stateX");
		this.instance.process("eventA");
		assertEquals(stateY, this.instance.getCurrentState());
	}


}
