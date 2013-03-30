package com.ncteam.iviewer.DAO.impl;

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

import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.FormInformation;
import com.ncteam.iviewer.domain.HRMark;
import com.ncteam.iviewer.domain.TechMark;

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
		Session sess=sessionFactory.getCurrentSession();
		List<String> interviewsDates=null;

			interviewsDates = (List<String>) sess.createQuery(query).setString("format", "yyyy-mm-dd hh24:mi")
					.list();

		return interviewsDates;
	}
	
	/*
	 * The method picks some fields from Form, Users and Universities tables.
	 * 
	 * @return The list of FormInformation class. Uses FormInformationTransformer class to achieve this.
	 */
	public List<FormInformation> getFormsInformation(){
		Session sess=sessionFactory.getCurrentSession();
		Query query=sess.createQuery("SELECT u.firstName, u.surname, u.lastName, u.userId," +
				"coalesce(to_char(i.startDate,'yyyy-mm-dd HH24:mi'),'Нет записи'), f.status, f.visitStatus," +
				" f.formId, un.universityName, f.universityId" +
				"  FROM Form f LEFT JOIN f.university un LEFT JOIN f.interview as i LEFT JOIN f.user u");
		query.setResultTransformer(new FormInformationTransformer());
		List<FormInformation> result=null;

			result = query.list();

		return result;
	}
	
	/*
	 * Picks some fields from Form and Users tables, but less than the getFormsInformation() method.
	 * 
	 * @return The list, every element of which contains information about one candidate. 
	 */
	public List<String[]> getShortFormInformation(){
		Session sess=sessionFactory.getCurrentSession();
		Query query=sess.createQuery("SELECT  u.surname, u.firstName, u.lastName," +
				"to_char(f.visitStatus) FROM Form f, User u where f.userId=u.userId");
		List<Object[]> queryList=null;
		List<String[]> result=new ArrayList<String[]>();

			queryList =(List<Object[]>) query.list();
			for(Object[] o:queryList){
				result.add(new String[]{(String)o[0], (String)o[1], (String)o[2], (String)o[3]});
			}

		return result;
	}
	
	public Hashtable<String, Long> getStudentsInUniversities(){

		Session sess=sessionFactory.getCurrentSession();
		Query query=sess.createQuery("SELECT  u.universityName, count(f.formId)" +
				" FROM Form f RIGHT OUTER JOIN f.university u  " +
				"group by u.universityName");
		List<Object[]> queryList=null;
		Hashtable<String, Long> result=new Hashtable<String, Long>();
		queryList =(List<Object[]>) query.list();
		for(Object[] o:queryList){
			result.put((String)o[0], (Long)o[1]);
		}

		return result;
	}
	
	public Hashtable<Integer, Long> getStudentsInFaculties(){
		Session sess=sessionFactory.getCurrentSession();
		Query query=sess.createQuery("SELECT  fa.facultyId, count(f.formId) " +
				" FROM Form f RIGHT OUTER JOIN f.faculty fa  " +
				"group by fa.facultyId");
		List<Object[]> queryList=null;
		Hashtable<Integer, Long> result=new Hashtable<Integer, Long>();

			queryList =(List<Object[]>) query.list();
			for(Object[] o:queryList){
				result.put((Integer)o[0], (Long)o[1]);
			}
			
		return result;
	}
	
	public List<String> getCandidatesRegistrationDates(){
		Session sess=sessionFactory.getCurrentSession();
		Query query=sess.createQuery("SELECT  to_char(u.regDate,'yyyy-mm-dd')" +
				"FROM Form f, User u where f.userId=u.userId");
		List<String> result=new ArrayList<String>();
		
			result =(List<String>) query.list();
			
		return result;
	}
	
	/*
	 * Элемент [0] возвращаемого массива - количество студентов, которые не пришли на собеседование
	 * Элемент [1] возвращаемого массива - количество студентов, которые пришли на собеседование
	 */
	public byte[] getCameDoesntCameStudents(){

		Session sess=sessionFactory.getCurrentSession();
		Query query=sess.createQuery("SELECT count(*)" +
				"FROM Form f where f.visitStatus=:visit_status");
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
		
		Session sess=sessionFactory.getCurrentSession();
		Query query=sess.createQuery("SELECT s.sourceName, count(*)" +
				"FROM Form f RIGHT OUTER JOIN f.source s " +
				"GROUP BY s.sourceName");
		Hashtable<String, Integer> result=new Hashtable<String, Integer>();
		List<Object[]> temp= query.list();
			for(Object[] o:temp){
				result.put((String)o[0], ((Long)o[1]).intValue());
			}
			
		return result;
	}
	
	public List<String> getAllAdvertisementNames(){
		String query="SELECT sourceName FROM Source";
		Session sess=sessionFactory.getCurrentSession();
		List<String> result=null;
		
			result = (List<String>) sess.createQuery(query).list();
			
		return result;
	}
	
	public HRMark getHRMarkByFormId(int id){
		String query="FROM HRMark h where h.formId=:id";
		Session sess=sessionFactory.getCurrentSession();
		return (HRMark)sess.createQuery(query).setInteger("id", id).uniqueResult();
	}	
	
	public TechMark getTechMarkByFormId(int id){
		String query="FROM TechMark h where h.formId=:id";
		Session sess=sessionFactory.getCurrentSession();
		return (TechMark)sess.createQuery(query).setInteger("id", id).uniqueResult();
	}
	
	public Form getFormByUserId(int userID){
		String query="FROM Form f where f.userId=:userID";
		Session sess=sessionFactory.getCurrentSession();
		return (Form) sess.createQuery(query).setInteger("userID", userID).uniqueResult();
	}
}
