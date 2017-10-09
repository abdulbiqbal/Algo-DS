package com.abi;

public class Main {

	public static void main(String[] args) {
		char[] arr = {'a','b','c','d','e','f','g','h'};
		
		new Thread1(arr, false).start();
		new Thread1(arr, true).start();


	}

	public static class Thread1 extends Thread{
		boolean odd = false;
		private char[] arr;

		Thread1(char[] arr,boolean odd){
			this.odd = odd;
			this.arr = arr;
		}

		public void run(){
			for (int i = 0; i < arr.length; i++) {
				try {
					synchronized (arr) {
						if(!odd && i%2 == 0){
							System.out.println(arr[i]);
							arr.notify();
							arr.wait();

						}else if(odd && i%2 > 0){
							System.out.println(arr[i]);
							arr.notify();
							arr.wait();
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
