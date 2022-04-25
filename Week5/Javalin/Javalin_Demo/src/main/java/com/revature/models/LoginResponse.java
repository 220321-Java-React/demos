package com.revature.models;

import java.util.Objects;

// This class is representing a response on a successful login

public class LoginResponse {
	
	private String username;
	private String name;
	
	public LoginResponse(String username, String name) {
		super();
		this.username = username;
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LoginResponse other = (LoginResponse) obj;
		return Objects.equals(name, other.name) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "LoginResponse [username=" + username + ", name=" + name + "]";
	}
	

}
