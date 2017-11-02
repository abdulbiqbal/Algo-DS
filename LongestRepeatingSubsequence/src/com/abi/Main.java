/*
 * http://practice.geeksforgeeks.org/problems/longest-repeating-subsequence/0
 */
package com.abi;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		
		while(T-- > 0){
			int a = sc.nextInt();
			String str = null;
			
			do{
				str = sc.nextLine();
			}while(str == null || str.length() < a);
			
			System.out.println(lrs(str));
		}
	}

	private static int lrs(String str) {
		int l = str.length();
		int[][] L = new int[l+1][l+1];
		
		for (int i = 0; i <= l; i++) {
			for (int j = 0; j <= l; j++) {
				
				if(i == 0 || j == 0)
					L[i][j] = 0;
				else if(i != j && str.charAt(i-1) == str.charAt(j-1))
					L[i][j] = 1 + L[i-1][j-1];
				else
					L[i][j] = Integer.max(L[i-1][j], L[i][j-1]);				
			}			
		}		
		return L[l][l];
	}

}
