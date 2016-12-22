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
	 */
	Boolean isPalindrome(){
		 
		 if(head == null || head.next == null)
			 return true;
		 
		 Node<T> slowPtr = head;
		 Node<T> fastPtr = head;
		 
		 Stack<Node<T>> secondHalfNodes = new Stack<>();
		 
		 while(fastPtr.next != null){			 
			 fastPtr = fastPtr.next;			 
			 if(fastPtr.next != null){
				 fastPtr = fastPtr.next;
				 slowPtr = slowPtr.next;
			 }
		 }
		 
		 while(slowPtr.next != null){
			 secondHalfNodes.push(slowPtr.next);
			 slowPtr = slowPtr.next;
		 }
		 
		 Node<T> temp = head;
		 while(!secondHalfNodes.isEmpty()){
			 if(!secondHalfNodes.peek().data.equals(temp.data))
				 return false;
			 
			 secondHalfNodes.pop();
			 temp = temp.next;
			 
		 }
		 
		 return true;
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
	

}
