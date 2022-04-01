package com.revature;

import com.revature.models.Menu;

public class Launcher {

	public static void main(String[] args) {
		
		//our main method will only have 2 lines of code...
		
		//Instantiate our Menu object
		Menu menu = new Menu();
		
		
		//use the Menu's displayMenu() method to use the Menu
		menu.displayMenu();
		
		//really clean main method! The power of abstraction - 
		//all the complicated menu code is in the displayMenu() method (abstracted away from us)
		
	}
	
}
