package com.revature.models;

public class Pokemon {

	//variables for the Pokemon class
	//BEN WILL REMEMBER TO MAKE THESE PRIVATE FOR ENCAPSULATION********************************************
	public String name;
	public String type;
	
	
	//one method
	public void fight() {
		System.out.println(name + " attacked");
	}

	
	//boilerplate code--------------
	//boilerplate code is code that you'll typically find in a Class
	//this includes methods like constructors, getters/setters, hashcode/equals, toString
	
	//Java makes generating these very easy!! Check the source tab.
	
	//no args constructor (source -> generate constructor from superclass)
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor (source -> generate constructor using fields)
	public Pokemon(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}


	//the toString() method lets you do String-like stuff with your object, like print them out.
	//otherwise you'd just get the memory address printed out... Which isn't helpful to us
	//(source -> generate toString)
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + "]";
	}
	
	
}
