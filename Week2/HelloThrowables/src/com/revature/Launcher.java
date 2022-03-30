package com.revature;

import com.revature.exceptions.MyCheckedException;
import com.revature.exceptions.MyUncheckedException;

public class Launcher {
	
	public static void main(String[] args) throws MyCheckedException {
		
		System.out.println("============================(Throwing some Built-in Exceptions)");
		
		//We'll never purposefully get an exception thrown, we're writing bad code for science
		
		System.out.println("Trying to divide by zero");
		
		//Declaring some variables to crash my code :(
		int i = 0;
		int i2 = 5;
		
		//This code will compile, ArithmeticException is a Runtime Exception, so the compiler isn't checking for it
		//System.out.println(i2/i);
		
		System.out.println("Trying to access an Array index that doesn't exist");
		
		int[] numbers = {0, 1, 2};
		
		//This code will call index 3, but as we know this Array only has indexes 0-2
		//Thus, an ArrayIndexOutOfBoundsException will be thrown
		//System.out.println(numbers[3]);
		
		System.out.println("===========================(Catching our Custom Exceptions with Try/Catch)");
		
		//the compiler will let you call this method... but it'll end up crashing your application
		//this method throws an UNCHECKED aka RUNTIME exception... the application crashes at runtime.
		//throwUnchecked();
		
		//the compiler won't let you call this method... it's a CHECKED aka COMPILE TIME exception.
		//the compiler WILL let you run this if you add a throws declaration in the main method signature
		//but... again it'll crash our application
		//throwChecked();
		
		//Why oh why did we bother calling these methods to crash our application?
		//we usually won't, but I did it for science. 
		//Typically, we'll use try/catch/finally blocks. Observe:
		
		try { //try will TRY a block of code that may or may not throw an exception
			
			System.out.println("try block starting...");
			
			throwChecked(); //we throw a Checked Exception here, specifically MyCheckedException
			
			System.out.println("I won't print - once the Exception is throw, the rest of the try block is skipped");
			
		} catch (MyUncheckedException e) {
			
			System.out.println("Will I run? NO!!!! I'm only checking for MyUncheckedException");
			
		} catch (MyCheckedException e) {
			
			System.out.println("Hello from the catch block - MyCheckedException was caught!!");
			//this catch block runs! It it looking to catch MyCheckedException, which is what was thrown in the try block
		
		} catch (Exception e) {
			
			System.out.println("I could've caught any kind of Exception");
			
		} finally { //finally is an optional block that runs after the try completes or the catch catches an Exception.
			
			System.out.println("Hello from the finally block - I will always run!");
			
		}
		
		//It's best practice to write your catch blocks from most specific to most generic.
		//Very common to see the final catch block catch just a generic Exception, as a safety precaution
		
	}
	
	//Creating methods that throw our custom exceptions-------------------------------------------------
	
	//methods that throw Checked Exceptions must indicate it in the method signature (E.g. throws ____Exception)
	public static void throwChecked() throws MyCheckedException {
		
		System.out.println("I'm about to throw a checked exception!");
		
		//the throw keyword is how we manually throw exceptions
		//in this case, we're writing code that throws our custom Checked Exception
		//Remember, exceptions are OBJECTS (notice the "new" keyword), so we need to give an appropriate constructor
		throw new MyCheckedException("Our custom CHECKED exception was thrown"); 
		//MyCheckedException only has one constructor, which takes a String 	
	}
	
	//the compiler doesn't check for unchecked exceptions... 
	//hence the name. so we can compile without the throws declaration
	//but of course, running this method will still throw an exception and crash the program
	public static void throwUnchecked()  {
		
		System.out.println("I'm about to throw an unchecked exception!");
		
		throw new MyUncheckedException("Our custom UNCHECKED exception was thrown");
		
	}
	
}
