package com.abi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

public class FSMBuilder {


	private static final String ALL_STATES = "*";

	public FSMBuilder() {
		super();
		this.states = new HashSet<>();
		this.initialStates = new HashSet<>();
		this.terminalStates = new HashSet<>();
		this.events = new HashSet<>();
		this.allStateTransitions = new HashMap<>();
	}

	private Set<State> states;
	private Set<State> initialStates;
	private Set<State> terminalStates;
	private Set<Event> events;
	private Map<Event,State> allStateTransitions;

	public FSM build(){
		this.addAllStatesTransitions();
		if(this.isFSMValid()){
			FSM fsm = new FSM();
			fsm.setInitialStates(initialStates);			
			return fsm;
		}
		throw new FSMException("Invalid FSM");
	}

	private boolean isFSMValid() {
		Set<State> stateReachable = new HashSet<>();
		Set<State> finalStates = new HashSet<>();

		for (State state : this.initialStates) {
			this.traverse(state,stateReachable,finalStates);
		}
		
		if(!finalStates.containsAll(this.terminalStates)){
			System.err.println("All terminal states are not reachable");
			return false;
		}
		
		for (State state : finalStates) {
			if(!this.terminalStates.contains(state)){
				System.err.println("Invalid Terminal " + state);
				return false;
			}
		}


		return true;
	}

	private void traverse(State currentState, Set<State> stateReachable, Set<State> finalStates) {
		Set<State> stateTraversed = new HashSet<>();
		traverse(currentState,stateReachable,finalStates,stateTraversed);
	}

	private void traverse(State currentState, Set<State> stateReachable, Set<State> finalStates,
			Set<State> stateTraversed) {
		if(currentState == null){
			return;
		}
			
		if(MapUtils.isEmpty(currentState.getTransitions())){
			finalStates.add(currentState);
			stateReachable.addAll(stateTraversed);
		}else{
			stateTraversed.add(currentState);
			for (Entry<Event, State> entry : currentState.getTransitions().entrySet()) {				
				if(!stateTraversed.contains(entry.getValue())){
					traverse(entry.getValue(),stateReachable,finalStates,stateTraversed);
				}				
			}
			stateTraversed.remove(currentState);
		}

	}

	private void addAllStatesTransitions() {		
		for (State state : this.states) {
			if(this.terminalStates.contains(state)){
				continue;
			}
			for (Entry<Event, State> entry : this.allStateTransitions.entrySet()) {
				state.getTransitions().put(entry.getKey(), entry.getValue());
			}
		}	

	}

	/**
	 * Function add a new State to a FSM
	 * @param name
	 * @return
	 */
	public FSMBuilder addState(String name){
		if(StringUtils.isNotEmpty(name)){
			Optional<State> opState = this.states.stream().filter(x->x.getName().equals(name)).findFirst();
			if(opState == null || !opState.isPresent()){
				this.states.add(new State(name));
			}else{
				throw new FSMException("State already exist with this name");
			}
		}else{
			throw new FSMException("Invalid State Name");
		}
		return this;
	}

	/**
	 * Function to add a state as a Initial State
	 * 
	 * @param name of an existing State
	 * @return
	 */
	public FSMBuilder addInitialState(String name){
		if(StringUtils.isNotEmpty(name)){
			Optional<State> optState = this.states.stream().filter(x->x.getName().equals(name)).findFirst();
			if(optState != null && optState.isPresent()){
				State state = optState.get();
				this.initialStates.add(state);
			}
			else{
				throw new FSMException("Invalid State");
			}
		}
		else{
			throw new FSMException("Invalid State");
		}
		return this;
	}

	/**
	 *  Function to add a state as a Terminal State
	 *  
	 * @param name
	 * @return
	 */
	public FSMBuilder addTerminalState(String name){
		if(StringUtils.isNotEmpty(name)){
			Optional<State> optState = this.states.stream().filter(x->x.getName().equals(name)).findFirst();

			if(optState != null && optState.isPresent()){
				State state = optState.get();
				if(MapUtils.isNotEmpty(state.getTransitions())){
					throw new FSMException("Invalid Terminal State");
				}
				this.terminalStates.add(state);
			}else{
				throw new FSMException("Invalid State");
			}
		}
		else{
			throw new FSMException("Invalid State");
		}
		return this;
	}

	public FSMBuilder addEvent(String name){
		if(StringUtils.isNotEmpty(name)){
			Optional<Event> opsEvent = this.events.stream().filter(x->x.getName().equals(name)).findFirst();
			if(opsEvent == null || !opsEvent.isPresent()){
				this.events.add(new Event(name));
			}else{
				throw new FSMException("Event already exist with this name");
			}
		}else{
			throw new FSMException("Invalid Event name");
		}
		return this;
	}

	public FSMBuilder addTransition(String sourceStatename,String eventName,String destinationStatename){
		if(StringUtils.isNotEmpty(sourceStatename) && StringUtils.isNotEmpty(eventName) && StringUtils.isNotEmpty(destinationStatename)){
			Event event = this.events.stream().filter(x->x.getName().equals(eventName)).findFirst().get();
			State destinationState = this.states.stream().filter(x->x.getName().equals(destinationStatename)).findFirst().get();

			if(event != null && destinationState != null){
				if(ALL_STATES.equals(sourceStatename)){
					this.allStateTransitions.put(event, destinationState);
				}else{
					Optional<State> optSourceState = this.states.stream().filter(x->x.getName().equals(sourceStatename)).findFirst();
					if(optSourceState!= null && optSourceState.isPresent()){
						State sourceState = optSourceState.get();
						if(this.terminalStates.contains(sourceState)){
							throw new FSMException("Terminal states cannot have any event transitions.");
						}
						sourceState.getTransitions().put(event, destinationState);
					}else{
						throw new FSMException("Invalid Source State");
					}
				}
			}
		}else{
			throw new FSMException("Invalid State or Event names");
		}
		return this;
	}

}
