package com.ncteam.iviewer.service;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import com.ncteam.iviewer.DAO.FormDAO;
import com.ncteam.iviewer.domain.FormInformation;

public class FormService extends TablesServiceImpl {

	
	private FormDAO formDAO=new FormDAO();
	
	public FormService(){
		super.setTablesDAO(formDAO);
	}
	
	public List<String> getAllInterviewsDates(){
		return formDAO.getAllInterviewsDates();
	}
	
	public List<String> getAllUniversityNames(){
		return formDAO.getAllUniversityNames();
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
}
