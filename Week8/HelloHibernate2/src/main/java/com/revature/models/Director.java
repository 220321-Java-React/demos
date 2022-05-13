package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //@Entity makes a Class a DB table (as long as you register it in the hibernate.cfg.xml)
@Table(name = "directors") //@Table lets us change table values such as the table name 
public class Director {

	@Id //This will make director_id the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our PK serial
	@Column //usually I'll put this annotation though it isn't necessary. We can set things like column name though 
	private int director_id;
	
	//we can also set attributes like constraints with the @Column annotation
	@Column(unique = true, nullable = false) //so now this column is unique and not null.
	private String director_name;
	
	@Column
	private int year_born;
	
	//In the real world a movie can have multiple directors, and a director can have multiple movies
	//SO let's model this demo to have many-to-many like functionality.
	//There is a OneToMany on the Director side, and a ManyToOne on the Movie side. This is like ManyToMany!!
	//what's mappedBy? It's the field in the Movie Class that references the Director Class.
	@OneToMany(mappedBy="director_fk", fetch=FetchType.EAGER)
	private List<Movie> filmography;

	//Boilerplate code below-------------------------------
	
	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//all args
	public Director(int director_id, String director_name, int year_born, List<Movie> filmography) {
		super();
		this.director_id = director_id;
		this.director_name = director_name;
		this.year_born = year_born;
		this.filmography = filmography;
	}


	//all args minus id in case we wanted to insert a new Director
	public Director(String director_name, int year_born, List<Movie> filmography) {
		super();
		this.director_name = director_name;
		this.year_born = year_born;
		this.filmography = filmography;
	}


	public List<Movie> getFilmography() {
		return filmography;
	}


	public void setFilmography(List<Movie> filmography) {
		this.filmography = filmography;
	}


	public int getDirector_id() {
		return director_id;
	}

	public void setDirector_id(int director_id) {
		this.director_id = director_id;
	}

	public String getDirector_name() {
		return director_name;
	}

	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}

	public int getYear_born() {
		return year_born;
	}

	public void setYear_born(int year_born) {
		this.year_born = year_born;
	}


	@Override
	public String toString() {
		return "Director [director_id=" + director_id + ", director_name=" + director_name + ", year_born=" + year_born
				+ ", filmography=" + filmography + "]";
	}

}
