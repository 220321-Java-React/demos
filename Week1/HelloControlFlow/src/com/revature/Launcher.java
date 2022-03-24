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
		
		int smallNum = 2; //declaring a variable to use in our While loops
		
		//WHILE the expression in parenthesis evaluates to true, the code in the while loop will run.
		while(smallNum < 500) {
			smallNum += 100;
			//we haven't seen += yet, it's basically shorthand smallNum = smallNum + 10;
			//you can use this with any arithmetic operator E.g. smallNum *= 10;
			System.out.println("smallNum has increased to: " + smallNum);
		}
		
		System.out.println("While Loop has completed! Enjoy your new number :)");
		
		//DO WHILE loops execute the code once, and THEN start evaluating the boolean
		do {
			smallNum -= 100;
			System.out.println("smallNum has decreased to: " + smallNum);
		} while(smallNum > 10);
		
		System.out.println("Do While Loop has completed! Enjoy your new number :)");
		
		System.out.println("=================================(For Loops)");
		
		//basic for loop
		
		int loopVictim = 0; //declaring an int that we'll manipulate with a for loop
		
		//"for as long as this int i, which starts at 0, is less than 10, increment it once per loop".
		for(int i = 0; i < 10; i++) { //it's typical practice to call the int "i" for "iterator"
			
			//every time this loop iterates, the code below will run
			loopVictim += 2; 
			System.out.println("Our loop victim is now: " + loopVictim);
			System.out.println("Our loop variable (the iterator) is now: " + i);
			//notice "Our loop variable is now: 10" never prints, since the loop breaks once i is not < 10.
		}
		
		//The loop executed 10 times (0-9). Once i = 10, the loop completes and doesn't execute its code again
		
		//more interesting use of for loops......
		
		//this is an Array, which we'll talk about shortly, but basically it's a list of values
		char[] myName = {'B', 'E', ' ', 'N', 'A', 'A', 'A'};
		
		System.out.println(myName);
		//This is not my name... I want to use control flow to clean up this Array so we only get my name (BEN)
		
		//"For as long as i is less than the length of the myName Array, run the block code and increment i by 1."
		for(int i = 0; i < myName.length; i++) {
			
			//clean out the empty space in the myName array
			
			//"if the char at position i is equal to an empty space, skip this iteration of the for loop"
			if(myName[i] == ' ' || myName[i] == 'A') {
				continue; //continue skips the current iteration of the loop and goes to the next one
			}
			
			//in this if statement we have ||, which stands for "or"
			
			//so the entire if statement reads:
			//"if the char in myName at index i is equal to ' ' OR 'A', skip this iteration of the for loop (continue)
			
			//if the if statement doesn't run, print out the value of the char at position "i"
			System.out.println(myName[i]);
			
		}
		
		System.out.println("==========================(Switch)");
		
		//declare a variable to use as our switch evaluation
		int age = 31;
		
		//depending on the value of the "age" variable, one of the following cases will run
		switch(age) {
			
		//each case is set up to run certain code if age == the case
		//we need BREAK statements at the end of each case, or else every case under the one that executes will run too
		//just remember, break will exit a loop or block
		case 20: 
			System.out.println("you are 20 years old");
			break; 
		
		case 25:
			System.out.println("you are 25 years old");
			break;
			
		case 30:
			System.out.println("you are 30 years old");
			break;
			
		default:
			System.out.println("Your age does not match any of the cases...");
			break;
			//the default case will run if none of the other cases above match the switch statement's argument
		}
		
	}
	
}
