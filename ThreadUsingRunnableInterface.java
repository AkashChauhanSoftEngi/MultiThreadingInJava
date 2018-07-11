package com.java.thread;

public class ThreadUsingRunnableInterface implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " ==" + i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadUsingRunnableInterface obj = new ThreadUsingRunnableInterface();
		Thread thread1 = new Thread(obj);
		thread1.setName("ThreadOne");
		thread1.setPriority(1);
		thread1.start();
		/*Run Method will be internally called from start() method*/
		
		Thread thread2 = new Thread(obj, "ThreadTwo");
		thread2.setPriority(2);
		thread2.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " ==" + i);
		}
	}

}
