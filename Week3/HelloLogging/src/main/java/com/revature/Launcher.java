package com.revature;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Launcher {

	public static void main(String[] args) {
		
		//We are going to create a simple CLI menu that lets a user log in
		boolean displayMenu = true;
		
		//Instantiate a Scanner object to take user input
		Scanner scan = new Scanner(System.in);
		
		//Instantiate a Logger object so that we can log application flow
		Logger log = LogManager.getLogger(Launcher.class);
		
		//Below is the actual menu that gets our user to log in
		while(displayMenu) {
			
			System.out.println("HELLO USER----- Please Log In");
			
			//prompt the user for username/password and store those inputs in String fields
			System.out.println("USERNAME:");
			String username = scan.nextLine();
			System.out.println("PASSWORD:");
			String password = scan.nextLine();
			
			if(username.equals("user") && password.equals("password")) {
				
				System.out.println("Welcome user!");
				
				log.info("User has successfully logged in");
				
				//then some user prompts go here (will do soon)
				
			} else {
				
				System.out.println("incorrect credentials... try again");
				
				log.warn("User failed to log in");
				
			}
			
		}

	}

}
