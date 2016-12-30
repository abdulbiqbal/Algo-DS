package com.abi;

public class Matrix {


	static void spiralPrint(int[][] mat){
		int a = 0 , b = mat.length -1;  // Row
		int x = 0 , y = mat[0].length -1 ;  //Column

		while(a<=b && x<=y){

			// Row
			for (int i = x; i <= y; i++) {
				System.out.print(mat[a][i] + " ");
			}

			a++;
			//Column			
			for (int i = a; i <= b; i++) {
				System.out.print(mat[i][y] + " ");
			}
			y--;


			// Row
			if(a<b){
				for (int i = y; i >= x; i--) {
					System.out.print(mat[b][i] + " ");
				}		
				b--;
			}

			if(x<y){
				for (int i = b; i >= a; i--) {
					System.out.print(mat[i][x] + " ");
				}		
				x++;
			}
		}

	}
	
	static int findK(int A[][], int n, int m, int k){		
		int a = 0 , b = A.length -1;  // Row
		int x = 0 , y = A[0].length -1 ;  //Column
		int cnt = 0;
		while(a<=b && x<=y){

			// Row
			for (int i = x; i <= y; i++) {
				//System.out.print(A[a][i] + " ");
				cnt++;
				if(cnt == k)
					return A[a][i];
			}

			a++;
			//Column			
			for (int i = a; i <= b; i++) {
				//System.out.print(A[i][y] + " ");
				cnt++;
				if(cnt == k)
					return A[i][y];
			}
			y--;


			// Row
			if(a<b){
				for (int i = y; i >= x; i--) {
					//System.out.print(A[b][i] + " ");
					cnt++;
					if(cnt == k)
						return A[b][i];
				}		
				b--;
			}

			if(x<y){
				for (int i = b; i >= a; i--) {
					//System.out.print(A[i][x] + " ");
					cnt++;
					if(cnt == k)
						return A[i][x];
				}		
				x++;
			}
		}

		return -1;
    }

}
