package com.abi;

import org.junit.Before;
import org.junit.Test;

public class FSMBuilderTest {
	
	FSMBuilder instance;
	
	@Before
	public void setup(){
		this.instance = new FSMBuilder();
		this.instance.addState("state1")
		.addState("state2")
		.addState("state10")
		.addEvent("event1")
		.addEvent("event2")
		.addTerminalState("state10");
	}
	
	@Test(expected = FSMException.class)
	public void testInvalidAddState1(){
		this.instance.addState(null);
	}
	
	@Test(expected = FSMException.class)
	public void testInvalidAddState2(){
		this.instance.addState("");
	}
	
	@Test(expected = FSMException.class)
	public void testDuplicateAddState(){
		this.instance.addState("state1");
	}
	
	@Test
	public void testValidAddState(){
		this.instance.addState("stateX");
	}
	
	@Test(expected = FSMException.class)
	public void testEmptyAddIntialState1(){
		this.instance.addInitialState(null);
	}
	
	@Test(expected = FSMException.class)
	public void testEmptyAddIntialState2(){
		this.instance.addInitialState("");
	}
	
	@Test(expected = FSMException.class)
	public void testInvalidAddIntialState(){
		this.instance.addInitialState("stateX");
	}
	
	@Test
	public void testValidAddTerminallState(){
		this.instance.addInitialState("state1");
	}
	
	@Test(expected = FSMException.class)
	public void testEmptyAddTerminalState1(){
		this.instance.addInitialState(null);
	}
	
	@Test(expected = FSMException.class)
	public void testEmptyAddTerminalState2(){
		this.instance.addInitialState("");
	}
	
	@Test(expected = FSMException.class)
	public void testInvalidAddTerminalState(){
		this.instance.addTerminalState("stateX");
	}
	
	@Test
	public void testValidAddTerminalState(){
		this.instance.addTerminalState("state1");
	}
	
	@Test(expected = FSMException.class)
	public void testInvalidAddEvent1(){
		this.instance.addEvent(null);
	}
	
	@Test(expected = FSMException.class)
	public void testInvalidAddEvent2(){
		this.instance.addEvent("");
	}
	
	@Test(expected = FSMException.class)
	public void testDuplicateAddEvent(){
		this.instance.addEvent("event1");
	}
	
	@Test
	public void testValidAddEvent(){
		this.instance.addEvent("eventX");
	}
	
	@Test(expected = FSMException.class)
	public void testEmptyAddTransition1(){		
		this.instance.addTransition("", "event1", "state2");
	}
	
	@Test(expected = FSMException.class)
	public void testEmptyAddTransition2(){		
		this.instance.addTransition(null, "event1", "state2");
	}
	
	@Test(expected = FSMException.class)
	public void testEmptyAddTransition3(){		
		this.instance.addTransition("state1","", "state2");
	}
	
	@Test(expected = FSMException.class)
	public void testEmptyAddTransition4(){		
		this.instance.addTransition("state1",null, "state2");
	}
	
	@Test(expected = FSMException.class)
	public void testEmptyAddTransition5(){		
		this.instance.addTransition("state1","event1", null);
	}
	
	@Test(expected = FSMException.class)
	public void testEmptyAddTransition6(){		
		this.instance.addTransition("state1","event1", "");
	}
	
	@Test(expected = FSMException.class)
	public void testAddTransitionInvalidSourceState1(){		
		this.instance.addTransition("stateX","event1", "state2");
	}
	
	@Test(expected = FSMException.class)
	public void testAddTransitionInvalidSourceState2(){		
		this.instance.addTransition("state10","event1", "state2");
	}
	
	@Test
	public void testAddTransitionValidSourceState1(){		
		this.instance.addTransition("state1","event1", "state2");
	}
	
	@Test
	public void testAddTransitionValidSourceState2(){		
		this.instance.addTransition("*","event1", "state2");
	}

}
