package com.abi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author abasit
 * 
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=1653
 * 
 * Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.

Example:

Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};

Output:  Following words of dictionary are present
         GEEKS, QUIZ

Example:
Input:
1
4
GEEKS FOR QUIZ GO
3 3
G I Z U E K Q S E

Output:
GEEKS QUIZ
 *
 */
public class Application {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] tokens;
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0){
			int x = Integer.parseInt(br.readLine());
			String[] dictionary = br.readLine().split(" ");

			line = br.readLine();
			tokens = line.split(" ");
			int n = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);

			line = br.readLine();
			tokens = line.split(" ");
			int tokenCounter = 0;
			char[][] boggle = new char[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					boggle[i][j] = tokens[tokenCounter++].charAt(0);
				}				
			}

			for (String word : dictionary) {
				if(isPossible(word,boggle))
					System.out.print(word + " ");
			}
		}	

	}

	static class Pair{
		public Pair(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		int i;
		int j;

	}

	static int[] movesI = {0,-1,-1,-1,0,0,1,1,1};
	static  int[] movesJ = {0,-1,0,1,-1,1,-1,0,1};

	private static boolean isPossible(String word, char[][] boggle) {
		if(word == null || word.length() == 0)
			return true;
		Pair charPosition = findChar(word.charAt(0),boggle);
		boolean found = false;
		if(charPosition != null){
			int n = 0, m =0;
			found = true;
			int wordCounter = 0;

			while(found && wordCounter<word.length()){
				found = false;
				for (int i = 0; i < movesI.length; i++) {
					n = charPosition.i + movesI[i];
					m = charPosition.j + movesJ[i];
					if(n >= 0 && n < boggle.length && m>=0 && m < boggle[0].length){
						if(word.charAt(wordCounter) == boggle[n][m]){
							found = true;
							charPosition.i = n;
							charPosition.j = m;
							break;
						}
					}

				}
				wordCounter++;
			}

		}
		return found;
	}

	private static Pair findChar(char ch,char[][] boggle) {
		for (int i = 0; i < boggle.length; i++) {
			for (int j = 0; j < boggle[i].length; j++) {
				if(boggle[i][j] == ch)
					return new Pair(i,j);
			}				
		}
		return null;
	}

}
