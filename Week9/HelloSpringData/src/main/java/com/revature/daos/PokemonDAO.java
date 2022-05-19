package com.revature.daos;

import java.util.List;
import java.util.Optional;

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

	//we had to define this method signature on our own, because JpaRepository can't provide it for us 
		//it's a little too complicated. Spring Data is smart, but can only find by id on it's own
	//BUT Spring Data is smart enough to create this method body for us - we just have to make the abstract method
	public Optional<List<Pokemon>> findByName(String name);
	
	//NOTE* SPring wants your method name to be in camelCase, or it'll throw a vague error (something about beans)
	//make sure to call it findBy{VARIABLE NAME YOU'RE SEARCHING BY}
	//for instance, if we wanted to find by type, we'd call the method findByType
	
	//Remember, an Optional is an object that MAY have whatever it's generic is, or it may be null
	//Thanks to Optionals, we can avoid NullPointerExceptions by throwing it against some null checking control flow
	
}
