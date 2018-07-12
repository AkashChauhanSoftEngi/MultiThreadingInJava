package com.java.thread;

public class ThreadUsingThreadClass extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " ==" + i);
		}
	}

	public static void main(String[] args) {
		ThreadUsingThreadClass obj1 = new ThreadUsingThreadClass();
		Thread thread1 = new Thread(obj1);
		thread1.setName("ThreadOne");
		thread1.setPriority(1);
		thread1.start();
		thread1.run();

		ThreadUsingThreadClass obj2 = new ThreadUsingThreadClass();
		Thread thread2 = new Thread(obj2);
		thread2.setName("ThreadTwo");
		thread2.setPriority(2);
		thread2.start();
		thread2.run();

		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " ==" + i);
		}

	}

}
