package com.abi;

import java.util.HashMap;
import java.util.Map;

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
		int duplicates = 1;
		Map<String,Integer> record = new HashMap<>();		
		for (int i = 0; i < Y.length; i++) {
			duplicates = 1;
			for (int j = i +1; j < Y.length; j++) {
				

				int mn = Y[j]-Y[i];
				int md = X[j]-X[i];
				
				if(md == 0 && mn ==0){
					duplicates++;
					continue;

				}else if(md == 0){
					key = "vertical";

				}else if(mn == 0){
					key = "0";
					

				}else{
					//mn = Math.abs(mn/gcd(mn,md));
					//md = Math.abs(md/gcd(mn,md));				
					key = Double.toString(mn *1.0 / md);
				}
				if(record.containsKey(key)){
					record.put(key,record.get(key) +1);					
				}else
					record.put(key,1);				
			}	
			
			result = Math.max(result,  duplicates);
			for (Map.Entry<String, Integer> r : record.entrySet()) {
				result = Math.max(result, r.getValue() + duplicates);
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
	
	public int maxPoints(int X[],int Y[],int N) {
	    if(N == 0) return 0;
	 
	    HashMap<Double, Integer> result = new HashMap<Double, Integer>();
	    int max=0;
	 
	    for(int i=0; i<N; i++){
	        int duplicate = 1;//
	        int vertical = 0;
	        for(int j=i+1; j<N; j++){
	            //handle duplicates and vertical
	            if(X[i] == X[j]){
	                if(Y[i] == Y[j]){
	                    duplicate++;
	                }else{
	                    vertical++;
	                }
	            }else{
	                double slope =Y[j] == Y[i] ? 0.0
					        : (1.0 * (Y[j] - Y[i]))
							/ (X[j] - X[i]);
	 
	                if(result.get(slope) != null){
	                    result.put(slope, result.get(slope) + 1);
	                }else{
	                    result.put(slope, 1);
	                }
	            }
	        }
	 
	        for(Integer count: result.values()){
	            if(count+duplicate > max){
	                max = count+duplicate;
	            }
	        }
	 
	        max = Math.max(vertical + duplicate, max);
	        result.clear();
	    }
	 
	 
	    return max;
	}


}
