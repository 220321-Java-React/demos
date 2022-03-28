package com.revature.models;

//This is an abstract class, note the abstract keyword. It will also implement our Growable Interface
//So now, this abstract class also has access to the variables and methods in Growable
public abstract class Fruit implements Growable {
	
	//abstract classes can have variables
	public String name;
	public String color;
	
	//abstract classes can have concrete methods
	public void getEaten() {
		System.out.println(name + " got eaten nom nom");
	}
	
	//abstract method - must be declared abstract as well
	public abstract String getThrown(); //remember, abstract methods have NO METHOD BODY
	
//two constructors (remember, we can't instantiate abstract classes, but the child class will inherit these constructors)
	
	//no-args constructor, it takes no arguments (source -> constructor from superclass)
	public Fruit() {
		super();
	}

	//all-args constructor, it takes all variables in the class (source -> constructor from fields)
	public Fruit(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}
	
}
