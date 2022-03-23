package com.revature;

public class Launcher {

	//to autogenerate a main method: type "main" and ctrl + space
	public static void main(String[] args) {
		
		//type syso, then ctrl + space
		System.out.println("======================================(Common Primitives)");
		
		//int is the most common integer-type primitive (others are byte, short, long)
		
		//this is an int variable equal to 200000
		int i = 200000;
		
		//we can use the + to concatenate (attach) strings and other values to each other
		System.out.println("the value of my int is: " + i);
		
		
		//chars are 2 bytes in size and are written in single quotes, unless they're numbers. 
		//They represent a single CHARacter.
		
		char c = 'a';
		char c2 = 67; //this prints "C", because it's actually calling the unicode value of id 67. which is C 
		char c3 = '$';
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		
		
		//doubles are the most common floating-point number. (this means they have decimals)
		double d = 2.2;
		System.out.println("the value of my double is: " + d);
		
		double d2 = 2;
		System.out.println("the value of my other double is: " + d2);
		//making an int value a double will automatically assign a decimal place
		
		
		//the last primitive type we'll use often is boolean. 
		//this is the ONLY way to denote true/false in java.
		boolean bool = true;
		boolean bool2 = false;
		
		System.out.println(bool);
		System.out.println(bool2);
		
		System.out.println("===================================(Arithmetic Operators)");
		
		//creating some variables to demonstrate some arithmetic operators
		int sum = 5 + 5;
		int difference = 20 - 10;
		int product = 5 * 2;
		int quotient = 100 / 10;
		int remainder = 30 % 20;
		//these should all equal 10
		
		//you can do mathematical operations within print statements using numbers OR variables
		System.out.println(5 + 5);
		System.out.println(sum + difference);
		System.out.println(sum * difference / quotient * remainder);
		
		//parenthesis will work like usual (PEDMAS)
		
		System.out.println("===================================(Increment/Decrement)");
		
		//we use ++ to increase a number by 1, and -- to decrease a number by 1
		//very useful in loops, which we'll see probably Thursday 
		
		int funnyNumber = 24;
		System.out.println("funnyNumber is equal to: " + funnyNumber);
		
		funnyNumber++; //this will increase the value of our variable by 1.
		System.out.println("funnyNumber is equal to: " + funnyNumber);
		
		funnyNumber--; //this will decrease the value of our variable by 1.
		System.out.println("funnyNumber is equal to: " + funnyNumber);
		
	}
	
}
