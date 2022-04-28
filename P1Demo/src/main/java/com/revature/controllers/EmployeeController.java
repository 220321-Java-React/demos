package com.revature.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

import io.javalin.http.Handler;

//The Controller layer is where HTTP requests get sent after Javalin directs them
//It's in this layer that we'll parse any JSON into Java objects and vice versa
//We'll either be getting data from the service layer (which gets the data from the DAO)
//OR we'll be sending data that came from the webpage to the service layer (which sends the data to the DAO)
public class EmployeeController {
	
	//we need an EmployeeService object 
	EmployeeService es = new EmployeeService();
	
	

	//this Handler will get the HTTP GET request for all employees, and send back the employees from the database
	public Handler getEmployeesHandler = (ctx) -> {

		
		if(AuthController.ses != null) { //if there is an active session from the AuthController...
			
		//we need an ArrayList of Employee objects (which we'll get from the service layer)
		ArrayList<Employee> employees = es.getEmployees();
		
		//create a GSON object to convert our Java object into JSON (since we can only transfer JSON, not Java)
		Gson gson = new Gson();
		
		//use the JSON .toJson() method to turn our Java into JSON
		String JSONEmployees = gson.toJson(employees);
		
		//Give a HTTP response containing our JSON string back to the webpage (or wherever the HTTP request came from)
		ctx.result(JSONEmployees); //.result() sends a response of data back
		ctx.status(200); //.status() sets the HTTP status code. 200 stands for "OK"
		
		} else { //if a session DOESN'T exist (user isn't logged in)
			ctx.status(400);
		}
		
	};
	
}
