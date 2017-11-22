package com.abi;
import java.util.*;

/*
 * Help..!!
A group of friends is going on a vacation to a beach by a car. One of them is suffering from a severe fever and needs to be taken to hospital in nearest town immediately.

Assume that car consumes one unit of petrol every unit of distance it travels. The hospital is located in town situated at co-ordinate 0. The car is 
D
D units away from the town. On this road, between the town and the current location of the car, there are 
N
N petrol stations where the friends can stop to acquire additional petrol.

As the fever is getting worse with time, the friends want to make the minimum possible number of stops for petrol on the way to the town. Fortunately, the capacity of the petrol tank on their car is so large that there is no limit to the amount of petrol it can hold. The car has some initial amount of petrol in tank which is denoted by 
P
P.

Determine the minimum number of stops needed to reach the town, or if the freinds cannot reach the town at all.

Note:
The town is situated at co-ordinate 0. All the other distances are given with respect to town's location.

Input Format:

First line contains an integer 
N
N, number of petrol stations on the way to town.
Each of the next 
N
N lines contains 
2
2 space-separated integers 
S
S and 
F
F describing a petrol station: 
S
S, the distance from the town to the station and 
F
F, the amount of petrol available at that station.
Next line contains 
2
2 space separated integers 
D
D and 
P
P.
Output Format:

Output a single integer giving the minimum number of stops necessary to reach the town. If it is not possible to reach the town, output 
−
1
−1.
Input Constraints:

1
≤
N
≤
10
5
1≤N≤105
1
≤
D
,
P
,
S
,
F
≤
10
9
 */

public class TestClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Station staions[] = new Station[N];
		
		for (int i = 0; i < staions.length; i++) {
			staions[i] = new Station(sc.nextInt(), sc.nextInt());
		}
		
		int D = sc.nextInt();
		int P = sc.nextInt();
		
		System.out.println(stopsNeeded(staions,D,P));
		
		

	}
	
	private static int stopsNeeded(Station[] staions, int d, int p) {
		int result = 0;
		
		if(d > p){
			
			if(staions.length > 1){
				if((d-staions[staions.length-1].s) > p){
					return -1;
				}
				int totalFuel = p;
				for (int i = 0; i < staions.length; i++) {
					totalFuel = totalFuel + staions[i].f;
				}
				if(totalFuel < d){
					return -1;
				}
			}
			
			int covered = 0;
			
			Arrays.sort(staions);
			
			while(covered < d){
				for (int i = 0; i < staions.length; i++) {
					if(!staions[i].stopped){
						int req = (d-staions[i].s) - covered;
						if(req < p){
							result++;
							staions[i].stopped = true;
							if(req > 0){
								p = p - req;
								covered = covered + req;
							}
							
							p = p + staions[i].f;
						}
						
						if(p+covered >= d)
							return result;
					}
					
					
				}
				
				if(result >= staions.length)
					return -1;
			}
			
		}
		
		return result;
	}

	static class Station implements Comparable<Station>{
		public Station(int s, int f) {
			super();
			this.s = s;
			this.f = f;
		}
		int s;
		int f;
		boolean stopped = false;
		@Override
		public int compareTo(Station o) {			
			return -1*Integer.compare(this.f, o.f);
		}
	}

}
