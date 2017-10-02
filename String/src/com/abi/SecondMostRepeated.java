/*
 * http://practice.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence/0/?ref=self
 */
package com.abi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SecondMostRepeated {

	public static void main(String[] args) throws Exception {
		Reader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		String line = br.readLine();
		
		int T = Integer.parseInt(line);
		while(T-- > 0){
			br.readLine(); // skip no of words
			line = br.readLine();
			secondMostRepeated(line);
		}

	}

	private static void secondMostRepeated(String line) {
		String[] words = line.split(" ");
		Map<String,Integer> map = new HashMap<String,Integer>(){
			
			@Override
			public Integer get(Object key){
				return this.containsKey(key) ? super.get(key):0;				
			}
		};
		
		for (String word : words) {
			if(map.containsKey(word)){
				map.put(word, map.get(word)+1);
			}else{
				map.put(word, 1);
			}
		}
		
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		String firstMaxWord = null;
		String secondMaxWord = null;
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() > firstMax){
				secondMax = firstMax;
				secondMaxWord = firstMaxWord;
				firstMax = entry.getValue();
				firstMaxWord = entry.getKey();
			}else if(entry.getValue() > secondMax){
				secondMax = entry.getValue();
				secondMaxWord = entry.getKey();;
			}
		}
		
		if(secondMaxWord != null){
			System.out.println(secondMaxWord);
		}		
	}

}
