package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

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

	//Ben is leaving this unimplemented... Check RoleDAO for findById functionality
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
	public void insertEmployee(Employee employee, int role_id) {
	
		try(Connection conn = ConnectionUtil.getConnection()){
		
		//First we need our SQL String that represents the INSERT statement we'll send to the DB
		//Again, there are variables in this statement, that we can fill out thanks to PreparedStatement
		String sql = "insert into employees (first_name, last_name, role_id)"
				+ "values (?, ?, ?);";
				
		//Instantiate a PreparedStatement to fill in the variables of our initial SQL String
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//fill in the values of our variables using ps.setXYZ()
		ps.setString(1, employee.getFirst_name());
		ps.setString(2, employee.getLast_name());
		ps.setInt(3, role_id); 
		//note how the DB role_id is an int, but in Java, Employees have a Role OBJECT
		//this is my workaround of choice... have the user input the id of the desired role when inserting the user data
		
		//Execute the Update!! (the method is called executeUpdate(), but it's for INSERTS, UPDATES, and DELETES)
		ps.executeQuery();
		
		//Tell the user the insert was successful
		System.out.println("Employee " + employee.getFirst_name() + " added. Welcome aboard agagagagaga!");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong inserting Employee!");
			e.printStackTrace();
		}
		
	} 


	@Override
	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
