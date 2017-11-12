package com.abi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		sc.nextLine();
		while(T-- > 0){
			
			String line = sc.nextLine();
			String[] strings = line.split(" ");
			System.out.println(hasSubsequence(strings[0],strings[1]));
		}

	}

	private static int hasSubsequence(String a, String b) {
		int result = 0;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {				
				if(a.charAt(i) == b.charAt(j)){
					return 1;
				}				
			}			
		}		
		return result;
	}

}
