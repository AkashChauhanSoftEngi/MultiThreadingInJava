package com.java.thread.executers;

import java.util.concurrent.Callable;

public class CallableThreadOne implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		System.out.println(" RUnning callable thread");
		Thread.sleep(1000);
		return 100;
	}
}
