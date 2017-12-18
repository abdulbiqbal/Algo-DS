package com.abi;

public class ExceptionDemo {

	public static void main(String[] args) {
		System.out.println(demo7());

	}

	private static int demo1() {
		try{
			return 1;
			
		}catch(Exception e){
			
		}finally{
			System.exit(0);
			return 2;
			
		}
	}
	
	private static int demo2() {
		try{			
			return 1;			
		}catch(Exception e){
			
		}finally{			
			return 2;			
		}
	}
	
	private static int demo3() {
		try{			
			throw new Exception();			
		}catch(Exception e){
			System.exit(1);
			return 1;
			
		}finally{			
			return 2;			
		}
	}
	
	private static int demo4() {
		try{			
			throw new Exception();			
		}catch(Exception e){			
			return 1;
			
		}finally{			
			return 2;			
		}
	}
	
	private static int demo5() {
		try{			
			throw new Exception();			
		}catch(Exception e){			
			return 1;
			
		}finally{			
			System.out.println("Finally Block");			
		}
	}
	
	private static int demo6() {
		try{			
			throw new Exception();			
		}catch(Exception e){			
			return 1;
			
		}finally{			
			throw new RuntimeException();		
		}
	}
	
	private static int demo7() {
		try{			
			throw new Exception();			
		}catch(Exception e){			
			throw new Exception();	
			
		}finally{			
			return 2;	
		}
	}

}
