package com.abi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main Class to demonstrate FSM
 * @author abasit
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		FSM fsm = buildFSM();
		interactWithFSM(fsm);
	}

	/**
	 * Method to interact with a FSM
	 * @param fsm
	 * @throws Exception
	 */
	private static void interactWithFSM(FSM fsm) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(fsm != null && (!fsm.isInitialized() || !fsm.getCurrentState().isTerminal())){
			System.out.print(">");
			String input = br.readLine();

			try{
				if(!fsm.isInitialized()){
					fsm.initialize(input);
				}else{
					fsm.process(input);					
				}
				System.out.println("<"+fsm.getCurrentState().getName());
			}catch(Exception e){
				System.err.println(e.getMessage());
			}
		}

	}

	/**
	 * Method to build a demo FSM
	 * @return
	 */
	private static FSM buildFSM(){
		FSMBuilder builder = new FSMBuilder();

		FSM fsm = builder.addState("0S")
				.addState("1S")
				.addState("2S")
				.addState("3S")
				.addState("4S")
				.addState("CANCELLED")
				.addState("COMPLETED")
				.addInitialState("0S")
				.addTerminalState("CANCELLED")
				.addTerminalState("COMPLETED")
				.addEvent("1R")
				.addEvent("2R")
				.addEvent("CANCEL")
				.addEvent("BUY")
				.addTransition("0S", "1R", "1S")
				.addTransition("0S", "2R", "2S")
				.addTransition("1S", "1R", "2S")
				.addTransition("1S", "2R", "3S")
				.addTransition("2S", "1R", "3S")
				.addTransition("2S", "2R", "4S")
				.addTransition("3S", "1R", "4S")
				.addTransition("*", "CANCEL", "CANCELLED")
				.addTransition("4S", "BUY", "COMPLETED")
				.build();

		return fsm;
	}

}
