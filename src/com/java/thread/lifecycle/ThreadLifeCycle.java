package com.java.thread.lifecycle;

/**
 * Thread state for a thread which has not yet started.
 */
//NEW,

/**
 * Thread state for a runnable thread.  A thread in the runnable
 * state is executing in the Java virtual machine but it may
 * be waiting for other resources from the operating system
 * such as processor.
 */
//RUNNABLE,

/**
 * Thread state for a thread blocked waiting for a monitor lock.
 * A thread in the blocked state is waiting for a monitor lock
 * to enter a synchronized block/method or
 * reenter a synchronized block/method after calling
 * {@link Object#wait() Object.wait}.
 */
//BLOCKED,

/**
 * Thread state for a waiting thread.
 * A thread is in the waiting state due to calling one of the
 * following methods:
 * <ul>
 *   <li>{@link Object#wait() Object.wait} with no timeout</li>
 *   <li>{@link #join() Thread.join} with no timeout</li>
 *   <li>{@link LockSupport#park() LockSupport.park}</li>
 * </ul>
 *
 * <p>A thread in the waiting state is waiting for another thread to
 * perform a particular action.
 *
 * For example, a thread that has called <tt>Object.wait()</tt>
 * on an object is waiting for another thread to call
 * <tt>Object.notify()</tt> or <tt>Object.notifyAll()</tt> on
 * that object. A thread that has called <tt>Thread.join()</tt>
 * is waiting for a specified thread to terminate.
 */
//WAITING,

/**
 * Thread state for a waiting thread with a specified waiting time.
 * A thread is in the timed waiting state due to calling one of
 * the following methods with a specified positive waiting time:
 * <ul>
 *   <li>{@link #sleep Thread.sleep}</li>
 *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
 *   <li>{@link #join(long) Thread.join} with timeout</li>
 *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
 *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
 * </ul>
 */
//TIMED_WAITING,

/**
 * Thread state for a terminated thread. The thread has completed execution.
 */
// TERMINATED;

public class ThreadLifeCycle {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		CustomThread customThread = new CustomThread();

		System.out.println("Thread States");

		Thread thread = new Thread(customThread, "ThreadOne");
		System.out.println("After thread Creation: " + thread.getState());

		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After using Join on the thread: " + thread.getState());
		
		thread.start();
		thread.setPriority(Thread.MAX_PRIORITY);
		System.out.println("After thread start() method: " + thread.getState());

		
		try {
			thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After sleep(1000) method: " + thread.getState());
	}
}

class CustomThread implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			
		}
	}
}
