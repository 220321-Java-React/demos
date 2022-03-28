package com.revature;

import com.revature.models.Berry;

public class Launcher {

	public static void main(String[] args) {
		
		//instantiate a new Berry object
		Berry strawberry = new Berry("Strawberry", "Red");
		
		//concrete getEaten() method from Fruit
		strawberry.getEaten();
		
		//Overridden method from the Growable Interface
		strawberry.grow(90);
		
		//Overridden method from the Fruit Abstract Class
		//it returns a string so we need to put it in a print statement
		System.out.println(strawberry.getThrown());
		
		//we can also directly access the variables found in the abstract class and interface
		System.out.println(strawberry.color);
		System.out.println(strawberry.name);
		System.out.println(Berry.unitOfTime); //unitOfTime of static so technically we should call it from the Berry class
		
	}
	
}
