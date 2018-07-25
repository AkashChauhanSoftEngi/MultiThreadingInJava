package com.java.thread.executers;

/*
 * Creates a thread pool that creates new threads as needed, 
 * but will reuse previously constructed threads when they are available.
 * Threads that have not been used for sixty seconds are terminated and removed from the cache.
 * 
 * */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorNewCacheThreadPool {

	public static void main(String[] args) {
		ExecutorService executer = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++) {
			Runnable threadOne = new WorkerThread("" + 1);
			Runnable threadTwo = new WorkerThread("" + 2);
			Runnable threadThree = new WorkerThread("" + 3);

			executer.execute(threadOne);
			executer.execute(threadTwo);
			executer.execute(threadThree);
			System.out.println();
		}
		
		executer.shutdown();
		while (!executer.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}