package com.abi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		boolean ismulti = false;
		
		while(line != null && !line.equals("")){
			printSingleLineComment(line);
			
			if(ismulti){
				ismulti = handleMultiEnd(line);
			}else			
				ismulti = handleMultiStart(line);
			
			line = br.readLine();
		}

	}

	private static boolean handleMultiEnd(String line) {
		if(line.contains("*/")){
			System.out.println(line.substring(0, line.lastIndexOf("*/")+2));
			return false;
		}else{
			System.out.println(line);
		}
		
		return true;
	}

	private static boolean handleMultiStart(String line) {
		
		if(line.contains("/*")){
			System.out.println(line.substring(line.indexOf("/*"), line.lastIndexOf("*/")+2));
			
		}
		
		return !line.contains("*/");
	}

	private static void printSingleLineComment(String line) {
		if(line.contains("//")){
			System.out.println(line.substring(line.indexOf("//")));
			
		}
		
	}

	

}
