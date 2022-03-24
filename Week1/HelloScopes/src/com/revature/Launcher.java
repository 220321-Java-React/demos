package com.revature;

public class Launcher {

	//This is a Class scoped primitive variable, note the "static", which makes it Class/Static (it belongs to the Class)
	//We will immediately assign the value 5 during declaration (In other words, we're initializing the variable)
	public static int i = 5;
	
	//Another Class scoped primitive variable, this one will not be given a value at declaration (It's UNinitialized)
	public static int i2; //uninitialized ints will default to 0;
	
	//This is a Class scoped reference variable
	public static Launcher launcher; //uninitialized reference variables (objects) will default to null.
	//Launcher is the data type (this is an instance of the Launcher Class, not the Launcher Class itself)
	
	//This is an instance scoped variable - note no "static" modifier
	double dub = 5.2; //it's initialized so all objects of the Launcher Class will start with dub being equal to 5.2
	
	//Each instance (object) of the Launcher Class will have its own specific value for the dub variable (instance scoped)
	//Each instance (object) of the Launcher Class will share a value for i and i2 (class scoped)
	
	//If you change the value of a static variable, that change will happen to all objects of that class.
	//If you change the value of a non-static variable, that change will only occur for the object you changed it in. 
	
	public static void main(String[] args) {
		
		System.out.println("===============================(Class & Instance Scoped Variables)");
		
		System.out.println(i); //should be 5 - it's been initialized
		System.out.println(i2); //should be 0 - it's uninitialized and defaults to 0
		
		//System.out.println(dub); 
		//a static method cannot access non-static members
		
		//static variables belong to the class, so they can be accessed by other static members (like this method)
		//instance variables belong to INSTANCES of the class (objects), so they aren't visible to static members
		
		//initializing the previously uninitialized primitive variable
		i2 = -98;
		
		//initializing the previously uninitialized reference variable
		launcher = new Launcher();
		
		System.out.println(i2); //this primitive has been changed to -98
		System.out.println(launcher); //reference variables store the location in memory (memory address)
		
		//The static launcher variable is an object of the Launcher class
		//so with this object, we can access the instance scoped dub variable
		System.out.println(launcher.dub);
		//Calling static objects with non-static variables is a way to access non-statics from within static methods
		
		//we can change the dub variable too, since we initialized a Launcher object
		launcher.dub = 500.97;
		
		System.out.println(launcher.dub); //printing it out to show that it's changed
		
		System.out.println("============================(Making a new Launcher object)");
		
		Launcher launcher2 = new Launcher();
		//launcher and launcher2 are the same data type (Launcher), but they are two different objects
		
		launcher2.dub = 1234; //giving launcher2 a new value for the nonstatic dub variable
		
		//dub is instance scoped, (nonstatic) 
		//so we can change the value of dub for launcher and launcher2, without affecting the other
		System.out.println(launcher.dub);
		System.out.println(launcher2.dub);
		
		launcher2.i2 = 5000; //giving launcher2 a new value for the static i2 variable
		
		//i2 is class scoped, (static)
		//so any changes to i2 will be reflected amongst every Launcher object
		System.out.println(launcher.i2);
		System.out.println(launcher2.i2);
		
		System.out.println("==================================(Method/Block Scopes)");
		
		//call the example() method below, giving it a value of true
		example(true);
		
	} //end of main method

	public static void example(boolean bool) {
		
		double d = 25.50; //this is a method scoped variable - only visible within the method body
		//the "bool" argument is also method scoped
		
		if(bool) {
			
			double d2 = 39.90; //this is a block scoped variable - only visible within the "if" block
			
			System.out.println("Block Scoped Variable: " + d2);
			
			System.out.println("Method Scoped Variable: " + d); //this is visible since it's in the same method as the if
			//method-scoped d is still visible within the if, since the if is inside the method
		}
		
		//System.out.println(d2); 
		//d2 is only visible within the if block, so we can't see it here.
		
	}
	
} //end of class
