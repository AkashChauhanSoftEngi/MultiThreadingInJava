package com.java.thread;

/**
 * The minimum priority that a thread can have.
 */
//public final static int MIN_PRIORITY = 1;

/**
 * The default priority that is assigned to a thread.
 */
//public final static int NORM_PRIORITY = 5;

/**
 * The maximum priority that a thread can have.
 */
//public final static int MAX_PRIORITY = 10;

public class ThreadPriority {

	public static void main(String[] args) {
		CustomThread customThread = new CustomThread();
		Thread threadOne = new Thread(customThread, "T1");
		Thread threadTwo = new Thread(customThread, "T2");
		
		/*
		 * For threadTwo: 
		 * Priority will be set to 10 as max
		 * This does not mean it will execute first there is no guarantee
		 * Also Plate-form dependent
		 * */
		threadTwo.setPriority(Thread.MAX_PRIORITY); 
		
		threadOne.start();
		threadTwo.start();
		
		/*
		 * For threadOne: 
		 * By default priority will be set to 5 which is called Norm Priority
		 * */
		System.out.println(threadOne);
		System.out.println(threadTwo);
	}

}

class CustomThread implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " =" + i);
		}
	}	
}