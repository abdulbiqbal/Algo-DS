/*
 * http://practice.geeksforgeeks.org/problems/smallest-distant-window/0
 */
package com.abi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		while(T-- > 0){
			System.out.println(minWindowSize(sc.nextLine()));
		}

	}

	private static int minWindowSize(String str) {
		int min = Integer.MAX_VALUE;
		int distinctCharCount = 0;
		int[] pattern = new int[256];
		
		for (int i = 0; i < str.length(); i++) {
			
			if(pattern[str.charAt(i)] == 0)
				distinctCharCount++;
			
			pattern[str.charAt(i)]++;
			
		}
		int charFounds = 0;
		int[] findings = new int[256];
		int start = 0;
		int startIndex = -1;
		
		for (int i = 0; i < str.length(); i++) {
			
			if(findings[str.charAt(i)] == 0)
				charFounds++;
			
			findings[str.charAt(i)]++;
			
			if(charFounds == distinctCharCount){
				while(findings[str.charAt(start)] > 1){
					findings[str.charAt(start)]--;
					start++;
				}
				
				int lenWindow = i - start + 1;
	            if (min > lenWindow)
	            {
	            	min = lenWindow;
	                startIndex = start;
	            }
			}
			
			
		}
		
		return min;
	}

}
