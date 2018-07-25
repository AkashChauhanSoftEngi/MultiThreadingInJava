package com.java.thread.executers;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ImplementCallableInterface {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(service);

		// Using Completion service
		completionService.submit(new CallableThreadOne());
		completionService.submit(new CallableThreadTwo());

		System.out.println(completionService.take().get());
		System.out.println(completionService.poll(5, TimeUnit.SECONDS).get());
	}
}