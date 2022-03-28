package com.revature.models;

//This is an Interface, which contains fields and abstract methods
//It's common practice to give Interfaces verb-like names that describe what they do
public interface Growable {
	
	//Interface variables are public, static, final by default. We don't have to explicitly state those modifiers.
	String unitOfTime = "days";
	
	//Abstract method - no method body! AKA no implementation. public abstract by default.
	void grow(int days); //note the semicolon, not curly braces... it's an ABSTRACT METHOD with no method body
	
	//we could have concrete methods here if we used the "default" keyword, but we won't usually do that.
	
	
	/*
	default void someMethod() {
		SOME COODE WOULD GO HERE
	}
	*/
}
