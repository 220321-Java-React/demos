package com.revature;

import java.util.ArrayList;

import com.revature.models.Pokemon;

//BEN WILL WRITE SOME GENERAL COMMENTS ABOUT COLLECTIONS UP HERE

//Collections are like Arrays in that they are objects that data BUT there are quite a few differences
//Collections can only hold objects (we'll talk more about wrapper classes)

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
		myPokemonList.add(new Pokemon("Pikachu", "Electric"));
		
		//we can print out an ArrayList thanks to the toString() method in the Pokemon Class
		System.out.println(myPokemonList);
		
	}
	
}
