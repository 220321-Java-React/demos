package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="pokemon")
@Component
public class Pokemon {

	//we are using Spring Data. Our Model classes should look just like Hibernate
	//Spring Data abstracts hibernate away, but it still uses the JPA annotations to map classes to tables
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//non-id columns don't need the @column annotation if you don't wish to add any constraints
	private String name;
	private String type;
	private int level;

	
	//boilerplate code below----------------------------------------------------------
	
	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pokemon(int id, String name, String type, int level) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.level = level;
	}


	public Pokemon(String name, String type, int level) {
		super();
		this.name = name;
		this.type = type;
		this.level = level;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + ", level=" + level + "]";
	}
	
	
	
}
