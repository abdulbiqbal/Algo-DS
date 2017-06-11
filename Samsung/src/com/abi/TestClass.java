package com.abi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestClass {

	static int px[] = {1,1,0};
	static int py[] = {1,0,1};
	static boolean[] primes=new boolean[100001];

	static int A[][] = null;
	static List<Pair> bestPath = null;
	static int solutionCount = 0;


	public static void main(String args[] ) throws Exception {
		
		fillSieve();

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		A = new int[N][M];

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				A[x][y] = s.nextInt();
			}
		}

		traverse(new Pair(0,0), new ArrayList<>());
		System.out.println(solutionCount);
		if(solutionCount>0)
			printPath(bestPath);
	}

	private static void printPath(List<Pair> bestPath2) {
		for (Pair pair : bestPath2) {
			System.out.println((pair.x + 1) + " " + (pair.y +1));
		}

	}

	private static void traverse(Pair p, List<Pair> path) {
		if(isPrime(A[p.x][p.y])){
			path.add(p);

			if(p.x == A.length-1 && p.y == A[0].length-1){
				if(bestPath == null){
					bestPath = new ArrayList<>(path);
				}
				solutionCount++;

			}else{
				for (int i = 0; i < px.length; i++) {	
					if(p.x + px[i] < A.length && p.y + py[i] < A[0].length)
						traverse(new Pair(p.x + px[i], p.y + py[i]),path);
				}			
			}
		}


	}
	
	static public void fillSieve() {
	    Arrays.fill(primes,true);        // assume all integers are prime.
	    primes[0]=primes[1]=primes[2]=true;       // we know 0 and 1 are not prime.
	    for (int i=2;i<primes.length;i++) {
	        //if the number is prime,
	        //then go through all its multiples and make their values false.
	        if(primes[i]) {
	            for (int j=2;i*j<primes.length;j++) {
	                primes[i*j]=false;
	            }
	        }
	    }
	}

	static boolean isPrime(int n) {
		return primes[n];
	}

	static class Pair{
		int x,y;

		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

}
