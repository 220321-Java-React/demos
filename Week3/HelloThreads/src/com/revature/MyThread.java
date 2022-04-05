package com.revature;

//This Thread will extend the Thread Class and override the run() method.
//Note that we could also implement the Runnable Interface, but Thread extends that for us.
public class MyThread extends Thread {

	//the run() method is the process/behavior that you want your Thread to have
	@Override
	public void run() {
		
		//loop ten times to help us show this thread running
		for(int i = 0; i < 10; i++) {
			
			//we have to use StringBuffer, because StringBuilder isn't thread safe. The only reason we'd use buffer > builder
			StringBuffer sb = new StringBuffer(Thread.currentThread().getName());
			//Here, we have a StringBuffer that is equal to the name of our Thread
			
			//append a message to the StringBuffer so we can see it working in the console
			sb.append(" is working...");
			
			//print out the stringbuffer so we can actually watch this work
			System.out.println(sb);
			
			//might need to make the thread sleep so we can see it working better
			//sleep() is a method that makes the thread wait some amount of milliseconds between iterations
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Exception Caught!");
			}
			
		}
		
		//so we know when the thread ends
		System.out.println(Thread.currentThread().getName() + " is finished******");
		
	}
	
	
}
