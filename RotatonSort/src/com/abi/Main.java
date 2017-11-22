package com.abi;

import java.util.Scanner;

public class Main {
	
	static RotiSequencer rotiSequencer;

	public static void main(String[] args) {
		rotiSequencer = new RotiSequencerImpl();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] rotis = new int[n];
		for (int i = 0; i < n; i++) {
			rotis[i] = sc.nextInt();
		}
		
		rotiSequencer.sort(rotis);
		rotiSequencer.showRotis(rotis);
		sc.close();

	}

	

}
