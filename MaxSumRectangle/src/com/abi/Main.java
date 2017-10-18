/*
 * http://practice.geeksforgeeks.org/problems/maximum-sum-rectangle/0
 */
package com.abi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0){
			int R = sc.nextInt();
			int C = sc.nextInt();
			int[][] arr = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					arr[i][j] = sc.nextInt();
				}				
			}
			System.out.println(maxRectangle(arr));
			
		}

	}

	private static int maxRectangle(int[][] arr) {
		int maxSum = Integer.MIN_VALUE;
		
		int rows = arr.length;
		int cols = arr[0].length;
		
		for (int i = 0; i < rows; i++) {
			int[] rowSum = new int[cols];
			
			for (int j = i; j < rows; j++) {
				
				for (int k = 0; k < cols; k++) {
					rowSum[k] = rowSum[k] + arr[j][k];
				}
				maxSum = Math.max(maxSum,myKadane(rowSum));	
			}			
					
		}		
		return maxSum;
	}

	private static int myKadane(int[] arr) {
		int maxSum = arr[0];
		int currentMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			currentMax = Math.max(arr[i], currentMax + arr[i]);
			maxSum = Math.max(maxSum, currentMax);
		}
		
		return maxSum;
	}
	
	

}
