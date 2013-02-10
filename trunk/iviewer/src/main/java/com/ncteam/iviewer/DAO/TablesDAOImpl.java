package com.ncteam.iviewer.DAO;

import java.sql.Statement;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.Form_backup;
import com.ncteam.iviewer.domain.HR_mark;
import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.domain.News;
import com.ncteam.iviewer.domain.Tech_mark;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.domain.Users_type;


@Repository
public class TablesDAOImpl implements TablesDAO{

	static{
	  	  Locale.setDefault(Locale.ENGLISH);
		}
		
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private boolean isSessionFactorySet=false;
		
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		isSessionFactorySet=true;
		session=SessionFactoryUtils.getSession(sessionFactory, true);
	}
	
	protected void finalize ( ) {
		if(session!=null&&session.isOpen())
			session.close();
	}
	
	public <T> void addRecord(T record) {
		
			Session curSession=getSession();
			try{
					Statement stmt=session.connection().createStatement();
					stmt.execute( "alter session set NLS_DATE_FORMAT='yyyy-mm-dd HH24:MI'" );
			}
			catch(Exception e){	}
			curSession.getTransaction().begin();
			curSession.save(record);
			curSession.getTransaction().commit();
	}

	
	public <T> void updateRecord(T record) {
		Session curSession=getSession();
		try{
			Statement stmt=session.connection().createStatement();
			stmt.execute( "alter session set NLS_DATE_FORMAT='yyyy-mm-dd HH24:MI'" );
		}
		catch(Exception e){	}
		curSession.getTransaction().begin();
		curSession.update(record);
		curSession.getTransaction().commit();
	}

	
	@SuppressWarnings("unchecked")
	public <T> T getRecordById(int id, Class<T> recordClass) {
		Session curSession=getSession();
		return (T) curSession.get(recordClass, id);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAllRecords(Class<T> recordClass) {
		Session curSession=getSession();
		if(recordClass==User.class){
		return curSession.createQuery("from User").list();
		}
		else if(recordClass==Form.class){
			return curSession.createQuery("from Form").list();
		}
		else if(recordClass==HR_mark.class){
			return curSession.createQuery("from HR_mark").list();
		}
		else if(recordClass==News.class){
			return curSession.createQuery("from News").list();
		}
		else if(recordClass==Interview.class){
			return curSession.createQuery("from Interview").list();
		}
		else if(recordClass==Users_type.class){
			return curSession.createQuery("from Users_type").list();
		}
		else if(recordClass==Tech_mark.class){
			return curSession.createQuery("from Tech_mark").list();
		}
		else if(recordClass==Form_backup.class){
			return curSession.createQuery("from Form_backup").list();
		}
		else return null;
	}

	
	public void deleteRecord(Object record) {
		if (null != record) {
			Session session=getSession();
			session.getTransaction().begin();
			session.delete(record);
			session.getTransaction().commit();
		}
	}
	
	private Session getSession(){
		if(isSessionFactorySet)
			return this.session;
		else
			return sessionFactory.getCurrentSession();
	}

}
