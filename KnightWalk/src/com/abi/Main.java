package com.abi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int s1 = sc.nextInt();
			int s2 = sc.nextInt();
			int d1 = sc.nextInt();
			int d2 = sc.nextInt();
			
			System.out.println(knightWalk(N,M,s1,s2,d1,d2));
			
			
		}

	}
	
	static int result = Integer.MAX_VALUE;
	static final int moveI[] = {-2,-2,-1,1,-1,1,2,2};
	static final int moveJ[] = {-1,1,-2,-2,2,2,-1,1};

	private static int knightWalk(int n, int m, int s1, int s2, int d1, int d2) {
		boolean[][] board = new boolean[n][m];		
		
		result = Integer.MAX_VALUE;
		
		knightWalk(board,s1,s2,d1,d2,0);
		return result;
	}

	private static void knightWalk(boolean[][] board, int s1, int s2, int d1, int d2,int moved) {
		
		if(moved >= result)
			return;
		
		if(s1 < 0 || s1 >= board.length || s2 < 0 || s2 >= board[0].length)
			return;
		
		if(board[s1][s2])
			return;
		
		board[s1][s2] = true;
		
		if(s1==d1 && s2==d2)
			result = Math.min(result, moved);
		else{
			for (int i = 0; i < moveI.length; i++) {
				knightWalk(board,s1+moveI[i],s2 + moveJ[i],d1,d2,moved+1);
			}
		}
		
		board[s1][s2] = false;
		
	}

}
