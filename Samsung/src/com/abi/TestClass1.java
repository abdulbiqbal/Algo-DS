package com.abi;

import java.util.Scanner;

public class TestClass1 {

	static int MOD = 1000000007;
	static final int MAX_NUM = 100000;
	static int A[];
	static long FIB_CACHE[];

	public static void main(String args[] ) throws Exception {

		/*FIB_CACHE = new long[MAX_NUM];
		FIB_CACHE[0] = 0;
		FIB_CACHE[1] = 1;*/

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int Q = s.nextInt();
		A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}

		for (int i = 0; i < Q; i++) {
			int L = s.nextInt();
			int R = s.nextInt();			
			fun(L,R);			
		}
		
		
		
	}

	private static void fun(int l, int r) {
		long[] range = new long[r-l + 1];
		
		for (int i = 0; i < range.length; i++) {
			range[i] = fib(A[l+i -1]);			
		}
		
		System.out.println(gcd(range));
	}

	private static long fib(int x){
		long num0 = 0;
		long num1 = 1;
		long fib = 0;
		
		if(x < 2)
			return x;
		
		for (int i = 2; i <= x; i++) {
			fib = (num0 + num1)% MOD;			
			num0 = num1;
		    num1 = fib;			
		}		
		return fib;

	}

	private static void findFib(int x) {
		if(x==0 || x==1){
			return;
		}
		if(FIB_CACHE[x] == 0){
			findFib(x-1);
			findFib(x-2);
			FIB_CACHE[x] = FIB_CACHE[x-2] + FIB_CACHE[x+1];
		}
	}

	private static long gcd(long a, long b)	{
		while (b > 0)
		{
			long temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}

	private static long gcd(long... input){
		long result = input[0];
		for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
		return result;
	}

}
