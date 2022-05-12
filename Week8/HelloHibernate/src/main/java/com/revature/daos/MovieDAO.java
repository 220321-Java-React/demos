package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Movie;
import com.revature.utils.HibernateUtil;

public class MovieDAO {

	//Hibernate DAO methods incorporate the Session objects methods to create/manipulate data (SESSION METHOD)
	//We can also use HQL to make SQL-esque statements to talk to the DB as well
	//read up on HQL and session method notes to understand what's going on here
	
	public void insertMovie(Movie movie) {
		
		//open a Session object to establish a connection to the DB
		Session ses = HibernateUtil.getSession(); //similar to opening a Connection object in JDBC
		
		//use a save() session method to save the movie to the DB
		ses.save(movie);
		
		//close the Session to prevent memory leaks
		HibernateUtil.closeSession();
		
		//This is the ENTIRE DAO method to insert a new movie - much cleaner and less complicated than JDBC
		
	}
	
}
