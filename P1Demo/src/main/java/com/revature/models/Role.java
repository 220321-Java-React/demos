package com.revature.models;

public class Role {

	private int role_id;
	private String role_title;
	private int role_salary;

	
	//boilerplate code below------------------------------------------
	
	//no args constructor
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Role(int role_id, String role_title, int role_salary) {
		super();
		this.role_id = role_id;
		this.role_title = role_title;
		this.role_salary = role_salary;
	}
	
	//when dealing with JDBC (Java DataBase Connectivity) applications, we like to make "all-args minus id" constructors
	//these will come in handy when we need to insert more data, because ID is handled on the database side.
	public Role(String role_title, int role_salary) {
		super();
		this.role_title = role_title;
		this.role_salary = role_salary;
	}
	

	//toString() is an important method because it allows us to print objects and their variables as a String
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_title=" + role_title + ", role_salary=" + role_salary + "]";
	}


	//we need getters and setters to make our private variables visible - ENCAPSULATION
	public int getRole_id() {
		return role_id;
	}


	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}


	public String getRole_title() {
		return role_title;
	}


	public void setRole_title(String role_title) {
		this.role_title = role_title;
	}


	public int getRole_salary() {
		return role_salary;
	}


	public void setRole_salary(int role_salary) {
		this.role_salary = role_salary;
	}
	
	
}
