package com.java.thread.executers;

/*
 * Creates an Executor that uses a single worker thread
 * Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time.
 * Wait until that one thread does not complete its work completely
 * 
 * */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorNewSingleThreadPool {

	public static void main(String[] args) {
		ExecutorService executer = Executors.newSingleThreadExecutor();

			Runnable threadOne = new WorkerThread("" + 1);
			Runnable threadTwo = new WorkerThread("" + 2);
			Runnable threadThree = new WorkerThread("" + 3);

			executer.execute(threadOne);
			executer.execute(threadTwo);
			executer.execute(threadThree);
			System.out.println();
		
		executer.shutdown();
		while (!executer.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}