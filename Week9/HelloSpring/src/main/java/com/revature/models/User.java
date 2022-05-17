package com.revature.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //again, we want to make this Class a bean
@Scope("prototype") //Classes are singletons by default...
public class User {

	private int id;
	private String name;
	private Account account;

	
	//boilerplate code
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String name, Account account) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
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


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + "]";
	}
	
	
	
}
