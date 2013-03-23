package com.ncteam.iviewer.service.impl;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncteam.iviewer.DAO.impl.FormDAOImpl;
import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.FormInformation;
import com.ncteam.iviewer.domain.HRMark;
import com.ncteam.iviewer.domain.TechMark;

@Service
public class FormServiceImpl extends TablesServiceImpl<FormDAOImpl> {

	@Autowired
	private FormDAOImpl formDAO;
	
	public FormServiceImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		super.setDAO(formDAO);
	}
	
	public List<String> getAllInterviewsDates(){
		return formDAO.getAllInterviewsDates();
	}
	
	public List<FormInformation> getFormsInformation(){
		List<FormInformation> result=formDAO.getFormsInformation();
		Collections.sort(result);
		return result;
	}
	
	public List<String[]> getShortFormInformation(){
		return formDAO.getShortFormInformation();
	}
	
	public Hashtable<String, Long> getStudentsInUniversities(){
		return formDAO.getStudentsInUniversities();
	}
	
	public Hashtable<Integer, Long> getStudentsInFaculties(){
		return formDAO.getStudentsInFaculties();
	}
	
	public List<String> getCandidatesRegistrationDates(){
		return formDAO.getCandidatesRegistrationDates();
	}
	
	public byte[] getCameDoesntCameStudents(){
		return formDAO.getCameDoesntCameStudents();
	}
	
	public Hashtable<String, Integer> getAdvertisementEfficiency(){
		return formDAO.getAdvertisementEfficiency();
	}
	
	public List<String> getAllAdvertisementNames(){
		return formDAO.getAllAdvertisementNames();
	}

	public HRMark getHRMarkByFormId(int id){
		return formDAO.getHRMarkByFormId(id);
	}
	public TechMark getTechMarkByFormId(int id){
		return formDAO.getTechMarkByFormId(id);
	}
	public Form getFormByUserId(int userID){
		return formDAO.getFormByUserId(userID);
	}
}
