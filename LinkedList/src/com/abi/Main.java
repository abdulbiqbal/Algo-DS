package com.abi;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		Node<Integer> head = new Node<Integer>(1);
		
		ll.addToTheLast(head);
		
		ll.addToTheLast(new Node<Integer>(2));
		ll.addToTheLast(new Node<Integer>(3));
		ll.addToTheLast(new Node<Integer>(3));
		ll.addToTheLast(new Node<Integer>(2));
		ll.addToTheLast(new Node<Integer>(1));
		
		System.out.println(ll);
		
		System.out.println("Middle Element: " + ll.getMiddleElement());
		
		System.out.println("Is Palimdrome: " + ll.isPalindrome());

	}

}
