/*
 * http://practice.geeksforgeeks.org/problems/row-with-minimum-number-of-1s/0
 */
package com.abi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0){
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			int result = -1;
			int min = Integer.MAX_VALUE;
			int cc;
			for (int i = 0; i < r; i++) {
				cc = 0;
				for (int j = 0; j < c; j++) {
					if(sc.nextInt() == 1){
						cc++;
					}
				}
				if(cc > 0 && cc < min){
					min = cc;
					result = i;
				}
			}
			System.out.println(result);
		}

	}

}
