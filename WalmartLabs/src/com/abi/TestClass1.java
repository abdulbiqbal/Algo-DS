package com.abi;

import java.util.Scanner;

public class TestClass1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int K[] = new int[N];
		int D[] = new int[N];
		
		for (int i = 0; i < K.length; i++) {
			K[i] =  s.nextInt();
		}
		for (int i = 0; i < D.length; i++) {
			D[i] =  s.nextInt();
		}
		
		int mismatch = 0;
		
		for (int i = 0; i < N; i++) {
			if(K[i] != D[i]){
				mismatch = mismatch + readjust(K[i],i,D);
			}
			
		}
		
		System.out.println(mismatch);

	}

	private static int readjust(int num, int index, int[] d) {
		int result = 0;
		int ci = findNumIndex(d,num);
		
		while(ci != index){
			result++;
			swapWithAdjacent(d,ci);
			ci--;
			
		}
		return result;
	}

	private static void swapWithAdjacent(int[] d, int ci) {
		if(ci > 0){
			int t = d[ci];
			d[ci] = d[ci-1];
			d[ci-1] = t;
		}
		
	}

	private static int findNumIndex(int[] d, int num) {
		for (int i = 0; i < d.length; i++) {
			if(d[i] == num)
				return i;
		}
		return -1;
	}

}
