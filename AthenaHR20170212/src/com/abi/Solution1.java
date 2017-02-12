package com.abi;

import java.util.HashSet;

public class Solution1 {

	public static void main(String[] args) {
		System.out.println(firstRepeatedWord("He quite test abc-;. test enough of this nonsense."));

	}
	
	static String firstRepeatedWord(String s) {
		char[] inputStr = s.toCharArray();
		HashSet<String> set = new HashSet<>();
		int wordStart = 0;
		int wordEnd = -1;
		String word = null;
		for (int i = 0; i < inputStr.length; i++) {			
			if(inputStr[i] == ' ' || inputStr[i] == '\t' || inputStr[i] == ',' || inputStr[i] == ':'
					|| inputStr[i] == ';' || inputStr[i] == '-' || inputStr[i] == '.'){
				wordEnd = i;				
				word = s.substring(wordStart, wordEnd);
				if(set.contains(word))
					return word;
				else{
					if(word.length() >0)
					set.add(word);
				}
				wordStart = i+1;
			}			
		}
		word = s.substring(wordStart, s.length());
		if(set.contains(word))
			return word;
		else
			set.add(word);
		
		return null;

    }

}
