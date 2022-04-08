package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

//This RoleDAO is responsible for communicating with the roles table in the database
//Every DB table should have a DAO class associated with it, if you want to use the data from that table 
public class RoleDAO {

	//This method will contact the database to get a dataset of all the roles in our database
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
		
		
		
	}
	
}
