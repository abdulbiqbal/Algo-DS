/*
 * http://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x/0
 */
package com.abi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		while(T-- > 0){
			int arr[] = new int[sc.nextInt()];
			int x = sc.nextInt();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.println(countTriplets(arr,x));
		}

	}

	private static int countTriplets(int[] arr, int x) {
		int result = 0;
		Arrays.sort(arr);
		int sum;
		if(arr.length > 2){
			for (int i = 0; i < arr.length - 2; i++) {
				int s = i + 1;
				int e = arr.length - 1;

				while(s < e){
					sum = arr[i] + arr[s] + arr[e];
					if(sum < x){
						result = result + (e - s);
						s++;
					}
					else					
						e--;
				}
				

			}
		}
		return result;
	}

}
