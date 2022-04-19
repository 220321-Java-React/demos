package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Employee;

public class KrustyTests {

	UserDAO ud = new UserDAO();
	EmployeeDAO ed = new EmployeeDAO();
	RoleDAO rd = new RoleDAO();
	
	@Test
	public void testSuccessfulLogin() {
		
		assertTrue(ud.login("user", "password"));
		
	}
	
	@Test 
	public void testFailedLogin() {
		
		assertFalse(ud.login("ayy", "lmao"));
	
	}
	
	@Test
	public void testDataIsReturnedOnValidRoleSearch() {
		
		assertNotNull(ed.getEmployeesByRole("Fry Cook"));
		
	}
	
	
	@Test
	public void testNullIsReturnedOnInvalidRoleSearch() {
		
		assertEquals(rd.getRoleById(-5000), null);
		
	}
	
	
	@Test
	public void testRecordUniqueness() {
		assertNotSame(rd.getRoleById(1), rd.getRoleById(2));
		assertNotSame(rd.getRoleById(3), rd.getRoleById(4));
	}
	
}
