/*
 * http://practice.geeksforgeeks.org/problems/pairs-with-positive-negative-values/0
 */
package com.abi;

import java.util.Scanner;

public class PostiveNegativePair {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T= sc.nextInt();

		while(T-- > 0){
			int N = sc.nextInt();
			boolean pos[] = new boolean[1001];
			boolean neg[] = new boolean[1001];
			for (int i = 0; i < N; i++) {
				int n = sc.nextInt();				
				if(n < 0){
					neg[n*-1] = true;
				}else{
					pos[n] = true;
				}
			}
			
			boolean isAnyResult  = false;
			for (int i = 0; i < 1001; i++) {
				if(pos[i] && neg[i]){
					isAnyResult = true;
					System.out.print("-" + i + " " + i + " ");
				}				
			}
			if(!isAnyResult)
				System.out.print(0);
			
			System.out.println();
		}

		sc.close();

	}

}
