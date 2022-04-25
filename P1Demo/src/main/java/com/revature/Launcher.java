package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;

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
		
		//Instantiate our Menu object
		Menu menu = new Menu();
		
		//use the Menu's displayMenu() method to use the Menu
		menu.displayMenu();
		
		//really clean main method! The power of abstraction - 
		//all the complicated menu code is in the displayMenu() method (abstracted away from us)

		
	}
	
}
