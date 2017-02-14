package com.abi;

public class Solution {

	public static void main(String[] args) {
		System.out.println(maxMoney(2,2));
		System.out.println(maxMoney(3,1));
		System.out.println(maxMoney(3,3));
		
		System.out.println(isTriangular(1631432881));

	}
	
	static final int MOD = 1000000007;
	
	static int maxMoney(int n, long k) {
		
		if(isTriangular(k))
			return sum(n) -1;
		else return sum(n);


    }
	
	final static boolean isTriangular(long n){
		return isPerfectSquare((8*(n%MOD))+1);
	}
	
	final static boolean isPerfectSquare(long n)
	{
	  if (n < 0)
	    return false;

	  long tst = (long)(Math.sqrt(n) + 0.5);
	  return tst*tst == n;
	}
	
	static int sum(int n){
		
		int x = (n+1)%MOD;
		
		return (((n%MOD) * x)/2)%MOD;
		
	}

}
