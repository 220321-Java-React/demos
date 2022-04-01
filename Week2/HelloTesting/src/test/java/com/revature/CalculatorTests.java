package com.revature;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//This is a test class! It'll be full of methods that test our Calculator Class
public class CalculatorTests {

	//declare an uninitialized Calculator object so we can use and test it's methods
	static Calculator calc;
	
	//make a couple variables to be used in my tests
	//I accidentally put these within the @Before method at first, and they couldn't be used in other methods cuz scope
	int i = 5;
	int j = 10;
	int k = 0;
	
	@Before //methods with @Before will run BEFORE every tests run in JUnit 4, it's @BeforeAll in JUnit
	//I want to initialize my calculator object to be used in the tests
	public void initialize() {
		System.out.println("In the @Before method");
		calc = new Calculator();
	}
	
	@After //methods with @After will run AFTER every test runs in JUnit 4, it's @AfterAll in Junit 5
	//I want to set my Calculator back to null after each method runs
	public void uninitialize() {
		System.out.println("In the @After method");
		calc = null;
	}
	
	//Unit tests below-------------------------
	
	//TO RUN A TEST CLASS: right click the test class -> run as -> JUnit test
	
	@Test
	public void testAdd() {
		
		System.out.println("TESTING ADD METHOD");
	
		int result = calc.add(i, j); //we're assigning the result of the add() method to this result variable
		
		assertTrue(result == 10); //this test will pass if result == 10.
		
	}
	
	
	
}
