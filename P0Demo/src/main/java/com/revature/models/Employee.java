package com.revature.models;

//This Class models the employees table in our database
public class Employee {

	//variables for the employee class - must match the employees table in the database
	//note the private variables, private coupled with getters and setters (see below) are how we achieve ENCAPSULATION
	private int employee_id;
	private String first_name;
	private String last_name;

	
	//this class won't have any methods, we just need it to represent (aka MODEL) some data
	
	//boilerplate code below------------------------------
	//boilerplate code is any code that you'll probably write over and over again
	//most classes that we make objects of will have constructors, getters/setters, toString
	//so java makes this easy for us with the source tab 
	
	//remember all of this can be generated with the source tab
	
	//no args constuctor (source -> constructor from superclass)
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor (source -> constructor from fields)
	public Employee(int employee_id, String first_name, String last_name) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	//BEN WILL ALSO MAKE A CONSTRUCTOR WITH ALL ARGS MINUS ID (so that we can insert new users)
	
	//the toString() method lets us actually print out our objects, since it would print a memory address otherwise
	//(source -> generate toString)
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name + "]";
	}

	
	//getters and setters allow you to access and change your private variables... ENCAPSULATION
	//(source -> generate getters and setters, make sure to check all the boxes)
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	} 
	
	
}
