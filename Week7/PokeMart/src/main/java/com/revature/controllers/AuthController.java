package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;

import io.javalin.http.Handler;

public class AuthController {

	public Handler loginHandler = (ctx) -> {
		
		//Taking in the data sent from the front end (login credentials) and putting them in a String
		String loginCreds = ctx.body();
		
		//needed to make JSON <-> Java conversions
		Gson gson = new Gson();
		
		//make a new LoginDTO Class based on the data sent by the user
		LoginDTO lDTO = gson.fromJson(loginCreds, LoginDTO.class);
		
		if(lDTO.username.equals("trainer") && lDTO.password.equals("password")) {
		
		//we're hardcoding the user id here, but if done with a DB, the user's ID will definitely be populated normally
		lDTO.id = 1; //no setter needed, we made the variables of LoginDTO public (bad practice)
		
		//we use toJson to take Java and turn it into a JSON object (to send to the front end)
		String loginJSON = gson.toJson(lDTO);
		
		//ctx.status lets us set a status code
		ctx.status(202);
		//ctx.result sends stuff back to the front end
		ctx.result(loginJSON);
		
		} else {
			ctx.status(401); //401 stands for forbidden
		}
		
	};
	
}
