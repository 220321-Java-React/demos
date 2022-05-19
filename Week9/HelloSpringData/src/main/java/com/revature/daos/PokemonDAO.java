package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Pokemon;

//By extending JpaRepository, we get access to various DAO methods that we don't have to write ourselves.
	//try to ctrl + click on JpaRepository to see the methods it provides
//JpaRepository takes two generics... (Pokemon and Integer in our case)
	//the first generic is the entity being persisted (the class being mapped to the database)
	//the second generic is the data type of the primary key (wrapper class)

@Repository //the annotation you should use if you want your DAO class to be a bean.
public interface PokemonDAO extends JpaRepository<Pokemon, Integer>{

	
	
}
