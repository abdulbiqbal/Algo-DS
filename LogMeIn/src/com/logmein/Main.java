package com.logmein;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String input = "A3B3C3D3";
		fun(input);
		//System.out.println(fun(input));
		

	}

	private static void fun(String input) {
		char[] str = input.toCharArray();
		
		int n = 1;
		char lastChar = 0;
		char printedChar = 0;
		char d = 0;
		for (char c : str) {
			d = c;
			if(c >= '0' && c <= '9'){
				n = Integer.parseInt(c + "");
			}else{
				if(lastChar != c){
					for (int i = 0; i < n; i++) {
						System.out.print(lastChar);
					}
					printedChar = lastChar;
					lastChar = c;
				}
				
				n = 1;
			}
		}
		if(lastChar != printedChar){
			for (int i = 0; i < n; i++) {
				System.out.print(lastChar);
			}
		}
	}

}
