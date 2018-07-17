package com.java.thread.object.waitnotify;

public class WaitNotifyTest {

    public static void main(String[] args) {
    	
        Message msg = new Message("process it");
        
        Waiter waiterOne = new Waiter(msg);
        new Thread(waiterOne, "W1").start();
        
        Waiter waiterTwo = new Waiter(msg);
        new Thread(waiterTwo, "W2").start();
        
        Notifier notifierOne = new Notifier(msg);
        new Thread(notifierOne, "N1").start();
        
        System.out.println("All the threads are started");
        System.out.println();
    }

}