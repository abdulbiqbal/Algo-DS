package com.abi;

import java.util.Stack;

public class GraphUtil {

	static void dfs(Graph g, int v){

		boolean visited[] = new boolean[g.V];

		dfsUtil(g,v,visited);
		System.out.println();
	}

	private static void dfsUtil(Graph g, int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int a : g.adj[v]) {
			if(visited[a] == false)
				dfsUtil(g,a,visited);
		}
	}

	static void dfsStack(Graph g, int v){
		boolean visited[] = new boolean[g.V];
		
		Stack<Integer> st = new Stack<>();
		
		st.push(v);
		
		while(!st.isEmpty()){
			int c = st.pop();
			
			if(visited[c] == false){
				System.out.print(c + " ");
				visited[c] = true;
			}
			
			for (int a : g.adj[c]) {
				if(visited[a] == false)
					st.push(a);
			}
			
		}
		
		
				
	}

}
