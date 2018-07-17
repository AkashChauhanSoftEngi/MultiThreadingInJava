package com.java.thread;

public class StopThread {
	private static volatile boolean stop;

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			public void run() {
				while (!stop) {
					System.out.println("In while ...");
				}
			}
		});

		t.start();
		Thread.sleep(1);
		stop = true;
	}
}
