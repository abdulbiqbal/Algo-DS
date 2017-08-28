package com.logmein;

public class ThreadProd {

	public static void main(String[] args){
		Object lock = new Object();
		Thread1 alpha = new Thread1(lock);
		Thread2 number = new Thread2(lock);

		new Thread(alpha).start();
		new Thread(number).start();
	}

	public static class Thread1 implements Runnable {		


		private Object lock;

		public Thread1(Object lock) {
			this.lock = lock;
		}

		public void run() {
			char A = 'A';
			for (int i = 0; i < 26; i++) {
				synchronized (lock){
					System.out.print(A++);
					try {

						lock.notify();
						lock.wait(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static class Thread2 implements Runnable {

		private Object lock;

		public Thread2(Object lock) {
			this.lock = lock;
		}

		public void run() {

			for (int i = 1; i < 27; i++) {
				synchronized (lock){
					System.out.print(i);
					try {
						lock.notify();
						lock.wait(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
