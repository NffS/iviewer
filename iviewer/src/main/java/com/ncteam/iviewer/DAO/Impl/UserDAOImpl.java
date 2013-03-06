package com.ncteam.iviewer.DAO.Impl;

import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncteam.iviewer.domain.User;

@Repository
public class UserDAOImpl extends TablesDAOImpl {

	static{
	  	  Locale.setDefault(Locale.ENGLISH);
		}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(){
		super();
	}
	
	public User getUserByEmail(String email){
		String query="FROM User WHERE email=:email";
		Session sess=sessionFactory.openSession();
		User user=null;
		user = (User) sess.createQuery(query).setString("email", email).uniqueResult();
		return user;
	}
}
