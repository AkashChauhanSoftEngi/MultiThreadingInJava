package com.java.thread;

/*
 * When we call start method, then separate call stack will be created for that thread
 * when we call run method directly, then it will be stored in current stack [usually in main method stack]
 * We should not call run method directly, let the JVM execute run() method through start() method by creating separate call stack
 * Otherwise it will behave as a simple current thread method, not for that particular method
 *  
 * */

//Output
/*
 * main =0 main =1 main =2 main =3 main =4 main =5 main =6 main =7 main
 * =8 main =9 main =0 main =1 main =2 main =3 main =4 main =5 main =6
 * main =7 main =8 main =9
 * 
 */

public class StartOrRunMethod {

	public static void main(String[] args) {
		CustomThreadSleepOrRun customThread = new CustomThreadSleepOrRun();
		Thread threadOne = new Thread(customThread, "T1");
		Thread threadTwo = new Thread(customThread, "T2");

		// threadOne.start();
		// threadTwo.start();

		threadOne.run();
		threadTwo.run();

	}

}

class CustomThreadSleepOrRun implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " =" + i);
		}
	}
}