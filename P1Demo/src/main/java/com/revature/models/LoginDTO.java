package com.revature.models;

//What the HECK is a LoginDTO? Data Transfer Object. A DTO is just a model of some data coming in from the front end
//An HTTP handler will take in a JSON object sent in by the user, containing their username and password
//this then gets sent to the controller to get turned into this Java object (using Gson)
//the username and password the user sent in will be put into this DTO as variables, which we'll check in the AuthService
//You NEVER store a DTO in the database. It's purely for DATA TRANSFER... we're transferring the username/password
public class LoginDTO {

	//our LoginDTO models ONLY the username/password sent in by the user
	private String username;
	private String password;

	
	//I just want a no args and all args constructor, so we can instantiate LoginDTOs
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	//we need getters/setters to access our fields (encapsulation)
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	//so that we can actually print out this print this class out
	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", password=" + password + "]";
	}
	
	
}
