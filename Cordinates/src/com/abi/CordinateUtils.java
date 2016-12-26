package com.abi;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CordinateUtils {

	/**
	 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700379
	 * Maximum points in a straight line
	 * @param X
	 * @param Y
	 * @param N
	 * @return
	 */
	int noOfPoints(int X[],int Y[],int N) {
		int result = 0;
		String key;
		Map<String,Integer> record = new HashMap<>();		
		for (int i = 0; i < Y.length; i++) {
			for (int j = i ; j < Y.length; j++) {
				

				int mn = Y[j]-Y[i];
				int md = X[j]-X[i];

				if(md == 0){
					key = "vertical";

				}else if(mn == 0){
					key = "0";
					

				}else{
					mn = Math.abs(mn/gcd(mn,md));
					md = Math.abs(md/gcd(mn,md));				
					key = mn + "" + md;
				}
				if(record.containsKey(key)){
					record.put(key,record.get(key) +1);					
				}else
					record.put(key,1);				
			}	
			
			for (Entry<String, Integer> r : record.entrySet()) {
				result = Math.max(result, r.getValue());
			}
			record.clear();
		}		

		return result;

	}

	int gcd(int a, int b){
		if(a==0)
			return Math.abs(b);
		if(b==0)
			return Math.abs(a);

		return Math.abs(gcd(b,a%b));
	}

}
