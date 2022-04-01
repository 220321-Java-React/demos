package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Employee;

//Ben will elaborate on DAO Classes when we actually get our databases working

//PLEASE NOTE OUR ACTUAL DAO WILL LOOK VERY DIFFERENT FROM THIS
public class EmployeeDAO {

	//For now, I'll have an ArrayList of Employee objects, which will act as our fake database
	ArrayList<Employee> employeeList = new ArrayList<>();
	
	//This TEMPORARY method will return the employees from the database
	public ArrayList<Employee> getEmployees(){
		
		//first, fill the ArrayList with some data
		employeeList.add(new Employee(1, "Spongebob", "Squarepants"));
		employeeList.add(new Employee(2, "Squidward", "Tentacles"));
		
		return employeeList;
		
	}
	
}
