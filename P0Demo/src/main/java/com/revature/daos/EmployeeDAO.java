package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Employee;
import com.revature.models.Role;

//DAO stands for Data Access Object - it's the layer of classes that directly interact with our database
//EVENTUALLY (not yet) we'll have a bunch of methods here that send SQL statements to our database
//In order to insert/manipulate/delete/view the data in the database

//PLEASE NOTE OUR ACTUAL DAO WILL LOOK VERY DIFFERENT FROM THIS
public class EmployeeDAO implements EmployeeDAOInterface{

	//For now, I'll have an ArrayList of Employee objects, which will act as our fake database
	ArrayList<Employee> employeeList = new ArrayList<>();
	
	//Instantiate some Role Objects to use in our Employee objects
	//(Because every Employee has a Role Object... check the variables in Employee class if you're confused)
	Role cashier = new Role(1, "Cashier", 50000);
	Role frycook = new Role(2, "Frycook", 70000);

	
	//This TEMPORARY method will return the employees from the database
	//In the future, this method body will actually be communicating directly to the database
	public ArrayList<Employee> getEmployees(){
		
		//first, fill the ArrayList with some data
		//we're using the all-args constructor which takes in an id, firstname, lastname, and a Role object
		employeeList.add(new Employee(1, "Spongebob", "Squarepants", frycook));
		employeeList.add(new Employee(2, "Squidward", "Tentacles", cashier));
		
		return employeeList;
		
	}

	//Ben will flesh out these methods whenever we get back to P0 demo, probably when we actually know database comms 

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Employee> getEmployeesByRole(String title) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
