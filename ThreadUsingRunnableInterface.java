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
		ThreadUsingRunnableInterface obj1 = new ThreadUsingRunnableInterface();
		Thread thread1 = new Thread(obj1);
		thread1.setName("ThreadOne");
		thread1.setPriority(Thread.MIN_PRIORITY); //
		thread1.start();
		/* Run Method will be internally called from start() method */

		ThreadUsingRunnableInterface obj2 = new ThreadUsingRunnableInterface();
		Thread thread2 = new Thread(obj2, "ThreadTwo");
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread2.start();

		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " ==" + i);
		}
	}

}
