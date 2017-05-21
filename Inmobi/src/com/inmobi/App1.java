package com.inmobi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Map<Integer,List<Integer>> dependecies = new HashMap<>();
		for (int i = 0; i < M; i++) {
			int value = sc.nextInt();
			int key = sc.nextInt();
			
			if(!dependecies.containsKey(key)){
				dependecies.put(key, new ArrayList<>());
			}
			dependecies.get(key).add(value);
		}
		
		System.out.println(dependecies);
	}

}
