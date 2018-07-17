package com.java.thread;

/*
 * You can only extend one class in your new class, but you can implement as many interfaces as you would like.
 * So if we use, implement Runnable interface then if needed we can extend another class but in case of
 * Extending Thread class we can not extend another class if needed so, Runnable is preferable over Thread class
 * 
 * */

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
