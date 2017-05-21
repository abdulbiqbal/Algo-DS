package com.abi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TidyNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      String n = in.next();
	      getLastTidyNumber(i,n);
	    }

	}

	private static void getLastTidyNumber(int c, String n) {
		char[] str = n.toCharArray();
		int l = 9;
		for (int i = n.length() - 1; i >= 0; i--) {
			int d = Integer.parseInt(str[i] + "");
			if(d > l){
				str[i] = (char) (str[i] - 1);
				set9(str,i+1);
				i--;
			}else
				l = d;
		}
		
		printAsNumber(c,str);
	}

	private static void printAsNumber(int c, char[] str) {
		int i = 0;
		if(str[0] == '0'){
			for (; i < str.length; i++) {
				if(str[i] != '0')
					break;
			}
		}
		System.out.print("Case #" + c + ": ");
		for (int j = i; j < str.length; j++) {
			System.out.print(str[j]);
		}
		System.out.println();
		
	}

	private static void set9(char[] str, int s) {
		for (int i = s; i < str.length; i++) {
			str[i] = '9';
		}		
	}
	

}
