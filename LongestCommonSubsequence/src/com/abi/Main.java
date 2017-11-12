/*
 * http://practice.geeksforgeeks.org/problems/longest-common-subsequence/0
 */
package com.abi;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			String str1 = null;
			do{
				str1 = sc.nextLine();
			}while(str1 == null || str1.length() < a);
			
			String str2 = sc.nextLine();
			
			System.out.println(lcsMem(str1,str2));
			
		}
	}
	
	private static int lcsMem(String str1, String str2) {
		
		int L[][] = new int[str1.length()+1][str2.length()+1];
		
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				
				if(i == 0 || j== 0)
					L[i][j] = 0;
				else if(str1.charAt(i-1) == str2.charAt(j-1))
					L[i][j] = 1 + L[i-1][j-1];
				else
					L[i][j] = Integer.max(L[i-1][j], L[i][j-1]);
				
			}			
		}
		
		
		
		return L[str1.length()][str2.length()];
		
	}

	private static int lcs(String str1, String str2) {
		return lcs(str1,str1.length(),str2,str2.length());
	}

	//recursive
	private static int lcs(String str1, int m, String str2, int n) {
		if(m > 0 && n > 0){
			if(str1.charAt(m-1) == str2.charAt(n-1))
				return 1+lcs(str1,m-1,str2,n-1);
			else
				return Integer.max(lcs(str1,m-1,str2,n),lcs(str1,m,str2,n-1));
		}
		return 0;
	}

}
