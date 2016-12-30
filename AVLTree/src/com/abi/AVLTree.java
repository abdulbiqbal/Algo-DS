package com.abi;

public class AVLTree {

	public static Tree rightRotate(Tree x){
		Tree l = x.left;
		Tree t = l.right;

		l.right = x;
		x.left = t;

		x.height = Math.max(x.left.height, x.right.height) + 1;
		l.height = Math.max(l.left.height, l.right.height) + 1;

		return l;
	}

	public static Tree leftRotate(Tree x){		
		Tree r = x.right;
		Tree t = r.left;

		r.left = x;
		x.right = t;

		x.height = Math.max(x.left.height, x.right.height) + 1;
		r.height = Math.max(r.left.height, r.right.height) + 1;

		return r;
	}


	public static Tree insertToAVL(Tree node,int data){
		if(node == null)
			return new Tree(data);

		if(data < node.data)
			node.left = insertToAVL(node.left, data);
		else if(data > node.data)
			node.right = insertToAVL(node.right, data);
		else
			return node;

		int balance = getBalance(node);

		// LL
		if(balance > 1 && node.left.data > data)
			return rightRotate(node);
		//LR
		if(balance > 1 && node.left.data < data){
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// RR
		if(balance < -1 && node.right.data < data)
			return leftRotate(node);

		// RR
		if(balance < -1 && node.right.data > data){
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}


		return node;
	}

	private static int getBalance(Tree node) {
		int l = 0;
		int r = 0;

		if(node == null)
			return 0;

		if(node.left != null)
			l = node.left.height + 1;

		if(node.right != null)
			r = node.right.height + 1;

		return l-r;
	}


}
