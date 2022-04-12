package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

//DAO stands for Data Access Object - it's the layer of classes that directly interact with our database
//EVENTUALLY (not yet) we'll have a bunch of methods here that send SQL statements to our database
//In order to insert/manipulate/delete/view the data in the database

//PLEASE NOTE OUR ACTUAL DAO WILL LOOK VERY DIFFERENT FROM THIS
public class EmployeeDAO implements EmployeeDAOInterface{

	//Instantiate a RoleDAO object so that we can use one of it's methods in the getEmployees() method
	RoleDAO rDAO = new RoleDAO();
	
	//This TEMPORARY method will return the employees from the database
	//In the future, this method body will actually be communicating directly to the database
	public ArrayList<Employee> getEmployees(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//a String that will represent our SQL statement
			String sql = "select * from employees;";
			
			//a Statement object to execute our query 
			Statement s = conn.createStatement();
			
			//execute our query into a ResultSet object, which will hold all the data 
			//executeQuery() is what actually queries the database! Then we put the records into a ResultSet
			ResultSet rs = s.executeQuery(sql);
			
			//Instantiate an ArrayList to put our Employee objects into
			ArrayList<Employee> employeeList = new ArrayList<>();
			
			//use rs.next() in a while loop to create Employee objects and populate our ArrayList with them.
			//remember, the ResultSet is what's holding our data. We need to turn it into something Java can read (objects)
			while(rs.next()) {
				//Create a new Employee object from each record in the ResultSet
				//we're using the all args constructor of Employee to fill in new Employee objects with DB data
				Employee e = new Employee(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						null //there is no JDBC method for getRole... we'll add the Role object in below
						//this is an extra step we have to take because in the DB, the role_id_fk is an int
						//but we need a Role object here
						);
				
				//we need to get the role of each employee somehow...
				//we need to use the DAO method for getRoleById from the RoleDAO
				int roleFK = rs.getInt("role_id_fk");
				
				//get a Role object from the RoleDAO
				Role r = rDAO.getRoleById(roleFK);
				
				//use the SETTER of the Employee class to set the Role object to the one we got from the DB above.
				e.setRole(r);
				//thanks to this setter, our Employee objects can be FULLY initialized (every variable has a value)
				
				//add the fully initialized Employee into the ArrayList
				employeeList.add(e);
			}
			
			//once the while loop ends (when rs.next() == false), return the ArrayList
			return employeeList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting all employees!");
			e.printStackTrace();
		}
		
		return null;
		
	}


	//We want a method that can take in a Role title, and return all Employees with that Role
	@Override
	public ArrayList<Employee> getEmployeesByRole(String title) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//We need a SQL String with a JOIN
			//We need to join employees on roles in order to access the role_title column from the roles table
			//since I want to get employees by their role title, I need access to the data in both tables
			String sql = "select * from employees inner join roles "
					+ "on role_id = role_id_fk where role_title = ?;";
			
			//we have a variable in the SQL statement, so we need a PreparedStatement to fill it in
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//now we just need to input the variable value
			ps.setString(1, title);
			
			//Execute the query into a ResultSet object
			ResultSet rs = ps.executeQuery();
			
			//Instantiate an empty ArrayList that we'll fill with the data from the ResultSet
			ArrayList<Employee> employeeList = new ArrayList<>();
			
			//while there are records remaining in the ResultSet...
			while(rs.next()) {
				
				//create new Employee objects based on the data, and fill in the ArrayList
				Employee e = new Employee(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						null
						);
				
				//get the foreign key from the Employees table to use in our getRoleById() method
				int roleFK = rs.getInt("role_id_fk");
				
				Role r = rDAO.getRoleById(roleFK);
				
				//fill in the previously null Role variable in this new Employee object (with the setter!)
				e.setRole(r);
				
				//fill in the employeeList with each while loop until eventually rs.next() == false.
				employeeList.add(e);
			}
			
			return employeeList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting employees by ID");
			e.printStackTrace();
		}
		
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
	
	
	
	
	//Ben is leaving this unimplemented... Check RoleDAO for findById functionality
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
