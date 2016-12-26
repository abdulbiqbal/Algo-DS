package com.abi;

import java.io.*;
import java.util.*;
public class MaxSubArraySum {
	public static void main(String args[] ) throws Exception {

		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();

		int N = Integer.parseInt(line);

		int[] arr = new int[N];
		line = br.readLine();
		String[] token = line.split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(token[i]);
		}
		
		System.out.println(maxSubArraySum(arr));*/

		int arr[] = { 1, 8, -3, -7, 2, 7, -1, 9 };
		System.out.println(kadaneAlgo(arr));
		

	}

	public static int maxSubArraySum(int[] arr) {  
		int maxEnd = arr[0];  
		int maxSum = arr[0];  
		for(int i=1;i<arr.length;i++){  
			maxEnd = Math.max(arr[i], maxEnd+arr[i]);  
			maxSum = Math.max(maxSum,maxEnd);  
		}  
		return maxSum;  
	}  
	
	public static int kadaneAlgo(int []arr){
		int maxEndHere = arr[0];
		int maxSoFar = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			maxEndHere = Math.max(arr[i], maxEndHere + arr[i]);
			maxSoFar = Math.max(maxEndHere, maxSoFar);			
		}
		
		return maxSoFar;
	}
}