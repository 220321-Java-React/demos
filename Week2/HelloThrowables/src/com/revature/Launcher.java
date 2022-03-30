package com.revature;

public class Launcher {
	
	public static void main(String[] args) {
		
		System.out.println("============================(Throwing some Built-in Exceptions)");
		
		System.out.println("Trying to divide by zero");
		
		//Declaring some variables to crash my code :(
		int i = 0;
		int i2 = 5;
		
		//This code will compile, ArithmeticException is a Runtime Exception, so the compiler isn't checking for it
		System.out.println(i2/i);
		
		
		
	}
	
}
