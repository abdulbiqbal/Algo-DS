/*
 * http://practice.geeksforgeeks.org/problems/maximum-tip-calculator/0
 */
package com.abi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- >0){
			int N = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();
			Pair[] p = new Pair[N];
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				p[i] = new Pair();
				p[i].i = i;
				p[i].a = sc.nextInt();
			}
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				p[i].b = sc.nextInt();
			}
			
			Arrays.sort(p, new Comparator<Pair>(){

				@Override
				public int compare(Pair arg0, Pair arg1) {
					return -1 *Integer.compare(Math.abs(arg0.a - arg0.b), Math.abs(arg1.a - arg1.b));
				}
				
			});
			
			
			int maxTip = 0;
			
			for (int i = 0; i < p.length; i++) {
				if((X>0 && p[i].a > p[i].b) || Y==0){
					maxTip = maxTip + p[i].a;
					X--;
				}else{
					maxTip = maxTip + p[i].b;
					Y--;
				}
			}
			
			System.out.println(maxTip);
			if(sc.hasNextLine())
	            sc.nextLine();
		}
		sc.close();

	}
	
	static class Pair{
		int i;
		int a;
		int b;
	}

}
