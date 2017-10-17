/*
 * http://practice.geeksforgeeks.org/problems/start-elements/0
 */
package com.abi;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0){
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();				
			}
			
			printStars(arr);
			
		}

	}

	private static void printStars(int[] arr) {
		int superStar = -1;
		Stack<Integer> star = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if(star.isEmpty() || arr[i] > star.peek()){
				star.add(arr[i]);
				superStar = arr[i];
			}else if(superStar == arr[i]){
				superStar = -1;
			}
		}		
		while(!star.isEmpty()){
			System.out.print(star.pop() + " ");
		}
		System.out.println();
		System.out.println(superStar);		
	}

}
