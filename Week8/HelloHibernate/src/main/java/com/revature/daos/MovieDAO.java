package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

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
	
	//If you're SELECTing ALL records from the DB, HQL is your best bet since it's so quick
	public List<Movie> getAllMovies(){
		
		//open a Session object to connect to the DB
		Session ses = HibernateUtil.getSession();
		
		//SELECT ALL movies using HQL instead of sessions methods.
		List<Movie> movieList = ses.createQuery("FROM Movie").list();
		//we're selecting ALL records FROM the movies table. Remember, HQL uses Class names, not DB table names
		
		//close the session
		HibernateUtil.closeSession();
		
		//return the List of Movies
		return movieList;
		
	}
	
	//Session methods are best used when you're SELECTing by the primary key
	//because get() and load() both expect a serializable (which our PK is)
	public Movie getMovieById(int id) {
		
		//open a Session object
		Session ses = HibernateUtil.getSession();
		
		//SELECT a Movie by ID 
		Movie movie = ses.get(Movie.class, id);
		
		//close the Session
		HibernateUtil.closeSession();
		
		//return the Movie
		return movie;
		
	}
	
	//get all Movies by Director with HQL
	//check the HQL query - we'll need to look for director.director_id, since we're searching Movie.director.director_id
	public List<Movie> getMoviesByDirectorId(int id){
		
		Session ses = HibernateUtil.getSession();
		
		//create a query with a parameter that takes in the director id (given in the method argument)
		//"find every Movie which we'll call m, where the id of it's Director object = ?"
		Query q = ses.createQuery("FROM Movie m WHERE m.director_fk.director_id = ?0");
		
		//set the ? to the id sent in the method call. This is how we PARAMETERIZE HQL
		q.setParameter(0, id);
		
		//create a List of Movies based on the results of the query
		List<Movie> movieList = q.getResultList();
		
		HibernateUtil.closeSession();
		
		return movieList;
		
		/*
		  I'd imagine this is a good template for user login
		  "FROM User u WHERE u.username = ?0 etc...."
		 */
		
	}
	
}
