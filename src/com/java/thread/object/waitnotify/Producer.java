package com.java.thread.object.waitnotify;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
	@SuppressWarnings("rawtypes")
	private final Queue sharedQ;
	private int maxSize;

	@SuppressWarnings("rawtypes")
	public Producer(Queue sharedQ, int maxSize) {
		super();
		this.sharedQ = sharedQ;
		this.maxSize = maxSize;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		while (true) {
			synchronized (sharedQ) {
				while (sharedQ.size() == maxSize) {
					try {
						System.out.println("Queue is full");
						sharedQ.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Random random = new Random();
                int number = random.nextInt(100);
                System.out.println("Producing value " + number);
                sharedQ.add(number);
                sharedQ.notify();
			}
		}
	}
}
