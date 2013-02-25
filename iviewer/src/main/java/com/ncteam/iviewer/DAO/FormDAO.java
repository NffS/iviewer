package com.ncteam.iviewer.DAO;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Support.FormInformationTransformer;

import com.ncteam.iviewer.domain.FormInformation;


public class FormDAO extends TablesDAOImpl {

	static{
	  	  Locale.setDefault(Locale.ENGLISH);
		}
	
	private SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	
	public FormDAO(){
		super.setSessionFactory(sessionFactory);
	}
	
	public List<String> getAllInterviewsDates(){
		
		String query="SELECT to_char(start_date, :format) FROM Interview";
		Session sess=sessionFactory.openSession();
		List<String> interviewsDates=null;
		sess.getTransaction().begin();
		try{
			interviewsDates = (List<String>) sess.createQuery(query).setString("format", "yyyy-mm-dd hh24:mi")
					.list();
			sess.getTransaction().commit();
			sess.close();
		}
		catch(Exception e){
			sess.getTransaction().rollback();
			sess.close();
		}
		return interviewsDates;
	}
	
	public List<String> getAllUniversityNames(){
		String query="SELECT university_name FROM University";
		Session sess=sessionFactory.openSession();
		List<String> universities=null;
		sess.getTransaction().begin();
		try{
			universities = (List<String>) sess.createQuery(query).list();
			sess.getTransaction().commit();
			sess.close();
		}
		catch(Exception e){
			sess.getTransaction().rollback();
			sess.close();
		}
		return universities;
	}
	
	public List<FormInformation> getFormsInformation(){
		Session sess=sessionFactory.openSession();
		Query query=sess.createQuery("SELECT u.first_name, u.surname, u.last_name," +
				"to_char(i.start_date,'yyyy-mm-dd HH24:mi'), f.status, f.form_id, un.university_name" +
				"  FROM Form f, User u, Interview i, University un " +
				"where f.user_id=u.user_id " +
				"and f.interview_id=i.interview_id " +
				"and f.university_id=un.university_id");
		query.setResultTransformer(new FormInformationTransformer());
		List<FormInformation> result=null;
		sess.getTransaction().begin();
		try{
			result = query.list();
			sess.getTransaction().commit();
			sess.close();
		}
		catch(Exception e){
			sess.getTransaction().rollback();
			sess.close();
		}
		return result;
	}
	
	public List<String[]> getShortFormInformation(){
		Session sess=sessionFactory.openSession();
		Query query=sess.createQuery("SELECT  u.surname, u.first_name, u.last_name," +
				"to_char(f.visit_status) FROM Form f, User u where f.user_id=u.user_id");
		List<Object[]> queryList=null;
		List<String[]> result=new ArrayList<String[]>();
		sess.getTransaction().begin();
		try{
			queryList =(List<Object[]>) query.list();
			for(Object[] o:queryList){
				result.add(new String[]{(String)o[0], (String)o[1], (String)o[2], (String)o[3]});
			}
			sess.getTransaction().commit();
			sess.close();
		}
		catch(Exception e){
			sess.getTransaction().rollback();
			sess.close();
		}
		return result;
	}
	
	public Hashtable<String, Long> getStudentsInUniversities(){

		Session sess=sessionFactory.openSession();
		Query query=sess.createQuery("SELECT  u.university_name, count(f.form_id)" +
				" FROM Form f RIGHT OUTER JOIN f.university u  " +
				"group by u.university_name");
		List<Object[]> queryList=null;
		Hashtable<String, Long> result=new Hashtable<String, Long>();
		sess.getTransaction().begin();
		try{
			queryList =(List<Object[]>) query.list();
			for(Object[] o:queryList){
				result.put((String)o[0], (Long)o[1]);
			}
			sess.getTransaction().commit();
			sess.close();
		}
		catch(Exception e){
			sess.getTransaction().rollback();
			sess.close();
		}
		return result;
	}
	
	public Hashtable<Integer, Long> getStudentsInFaculties(){
		Session sess=sessionFactory.openSession();
		Query query=sess.createQuery("SELECT  fa.faculty_id, count(f.form_id) " +
				" FROM Form f RIGHT OUTER JOIN f.faculty fa  " +
				"group by fa.faculty_id");
		List<Object[]> queryList=null;
		Hashtable<Integer, Long> result=new Hashtable<Integer, Long>();
		sess.getTransaction().begin();
		try{
			queryList =(List<Object[]>) query.list();
			for(Object[] o:queryList){
				result.put((Integer)o[0], (Long)o[1]);
			}
			sess.getTransaction().commit();
			sess.close();
		}
		catch(Exception e){
			sess.getTransaction().rollback();
			sess.close();
		}
		return result;
	}
	
	public List<String> getCandidatesRegistrationDates(){
		Session sess=sessionFactory.openSession();
		Query query=sess.createQuery("SELECT  to_char(u.reg_date,'yyyy-mm-dd')" +
				"FROM Form f, User u where f.user_id=u.user_id");
		List<String> result=new ArrayList<String>();
		sess.getTransaction().begin();
		try{
			result =(List<String>) query.list();
			sess.getTransaction().commit();
			sess.close();
		}
		catch(Exception e){
			sess.getTransaction().rollback();
			sess.close();
		}
		return result;
	}
}
