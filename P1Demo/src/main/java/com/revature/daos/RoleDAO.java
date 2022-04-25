package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

//This RoleDAO is responsible for communicating with the roles table in the database
//Every DB table should have a DAO class associated with it, if you want to use the data from that table 
public class RoleDAO implements RoleDAOInterface{

	//This method will contact the database to get a dataset of all the roles in our database
	@Override
	public ArrayList<Role> getRoles(){
		
		//The first thing we do in DAO methods is open a Connection to our database
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//Write out the SQL query I want to send to the database
			String sql = "select * from roles;";
			
			//Put the SQL query into a Statement object 
			Statement s = conn.createStatement(); //createStatement() is a method from our Connection object
			
			//Execute our statement and put the results into a ResultSet object
			//we use the executeQuery() method from the Statement object, and give it our sql string to execute
			ResultSet rs = s.executeQuery(sql);
			
			//All the code above makes a call to our database... Now, we need to store the data in an ArrayList
			
			//Why do we need to turn our DB data into a ArrayList?
			//Java can't read database data, so we need to turn it into something Java can understand
			
			//create an empty ArrayList to be filled with Role data
			ArrayList<Role> roleList = new ArrayList<>();
			
			//while there are results in the ResultSet rs... (.next() is a method that returns true if there's more data)
			while(rs.next()) {
				
				//use the all-args constructor to create a new Role object from each returned record in the DB
				Role role = new Role(
						//we want to use rs.get() for each column in the record						
						rs.getInt("role_id"),
						rs.getString("role_title"),
						rs.getInt("role_salary")
						);
				
				//use .add() to populate our ArrayList with each new Role object
				roleList.add(role);
			}
			
			//when there are no more results in the ResultSet, the while loop will break... because rs.next() == false
			//return the populated list of roles!!!!
			return roleList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong contacting the database!");
			e.printStackTrace(); //this method is what prints an error message if something goes wrong
		}
		
		return null; //we add this after the try/catch block so Java won't yell at us
		//(Since there's no guarantee that the try block will run and return our ArrayList)
		
	}//end of getRoles()

	
	//Bit more complicated query - we need to use parameters in a PreparedStatement
	@Override
	public Role getRoleById(int id) {
		
		//use a try-with-resources block to open a DB connection
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//String that lays out the SQL query we want to run
			//this String has a variable/parameter, the role_id we're searching for is determined at runtime
			String sql = "select * from roles where role_id = ?";
			
			//we need a PreparedStatement object to fill in variables of our SQL query 
			PreparedStatement ps = conn.prepareStatement(sql); //conn.prepareStatement() instead of createStatement()
			
			//insert the method's argument (int id) as the variable in our SQL query
			ps.setInt(1, id); //the 1 is referring to the first variable (?) in our SQL String
			//then the second parameter is the value we want to put into that first variable
			
			//Execute the query in a ResultSet object to hold our incoming data
			ResultSet rs = ps.executeQuery();
			
			//the above code gets our data, and now we need to populate that data into a Role object
			//we can return the new role object right away without assigning it to a variable
			
			while(rs.next()) {
				
			return new Role(
					rs.getInt("role_id"),
					rs.getString("role_title"),
					rs.getInt("role_salary")
					);
				
			}	
			//note how we don't need an ArrayList here, since we're only returning one object
			
		} catch (SQLException e) {
			System.out.println("Something went wrong fetching this data!!");
			e.printStackTrace(); //print stack trace so we actually get some clues as to what went wrong
		}
		
		return null;
	}

	@Override
	public void updateRoleSalary(String title, int salary) {
	
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//write out our SQL UPDATE command
			String sql = "update roles set role_salary = ? where role_title = ?";
			
			//create our PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//input the appropriate values into our PreparedStatement
			ps.setInt(1, salary); //update the first ? with the int salary from the method arguments
			ps.setString(2, title); //update the second ? with the String title from the method arguments
			
			//execute the update!!
			ps.executeUpdate();
			
			//tell the user that the update was successful
			System.out.println(title + " salary has been updated to: " + salary);
			
		} catch (SQLException e) {
			System.out.println("Couldn't update :(");
			e.printStackTrace();
		}
		
	}
	
}//end of the Class
