package com.ncteam.iviewer.DAO;

import java.sql.Statement;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> T addRecord(T record) {
		Session session=sessionFactory.getCurrentSession();
		try{
		Statement stmt=session.connection().createStatement();
		stmt.execute( "alter session set NLS_DATE_FORMAT='yyyy-mm-dd HH24:MI'" );
		}
		catch(Exception e){	}
		return (T)sessionFactory.getCurrentSession().save(record);
		
	}

	
	public <T> void updateRecord(T record) {
		Session session=sessionFactory.getCurrentSession();
		try{
		Statement stmt=session.connection().createStatement();
		stmt.execute( "alter session set NLS_DATE_FORMAT='yyyy-mm-dd HH24:MI'" );
		}
		catch(Exception e){	}
		sessionFactory.getCurrentSession().update(record);
	}

	
	@SuppressWarnings("unchecked")
	public <T> T getRecordById(int id, Class<T> recordClass) {
		T record = (T) sessionFactory.getCurrentSession().get(recordClass, id);
        return record;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getAllRecords(Class<T> recordClass) {
		if(recordClass==User.class){
		return sessionFactory.getCurrentSession().createQuery("from User")
	            .list();
		}
		else if(recordClass==Form.class){
			return sessionFactory.getCurrentSession().createQuery("from Form")
            .list();
		}
		else if(recordClass==HR_mark.class){
			return sessionFactory.getCurrentSession().createQuery("from HR_mark")
            .list();
		}
		else if(recordClass==News.class){
			return sessionFactory.getCurrentSession().createQuery("from News")
            .list();
		}
		else if(recordClass==Interview.class){
			return sessionFactory.getCurrentSession().createQuery("from Interview")
            .list();
		}
		else if(recordClass==Users_type.class){
			return sessionFactory.getCurrentSession().createQuery("from Users_type")
            .list();
		}
		else if(recordClass==Tech_mark.class){
			return sessionFactory.getCurrentSession().createQuery("from Tech_mark")
            .list();
		}
		else if(recordClass==Form_backup.class){
			return sessionFactory.getCurrentSession().createQuery("from Form_backup")
            .list();
		}
		else return null;
	}

	
	public void deleteRecord(Object record) {
		if (null != record) {
            sessionFactory.getCurrentSession().delete(record);
        }
		
	}

}
