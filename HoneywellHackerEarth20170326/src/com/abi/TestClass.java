package com.abi;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Professor and his operations
Consider an array of integers 
A
A having 
N
N elements in which each element has a one- to-one relation with another array element.

For each 
i
i, where 
1
≤
i
≤
N
1≤i≤N, there exists a 
1
−
>
1
1−>1 relation between element 
i
i and element 
N
−
i
+
1
N−i+1

Professor A now asked one of his students to make some operations on this array which are as follows:

Given two integers 
(
L
,
R
)
(L,R) , he has to swap each element in that range with its related element.(See Sample explanation for clarity.)

Professor has asked him to perform Q operations and then finally tell the resultant array. Can you help him do it?

Input :

First line contains an integer N.
Next line contains N space separated integers describing the original array.
Next line contains single integer Q - the number of operations to be performed.
Next Q lines contains two integers L and R as explained in the question above.

Output
Output the resultant array required by the professor

Constraints 
1
≤
N
,
Q
≤
10
5
1≤N,Q≤105 
1
≤
A
[
i
]
≤
10
8
1≤A[i]≤108 
1
≤
L
≤
R
≤
N
 */

public class TestClass {

	public static void main(String args[] ) throws Exception {

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		int A[] = new int[N];
		boolean swapRequired[] = new boolean[N];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}

		int Q = s.nextInt();

		for (int i = 0; i < Q; i++) {
			int L = s.nextInt();
			int R = s.nextInt();
			setSwap(swapRequired,L,R);

		}
		rangeSwap(A,swapRequired);
		printArray(A);
	}

	private static void rangeSwap(int[] a, boolean[] swapRequired) {
		for(int i = 0; i < a.length; i++){
			if(swapRequired[i]){
				int temp = a[i];
				a[i] = a[a.length - i - 1] ;
				a[a.length - i - 1] = temp;
			}				
		}		
	}

	private static void setSwap(boolean[] swapRequired, int l, int r) {
		for(int i = l-1; i < r; i++){
			if(i < swapRequired.length){
				swapRequired[i] = !swapRequired[i];
			}	
		}
	}

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

}
