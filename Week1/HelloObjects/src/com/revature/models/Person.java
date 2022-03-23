package com.revature.models;

//This is a class meant to model a Person - you can think of it like a template/blueprint for all object that are People
//It defines all the fields (variables) and methods (behvaiors) that I want a Person to have

public class Person {

	//declaring some Person variables, we'll give them values using the Constructors below.
	public String name;
	public int weight;
	public int age;
	
	//declare a method for the Person class
	
	//This method will return a String with the "return" keyword, and take in a String to create what the Person says
	public String talk(String words) {
		return "Person says: " + words;
	}
	
	//Some constructors below----------------------------------
	
	//Remember, constructors are special methods that let us instantiate an object
	//In other words, we provide initial values to the object's variables (hence why say initialize)
	
	//Contructors have no return types
	
	//no-args constructor 
	//If you create a new Person objects without arguments (no args), this no-args constructor will be called
	//Thus, giving our new Person object these default values
	public Person() {
		this.name = "Tyler";
		this.weight = 160;
		this.age = 32;
	}
	
}
