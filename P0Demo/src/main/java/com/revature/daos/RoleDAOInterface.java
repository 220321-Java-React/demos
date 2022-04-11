package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Role;

//This interface will lay out every method that I want my RoleDAO to have
public interface RoleDAOInterface {

	//ctrl + shift + o to import multiple Classes at once
	
	//get all roles
	ArrayList<Role> getRoles();
	
	//take in an int, and get the Role which has a role_id == that int
	Role getRoleById(int id);
	
	//take in an int and a String, and change the appropriate role's salary using those arguments
	void updateRoleSalary(String title, int salary);
	
}
