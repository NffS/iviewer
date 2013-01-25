package com.ncteam.iviewer.DAO;

import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import com.ncteam.iviewer.domain.User;


public class UserDAOImpl extends TablesDAOImpl {

	static{
	  	  Locale.setDefault(Locale.ENGLISH);
		}
		
	
	private SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	
	public User getUserByEmail(String email){
		String query="SELECT user_id, email, password,"
				+"first_name, surname, last_name, foto, user_type_id FROM Users WHERE email='"+email+"'";
		Session sess=sessionFactory.openSession();
		User user=null;
		sess.getTransaction().begin();
		try{
		user = (User) sess.createSQLQuery(query).addEntity(User.class).list().get(0);
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
