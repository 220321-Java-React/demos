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

	
	//Method Overriding below---------------------
	
	
	
	//Making a no-args and all-args constructors-----------
	
	public Pirate() {
		super(); //This call to super() will call the no-args constructor of the parent class (Person)
		this.peglegs = 8; //(he's an octopus-person hybrid)
	}

	public Pirate(String name, int weight, int age, int peglegs) {
		super(name, weight, age); //calls the all-args constructor of Person
		this.peglegs = peglegs;
	}
	
}
