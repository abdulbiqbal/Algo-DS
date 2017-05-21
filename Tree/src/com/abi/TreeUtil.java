package com.abi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TreeUtil {
	int maxDiff;

	/**
	 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700227
	 * @param root
	 * @return
	 */
	int maxDiff(Node root){
		maxDiff = -1000;

		if(root != null){
			maxDiffUtil(root.left,root.data);
			maxDiffUtil(root.right,root.data);
		}

		return maxDiff;
	}

	void maxDiffUtil(Node node, int parentValue){
		if(node == null){
			return;
		}else{
			maxDiff = Math.max(maxDiff, parentValue - node.data);
		}
		maxDiffUtil(node.left,Math.max(node.data,parentValue));
		maxDiffUtil(node.right,Math.max(node.data,parentValue));
	}
	
	static int _cSmallest = 1;
	static void kthSmallest(Node root, int k){
		_cSmallest = 0;		
		_ksmall(root,k);		
	}

	private static void _ksmall(Node root, int k) {
		if(root == null || _cSmallest > k)
			return;
		_ksmall(root.left,k);
		_cSmallest++;
		if(_cSmallest == k)
			System.out.println(root.data);
		else
			_ksmall(root.right,k);		
	}
	
	static int KthSmallestElement(Node root, int k){
		int result = 0;
		Stack<Node> st = new Stack<>();
		st.push(root);
		Node pt = root;
		do{
			if(pt.left != null)
				st.push(pt);
			
		}while(!st.isEmpty());
		return result;
	}
	
	static void inOrderTraversal(Node root){
		if(root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);		
	}
	
	static void inOrderTraversalStack(Node root){
		Stack<Node> st = new Stack<>();
		Node current = root;
		while(current != null){
			st.push(current);
			current = current.left;
		}
		
		while(!st.isEmpty()){
			current = st.pop();
			System.out.print(current.data + " ");
			
			if(current.right != null){
				current = current.right;
				
				while(current != null){
					st.push(current);
					current = current.left;
				}
			}
			
		}
	}
	
	static class QItem{
		public QItem(Node node, int hd) {
			super();
			this.node = node;
			this.hd = hd;
		}
		Node node;
		int hd;
	}
	
	public static void printTopView(Node root)
    {
		Set<Integer> s = new HashSet<>();
        Queue<QItem> q = new LinkedList<>();
        
        q.add(new QItem(root,0));
        while(!q.isEmpty()){
        	QItem c = q.remove();
        	
        	if(!s.contains(c.hd)){
        		s.add(c.hd);
        		System.out.print(c.node.data + " ");
        	}
        	
        	if(c.node.left != null)
        		q.add(new QItem(c.node.left, c.hd-1));
        	
        	if(c.node.right != null)
        		q.add(new QItem(c.node.right, c.hd+1));
        	
        	
        }
        
    }
	
	public void btWithKleaves(Node root, int k){
		List<Integer> result = new ArrayList<>();
		btWithKleavesUtil(root,k,result);
		
		if(result.isEmpty())
			System.out.println(-1);
		else{
			for (Integer integer : result) {
				System.out.println(integer);
			}
			
		}
    }

	private int btWithKleavesUtil(Node root, int k, List<Integer> result) {
		if(root == null)
			return 0;	
		
		if(root.left == null && root.right == null){
			return 1;
		}
		
		int n = btWithKleavesUtil(root.left,k,result);
		n = n + btWithKleavesUtil(root.right,k,result);
		
		
		if( n == k)
			result.add(root.data);
		return n;
	}
	
	public static int maxLevelSum(Node root){
		int max = 0;
		Map<Integer,Integer> result = new HashMap<>();
		
		maxLevelSumUtil(root,0,result);
		
		for (Entry<Integer, Integer> e : result.entrySet()) {
			if(e.getValue() > max)
				max = e.getValue();
		}
		return max;
     }

	private static void maxLevelSumUtil(Node root, int i, Map<Integer, Integer> result) {
		if(root == null)
			return;
		if(!result.containsKey(i)){
			result.put(i, 0);
		}
		
		result.put(i, result.get(i) + root.data);
		maxLevelSumUtil(root.left,i+1,result);
		maxLevelSumUtil(root.right,i+1,result);
	}

}
