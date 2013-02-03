package com.ncteam.iviewer.service;

import org.springframework.transaction.annotation.Transactional;

import com.ncteam.iviewer.DAO.InterviewDAOImpl;
import com.ncteam.iviewer.domain.Interview;


public class InterviewServiceImpl extends TablesServiceImpl {

	
	private InterviewDAOImpl interviewDAO=new InterviewDAOImpl();
	

	@Transactional
	public void updateInterview(Interview interview) {
		interviewDAO.updateInterview(interview);
	}
}
