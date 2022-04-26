package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.controllers.EmployeeController;
import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		//In this try/catch, we're just testing whether our Connection (from the ConnectionUtil Class) is successful
		//remember - the getConnection() method will return a Connection Object if you connect successfully
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) { //if creating this connection fails... catch the exception and print the stack trace
			System.out.println("connection failed... :(");
			e.printStackTrace();
		}
		
		//We now have a webpage that needs to send HTTP requests to our Java Server!
		//So we no longer have a menu that works on the CLI. We need to use JAVALIN
		
		//Javalin is a technology we use to take in HTTP requests (from our front end) and send back HTTP Responses
		//HTTP Responses can be anything from data that was requested, to just a status code that says data was received
		
		//Instantiating an EmployeeController object so that we can access it's Handlers
		EmployeeController ec = new EmployeeController();
		
		
		//Typical Javalin syntax to create a Javalin object
		Javalin app = Javalin.create(
					//the config lambda lets us specify certain configurations.
					config -> {
						config.enableCorsForAllOrigins(); //this allows us to process JS requests from anywhere
					}
				).start(3000); //we need this to start our application on port 3000
		
		//We need to make some endpoint handlers, which will take in requests and send them where they need to go
		//Javalin endpoint handlers are like the traffic cop to your server. They take traffic and direct it.
		
		
		//handler ending in /employees that takes in GET requests - will return all employees
		//the app.get() method takes in a URL endpoint, and a place in the server to send the request to
		app.get("/employees", ec.getEmployeesHandler);
		
	}
	
}
