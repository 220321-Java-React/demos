package com.revature.exceptions;

//This is a checked exception (aka compile time exception), so we have to extend Exception
@SuppressWarnings("serial")
public class MyCheckedException extends Exception {

	//constructor - This constuctor is calling the super constructor from Exception... 
		//which is actually calling the super constructor from Throwable
	public MyCheckedException(String message) {
		super(message); //remember super calls the SUPER constructor
	}
	
	//So the whole point of this constructor is to return an Exception message (stack trace) when it gets thrown
	
}
