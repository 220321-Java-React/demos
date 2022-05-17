package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.config.Config;
import com.revature.models.User;

public class Launcher {

	public static void main(String[] args) {
		
		//Create an ApplicationContext Spring Container object. It will manage our beans!
		//ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//we are instantiating a new ApplicationContext to hold our spring beans
		//BUT in order to configure it we need to give it the class path context to our config file (our XML file)
		
		//This is how you make an ApplicationContext when using a CONFIG CLASS
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		
		//Now that we have a Spring Container^^^ which is storing User and Account beans, we can make some!
		
		//we're calling our ApplicationContext and attempting to get a Bean with the name = "user"
		//a cast is needed because the ApplicationContext can't guess what kind of object this will be
		User u = (User)ac.getBean("user");
		
		//Let's take a look at what our User bean looks like
		System.out.println(u);
		//we got a User object that the ApplicationContext created for us with .getBean()
		//BUT... nowhere did I create an Account class to attach to it.
		//This is the power of autowiring - Spring did it for us, "automagically"
		
		//now we can give our Bean some values
		u.setId(1);
		u.setName("Bon");
		u.getAccount().setBalance(5000.56); //we need to use the getter of the User class to access Account variables
		u.getAccount().setType("Savings");
		
		//User should have full data now!
		System.out.println(u);
		
		
		System.out.println("================================================(Messing with Bean Scopes)");
		
		//recall bean scopes - Beans are singletons by default, which means there can only ever be one instance
		User u2 = (User)ac.getBean("user");
		
		//Give the user new values
		u2.setName("Bono");
		u2.setId(2);
		
		//Thus, this new User is the same User as the first one we made
		System.out.println(u2);
		//the values will be the same across all User objects.
		System.out.println(u);
		
		//If you're reading this, we changed the User scope to "prototype" so that there can be unique instances
		
		
	}
	
}
