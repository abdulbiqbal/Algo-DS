/*
 * http://practice.geeksforgeeks.org/problems/find-the-highest-number/0
 */
package com.abi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- > 0){
			int n = sc.nextInt();
			int last =-1;
			int current;
			boolean found = false;
			for (int i = 0; i < n; i++) {
				current = sc.nextInt();
				if(last > current && !found){
					System.out.println(last);
					found = true;
				}
				
				last = current;
			}
		}

	}

}
