package com.revature.models;

import java.util.Objects;

// This is a plain old Java Object
// We will be using to represent a user login attempt
public class UserLogin {
	
	private String username;
	private String password;
	
	public UserLogin(String username, String password) {
		this.username = username;
		this.password = password;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
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
		UserLogin other = (UserLogin) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + "]";
	}
	
	
	
}
