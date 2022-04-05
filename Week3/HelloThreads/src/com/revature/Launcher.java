package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		//instantiate two MyThread object
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		
		//These Threads run whenever they want... but we can set priority!
		//Priority does "an ok" job at making sure one Thread finished before others
		//the higher the number, the more priority the Thread has over others
		t1.setPriority(1); //this should make t1 start last
		t2.setPriority(10); //this should make t2 start first
		
		
		//let both threads start using the start() method
		t1.start();
		t2.start();
		t3.start();
		
		
		
	}
	
}
