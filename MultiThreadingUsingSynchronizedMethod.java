package com.java.thread.synchronize;

public class MultiThreadingUsingSynchronizedMethod {

	public synchronized void perform()
    {
        for(int i=0;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" ="+i);
        }
    }
	
	public static void main(String[] args) {
		MultiThreadingUsingSynchronizedMethod sync = new MultiThreadingUsingSynchronizedMethod();
		CustomizeThreadOne customOne = new CustomizeThreadOne(sync);
		CustomizeThreadTwo customTwo = new CustomizeThreadTwo(sync);
		
		Thread threadOne = new Thread(customOne, "T1");
		Thread threadTwo = new Thread(customTwo, "T2");
		
		threadOne.start();
		threadTwo.start();
		
		for(int i=0;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" ="+i);
        }
	}

}


class CustomizeThreadOne implements Runnable{
	
	private MultiThreadingUsingSynchronizedMethod synchronizationThread;
	
	public CustomizeThreadOne(MultiThreadingUsingSynchronizedMethod synchronizationThread) {
		this.synchronizationThread = synchronizationThread;
	}

	@Override
	public void run() {
		synchronizationThread.perform();
	}
}

class CustomizeThreadTwo implements Runnable{
	
	private MultiThreadingUsingSynchronizedMethod synchronizationThread;
	
	public CustomizeThreadTwo(MultiThreadingUsingSynchronizedMethod synchronizationThread) {
		this.synchronizationThread = synchronizationThread;
	}

	@Override
	public void run() {
		synchronizationThread.perform();
	}
}
