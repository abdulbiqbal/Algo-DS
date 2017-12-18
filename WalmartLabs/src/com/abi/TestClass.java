package com.abi;

import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {
		/* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
        Scanner s = new Scanner(System.in);
        String num = s.nextLine();                 // Read
        int swaps = s.nextInt();
        
        System.out.println(swaps);
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < sb.length(); i++) {
        	if(swaps > 0){
        		int maxIndex = maxPossible(sb,i,swaps);
        		int x = Character.getNumericValue(sb.charAt(maxIndex));
        		int swap = maxIndex - i;
        		swaps = swaps - swap;
        		sb.deleteCharAt(maxIndex);
        		sb.insert(i, x);
        		
        	}else
        		break;
			
		}

        System.out.println(sb);

	}

	private static int maxPossible(StringBuilder sb,int from, int swaps) {
		int max = Character.getNumericValue(sb.charAt(from));
		int  maxIndex = from;
		for (int i = 1; i <= swaps; i++) {
			int x = Character.getNumericValue(sb.charAt(from+i));
			
			if(x > max){
				max = x;
				maxIndex = from+i;
			}
		}
		
		return maxIndex;
	}

}
