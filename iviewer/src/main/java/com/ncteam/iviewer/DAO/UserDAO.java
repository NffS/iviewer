package com.ncteam.iviewer.DAO;

import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import com.ncteam.iviewer.domain.User;


public class UserDAO extends TablesDAOImpl {

	static{
	  	  Locale.setDefault(Locale.ENGLISH);
		}
	
	private SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	
	public UserDAO(){
		super.setSessionFactory(sessionFactory);
	}
	
	public User getUserByEmail(String email){
		String query="FROM User WHERE email=:email";
		Session sess=sessionFactory.openSession();
		User user=null;
		sess.getTransaction().begin();
		try{
		user = (User) sess.createQuery(query).setString("email", email).uniqueResult();
		sess.getTransaction().commit();
		sess.close();
		}
		catch(Exception e){
			sess.getTransaction().rollback();
			sess.close();
		}
		return user;
	}
}