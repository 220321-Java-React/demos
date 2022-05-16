package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.models.User;

public class Launcher {

	public static void main(String[] args) {
		
		//Create an ApplicationContext Spring Container object. It will manage our beans!
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//we are instantiating a new ApplicationContext to hold our spring beans
		//BUT in order to configure it we need to give it the class path context to our config file (our XML file)
		
		
		//Now that we have a Spring Container^^^ which is storing User and Account beans, we can make some!
		
		//we're calling our ApplicationContext and attempting to get a Bean with the name = "user"
		//a cast is needed because the ApplicationContext can't guess what kind of object this will be
		User u = (User)ac.getBean("user");
		
		
		
	}
	
}
