package com.revature.exceptions;

//Unchecked Exceptions AKA Runtime Exceptions must extend RuntimeException
//Check the class hierarchy in the notes if you need a visual reference
public class MyUncheckedException extends RuntimeException {

	//constructor
	
	//similar to our CheckedException, this constructor will let us display a stack trace (Error message)
	
	public MyUncheckedException(String message) {
		super(message); 
		//This super() is calling the constructor from RuntimeException, which calls Exception, which calls Throwable
	}
	
}