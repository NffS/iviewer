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
import com.ncteam.iviewer.domain.User;

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
	public Form getFirstForm(){
		Form newForm = new Form();		
			newForm.setInterestTc("+-");
			newForm.setInterestNc("+-");
			
			newForm.setInterestAreaPo("+-");
			
			newForm.setJobArDeepSpec("+-");
			newForm.setJobArManage("+-");
			newForm.setJobArSales("+-");
			newForm.setJobArVaried("+-");
			
			newForm.setProgLangC(1);
			newForm.setProgLangJava(1);
			
			newForm.setCsAlgorithms(0);
			newForm.setCsDb(0);
			newForm.setCsDesign(0);
			newForm.setCsGui(0);
			newForm.setCsNetworkProg(0);
			newForm.setCsNetworkTech(0);
			newForm.setCsOop(0);
			newForm.setCsWeb(0);
			
			newForm.setEnglishRead(1);
			newForm.setEnglishSpoken(1);
			newForm.setEnglishWrite(1);
			
			newForm.setSourceId(4);
			
			newForm.setComment2(" ");
			newForm.setMotivation_comment(" ");
			
			newForm.setStatus(0);
			newForm.setVisitStatus(0);
		return newForm;
	}
}
