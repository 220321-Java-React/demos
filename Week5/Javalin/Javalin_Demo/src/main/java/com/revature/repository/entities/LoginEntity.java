package com.revature.repository.entities;

import java.util.Objects;

// This entity is used to match the table representation in sql
public class LoginEntity {
	
	private int login_id;
	private String username;
	private String pass;
	private String name;
	
	public LoginEntity(int login_id, String username, String pass, String name) {
		super();
		this.login_id = login_id;
		this.username = username;
		this.pass = pass;
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(login_id, name, pass, username);
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
		LoginEntity other = (LoginEntity) obj;
		return login_id == other.login_id && Objects.equals(name, other.name) && Objects.equals(pass, other.pass)
				&& Objects.equals(username, other.username);
	}
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "LoginEntity [login_id=" + login_id + ", username=" + username + ", pass=" + pass + ", name=" + name
				+ "]";
	}
	
	

	
}
