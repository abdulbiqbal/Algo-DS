/*
 * http://practice.geeksforgeeks.org/problems/chocolate-station/0
 */
package com.abi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0){
			int N = sc.nextInt();
			int stations[] = new int[N];			
			for (int i = 0; i <N; i++) {
				stations[i] = sc.nextInt();				
			}
			int P = sc.nextInt();
			
			System.out.println(totalCostOfTravel(stations,P));
		}

	}

	private static int totalCostOfTravel(int[] stations, int p) {
		int totalCost = 0;
		
		if(stations != null && stations.length > 0){
			totalCost = stations[0];
			int currentStock = 0;
			int chocolatesGot = 0;
			for (int i = 1; i < stations.length; i++) {
				chocolatesGot = stations[i-1] - stations[i];
				currentStock = currentStock + chocolatesGot;
				
				if(currentStock < 0){
					totalCost = totalCost - currentStock;
					currentStock = 0;
				}
			}
		}
		totalCost = totalCost * p;
		return totalCost;
	}

}
