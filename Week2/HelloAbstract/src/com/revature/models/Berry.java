package com.revature.models;

//The concrete class Berry extends the abstract class Fruit
//Think of it as a more specific implementation of the more generic Fruit type
//The Fruit abstract class implements the Growable interface... so Berry inherits Growable's members as well. 
public class Berry extends Fruit {

	//This method is coming from the Growable Interface... concrete classes must implement inherited abstract methods
	@Override
	public void grow(int days) {
		//name is from the Fruit Class, days is coming from the method parameter, unitOfTime is coming from Growable
		System.out.println(name + " grew in " + days + ' ' + unitOfTime);
	}

	//This method is coming from the Fruit Abstract Class... concrete classes must implement inherited abstract methods
	@Override
	public String getThrown() {
		//name and color are both coming from Fruit
		return name + " got thrown and left a " + color + " stain";
	}

	
	//Two constructors, so we can actually create Berry objects in our Launcher
	
	//I got both of these using (source -> generate constructor from Super Class)
		//Recall that these same two constructors exist in Fruit, which is the Super Class of Berry
	
	//no args construtor from the Fruit Class
	public Berry() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor from the Fruit Class
	public Berry(String name, String color) {
		super(name, color);
		// TODO Auto-generated constructor stub
	}
	
}
