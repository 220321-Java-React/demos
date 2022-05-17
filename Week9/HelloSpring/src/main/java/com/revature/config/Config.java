package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.models.Account;
import com.revature.models.User;

@Configuration //This is how we specify that a Class is a Bean Configuration Class
public class Config {

	//in a config class we configure our Beans with getters (this is the OTHER ugly way to configure/wire beans)
	
	@Bean(name = "user") //name our bean
	@Scope("prototype") //scope our bean (singleton by default)
	public User getUser() {
		
		//return new User();
		
		//this^^ return statement isn't enough - we need to WIRE our beans through a constructor for Account in User
		
		//we need a User constructor that has only an Account so we can use the getAccount bean method below
		return new User(getAccount());
	}
	
	@Bean(name = "account")
	public Account getAccount() {
		return new Account();
		
		//Account is a dependency of User. Accounts don't need Users, so we can just return an Account here.
	}
	
}
