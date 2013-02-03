package com.ncteam.iviewer.DAO;

import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.ncteam.iviewer.domain.Interview;

public class InterviewDAOImpl extends TablesDAOImpl {

	static{
	  	  Locale.setDefault(Locale.ENGLISH);
		}
			
	private SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	
	public void updateInterview(Interview interview){
		String hql = "UPDATE Interview set seats=:seats, end_date=to_date(:end_date,'yyyy-mm-dd HH24:MI:SS')," +
				" start_date=to_date(:start_date,'yyyy-mm-dd HH24:MI:SS') where interview_id=:interview_id";
		Session session=sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		try{
		Query query = session.createQuery(hql);
		query.setParameter("seats", interview.getSeats());
		query.setParameter("end_date", interview.getStringEnd_date());
		query.setParameter("start_date", interview.getStringStart_date());
		query.setParameter("interview_id", interview.getInterview_id());
		query.executeUpdate();
		session.getTransaction().commit();
		}
		catch(Exception e){
			
			session.getTransaction().rollback();
		}
		
	}
}
