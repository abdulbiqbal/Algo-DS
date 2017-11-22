/*
 * http://practice.geeksforgeeks.org/problems/total-number-of-strings/0
 */
package com.abi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- > 0){
			System.out.println(noOfStrings(sc.nextInt()));
		}

	}

	private static int noOfStrings(int n) {
		return fun(n,1,2);
	}

	private static int fun(int n, int bCount, int cCount) {
		
		if(bCount < 0 || cCount < 0)
			return 0;
		if(n == 0)
			return 1;
		
		if(bCount == 0 && cCount == 0)
			return 1;
		
		
		return fun(n-1,bCount,cCount) + fun(n-1,bCount-1,cCount) + fun(n-1,bCount,cCount-1);
	}

}
