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
		
		//System.out.println(tyler.swordFight());
		//Objects of type Person cannot call the Pirate-specific swordFight() method.
		//Pirate extends Person, so Pirate has everything Person has, but not the other way around
		
		//use the OVERRIDDEN talk() method of the Pirate class
		System.out.println(blackBeard.talk("ARGS"));
		
		System.out.println("==================================(Casting)");
		
		//using upcasting-----------------
		
		//a subclass-type object (Pirate) gets assigned to a superclass-type variable (Person)
		Person upcastedPerson = new Pirate();
		
		//this is legal and done implicitly by the compiler, because a Pirate will always be a Person
		
		//upcastedPerson.swordFight();
		//upcastedPerson.pegLegs;
		//upcastedPerson is of type Person... so the swordFight() method and pegLegs variable aren't visible
		
		System.out.println(upcastedPerson.talk("I'm visible because upcasting lets me be"));
		//upcastedPerson is of type Person, BUT the Pirate-specific version of talk() will be used. Because we upcasted!
		
		System.out.println(upcastedPerson.name);
		//upcastedPerson is of type Person, so all of the Person-specific variables are visible
		
		//so in summary, we have a kind of hybrid object that has all of Person's members, 
		//and only Pirate's overridden methods
		
		//using downcasting------------------------------------------
		
		//Pirate p = (Pirate) new Person();
		//This will compile, but error out at runtime - 
		//It's illegal because not all Persons are necessarily Pirates. Java doesn't know how to make this distinction
		
		//parent type reference variable assigned to a child class object (upcasting), THEN we can legally downcast
		Person p1 = new Pirate();
		Pirate p2 = (Pirate) p1; //legal downcasting. Basically turning an upcasted variable into the child class again
		
		System.out.println(p2.peglegs); //now we can access Pirate specific members again!!
		System.out.println(p2.swordFight());
		
		//this is really the only reason you'd downcast - to access child specific members that were hidden by an upcast
		
		//but if you really need Pirate members, just save yourself some steps and make a Pirate object in the first place
		
	}
	
}
