package com.revature;

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
		
		
	}
	
}