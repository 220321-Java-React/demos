package com.revature.models;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;

//This Menu Class will have a method that displays a menu to the user that they can interact with: displayMenu()
//Through this menu, the user can give inputs that will interact with the database
public class Menu {
	
	//instantiating an EmployeeDAO object so that we can use it's methods
	EmployeeDAO eDAO = new EmployeeDAO();
	//instantiating a RoleDAO object so that we can use its methods
	RoleDAO rDAO = new RoleDAO();

	//All of the menu display options and control flow are contained within this method
	public void displayMenu() {
		
		boolean displayMenu = true; //we're going to use this to toggle whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //Scanner object to parse (read) user input
		
		//pretty greeting
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println("WELCOME to the Krusty Krab Employee Management System");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		
		//display the menu as long as the displayMenu boolean is true
		while(displayMenu) {
			
			//tell the user to choose an option
			System.out.println("----------------");
			System.out.println("CHOOSE AN OPTION");
			System.out.println("----------------");
			
			
			//list out the user's options for them to choose
			System.out.println("1: get greeted");
			System.out.println("2: exit the application");
			System.out.println("3: show all employees");
			System.out.println("4: show all roles");
			System.out.println("5: get role by ID");
			
			
			//parse the user's input after they choose option, and put it in a int variable
			int input = scan.nextInt();
			scan.nextLine(); //without nextLine(), the application won't move to the next line... so we need it!
			
			//switch statement - depending on the user's input, do some functionality
			switch(input) {
			
			case 1: {
				System.out.println("Hello User!");
				break;
			}
			
			case 2: {
				System.out.println("Bye user! Come again soon.");
				displayMenu = false; //remember, the while loop depends on displayMenu being true. so this ends the loop.
				break;
			}
			
			case 3: {
				//call the getEmployees() method from the EmployeeDAO, put the results into a variable
				ArrayList<Employee> employees = eDAO.getEmployees();
				
				//print out the values of our employees variables in a forEach
				//I'm sure you all can find even cleaner ways to print this data out ;)
				employees.forEach(employee -> {
					System.out.println("----------------------");
					System.out.println(employee.getEmployee_id());
					System.out.println(employee.getFirst_name());
					System.out.println(employee.getLast_name());
					System.out.println("----------------------");
					//Ben won't forget to show employee.getRole()
				});
				
				break;
			}
			
			case 4: {
				
				//get the ArrayList of roles from the roleDAO
				ArrayList<Role> roles = rDAO.getRoles();
				
				//enhanced for loop to print out our role data one by one
				for(Role role : roles) {
					System.out.println(role);
				}
				
				break;
			}
			
			case 5: {
				
				System.out.println("What Role ID would you like to search?");
				
				int idInput = scan.nextInt(); //we get the user's input for ID
				scan.nextLine(); //we still need nextLine() to move to the next line
				
				//what if the user enters a String? the program will crash
				//it's up to you to polish your P0 and add some foolproofing to cases like this
				
				//creating a new Role object, using the getRoleById method in the Role DAO
				Role role = rDAO.getRoleById(idInput);
				
				//simply print out our new role object
				System.out.println(role);
				
				break;
			}
			
			default: {
				//this default block will run if the user inputs a number that isn't one of the options
				System.out.println("What did you say?? Try again. Do better...");
				break;
			}
			
			} //switch statement ends here
			
		} //while loop ends here
		
	} //method ends here
	
} //class ends here
