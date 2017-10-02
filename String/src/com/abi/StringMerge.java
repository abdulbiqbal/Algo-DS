/*
 * http://practice.geeksforgeeks.org/problems/merge-two-strings/0
 */
package com.abi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class StringMerge {

	public static void main(String[] args) throws Exception {
		Reader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		String line = br.readLine();
		
		int T = Integer.parseInt(line);
		while(T-- > 0){
			line = br.readLine();
			String[] strs = line.split(" ");
			mergeString(strs[0],strs[1]);
		}

	}

	private static void mergeString(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		int i = 0,j=0;
		
		while(i < s1.length || j < s2.length){
			if(i < s1.length){
				System.out.print(s1[i]);
			}
			
			if(j<s2.length){
				System.out.print(s2[j]);
			}
			i++;
			j++;
		}
		System.out.println();
		
	}

}
