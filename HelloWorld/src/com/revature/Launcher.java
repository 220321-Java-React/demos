//This is a comment

//This is a package declaration
//package declarations must be the first line of Class, unless it's a comment of course
package com.revature;

//This is a class declaration
public class Launcher {

	//This is our main method - the entry point of our application
	//The opening line of a method is called a method signature. This is a typical main method signature
	public static void main(String[] args) {
		
		//The code inside a method (inside the curly braces) is called the method body
		
		//This is a print statement - it PRINTS a message to your console.
		//Whatever you write in the print statement will get printed to the console below
		System.out.println("Hello World! Hello Java! be nice to me");
		
		//if you want something like double quotes within double quotes, use \backslashes\
		System.out.println("I typed \"syso\" + ctrl + space to autogenerate this print statement");
		
		//call exampleMethod, and give it some values
		exampleMethod(4, 5);
		
		//exampleMethod above will run, but we won't get anything back if we don't PRINT it.
		System.out.println(exampleMethod(13, 45));
		
		//we could declare a variable, that saves the int returned from exampleMethod
		int i = exampleMethod(7, 15);
		
		//variables are always declared like: datatype variableName = value
		//for example: String s = "hi";
		
		//since exampleMethod returns an int, we can store and print it from an int variable
		System.out.println(i);
		
	}
	
	//Here's an example method, check the notes for method anatomy
	public static int exampleMethod(int a, int b) {
		return a + b;
	}
	
	static String hi = "hi";
	
	public static void changeHi(String s) {
		hi = s;
	}
	
	
	
	
}
