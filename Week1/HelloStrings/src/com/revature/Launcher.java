package com.revature;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("==========================================(Strings are immutable)");
		
		String string = "I am immutable, which means my value can't change";
		
		//The String class has no methods that let us change the value of the String...
		
		string.toUpperCase(); //This will RETURN the String in upper case, but it won't change the original String
		
		System.out.println(string); //the original String is unchanged
		
		//BUT, we can assign a changed String to a new String variable
		String newString = string.toUpperCase();
		
		System.out.println(newString); //as you see, this new String has saved the mutation we did on the original String
		
		string = string.toUpperCase(); //what if we try to change the original String this way?
		
		System.out.println(string); //the original String VARIABLE changes, but not the String object itself
		
		//what gives? The original value is actually still unchanged... But the original OBJECT hasn't changed
		//the string variable is now simply pointing to a new object, the original object hasn't changed
			//the original String is floating around in the String Pool (see the notes)
		
		string = string + "more stuff";
		
		System.out.println(string);
		
		System.out.println("==========================(Testing String Equality)");
		
		String s1 = "Hi Java"; //this makes a new object in the String Pool.
		String s2 = "Hi Java"; //this points to the same object created above.
		//if we use string literals (AKA no "new" keyword), identical values will point to the same object.
		String s3 = "hi java";
		String s4 = new String("Hi Java"); //every time we use "new" for Strings, it'll make a new object in memory.
		String s5 = new String("Hi Java");
		
		System.out.println(s1 == s2); //true. == compares memory address. s1 and s2 point to the SAME Java Object.
		System.out.println(s1.equals(s2)); //true. .equals() compares values. s1 and s2 have the same value.
		System.out.println(s1 == s3); //false. == compares memory, s1 and s3 point to DIFFERENT Java Objects.
		System.out.println(s1.equals(s3)); //false. .equals() compares values. s1 and s3 have different values.
		
		System.out.println(s1 == s4); //false. "new" create a new object in memory. So s1 and s4 have different addresses
		System.out.println(s1.equals(s4)); //true. s1 and s4 contain the same VALUE (not the same object, but same value)
		
		System.out.println(s4 == s5); //false, two different objects in memory
		System.out.println(s4.equals(s5)); //true. they hold the same VALUE (not the same object tho)
		
		//See why we use .equals() with Strings and == with primitives? 
		//For one, Strings are Objects, and we usually compare Objects with .equals
		//We usually want to compare the VALUE of a variable, not the memory address.
		//(Primitives aren't objects, so they aren't stored in the same place/way objects are).
		
		System.out.println("========================================(Using some String Methods)");
		
		//Remember, String is a CLASS. Thus, every String is an object with access to the String Class's methods/variables
		
		//a pangram to use String methods on
		String pangram = "Sphinx of Black Quartz, Judge My Vow";
		
		//hopefully these method names are self explanatory
		System.out.println(pangram.toLowerCase());
		System.out.println(pangram.toUpperCase());
		
		//length() returns int representing the length of the String 
		System.out.println(pangram.length());
		
		//.charAt() returns the char at a given index
		System.out.println(pangram.charAt(0)); //first character
		System.out.println(pangram.charAt(pangram.length() - 1));
		
		//.charAt in a for loop
		for(int i = 0; i < pangram.length(); i++) {
			System.out.println(pangram.charAt(i));
		}
		
		//.substring() returns a String that's found within the given indexes
		System.out.println(pangram.substring(4, 25)); //this will print characters 4-25 of our pangram String
		
		//one more method - .split() will create an Array via specified delimiters
		String[] words = pangram.split(" "); 
		//This checks for spaces, and every String separated by spaces will be an Array element
		
		System.out.println(words); //This will simply print a memory address
		
		//we'll use an enhanced for loop to print out the word Array's contents
		for(String word : words) { //"For every String (denoted by the "word" variable) in the words Array, do this"
			System.out.println(word);
			//for every word in the words Array, print it out
			//Recall that the words Array came from using the .split() method above
		}
		
		//enhanced for loops are a super convenient way to iterate through things like Arrays
		
		//Wrapping up String talk:
		
		//Note that the above methods WON'T actually change the original pangram String
		//we've been using method to print manipulations of the original, but they aren't changing the string itself
		
		//See StringBuilder/StringBuffer for mutable String-like behavior
	
		System.out.println("=============================(Using StringBuilder)");
		
		//instantiate a new StringBuilder object based on our pangram String above
		StringBuilder sb = new StringBuilder(pangram); //we're using the pangram ref variable in the SB's constructor
		
		System.out.println(sb); //our StringBuilder now has the value of the pangram String
		
		//perform some mutations using StringBuilder methods
		sb.reverse(); //reverse the characters
		sb.append("BENJAMIN"); //append my name to the end of the StringBuilder
		sb.insert(12, "ADRIENNE and YOU are in here as well");
		sb.delete(30, 35); //delete the chars foudn in indexes 30-35
		sb.replace(0, 8, "Hello from the replace method"); //replace the chars in indexes 0-8
		
		System.out.println(sb); //we get printed out whatever this is
		
		//StringBuilders have the .toString(), which will convert it into a String if you need a String specifically
		String newerString = sb.toString();
		
		System.out.println(newerString);
		
		System.out.println("=========================(Scanner)");
		
		//instantiate a Scanner object
		Scanner scan = new Scanner(System.in); //System.in is how we tell Scanner we're taking inputs from the console
		
		System.out.println("What's your name?"); //ask the user a question they must answer
		
		String name = scan.nextLine(); //the nextLine() method gather a user input STRING and moves to the next line
		
		System.out.println(name + "?... That's a lovely name.");
		
		System.out.println("How old are you?");
		
		int age = scan.nextInt(); //nextInt() will grab a user inputted int, but doesn't make a new line...
		scan.nextLine(); //we need to explicitly call nextLine() in order to actually move to the next line
		//without nextLine() you won't be able to add any more user input!!
		
		System.out.println("What?!?!?!?!??!" + age + "?? what's your secret?");
		
		String secret = scan.nextLine();
		
		System.out.println("OK starting tomorrow I'll " + secret);
		
	}
	
}
