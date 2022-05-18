package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

public class Launcher {

	public static void main(String[] args) {
		
		//Instantiate an ApplicationContext so we can do Bean stuff
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Instantiate an AvengerDAO object by getting the Bean for it.
		//Notice we specify AvengerDAO.class, so we don't have to do the cast (like in HelloSpring)
		AvengerDAO aDAO = ac.getBean(AvengerDAO.class);
		
		//Make a new Avenger object using the getById AvengerDAO method
		Avenger a1 = aDAO.getById(2);
		
		System.out.println("hi");
		
	}
	
}
