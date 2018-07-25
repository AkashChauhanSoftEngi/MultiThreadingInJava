package com.java.thread.lifecycle;

import java.util.concurrent.TimeUnit;

/*
 * Thread.stop() method is Deprecated in new version
 * ensure that boolean variable which is used to stop the thread is volatile, otherwise, in the worst case your thread may not stop and run infinitely,
 * as might not read from main memory or just read cache memory only
 * Using TimeUnit class to pause a thread is better than Thread.sleep(), as You know up front that whether thread is stopping for 2 millisecond or 2 second, which was not visible in case of Thread.sleep()
 * Reference: http://www.java67.com/2015/07/how-to-stop-thread-in-java-example.html
 * */

public class StopingThread {

	public static void main(String[] args) throws InterruptedException {
		Server server = new Server();
		Thread thread = new Thread(server,"thread");
		thread.start();
		
		//Now, let's stop our Server thread
		System.out.println(Thread.currentThread().getName() + "is stopping server thread");
		server.stop();
		
		//Let's wait to see server thread stopped
		TimeUnit.MILLISECONDS.sleep(20000);
		
		System.out.println(Thread.currentThread().getName() + " is finished now");
	}

}

class Server implements Runnable{
	private volatile boolean exit = false; 

	@Override
	public void run() {
		while(!exit){
			System.out.println("Server is Running!");
		}
		System.out.println("Server is stopped....");
	}
	
	public void stop(){
		exit = true;
	}
	
}