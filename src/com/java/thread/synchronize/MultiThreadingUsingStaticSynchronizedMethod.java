package com.java.thread.synchronize;

public class MultiThreadingUsingStaticSynchronizedMethod {

	public static void main(String[] args) {

		Thread t1 = new Thread(new CustomizeThread(), "T1");
		Thread t2 = new Thread(new CustomizeThread(), "T2");
		Thread t3 = new Thread(new CustomizeThread(), "T3");
		Thread t4 = new Thread(new CustomizeThread(), "T4");
		Thread t5 = new Thread(new CustomizeThread(), "T5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final Count:" + CustomizeThread.getCount());
	}

}

class CustomizeThread implements Runnable {

	public static int count;

	public static synchronized void perform() {
			System.out.println(Thread.currentThread().getName());
			count= count + 5;
			System.out.println("Count: " + count);
	}

	@Override
	public void run() {
		perform();
	}

	public static int getCount() {
		return count;
	}
}
