package com.java.thread.lifecycle;

/*
 * A thread can only request the other thread to stop. The request is made in the form of an interruption. 
 * Calling the interrupt() method on an instance of a Thread sets the interrupt status state as true on the instance.
 * Reference: https://www.youtube.com/watch?v=6HydEu75iQI
 * */
import java.util.concurrent.TimeUnit;

public class StoppingThreadUsingInterrupt {

	public static void main(String[] args) throws InterruptedException {
		ServerTwo server = new ServerTwo();
		Thread thread = new Thread(server, "T1");
		thread.start();
		System.out.println("Started!");
		TimeUnit.MILLISECONDS.sleep(10000);
		thread.interrupt();
		System.out.println("Finished!");
	}

}

class ServerTwo implements Runnable {

	@Override
	public void run() {
		
		int count = 0;
		while (!Thread.currentThread().isInterrupted()) {
			count++;
		}
		System.out.println(Thread.currentThread().getName() + "Interrupted!");
		System.out.println("Count: " + count);
		
		/* OR */
//		for (int i = 0; i < 1E8; i++) {
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				System.out.println(Thread.currentThread().getName() + " Interrupted!");
//				break;
//			}
//		}
	}
}