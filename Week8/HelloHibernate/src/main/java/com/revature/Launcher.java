package com.revature;

import java.util.List;

import com.revature.daos.MovieDAO;
import com.revature.models.Director;
import com.revature.models.Movie;

public class Launcher {

	public static void main(String[] args) {
		
		//we need a MovieDAO object so we can call it's method
		MovieDAO mDAO = new MovieDAO();
		
		//going to create some directors and movies to insert into the DB
		Director d1 = new Director("Quentin Tarantino", 1850);
		Director d2 = new Director("James Cameron", 1753);
		
		Movie m1 = new Movie("Pulp Fiction", "kinda a mixed bag", d1);
		Movie m2 = new Movie("Avatar: The Last Airbender", "sci fi garbage fire", d2);
		Movie m3 = new Movie("The Hateful Eight", "wow... what?", d1);
		
		//INSERT our movie objects using our DAO method
		mDAO.insertMovie(m1);
		mDAO.insertMovie(m2);
		mDAO.insertMovie(m3);
		
		//calling our SELECT statement from the DAO
		List<Movie> allMovies = mDAO.getAllMovies();
		
		//iterate through the movie list to see our movies
		for(Movie m:allMovies) {
			System.out.println(m);
		}
		
		//calling our SELECT BY ID from the DAO
		System.out.println(mDAO.getMovieById(2));
		
		
		//calling our SELECT by director ID method
		List<Movie> directorMovies = mDAO.getMoviesByDirectorId(1);
		
		for(Movie m:directorMovies) {
			System.out.println(m);
		}
		
		//UPDATE a Movie with session methods
		m2.setTitle("Terminator");
		m2.setGenre("Sci Fi Bonfire");
		
		mDAO.updateWithSessionMethod(m2);
		
		//print out the movie just to show that it updated
		System.out.println(mDAO.getMovieById(2)); //Movie m2 has an id of 2
		
	}
	
}
