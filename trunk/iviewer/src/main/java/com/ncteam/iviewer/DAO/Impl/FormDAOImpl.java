package com.ncteam.iviewer.DAO.Impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Support.FormInformationTransformer;

import com.ncteam.iviewer.domain.FormInformation;

@Repository
public class FormDAOImpl extends TablesDAOImpl {

	static{
	  	  Locale.setDefault(Locale.ENGLISH);
		}
	@Autowired
	private SessionFactory sessionFactory;
	
	public FormDAOImpl(){
		super();
	}
	
	public List<String> getAllInterviewsDates(){
		
		String query="SELECT to_char(start_date, :format) FROM Interview";
		Session sess=sessionFactory.openSession();
		List<String> interviewsDates=null;

			interviewsDates = (List<String>) sess.createQuery(query).setString("format", "yyyy-mm-dd hh24:mi")
					.list();

		return interviewsDates;
	}
	
	public List<String> getAllUniversityNames(){
		String query="SELECT university_name FROM University";
		Session sess=sessionFactory.openSession();
		List<String> universities=null;

			universities = (List<String>) sess.createQuery(query).list();

		return universities;
	}
	
	/*
	 * The method picks some fields from Form, Users and Universities tables.
	 * 
	 * @return The list of FormInformation class. Uses FormInformationTransformer class to achieve this.
	 */
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

			result = query.list();

		return result;
	}
	
	/*
	 * The method picks some fields from Form and Users tables, but less than the getFormsInformation() method.
	 * 
	 * @return The list, every element of which contains information about one candidate. 
	 */
	public List<String[]> getShortFormInformation(){
		Session sess=sessionFactory.openSession();
		Query query=sess.createQuery("SELECT  u.surname, u.first_name, u.last_name," +
				"to_char(f.visit_status) FROM Form f, User u where f.user_id=u.user_id");
		List<Object[]> queryList=null;
		List<String[]> result=new ArrayList<String[]>();

			queryList =(List<Object[]>) query.list();
			for(Object[] o:queryList){
				result.add(new String[]{(String)o[0], (String)o[1], (String)o[2], (String)o[3]});
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
		queryList =(List<Object[]>) query.list();
		for(Object[] o:queryList){
			result.put((String)o[0], (Long)o[1]);
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

			queryList =(List<Object[]>) query.list();
			for(Object[] o:queryList){
				result.put((Integer)o[0], (Long)o[1]);
			}
			
		return result;
	}
	
	public List<String> getCandidatesRegistrationDates(){
		Session sess=sessionFactory.openSession();
		Query query=sess.createQuery("SELECT  to_char(u.reg_date,'yyyy-mm-dd')" +
				"FROM Form f, User u where f.user_id=u.user_id");
		List<String> result=new ArrayList<String>();
		
			result =(List<String>) query.list();
			
		return result;
	}
	
	/*
	 * Элемент [0] возвращаемого массива - количество студентов, которые не пришли на собеседование
	 * Элемент [1] возвращаемого массива - количество студентов, которые пришли на собеседование
	 */
	public byte[] getCameDoesntCameStudents(){

		Session sess=sessionFactory.openSession();
		Query query=sess.createQuery("SELECT count(*)" +
				"FROM Form where visit_status=:visit_status");
		byte[] result=new byte[2];
	
			result[0] =((Long) query.setInteger("visit_status", 0).uniqueResult()).byteValue();
			result[1]=((Long) query.setInteger("visit_status", 1).uniqueResult()).byteValue();
			
		return result;
	}
	
	/*
	 * @return The hastable's key is the advertisement name, 
	 * the value is the number of candidates, that has chosen this type of advertisement.
	 */
	public Hashtable<String, Integer> getAdvertisementEfficiency(){
		
		Session sess=sessionFactory.openSession();
		Query query=sess.createQuery("SELECT s.source_name, count(*)" +
				"FROM Form f RIGHT OUTER JOIN f.source s " +
				"GROUP BY s.source_name");
		Hashtable<String, Integer> result=new Hashtable<String, Integer>();
		List<Object[]> temp= query.list();
			for(Object[] o:temp){
				result.put((String)o[0], ((Long)o[1]).intValue());
			}
			
		return result;
	}
	
	public List<String> getAllAdvertisementNames(){
		String query="SELECT source_name FROM Source";
		Session sess=sessionFactory.openSession();
		List<String> result=null;
		
			result = (List<String>) sess.createQuery(query).list();
			
		return result;
	}
}
