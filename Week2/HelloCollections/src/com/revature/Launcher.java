package com.revature;

import java.util.ArrayList;

import com.revature.models.Pokemon;


//BEN WILL WRITE SOME GENERAL COMMENTS ABOUT COLLECTIONS UP HERE

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
		
		
		
		System.out.println("====================================(Queues)");
		
		
		
		System.out.println("=====================================(Maps)");
		
		
		
	}
	
}
