package com.revature.services;

import com.revature.models.Employee;
import com.revature.models.Role;

//remember, I'm semi-hardcoding here. You'll need to get this employee data from the DAO & DB
public class AuthService {

	//Typically, you'll want to validate username/password here in the service... 
	//by calling some DAO method that gets employees where username = ? and password = ?
	
	public Employee login(String username, String password) {
		
		//we would call the DAO method here, and use its results in the if/else below
		//the DAO method would return whatever gets found in the DB (records with matching username/pass)
		
		//this is hardcoding - telling Java exactly what we want the username/password to be
		if(username.equals("user") && password.equals("password")) {
			
			//empty Role object (no args constructor) just for simplicity here
			Role role = new Role();
			
			return new Employee(10, "Sandy", "Cheeks", role);
		} else {
			return null;
		}
		
	}
	
}
