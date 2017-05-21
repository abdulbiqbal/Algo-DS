package com.abi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		/*Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		//TreeUtil.inOrderTraversal(root);
		//TreeUtil.inOrderTraversalStack(root);
		//TreeUtil.kthSmallest(root, 4);
		TreeUtil.printTopView(root);*/
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int k=sc.nextInt();
			Node root=null;
			if(n==0||n==1)
			{
				System.out.println("-1");
				continue;
			}
			for(int i=0;i<n;i++){
				int a=sc.nextInt();
				int a1=sc.nextInt();
				char lr=sc.next().charAt(0);
				if(root==null){
					root=new Node(a);
					switch(lr){
						case 'L':root.left=new Node(a1);
						break;
						case 'R':root.right=new Node(a1);
						break;
					}
				}
				else{
					insert(root,a,a1,lr);
				}
			}
			TreeUtil g=new TreeUtil();
			g.btWithKleaves(root,k);
		}
	}
	
	public static void insert(Node root,int a,int a1,char lr){
		if(root==null)
			return;
		if(root.data==a)
		{
			switch(lr){
					case 'L':root.left=new Node(a1);
					break;
					case 'R':root.right=new Node(a1);
					break;
				}
		}
		else {
			insert(root.left,a,a1,lr);
			insert(root.right,a,a1,lr);
		}
	}

}
