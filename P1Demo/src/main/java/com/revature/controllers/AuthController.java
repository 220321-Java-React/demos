package com.revature.controllers;

import com.google.gson.Gson;

import io.javalin.http.Handler;

public class AuthController {

	//we need an AuthService object to use it's method
	
	//we need a loginHandler to handle login requests (which come to app.post("/login", xxx)
	public Handler loginHandler = (ctx) -> {
		
		//with POST requests, we have some data coming in, which we access with ctx.body();
		//body??? it means the BODY of the request... which is just the data the user sent.
		String body = ctx.body();
		
		//create a new GSON object to make Java <-> JSON conversions.
		Gson gson = new Gson();
		
		//turn that JSON String directly into a LoginDTO object
		
		
		
	};
	
	
}
