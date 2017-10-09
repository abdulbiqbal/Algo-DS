package com.abi;

public class Util {
	
	static int MOD = 1000000007;

	public static void main(String[] args) {
		
		long num0 = 0;
		long num1 = 1;
		long fib;
		System.out.println(0 + "\t\t" + 0);
		System.out.println(1 + "\t\t" + 1);
		
		for (int i = 2; i < 100000; i++) {
			fib = (num0 + num1)% MOD;
			System.out.println(i + "\t\t" + fib);
			
			num0 = num1;
		    num1 = fib;			
		}



	}

}
