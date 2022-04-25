package com.revature.service;

import com.revature.repository.entities.LoginEntity;
import com.revature.models.LoginResponse;
import com.revature.repository.LoginRepository;

public class LoginService {
	// I will be hard coding in the Username and Password
	// You will need to implement the DB aspect using your JDBC and Repo
	
	// We use the Service to implement business logic
	// This includes any processing, validation, reformatting
	
	// This is the login repo that will get the required data for us in the database
	// Do not interact directly from here to the SQL database, we have a separation
	// of concerns
	private LoginRepository loginRepository;
	
	public LoginService() {
		this.loginRepository = new LoginRepository();
	}
	
	public LoginResponse loginValidation(String username, String password) {
		// This method will validate the login
		// We use the loginRepository to get the login via its unique username
		// The loginEntity is a representation of the table that will contain the login
		// data for our users
		LoginEntity loginEntity = loginRepository.getLogin(username);
		
		// We check now that the user inputted password and the password in the DB matches
		// Do this in the service layer not in DB because you can then provide additional
		// functionality for more nauanced situations
		// This check will throw a nullpointer exception on a failed retrieval
		// Implement a null check before checking password
		if(loginEntity.getPass().equals(password)) {
			return new LoginResponse(loginEntity.getUsername(), loginEntity.getName());
		}else {
			return null;
		}
	}
}
