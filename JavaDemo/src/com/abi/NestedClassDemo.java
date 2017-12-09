package com.abi;

public class NestedClassDemo {

	public static void main(String[] args) {
		NestedClassDemo b = new NestedClassDemo();
		
		//A a = new b.A();  //Incorrect
		A a = b.new A();

	}
	
	class A{
		
	}

}
