package com.revature;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

//This is a test class! It'll be full of methods that test our Calculator Class
public class CalculatorTests {

	//declare an uninitialized Calculator object so we can use and test it's methods
	Calculator calc;
	
	//ben may or may not show @Before/AfterAll
	
	
	//Unit tests below-------------------------
	
	//TO RUN A TEST CLASS: right click the test class -> run as -> JUnit test
	
	@Test
	public void testAdd() {
		
		System.out.println("TESTING ADD METHOD");
	
		int result = calc.add(5, 5); //we're assigning the result of the add() method to this result variable
		
		assertTrue(result == 10); //this test will pass if result == 10.
		
	}
	
}
