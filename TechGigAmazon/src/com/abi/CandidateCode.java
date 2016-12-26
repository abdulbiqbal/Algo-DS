package com.abi;

import java.io.*;
import java.util.*;
public class CandidateCode {

	public static class Vendor implements Comparable<Vendor>{
		public Vendor(int startTime, int endTime, int price) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
			this.price = price;
		}
		int startTime;
		int endTime;
		int price;
		@Override
		public int compareTo(Vendor o) {
			if (this.price == o.price){

				if(this.startTime == o.startTime){
					return o.endTime - this.endTime;
				}else
					return this.startTime - o.startTime;
			}else
				return this.price - o.price;
		}

		public String toString(){
			return startTime + " " + endTime + " " + price;
		}
	}
	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();

		int N = Integer.parseInt(line);

		Vendor v[] = new Vendor[N];

		String []token = null;
		int start = -1;
		int end = -1;

		for (int i = 0; i < N; i++) {
			line = br.readLine();
			token = line.split(" ");
			v[i] = new Vendor(Integer.parseInt(token[0]), Integer.parseInt(token[1]), 
					Integer.parseInt(token[2]));

			if(start ==-1)
				start = Integer.parseInt(token[0]);
			else
				start = Math.min(start, Integer.parseInt(token[0]));

			end = Math.max(end, Integer.parseInt(token[1]));
		}

		solve(start, end, v);

	}

	private static void solve(int start, int end, Vendor[] v) {
		int cvIndex =-1;
		int nvIndex =-1;
		int lastStart = start;
		Arrays.sort(v);
		cvIndex = bestVendorAtTime(start,v);
		for(int i=start; i<=end; i++){

			nvIndex = bestVendorAtTime(i,v);

			if(nvIndex != cvIndex){  //Change in Vendor
				if(cvIndex == -1){ // Previous No Vendor
					System.out.println(lastStart + " " + (i-1) + " " + 0);
					lastStart = i;
				}else{
					if(nvIndex != -1){
						if(v[cvIndex].price == v[nvIndex].price){ // If Same price just change the vendor

						}else{
							System.out.println(lastStart + " " + (i-1) + " " + v[cvIndex].price);
							lastStart = i;							
						}
						
					}else{// No vendor now
						System.out.println(lastStart + " " + (i-1) + " " + v[cvIndex].price);
						lastStart = i;							
					}					
				}
				cvIndex = nvIndex;
			}

		}
		System.out.println(lastStart + " " + end + " " + v[cvIndex].price);

	}
	private static int bestVendorAtTime(int time,Vendor[] v) {
		for (int j = 0; j < v.length; j++) {
			if(v[j].startTime <= time && v[j].endTime >= time)
				return j;
			}
		return -1;
	}

	

}
