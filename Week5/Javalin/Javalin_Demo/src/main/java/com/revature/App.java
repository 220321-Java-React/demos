package com.revature;

import com.revature.controllers.LoginController;

import io.javalin.Javalin;

public class App {
	public static void main(String args[]) {
		
		// Inside App we provide controllers that handle our endpoint functionalities
		LoginController lc = new LoginController();
		
		// This will be where we start our server
		Javalin app = Javalin.create(
				config -> {
					// We enable cors to allow us to send data back and forth between our external server
					config.enableCorsForAllOrigins();
				}
				).start(9898); // We start on port 9898
		
		// Setting an end point that will return a Hello World
		// Plain text for the domain name
		// In this example the domain name is http://localhost:9898
		app.get("/", ctx -> ctx.result("Hello World"));
		
		app.get("/greet", ctx -> {
			ctx.res.getWriter().write("Hello there from javalin");
		});
		
		// We are now using the Login Controller class to handle any requests
		// Based around logging into our web application
		app.post("/login", lc.loginHandler);
		
	}
}
