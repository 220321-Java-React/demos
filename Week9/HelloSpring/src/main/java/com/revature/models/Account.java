package com.revature.models;

import org.springframework.stereotype.Component;

@Component //@Component is the generic annotation for making a Class a bean, and storing it in the Spring Container
//The Spring Container we use is ApplicationContext
public class Account {

	private double balance;
	private String type;

	
	//boilerplate code----------------------------
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(double balance, String type) {
		super();
		this.balance = balance;
		this.type = type;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Account [balance=" + balance + ", type=" + type + "]";
	}
	
}


