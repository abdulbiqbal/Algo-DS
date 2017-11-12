package com.abi;

public class Main {

	public static void main(String[] args) {
		int [][]mat = {
				{1,2,3,4,5,6},
				{7,8,9,10,11,12},
				{13,14,15,16,17,18}
		};
		
		//Matrix.spiralPrint(mat);
		System.out.println(Matrix.findK(mat, 3, 6, 7));

	}

}
