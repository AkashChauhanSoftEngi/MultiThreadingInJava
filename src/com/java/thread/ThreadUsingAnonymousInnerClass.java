package com.java.thread;

public class ThreadUsingAnonymousInnerClass {

	public static void main(String[] args) {
		Runnable runnableOne = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " :" + i);
				}
			}
		};
		
		Runnable runnableTwo = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " :" + i);
				}
			}
		};
		
		Thread threadOne = new Thread (runnableOne, "Annonymous Thread T1");
		Thread threadTwo = new Thread (runnableTwo, "Annonymous Thread T2");
		
		threadOne.start();
		try {
			threadOne.join();/*Waits for this thread to die*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		threadTwo.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " :" + i);
		}
	}
}
