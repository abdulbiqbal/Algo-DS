package com.abi;

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

}
