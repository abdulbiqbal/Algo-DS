package com.abi;

public class Node<T> {
	T data;
	public Node<T> next;
	
	public Node(T data){
		this.data = data;
	}
	
	public String toString(){
		return data.toString();
	}

}
