package com.abi;

public class Main {

	public static void main(String[] args) {
		CordinateUtils cu = new CordinateUtils();
		
		int x[] = {1,1};
		int y[] = {2,2};
		
		System.out.println(cu.noOfPoints(x, y, 2));
		
		int [] x1 = {36,27,15,43,35,36,42,49,21,12,27,40,9,13,26,40,26,22,36,11,18,17,29,32,30,12,23,17,35,29,2,22,8,19};
		int [] y1 = {17,43,6,11,42,29,23,21,19,34,37,48,24,15,20,13,26,41,30,6,23,12,20,46,31,5,25,34,27,36,5,46,29,13};
		
		//System.out.println(cu.noOfPoints(x1, y1, 34));
		
		//System.out.println(cu.gcd(25, 75));
		

	}

}
