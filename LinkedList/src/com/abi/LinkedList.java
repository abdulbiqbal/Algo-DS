package com.abi;

import java.util.Stack;

public class LinkedList<T> {

	Node<T> head;

	public LinkedList(){
		super();
		this.head = null;		
	}

	public LinkedList(Node<T> head){
		super();
		this.head = head;		
	}

	public void addToTheLast(Node<T> node) { 

		if(head == null){
			head = node;
		}else{
			Node<T> temp = head;

			while(temp.next != null)
				temp = temp.next;

			temp.next = node;
		}

	}

	public String toString(){
		StringBuilder sb = new StringBuilder();

		Node<T> temp = head;

		while(temp != null){
			sb.append(temp.data + " ");
			temp = temp.next;
		}
		sb.setLength(sb.length() -1); // Remove last space
		return sb.toString();
	}

	/**
	 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700391
	 * @return
	 * Time O(n) Space O(n) for Stack
	 */
	Boolean isPalindrome(){

		if(head == null || head.next == null)
			return true;

		Node<T> slowPtr = head;
		Node<T> fastPtr = head;

		Stack<Node<T>> secondHalfNodes = new Stack<>();


		//traverse first half to move slowPtr to middle element
		while(fastPtr.next != null){			 
			fastPtr = fastPtr.next;			 
			if(fastPtr.next != null){
				fastPtr = fastPtr.next;
				slowPtr = slowPtr.next;
			}
		}

		// Add Second half in the Stack
		while(slowPtr.next != null){
			secondHalfNodes.push(slowPtr.next);
			slowPtr = slowPtr.next;
		}

		// Check the first half element with Next half stored in Stack
		Node<T> temp = head;
		while(!secondHalfNodes.isEmpty()){
			if(!secondHalfNodes.peek().data.equals(temp.data))
				return false;

			secondHalfNodes.pop();
			temp = temp.next;

		}

		return true;
	}

	/**
	 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700391
	 * @return
	 * Time O(n) Space O(n) for Stack
	 * Add all elements to Stack instead of half
	 */
	Boolean isPalindrome1(){

		if(head == null || head.next == null)
			return true;		 

		Stack<Node<T>> nodesStack = new Stack<>();	 

		Node temp = head;
		while(temp != null){
			nodesStack.push(temp);
			temp = temp.next;
		}		 
		temp = head;
		while(!nodesStack.isEmpty()){
			if(!nodesStack.peek().data.equals(temp.data))
				return false;			 
			nodesStack.pop();
			temp = temp.next; 
		}

		return true;
	}

	/**
	 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700391
	 * @return
	 * Time O(n) Space O(1) for Stack
	 * Add all elements to Stack instead of half
	 */
	Boolean isPalindrome2(){
		
		Boolean result = true;
		if(head == null || head.next == null)
			return result;

		Node<T> slowPtr = head;
		Node<T> fastPtr = head;


		while(fastPtr.next != null){			 
			fastPtr = fastPtr.next;			 
			if(fastPtr.next != null){
				fastPtr = fastPtr.next;
				slowPtr = slowPtr.next;
			}
		}
		
		Node n = reverse1(slowPtr.next);
		Node temp1 = head;
		Node temp2 = n;
		
		while(temp2!= null){
			if(!temp2.data.equals(temp1.data)){
				result = false;
				break;
			}	
			temp2 = temp2.next;
			temp1 = temp1.next;
			
		}
		
		reverse1(n);
		
			
			return result;

	}



	void reverse(){

		if(head == null || head.next == null)
			return;

		Node p = null, c = head;

		while(c != null){
			Node n = c.next;			
			c.next = p;			
			p =  c;
			c = n;		
		}
		head = p;

	}

	static Node reverse1(Node head){

		if(head == null || head.next == null)
			return head;

		Node p = null, c = head;

		while(c != null){
			Node n = c.next;			
			c.next = p;			
			p =  c;
			c = n;		
		}		
		return p;		
	}

	Node<T> getMiddleElement(){

		if(head == null || head.next == null)
			return head;

		Node<T> slowPtr = head;
		Node<T> fastPtr = head;

		while(fastPtr.next != null){

			fastPtr = fastPtr.next;

			if(fastPtr.next != null){
				fastPtr = fastPtr.next;
				slowPtr = slowPtr.next;
			}
		}

		return slowPtr;

	}

	static void printNodes(Node head){
		Node temp = head;

		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}


}
