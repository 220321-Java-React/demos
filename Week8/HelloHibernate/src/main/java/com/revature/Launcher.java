package com.revature;

import com.revature.daos.MovieDAO;
import com.revature.models.Director;
import com.revature.models.Movie;

public class Launcher {

	public static void main(String[] args) {
		
		//we need a MovieDAO object so we can call it's method
		MovieDAO mDAO = new MovieDAO();
		
		//going to create some directors and movies to insert into the DB
		Director d1 = new Director("Quentin Tarantino", 1850);
		
		Movie m1 = new Movie("Pulp Fiction", "kinda a mixed bag", d1);
		
		//insert our movie objects using our DAO method
		mDAO.insertMovie(m1);
		
	}
	
}
