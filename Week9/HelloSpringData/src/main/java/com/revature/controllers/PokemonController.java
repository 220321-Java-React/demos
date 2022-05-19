package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	//RESTTEMPLATE METHOD :)
	
}
