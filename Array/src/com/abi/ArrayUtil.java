package com.abi;

public class ArrayUtil {
	static int result = 1;
	
	// Brute Force
	static int lisb(int[] arr){
		result = 1;
		for (int i = 0; i < arr.length -1; i++) {
			lisb(arr,i,1);
		}
		
		return result;
	}
	
	static int lisb(int[] arr, int index, int len){
		
		result = Math.max(result, len);
		for (int i = index + 1; i < arr.length; i++) {
			if(arr[i] > arr[index]){
				lisb(arr,i,len+1);
			}
		}
		
		return result;
	}
	
	static int[] subResults;
	
	static int lis(int[] arr, int n){
		result = 1;
		subResults = new int[n];
		
		_lis(arr,n-1);
		return result;
	}

	private static int _lis(int[] arr, int n) {
		if(subResults[n]!=0)
			return subResults[n];
		
		int currentRes = 1;
		
		for (int i = 0; i < n; i++) {
			int subRes = _lis(arr,i);
			
			if(arr[i] < arr[n] && currentRes < (1 + subRes)){
				currentRes = subRes + 1;
			}			
		}
		
		result = Math.max(result, currentRes);
		
		if(subResults[n]==0)
			subResults[n] = currentRes;
		return currentRes;
	}

}
