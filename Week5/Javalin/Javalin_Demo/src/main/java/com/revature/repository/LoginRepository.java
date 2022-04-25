package com.revature.repository;
import com.revature.repository.entities.LoginEntity;

public class LoginRepository {
	// This is the DAO layer
	// We would have CRUD Methods
	// I will fake the Read method, this should made with JDBC
	public LoginEntity getLogin(String username) {
		// As I am not implementing JDBC, I will fake a successful return
		// This method is just conditional logic simulating our JDBC get login
		// If the proivded username matches the username in the DB then we will
		// Get a representation of that table entity in our Java
		if(username.equals("user1")) {
			// This entity is represented via LoginEntity
			return new LoginEntity(1, "user1", "pass1", "Bobby");
		}else {
			// If it does not exist then we return a null
			return null;
		}
	}
}
