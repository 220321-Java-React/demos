package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		int randomNum = (int)(Math.random() * 100);
		//what are we doing here? Typecasting!
		//just beware when casting from a double to an int, the decimal place will be lost
		//Math.random() typically returns a double, but we'll turn it into an int to make the number integers
		//Note - typecasting rounds DOWN, so the highest number we could get is 99
		
		System.out.println(randomNum); //just to show it works
		
		System.out.println("================================(if/else-if/else)");
		
		if(randomNum > 75) {
			System.out.println("random number is real big!"); //if randomNum > 75, run this code
		} else if (randomNum > 50) {
			System.out.println("random number is schmedium"); //otherwise, if it's greater than 50, run this code
		} else {
			System.out.println("random number is smol..."); //if all else fails, run this code
		}
		
		System.out.println("===============================(while/do-while loops)");
		
		
		
	}
	
}
