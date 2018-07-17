package com.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


/*
 * When using Atomic data types and their respective operations either run completely or roll back
 * By using Atomic data types we can ensure no race condition will occur 
 * The most commonly used atomic variable classes in Java are 
 * AtomicInteger, AtomicLong, AtomicBoolean, and AtomicReference.
 * 
 * */

public class MultiThreadingUsingAtomicClasses {
	public static class MeetUpEvent {
		private String name;
		private AtomicInteger count = new AtomicInteger(1); // 1 for organizer
		public AtomicReference<String> atomicReference = new AtomicReference<String>("abc");
		
		public MeetUpEvent(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}

		public void attending(int guestCount) {
			if (guestCount == 1) {
				count.incrementAndGet();
			} else {
				count.addAndGet(guestCount);
			}
		}

		public void notAttending(int guestCount) {
			if (guestCount == 1) {
				count.decrementAndGet();
			} else {
				boolean updated = false;
				while (!updated) {
					int currentCount = count.get();
					int newCount = currentCount - guestCount;
					updated = count.compareAndSet(currentCount, newCount);
				}
			}
		}

		public int getCount() {
			return count.get();
		}
	}

	public static void main(String[] args) {
		MeetUpEvent jugBoston = new MeetUpEvent("The Boston Java User Group");

		Thread userOne = new Thread(new Runnable() {
			@Override
			public void run() {
				jugBoston.attending(4);
				System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
			}
		});

		Thread userTwo = new Thread(new Runnable() {

			@Override
			public void run() {
				jugBoston.attending(3);
				System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
				jugBoston.notAttending(3);
				System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
			}
		});

		Thread userThree = new Thread(new Runnable() {

			@Override
			public void run() {
				jugBoston.attending(1);
				System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
			}
		});

		userOne.setName("User1");
		userTwo.setName("User2");
		userThree.setName("User3");

		userOne.start();
		sleep(1);
		userTwo.start();
		sleep(2);
		userThree.start();
		sleep(3);

		System.out.println("Total attending : " + jugBoston.getCount());
		System.out.println("Atomic Reference : " + jugBoston.atomicReference);
	}

	private static void sleep(int i) {
		try {
			TimeUnit.SECONDS.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
