package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {

	//we need an AuthService object to use it's login method
	AuthService as = new AuthService();
	
	//we need a loginHandler to handle login requests (which come to app.post("/login", xxx)
	public Handler loginHandler = (ctx) -> {
		
		//with POST requests, we have some data coming in, which we access with ctx.body();
		//body??? it means the BODY of the request... which is just the data the user sent.
		String body = ctx.body();
		
		//create a new GSON object to make Java <-> JSON conversions.
		Gson gson = new Gson();
		
		//turn that JSON String directly into a LoginDTO object
		//remember, fromJson() is the method that takes JSON and turns it into some Java object
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		//control flow to determine what happens in the event of successful/unsuccessful login
		if(as.login(LDTO.getUsername(), LDTO.getPassword()) != null) {
			
			//if login is successful, create a user session so that they can access the application's functionalities
			ctx.req.getSession();
			
			//return a successful status code
			ctx.status(202); //202 stands for "accepted"
			
			//get our employee object as JSON
			//here, we're using .toJson() to take in the result of our successful login (which is an Employee object)
			String employeeJSON = gson.toJson(as.login(LDTO.getUsername(), LDTO.getPassword()));
			
			//send back our Employee JSON object
			ctx.result(employeeJSON);
			
		} else {
			ctx.status(401); //401 stands for "unauthorized"
			System.out.println("heyo login failed");
		}
		
		
	};
	
	
}
