/*
 * Sorted Arrays
Alice has recently found an array 
a
a containing 
N
N integers. As we all know Alice loves sorted array so, he wants to sort the array. To sort an array Alice can add 1 to any integer in the array in 1 move.

Alice wants to find minimum number of moves needed to sort this array. Remember that after sorting the array, all elements in it should be distinct.

INPUT CONSTRAINTS

1

N
≤
10
5
1≤N≤105
1
≤
a
i
≤
10
6
1≤ai≤106
INPUT FORMAT
First line of input contains a single integer 
N
N.
Second line of input contains 
N
N space separated inegers, elements of array 
a
a.

OUTPUT FORMAT
Output a single integer, denoting number of moves needed to sort the given array.

Sample Input
3
1 6 5
Sample Output
2
Explanation
In first move Alice will add 1 to third integer then, in second move Alice will do the same he did in 1st move.
 */
package com.abi;

import java.util.*;

public class TestClass1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[sc.nextInt()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(moves(arr));

	}

	private static int moves(int[] arr) {
		int maxSoFar = 0;
		int moves = 0;
		int diff;
		
		if(arr != null && arr.length >1){
			maxSoFar = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if(arr[i] <= maxSoFar){
					diff =  (maxSoFar + 1) - arr[i];
					moves = moves + diff;
				}
				maxSoFar = Integer.max(maxSoFar+1, arr[i]);
			}
		}
		
		return moves;
	}

}
