/*
 * http://practice.geeksforgeeks.org/problems/find-k-th-character-in-string/0
 */
package com.abi;

import java.util.Scanner;

public class Main {
	
	static String[] bins = new String[51];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		bins[0] = "0";
		
		int T = sc.nextInt();
		
		while(T-- > 0){
			int m = sc.nextInt();
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			String bin = Integer.toBinaryString(m);//getBinary(m);
			//System.out.println(Integer.toBinaryString(m));
			
			System.out.println(getKCharFromIteratedString(bin,n,k));
		}

	}

	private static char getKCharFromIteratedString(String bin, int n, int k) {
		StringBuilder sb = new StringBuilder();
		while(n-- > 0){
			for (char c : bin.toCharArray()) {
				if(c == '0'){
					sb.append("01");
				}else{
					sb.append("10");
				}
			}
			bin = sb.toString();
			sb.setLength(0);
		}
		return bin.charAt(k);
	}

	private static String getBinary(int m) {
		if(bins[m] == null){
			int c = 1;
			StringBuilder sb = new StringBuilder(6);
			while(m>=c){
				if((m&c) > 0)
					sb.append(1);
				else
					sb.append(0);
				c=c<<1;
			}
			bins[m] = sb.reverse().toString();
		}
		return bins[m];
	}

}
