package com.revature.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//We use this class in order to get our sessions!
//Sessions manage the actual connection to our database.
public class HibernateUtil {

	//We use the SessionFactory interface in order to get a Session. 
	//Note that we point it to the hibernate.cfg.xml file where our database credentials etc. are stored.
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	//get Session objects from our SessionFactory
	//We only want one session in this application - hence private static - it's a singleton!
	private static Session ses;
	
	//This method actually gets us a Session object using the SessionFactory interface.
	//We'll be calling it in the dao layer often.
	public static Session getSession() {
		if (ses == null) { //if there isn't a session...
			ses = sf.openSession(); //get one!
		}
		return ses; //return a session Object
	}
	
	//Finally, we need a method that closes the Session objects 
	//Once we're done with our Session, we want to close it to prevent memory leaks 
	public static void closeSession() {
		ses.close();
		ses = null;
	}

}
