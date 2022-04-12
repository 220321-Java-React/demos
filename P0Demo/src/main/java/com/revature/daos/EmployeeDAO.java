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

	
	//This TEMPORARY method will return the employees from the database
	//In the future, this method body will actually be communicating directly to the database
	public ArrayList<Employee> getEmployees(){
		
		//will fill this out with proper JDBC logic :)
		
		return null;
		
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
		String sql = "insert into employees (first_name, last_name, role_id_fk)"
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
		ps.executeUpdate();
		
		//Tell the user the insert was successful
		System.out.println("Employee " + employee.getFirst_name() + " added. Welcome aboard agagagagaga!");
			
		} catch (SQLException e) {
			System.out.println("Something went wrong inserting Employee!");
			e.printStackTrace();
		}
		
	} 


	@Override
	public void removeEmployee(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//SQL String that we want to send to the DB
			String sql = "delete from employees where employee_id = ?;";
			
			//instantiate our PreparedStatement to fill in the variable
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			//ps.executeUpdate() to send our delete to the DB
			ps.executeUpdate();
			
			//let the user know that the dreams of their former employee have been crushed
			System.out.println("Get outta here, employee #" + id);
			
		} catch (SQLException e) {
			System.out.println("YOU CAN'T FIRE ME MY FATHER WILL SUE");
			e.printStackTrace();
		}
		
	}
	
}
