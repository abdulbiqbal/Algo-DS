package com.abi;

public class Main {

	public static void main(String[] args) {
		 /*Graph g = new Graph(4);
		 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);*/
		
		Graph g = new Graph(6);
	    g.addEdge(5, 2);
	    g.addEdge(5, 0);
	    g.addEdge(4, 0);
	    g.addEdge(4, 1);
	    g.addEdge(2, 3);
	    g.addEdge(3, 1);
	 
	        System.out.println("Following is Depth First Traversal "+
	                           "(starting from vertex 2)");
	        
	        //GraphUtil.dfs(g, 2);
	        GraphUtil.dfsStack(g, 5);

	}

}
