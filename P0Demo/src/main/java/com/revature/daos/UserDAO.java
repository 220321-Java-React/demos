package com.revature.daos;

//This is a (sort of fake) DAO class that deals with user data
//In P0, you should have a user table that keeps track of users and their password
//But here, I'm going to hardcode a "correct" username and password
//You will have to figure out how to check the user inputted credentials against the database
public class UserDAO {
	
	//This method will return true in the case of successful login, otherwise it will return false
	public boolean login(String username, String password) {
		
		if(username.equals("user") && password.equals("password")) {
			return true;
		}
		
		return false;
		
	}
	
	//Ok Ben hardcoded the credentials... thanks a lot...
	//How might I go about actually checking the DB for username/password?
	
	//You'll need a table of users that store usernames and passwords
	//This DAO method should use the inputted username and password in a select statement
	//Might I suggest select * from users where username = ? and password = ?;
	//If a record comes back, there IS a username and password matching what the user sent in
	//If "null" comes back, there is no username and password pair matching what the user sent in
	
}
