package com.revature.models;

//This Class models the employees table in our database
public class Employee {

	//variables for the employee class - must match the employees table in the database
	//note the private variables, private coupled with getters and setters (see below) are how we achieve ENCAPSULATION
	private int employee_id;
	private String first_name;
	private String last_name;
	//Every Employee in this application will have a role associated with it
	private Role role; //in other words, every EMPLOYEE has a ROLE

	
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
	public Employee(int employee_id, String first_name, String last_name, Role role) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
	}

	//We need an "all args minus id" constructor because the id is handled on the database side
	//when inserting data into a database, we should give objects with no id since the database gives each record an id
	public Employee(String first_name, String last_name, Role role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
	}
	
	//the toString() method lets us actually print out our objects, since it would print a memory address otherwise
	//(source -> generate toString)
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", role=" + role + "]";
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	} 
	
}
