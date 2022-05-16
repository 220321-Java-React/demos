package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

	public static void main(String[] args) {
		
		//Create an ApplicationContext Spring Container object. It will manage our beans!
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//we are instantiating a new ApplicationContext to hold our spring beans
		//BUT in order to configure it we need to give it the class path context to our config file (our XML file)
		
		
		
	}
	
}
