package com.revature;

//Importing the Person Class, so that we can make objects of type Person, and access its members (variables/methods)
import com.revature.models.Person;
import com.revature.models.Pirate;
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
		
		tyler.name = "newName"; //we can also change the values of this Person object
		
		//Instantiate a new Person object, using the all-args constructor (since we give it all arguments)
		Person perry = new Person("Perry", 160, 31);
		
		//Let's print out the fields of this new Person object
		System.out.println(perry.name);
		System.out.println(perry.weight);
		System.out.println(perry.age);
		
		System.out.println("=============================(Using the Methods)");
		
		//Let's use the talk() method of the Person Class
		System.out.println(tyler.talk("Hi I'm Tyler"));
		
		//Instantiate a new Pirate object using the all-args constructor
		Pirate blackBeard = new Pirate("BlackBeard", 200, 50, 2);
		
		//Using the swordFight method of the Pirate class
		System.out.println(blackBeard.swordFight());
		
		
		
	}
	
}
