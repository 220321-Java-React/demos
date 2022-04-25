package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This utility Class is where we manage and establish our database connection
public class ConnectionUtil {

	
	//This method will eventually return an object of type Connection, which we'll use to connect to our databse
	public static Connection getConnection() throws SQLException {
		
		//For compatibility with other technologies/frameworks, we'll need to register our PostgreSQL driver
		//This process makes the application aware of what Driver class we're using
		try {
			Class.forName("org.postgresql.Driver"); //searching for the postgres driver, which we have as a dependency
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); //This tells in the console us what went wrong
			System.out.println("problem occurred locating driver");
		}
		
		
		//Use our database credentials to establish a database connection
		//Hardcoded for now... BAD! we'll change this later to hide them in the Environment Variables
		
		//I'm going to put the credentials in Strings, and use those strings in a method that gets connections
		//the schema name at the end of this url String is whatever you named the schema you want to connect to
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=krusty_krab";
		String username = "postgres";
		String password = "Sparky2014!!";
		
		//This return statement is what returns out actual database Connection object
		//Note how this getConnection() method has a return type of Connection
		return DriverManager.getConnection(url, username, password);
		
	}
	
}
