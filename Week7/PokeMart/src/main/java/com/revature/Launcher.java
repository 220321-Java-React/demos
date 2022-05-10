package com.revature;

import com.revature.controllers.AuthController;

import io.javalin.Javalin;

public class Launcher {

	public static AuthController ac = new AuthController();
	
	public static void main(String[] args) {
		
		//Typical Javalin syntax to start up a Javalin Application
		Javalin app = Javalin.create(
				
				//the config lamda lets specify certain configs
				config -> {
					config.enableCorsForAllOrigins(); //this lets us take in any HTTP requests 
				}
				
				).start(5000); //we need this to start our application on port 5000
		
		//Javalin handler that takes post requests to url /login 
		app.post("/login", ac.loginHandler);
		
	}
	
}
