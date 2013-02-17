package com.ncteam.iviewer.DAO;

import java.sql.Statement;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


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
					Statement stmt=curSession.connection().createStatement();
					stmt.execute( "alter session set NLS_DATE_FORMAT='yyyy-mm-dd HH24:MI'" );
			}
			catch(Exception e){}
			if(isSessionFactorySet)
			curSession.getTransaction().begin();
			curSession.save(record);
			if(isSessionFactorySet)
			curSession.getTransaction().commit();
	}

	
	public <T> void updateRecord(T record) {
		Session curSession=getSession();
		try{
			Statement stmt=curSession.connection().createStatement();
			stmt.execute( "alter session set NLS_DATE_FORMAT='yyyy-mm-dd HH24:MI'" );
		}
		catch(Exception e){}
		if(isSessionFactorySet)
		curSession.getTransaction().begin();
		curSession.update(record);
		if(isSessionFactorySet)
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
		return curSession.createQuery("from "+recordClass.getName()).list();
	}

	
	public void deleteRecord(Object record) {
		if (null != record) {
			Session session=getSession();
			if(isSessionFactorySet)
			session.getTransaction().begin();
			session.delete(record);
			if(isSessionFactorySet)
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
