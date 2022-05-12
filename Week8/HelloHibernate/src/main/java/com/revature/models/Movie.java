package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//ctrl + shift + o for multiple imports at once. (cmd + shift + o for my mac users) 

@Entity
@Table(name = "movies")
public class Movie {

	@Id //This will make director_id the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int movie_id;
	
	@Column
	private String title;
	
	@Column 
	private String genre;
	
	//Many to One relationship with the Director Class - one director can havce many movies related to it.
	//We need to make this a Foreign Key to the Director table
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "director_id") //THIS is how you establish FK/PK relationships
	//the name attribute must be equal to the name of the PK in Directors in the DB. (in this case, director_id)
	public Director director_fk;
	
	//What is FetchType and CascadeType????
	
	//BEN WILL NOT FORGET TO TALK ABOUT IT
	
	//Boilerplate code below------------------------------
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(int movie_id, String title, String genre, Director director_fk) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.genre = genre;
		this.director_fk = director_fk;
	}

	public Movie(String title, String genre, Director director_fk) {
		super();
		this.title = title;
		this.genre = genre;
		this.director_fk = director_fk;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Director getDirector_fk() {
		return director_fk;
	}

	public void setDirector_fk(Director director_fk) {
		this.director_fk = director_fk;
	}

	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", title=" + title + ", genre=" + genre + ", director_fk=" + director_fk
				+ "]";
	}
	
	
	
}
