package com.abi;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		while(T-- > 0){
			String str = sc.nextLine();
			String fr = sc.nextLine();
			String[] frequencies = fr.split(" ");
			PriorityQueue<Node> queue = new PriorityQueue<>();
			
			for (int i = 0; i < str.length(); i++) {
				queue.add(new Node(str.charAt(i), Integer.parseInt(frequencies[i])));
			}
			
			createAndPrintHuffmannTree(queue);
			
		}
	}
	
	private static void createAndPrintHuffmannTree(PriorityQueue<Node> queue) {
		if(queue == null || queue.size() < 1){
			return;
		}
		while(queue.size() > 1){			
			Node leftNode = queue.poll();
			Node rightNode = queue.poll();
			
			Node newNode = new Node(null, leftNode.frequency + rightNode.frequency);
			newNode.left = leftNode;
			newNode.right = rightNode;			
			queue.add(newNode);			
		}
		
		//printTreePreOrder(queue.poll());
		printTreePreOrder(queue.poll(), new int[100],0);
		
	}

	private static void printTreePreOrder(Node node) {
		if(node == null)
			return;
		printTreePreOrder(node,new ArrayList<Integer>());
		
	}

	private static void printTreePreOrder(Node node, ArrayList<Integer> code) {
		if(node == null){
			return;
		}
		
		code.add(0);
		printTreePreOrder(node.left,code);
		code.remove(code.size() -1);
		
		code.add(1);
		printTreePreOrder(node.right,code);
		code.remove(code.size() -1);
		
		
		if(node.left == null && node.right == null){
			System.out.print("\n" + node.ch + " : ");
			for (Integer c : code) {
				System.out.print(c);
			}
			System.out.print(" ");
		}
		
	}
	
	private static void printTreePreOrder(Node node, int arr[], int top){
		
		if(node == null)
			return;
		
		if(node.left != null){
			arr[top] = 0;
			printTreePreOrder(node.left,arr,top+1);
		}
		
		if(node.right != null){
			arr[top] = 1;
			printTreePreOrder(node.right,arr,top+1);
		}
		
		if(node.ch != null){
			System.out.print("\n" + node.ch + " : ");
			for (int i = 0; i < top; i++) {
				System.out.print(arr[i]);
			}
		}
		
	}

	static class Node implements Comparable<Node>{
		public Node(Character ch, int frequency) {
			super();
			this.ch = ch;
			this.frequency = frequency;
		}
		Character ch;
		int frequency;
		Node left;
		Node right;
		@Override
		public int compareTo(Node n) {			
			return Integer.compare(this.frequency, n.frequency);
		}
	}

}
