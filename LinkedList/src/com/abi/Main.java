package com.abi;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		Node<Integer> head = new Node<Integer>(1);
		
		ll.addToTheLast(head);
		
		ll.addToTheLast(new Node<Integer>(2));
		ll.addToTheLast(new Node<Integer>(3));
		ll.addToTheLast(new Node<Integer>(4));
		ll.addToTheLast(new Node<Integer>(5));
		ll.addToTheLast(new Node<Integer>(6));
		
		System.out.println(ll);
		
		System.out.println("Middle Element: " + ll.getMiddleElement());
		
		//System.out.println("Is Palimdrome: " + ll.isPalindrome());
		System.out.println("Is Palimdrome: " + ll.isPalindrome2());
		
		//ll.reverse();
		//System.out.println("Reversed: " + ll);
		
		/*LinkedList.printNodes(ll.head.next);
		
		System.out.println();
		Node x = LinkedList.reverse1(ll.head.next);
		
		LinkedList.printNodes(x);
		
		System.out.println(ll);*/
		
		//ll.reverse();
		
		//System.out.println(ll);
		
		Node r = LinkedList.reverseRec(ll.head);
		
		LinkedList.printNodes(r);
		
		
		

	}

}
