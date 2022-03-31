package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import com.revature.models.Pokemon;

//Collections are like Arrays in that they are objects that hold data BUT there are quite a few differences
//Collections are DYNAMICALLY SIZED, which means we can change their size. We can't do that with Arrays.
//Collections can only hold references to objects (we'll talk more about wrapper classes)

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("=================================(Lists)");
		
		//ArrayList is a very common implementation of the List Interface
		//QC asked me the difference between ArrayLists and Lists
		
		//Making an ArrayList of Pokemon Objects
		ArrayList<Pokemon> myPokemonList = new ArrayList<>(); //empty ArrayList which we'll fill below
		
		//.add() method lets us add elements to our Lists 
		//so here, we're creating the object as we add it to the ArrayList. We could also have instantiated before adding
		myPokemonList.add(new Pokemon("Jolteon", "Electric"));
		myPokemonList.add(new Pokemon("Charmander", "Fire"));
		myPokemonList.add(new Pokemon("Gengar", "Ghost/Poison"));
		myPokemonList.add(new Pokemon("Rayquaza", "Dragon/Flying"));
		myPokemonList.add(new Pokemon("Ditto", "Normal"));
		myPokemonList.add(new Pokemon("Mudkip", "Water"));
		
		//.add(index) will add an object at a specific index 
		myPokemonList.add(0, new Pokemon("Pikachu", "Electric"));
		
		//we can print out an ArrayList thanks to the toString() method in the Pokemon Class
		System.out.println(myPokemonList);
		
		//BUT it'll be cleaner to use an enhanced for loop to iterate over the data structure
		//"For every Pokemon in the myPokemonList ArrayList, print out the Pokemon"
		for(Pokemon p : myPokemonList) {
			System.out.println(p);
		}
		
		//.get(index) is how we select elements at a certain index
		//here, we don't have the whole object so we can just call the name variable of the object after "get"ting it.
		System.out.println("The Pokemon at index 3 is: " + myPokemonList.get(3).name);
		
		//.size() is analogous to .length in Arrays, it returns an int of the size of the collection
		System.out.println("I have " + myPokemonList.size() + " Pokemon in my party");
		
		//we're going to do a forEach loop to make the Pokemon "fight"
		//forEach loops loop through Collections and perform a given action
		myPokemonList.forEach(pokemon -> pokemon.fight());
		//This arrow is called a lambda function, they're like a quick one-time use method.
		//What is "pokemon?" it's just the name we're giving to each object in the collection
			//we could have called it "p" or "tacos", but a more descriptive name is better practice
		
		//.remove() will remove a specific element given in the index
		myPokemonList.remove(4);
		myPokemonList.remove(2);
		
		//use a forEach loop to print out the remaining Pokemon
		myPokemonList.forEach(pokemon -> System.out.println(pokemon.name + " remains"));
		
		System.out.println("====================================(Sets)");
	
		//Instantiate an empty HashSet
		HashSet<Pokemon> myPokemonSet = new HashSet<>();
		
		//Make some Pokemon objects
		Pokemon totodile = new Pokemon("Totodile", "Water");
		Pokemon chansey = new Pokemon("Chansey", "Normal");
		Pokemon torchic = new Pokemon("Torchic", "Fire");
		Pokemon pidgey = new Pokemon("Pidgey", "Normal/Flying");
		
		//Add those Pokemon objects into our HashSet
		myPokemonSet.add(totodile);
		myPokemonSet.add(chansey);
		myPokemonSet.add(torchic);
		myPokemonSet.add(pidgey);
		myPokemonSet.add(pidgey); //Java will let you try to add a duplicate value here... but...
		
		//Notice how Sets have no particular order, unlike Lists
		//Also note how no duplicates are allowed
		for(Pokemon p : myPokemonSet) {
			System.out.println(p);
		}
		
		//.contains() returns a boolean of true if the Set contains the specified object
		if(myPokemonSet.contains(torchic)) {
			System.out.println("Torchic is in my party!");
		} else {
			System.out.println("No Torchics to be found...");
		}
		
		System.out.println(myPokemonSet);
		
		//Sets have no index... but if we use .iterator(), we can create an Iterator from that Sets values
		Iterator<Pokemon> iterator = myPokemonSet.iterator();
		
		//hasNext() checks to see if there are values as we iterate through a data structure. returns a boolean
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		//"While iterating though, if there is another value, do this code" (which in this case is just printing)
		//This iterator is NOT a HashSet, but it stole the values from our old HashSet.
		//Why would we use this over an ArrayList? tbh I wouldn't, I'd rather just use an ArrayList
		//Iterator is kind of like a long way of getting List-like behavior from a Set. You'll probs just want a List lol
		
		System.out.println("====================================(Queues)");
		
		//Instantiate a new LinkedList (which implements both List and Queue)
		LinkedList<Pokemon> pokemonLL = new LinkedList<>();
		
		//Add some Pokemon
		pokemonLL.add(new Pokemon("Wobbuffet", "Psychic"));
		pokemonLL.add(new Pokemon("Snorlax", "Normal"));
		pokemonLL.add(new Pokemon("Mew", "Psychic"));
		
		//Iterate through the LinkedList and print out the values using an enhanced for loop
		for(Pokemon p : pokemonLL) {
			System.out.println(p);
		}
		//Just like with Lists, Queues have a strict order
		
		//.peek() selects the first value
		System.out.println(pokemonLL.peek().name + " is the first Pokemon in the LinkedList");
		
		//.poll() selects and removes the first values
		System.out.println(pokemonLL.poll().name + " has left the chat...");
		
		//Print them out
		for(Pokemon p : pokemonLL) {
			System.out.println(p);
		}
		
		System.out.println("=====================================(Maps)");
		
		
		
	}
	
}
