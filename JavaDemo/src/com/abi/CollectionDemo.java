package com.abi;

import java.util.HashMap;
import java.util.TreeMap;

public class CollectionDemo {

	public static void main(String[] args) {
		demo6();

	}
	
	static class A{
		
	}
	
	static class B{
		
		public int hashCode(){
			return 0;
		}
		
		@Override
		public boolean equals(Object x){
			return false;
			
		}		
	}
	
	static class C{
		
		public int hashCode(){
			return 0;
		}
		
		@Override
		public boolean equals(Object x){
			return true;
			
		}		
	}
	
	static class D implements Comparable<D>{

		@Override
		public int compareTo(D o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	static class E implements Comparable<E>{

		int id;
		
		public E(int id){
			this.id=id;
		}
		@Override
		public int compareTo(E o) {
			return this.id - o.id;
		}
		
	}

	private static void demo1() {
		TreeMap map = new TreeMap();
		
		A a1 = new A();
		A a2 = new A();
		
		map.put(a1, 1);
		map.put(a2, 2);
		
		System.out.println(map.size());
		
	}
	
	private static void demo2() {
		TreeMap map = new TreeMap();
		
		B b1 = new B();
		B b2 = new B();
		
		map.put(b1, 1);
		map.put(b2, 2);
		
		System.out.println(map.size());
		
	}
	
	private static void demo3() {
		HashMap map = new HashMap();
		
		B b1 = new B();
		B b2 = new B();
		
		map.put(b1, 1);
		map.put(b2, 2);
		
		System.out.println(map.size());
		
		
	}
	
	private static void demo4() {
		HashMap map = new HashMap();
		
		C c1 = new C();
		C c2 = new C();
		
		map.put(c1, 1);
		map.put(c2, 2);
		
		System.out.println(map.size());
		System.out.println(map.get(map.keySet().iterator().next()));
		
		
	}
	
	private static void demo5() {
		TreeMap map = new TreeMap();
		
		D d1 = new D();
		D d2 = new D();
		
		map.put(d1, 1);
		map.put(d2, 2);
		
		System.out.println(map.size());
		System.out.println(map.get(map.keySet().iterator().next()));		
		
	}
	
	private static void demo6() {
		TreeMap map = new TreeMap();
		
		E e1 = new E(10);
		E e2 = new E(20);
		
		map.put(e1, 1);
		map.put(e2, 2);
		
		System.out.println(map.size());
		System.out.println(map.get(map.keySet().iterator().next()));		
		
	}

}
