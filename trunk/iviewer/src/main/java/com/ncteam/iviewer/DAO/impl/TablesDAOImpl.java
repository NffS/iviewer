package com.ncteam.iviewer.DAO.impl;

import java.sql.Statement;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;

import com.ncteam.iviewer.DAO.TablesDAO;

@Transactional
public class TablesDAOImpl implements TablesDAO{

	static{
	  	  Locale.setDefault(Locale.ENGLISH);
		}
		
	@Autowired
	private SessionFactory sessionFactory;

	
	public <T> void addRecord(T record) {
		
			try{
					Statement stmt=sessionFactory.getCurrentSession().connection().createStatement();
					stmt.execute( "alter session set NLS_DATE_FORMAT='yyyy-mm-dd HH24:MI'" );
			}
			catch(Exception e){}
			sessionFactory.getCurrentSession().save(record);
	}

	
	public <T> void updateRecord(T record) {
		try{
			Statement stmt=sessionFactory.getCurrentSession().connection().createStatement();
			stmt.execute( "alter session set NLS_DATE_FORMAT='yyyy-mm-dd HH24:MI'" );
		}
		catch(Exception e){}
		sessionFactory.getCurrentSession().update(record);
	}

	
	@SuppressWarnings("unchecked")
	public <T> T getRecordById(int id, Class<T> recordClass) {
		return (T) sessionFactory.getCurrentSession().get(recordClass, id);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAllRecords(Class<T> recordClass) {
		return sessionFactory.getCurrentSession().createQuery("from "+recordClass.getName()).list();
	}

	
	public void deleteRecord(Object record) {
		if (null != record) {
			sessionFactory.getCurrentSession().delete(record);
		}
	}
}
