package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.PokemonDAO;
import com.revature.models.Pokemon;

@RestController //This annotation combines @Controller and @ResponseBody
	//so this class is now a Bean that can use MVC annotations and send JSON responses
@RequestMapping(value="/pokemon") //any request coming in that ends in /pokemon will go to this controller
public class PokemonController {

	//I just need to autowire the DAO class to this class
	//Like in the last mvc demo, we'll skip the service layer just for the sake of time
	private PokemonDAO pDAO;

	//constructor injection - now, PokemonController will automagically have a PokemonDAO associated with it. 
	@Autowired
	public PokemonController(PokemonDAO pDAO) {
		super();
		this.pDAO = pDAO;
	}
	
	//BEN WILL GO BACK TO THE NOTES ABOUT RESTTEMPLATE
	
	//MVC Methods below (to handle HTTP requests)--------------------------------
	
	//every POST request ending in /pokemon will go here
	//thanks to @RequestBody we can take in Pokemon JSON data and turn it into Pokemon object
	@PostMapping
	public ResponseEntity addPokemon(@RequestBody Pokemon p) {
		
		//the save() method from our DAO is how we do INSERTs
		pDAO.save(p);
		
		//send back a response with status code 201 (Accepted) and no data 
		//.build() is how we send back responses with no data... .body() would let us send some data back
		return ResponseEntity.status(201).build();
		
	}
	
	//every GET request ending in /pokemon will go here
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAllPokemon(){
		
		//the .ok() method returns a 200 status code for us, and lets us include a reponse body 
		return ResponseEntity.ok(pDAO.findAll());
		
		//This would also work! But would be a little more code/method chaining than necessary
		//return ResponseEntity.status(200).body(pDAO.findAll());
		
	}
	
	//every GET request ending in /pokemon/id/{some number} will go here
	//the number given as a URL endpoint will be the parameter in this method, hence @PathVariable
	@GetMapping(value = "/id/{id}") //the number the user sends in will be assigned to that int id in the parameters
	public ResponseEntity<Pokemon> findById(@PathVariable int id){
		
		//findById returns an OPTIONAL
		//Optionals lend to code flexibility because it may or may not have the object requested. It may be null.
		//we get the contents of an Optional with .get();
		Pokemon p = pDAO.findById(id).get(); //create a Pokemon object from pDAO.getById()
		
		return ResponseEntity.ok(p); //send the new Pokemon object back with a 200 status code (OK)
		
		//getById might be trickier to use, fetchtype seems to mess with it.. So stick with findById for now :)
		
	}
	
	
	//All requests coming in that end in pokemon/name/{some string} will go here
	//This method will call the DAO method we had to create ourselves
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<List<Pokemon>> findByName(@PathVariable String name){
		
		//Optional to hold either a null (if the name isn't found) or a Pokemon List (if the name is found)
		Optional<List<Pokemon>> pokemonOptional = pDAO.findByName(name);
		
		//empty List to be populated if the Optional is not null
		List<Pokemon> pokeList;
		
		if(pokemonOptional.isPresent()) { //isPresent() checks if the Optional has data in it, returns true if so
			pokeList = pokemonOptional.get(); //remember .get() retrieves the data out of the Optional
			return ResponseEntity.ok(pokeList);
		} else {
			return ResponseEntity.noContent().build(); //send back an empty body with a "no content" status code
			//no content because the HTTP Request WAS technically successful, but there was no data there
		}
		
	}
	
	
	//RESTTEMPLATE METHOD :)
	
}
