package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		//instantiate two MyThread object
		MyThread t0 = new MyThread();
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		//These Threads run whenever they want... but we can set priority!
		//Priority does "an ok" job at making sure one Thread finishes before others
		//the higher the number, the more priority the Thread has over others. (1-10)
		t0.setPriority(1); //this should make t1 end last
		t1.setPriority(10); //this should make t2 end first
		
		//.join() method helps ensure that Threads finish last, by throwing them to the bottom of the stack
		//like priority, it does an "ok" job.
		try{
			t2.join();
		} catch (InterruptedException e) {
			System.out.println("Exception caught");
		}
		
		//let both threads start using the start() method
		t0.start();
		t1.start();
		t2.start();

	}
	
}
