package com.revature.models;

public class Blueberry extends Berry {

	//Blueberry now has all the members of Berry, Fruit, and Growable 
	//since it extends Berry, which extends Fruit, which implements Growable
	
	//We don't need to override anything (though we can), because Berry already implemented all the abstract methods
	
	
	//Java didn't FORCE us to do this, because it was already implemented before (in Berry).
	@Override
	public String getThrown() {
		return "This method now has a different implementation - it was overridden!";
	}
}
