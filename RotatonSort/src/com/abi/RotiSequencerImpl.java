package com.abi;

public class RotiSequencerImpl implements RotiSequencer{
	
	@Override
	public void showRotis(int[] rotis) {
		for (int i = 0; i < rotis.length; i++) {
			System.out.print(rotis[i] + " ");
		}
		System.out.println();
		
	}

	@Override
	public void sort(int[] rotis) {
		for (int i = rotis.length -1; i >= 0; i--) {
			
			//printArray(rotis);
			int mi = getMaxIndex(rotis,0,i);			
			if(mi < i){
				rotate(rotis,mi);
				//printArray(rotis);
				rotate(rotis,i);
			}
			
		}
		
	}

	/**
	 * Function to rotate first k rotis
	 * @param arr
	 * @param mi
	 */
	private void rotate(int[] arr, int k) {
		int bp = k;
		for (int i = 0; i <= k/2; i++) {
			int t = arr[i];
			arr[i] = arr[bp];
			arr[bp] = t;
			bp--;
		}
		
	}

	/**
	 * Function get Max Number in the Array in the given range
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private int getMaxIndex(int[] arr, int start, int end) {
		int mi = -1;
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if(arr[i] > max){
				mi = i;
				max = arr[i];
			}
		}
		return mi;
	}

}
