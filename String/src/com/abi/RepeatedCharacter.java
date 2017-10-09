/*
 * http://practice.geeksforgeeks.org/problems/repeated-character/0
 */
package com.abi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class RepeatedCharacter {

	public static void main(String[] args) throws Exception {
		Reader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		String line = br.readLine();
		
		int T = Integer.parseInt(line);
		while(T-- > 0){
			line = br.readLine();
			repeatedChar(line);
		}

	}

	private static void repeatedChar(String line) {
		Map<Character,Integer> repeated = new HashMap<>();
		Map<Character,Integer> firstAppearance = new HashMap<>();
		
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if(!firstAppearance.containsKey(c)){
				firstAppearance.put(c, i);
			}
			
			if(repeated.containsKey(c)){
				repeated.put(c, repeated.get(c)+1);
			}else{
				repeated.put(c, 1);
			}
		}
		
		int p = Integer.MAX_VALUE;
		
		for (Character cr : repeated.keySet()) {
			if(repeated.get(cr) > 1){
				if(p > firstAppearance.get(cr)){
					p = firstAppearance.get(cr);
				}
			}
		}
		
		if(p == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(line.charAt(p));
		
	}

}
