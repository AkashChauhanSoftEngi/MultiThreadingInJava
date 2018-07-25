package com.java.thread.executers;

/*
 * Creates a single-threaded executor that can schedule commands
 * to run after a given delay, or to execute periodically.
 * 
 * @param command the task to execute
 * @param initialDelay the time to delay first execution
 * @param period the period between successive executions for repetition
 * @param unit the time unit of the initialDelay and period parameters
 * */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorNewSingleScheduleThreadPool {

	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		Runnable threadOne = new WorkerThread("" + 1);
		service.scheduleAtFixedRate(threadOne, 3, 5, TimeUnit.SECONDS);
	}
}