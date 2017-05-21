package com.abi;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> input = new Stack<>();
		//11 2 32 3 41
		input.push(11);
		input.push(2);
		input.push(32);
		input.push(3);
		input.push(41);
		
		System.out.println(input);
		System.out.println(sort(input));


	}
	
	public static Stack<Integer> sort(Stack<Integer> input){
		Stack<Integer> result = new Stack<>();
		
		while(!input.isEmpty()){
			Integer e = input.pop();
			
			while(!result.isEmpty() && result.peek() < e){
				Integer t = result.pop();
				if(t < e){
					input.push(t);
				}
			}
			result.push(e);
			
		}
		return result;
	}

}
