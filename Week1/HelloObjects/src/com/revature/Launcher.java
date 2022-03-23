package com.revature;

//Importing the Person Class, so that we can make objects of type Person, and access its members (variables/methods)
import com.revature.models.Person;
//If Person was in the com.revauture package, we wouldn't need to import. But they're in different packages


public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("==============================(Using our Constructors)");
		
		//Instantiate a new Person object, using the no-args constructor (since we give it no arguments)
		Person tyler = new Person();
		//Is this a reference variable or a primitive? Reference variable!! Because it's REFERENCING an object
		
		//Let's print out the fields of our new Person object
		System.out.println(tyler.name); //Tyler
		System.out.println(tyler.weight); //160
		System.out.println(tyler.age); //32
		
		System.out.println("=============================(Using the Methods)");
		
		//Let's use the talk() method of the Person Class
		System.out.println(tyler.talk("Hi I'm Tyler"));
		
	}
	
}
