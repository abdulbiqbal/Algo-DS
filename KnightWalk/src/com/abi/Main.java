package com.abi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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

			System.out.println(knightWalkBfs(N,M,s1,s2,d1,d2));


		}

	}

	static int result = Integer.MAX_VALUE;
	static final int movesI[] = {-2,-2,-1,1,-1,1,2,2};
	static final int movesJ[] = {-1,1,-2,-2,2,2,-1,1};

	private static int knightWalk(int n, int m, int s1, int s2, int d1, int d2) {
		boolean[][] board = new boolean[n][m];		

		result = Integer.MAX_VALUE;

		knightWalk(board,s1,s2,d1,d2,0);

		if(result == Integer.MAX_VALUE)
			return -1;
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
			for (int i = 0; i < movesI.length; i++) {
				knightWalk(board,s1+movesI[i],s2 + movesJ[i],d1,d2,moved+1);
			}
		}

		board[s1][s2] = false;

	}

	static class Pair{
		public Pair(int x, int y, int level) {
			super();
			this.x = x;
			this.y = y;
			this.level = level;
		}
		int x;
		int y;
		int level;
		
		public boolean equals(Pair o){
			if(x == o.x && y == o.y)
				return true;
			return false;
			
		}

	}

	private static int knightWalkBfs(int n, int m, int s1, int s2, int d1, int d2) {
		boolean[][] board = new boolean[n][m];	

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(s1, s2, 0));
		Pair dest = new Pair(d1, d2, 0);
		board[s1-1][s2-1] = true;

		while(!q.isEmpty()){
			Pair poll = q.poll();

			if(dest.equals(poll))
				return poll.level;

			for (int i = 0; i < movesI.length; i++) {
				int x = poll.x + movesI[i];
				int y = poll.y + movesJ[i];
				if(x > 0 && x <= n && y > 0 && y <= m){
					if(board[x-1][y-1] == false){
						q.add(new Pair(x, y , poll.level + 1));
						board[x-1][y-1] = true;
					}
				}
			}



		}


		return -1;
	}




}
