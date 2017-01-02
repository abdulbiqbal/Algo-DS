package com.abi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in) ;
		
		int T = sc.nextInt();
		int arr[] = null;
		
		for (int i = 0; i < T; i++) {
			arr = new int[sc.nextInt()];
			
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			
			System.out.println(ArrayUtil.lis(arr,arr.length));
			
		}
		
		//System.out.println(Arrays.toString(arr));
		

	}

}
