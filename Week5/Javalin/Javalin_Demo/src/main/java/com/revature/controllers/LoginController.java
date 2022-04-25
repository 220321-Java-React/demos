package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginResponse;
import com.revature.models.UserLogin;
import com.revature.service.LoginService;

import io.javalin.http.Handler;

public class LoginController {
	
	// We generate the login service object to handle business logic
	LoginService ls = new LoginService();	
	
	public Handler loginHandler = (ctx) -> {
		// In our HTTP request, we have a body that contains
		// The data for the request
		String body = ctx.body();
		
		// This is GSON, our json parser
		Gson gson = new Gson();
		
		// GSON turns the body string into an object of the class you provide
		UserLogin lDTO = gson.fromJson(body, UserLogin.class);
		
		// We now use the Login Response object to represent a potential response to the front end
		LoginResponse lr = ls.loginValidation(lDTO.getUsername(), lDTO.getPassword());
		
		// This a null check to see if it was a successful response
		if(lr != null) {
			
			ctx.req.getSession(); // This activates the session for the current
			// logged in user
			
			ctx.status(200); // Status code of success, this tells the browser
			// That it was a successful login
			// Convert the Java object of Login response to a JSON string
			ctx.result(gson.toJson(lr));
			
		}else {
			
			// This is if login validation returned false
			ctx.status(401); // Unauthorized status code
			ctx.result(gson.toJson(null));
		}
		
	};
	
	
	public Handler createLoginHandler;
	
	public Handler updateLoginHandler;
	
}
