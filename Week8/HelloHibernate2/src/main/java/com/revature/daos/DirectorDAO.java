package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Director;
import com.revature.utils.HibernateUtil;

public class DirectorDAO {

	//all I want in this DAO is a GET ALL for Directors so we can see the many to many in action
	
	public List<Director> getAllDirectors(){
	
		Session ses = HibernateUtil.getSession();
		
		//get all directors with HQL
		List<Director> directorList = ses.createQuery("FROM Director").list();
		
		HibernateUtil.closeSession();
		
		return directorList;
		
	}
	
}
