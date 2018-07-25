package com.java.thread.executers;

/*
 * newFixedThreadPool(5): Creates a thread pool that reuses a fixed number of threads
 * When all threads are active,they will wait in the queue until a thread is available.
 * The threads in the pool will exist until it is explicitly {@link ExecutorService#shutdown shutdown}.
 * 
 * */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorNewFixedThreadPool {

	public static void main(String[] args) {
		ExecutorService executer = Executors.newFixedThreadPool(2);
			Runnable threadOne = new WorkerThread("" + 1);
			Runnable threadTwo = new WorkerThread("" + 2);
			Runnable threadThree = new WorkerThread("" + 3);
			
			executer.execute(threadOne);
			executer.execute(threadTwo);
			executer.execute(threadThree);
			System.out.println();

		executer.shutdown();
		while(!executer.isTerminated()){
		}
		System.out.println("Finished all threads");
	}
}