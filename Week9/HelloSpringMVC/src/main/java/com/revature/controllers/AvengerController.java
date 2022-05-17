package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

@Controller //Makes the Class a Bean, and with MVC it lets us use all of the below annotations----
@RequestMapping(value="/avenger") //all requests ending in /mvc/avenger will go to this controller.
@CrossOrigin //this lets us take in HTTP requests from other origins (such as your front end)
@ResponseBody //This makes it so that every method in the Class will convert responses to JSON for us.
public class AvengerController {

	//skipping the service layer in this demo to focus on MVC
	public AvengerDAO aDAO;

	//We want a constructor with only the AvengerDAO so we can use constructor injection
	@Autowired
	public AvengerController(AvengerDAO aDAO) {
		super();
		this.aDAO = aDAO;
	}
	
	//Declaring some methods that can handle HTTP requests (no more javalin, no more main method/handlers)-------
	
	//get all avengers (this method gets called when the application gets a GET request to /avenger)
	@GetMapping
	public List<Avenger> assemble(){
		return Arrays.asList(aDAO.getAll()); //return the Avenger List to the frontend/postman. whatever called for it.
		//Arrays.asList is how we can cast an Array into a List object
	}
	
	//get Avenger by id (this method gets called when the application gets a GET request to /avenger/{some number}
	@GetMapping("/{id}") //here, we add a PATH VARIABLE to the GetMapping. which means Requests to /avenger/{some number}
	//@PathVariable will allow you to get the user-inputted path variable sent in with the URL (int id in this case)
	//Spring has an object called ResponseEntity that lets us set things like status code, and the response body.
	public ResponseEntity<Avenger> getAvengerById(@PathVariable("id") int id){
		
		//get an Avenger object with the id path parameter that the user sends in the GET request to /avenger/{number}
		Avenger avenger = aDAO.getById(id);
		
		//if getById fails...
		if(avenger == null) {
			//send back an empty body with a "no content" (204) status code
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(avenger);
			//.status() lets us set status code, and .body() is what sends the response body back to the client
		}
		
		//If the "if" doesn't run, send back the Avenger in the boyd of the response and an "OK" status code (200)
		return ResponseEntity.ok(avenger);
		//we can also use some shorthand methods! .ok() takes a body to send and sets status code to 200
		
	}
	
	//update an Avenger
	@PutMapping //any HTTP PUT request ending in /avenger will go here
	//@RequestBody converts JSON from the body of the request into an object we specify (Avenger in this case)
	public ResponseEntity<Avenger> updateAvenger(@RequestBody Avenger avenger){
		
		//if the update fails (if the avenger we update doesn't have a valid id)...
		if(avenger == null) {
			ResponseEntity.badRequest().body(avenger);
			//send back a response with status code bad request (400) and the null avenger 
		}
		
		//if Avenger update is successfull, use the update DAO method and send the new avenger back
		avenger = aDAO.update(avenger);
		
		return ResponseEntity.accepted().body(avenger);
		//send back a status code of accepted (202) and the the new avenger data
		
	}
	
	//What about @PostMapping? should be pretty straightforward to make a POST request
	//you'd simply get the data out of the @RequestBody and send it wherever it needs to go.
	
}