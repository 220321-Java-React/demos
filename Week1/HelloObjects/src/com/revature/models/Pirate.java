package com.revature.models;

//Pirate extends Person!! So what? First of all, this is the primary example of Inheritance (Pillar of OOP)
//This means that the Pirate class inherits all of the variables and methods of the Person class
//BUT, it can also have its own variables and methods unique to the Pirate class
//Pirate is therefore a child class of Person. (Child/Parent relationship) (Subclass/Superclass relationship)
public class Pirate extends Person {

	//Pirate has all the variables of the Person class, as well as this variable unique to pirates
	public int peglegs;
	
	//Pirate has the talk() method of the Person class, as well as this method unique to pirates
	public String swordFight() {
		return "Pirate chopped ya head off";
	}

	
	//Method Overriding below---------- Note the @Override annotation, which indicates an overridden method
	
	//Without Overriding, the Pirate Class would have the exact same talk() method as the Person Class...
	//But here, we declare the same method signature, with a different implementation (aka method body)
	//Why do we do this? So that the Pirate Class can have it's own specific functionality for the talk() method
	@Override 
	public String talk(String words) {
		return "Pirate says: " + words;
	}
	
	
	//Making a no-args and all-args constructors-----------
	
	//Constructors are a great example of METHOD OVERLOADING - methods with the same name, but different arguments
	
	public Pirate() {
		super(); //This call to super() will call the no-args constructor of the parent class (Person)
		this.peglegs = 8; //(he's an octopus-person hybrid)
	}

	public Pirate(String name, int weight, int age, int peglegs) {
		super(name, weight, age); //calls the all-args constructor of Person
		this.peglegs = peglegs;
	}
	
}
