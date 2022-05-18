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
		
		a1.setFirstName("hello???"); //no logs will occur for anything we do in a1, because we didn't use getBean()
		//SpringAOP only works on BEANS. BEANSSSSS.

		//in order for any logs to occur, we need an Avenger BEAN, not an Avenger POJO (plain ol' java object)
		Avenger a2 = ac.getBean(Avenger.class);
		
		//Give some values to this new Avenger
		a2.setAveId(6);
		a2.setAveName("Static Shock");
		a2.setFirstName("Virgil");
		a2.setLastName("Hawkins");
		a2.setPower("Static Shock");
		a2.setPowerLevel(528795468);

		
	}
	
}
