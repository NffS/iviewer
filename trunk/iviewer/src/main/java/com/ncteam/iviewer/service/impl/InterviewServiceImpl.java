package com.ncteam.iviewer.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncteam.iviewer.DAO.impl.InterviewDAOImpl;

@Service
public class InterviewServiceImpl extends TablesServiceImpl<InterviewDAOImpl> {

	@Autowired
	private InterviewDAOImpl interviewDAO;
	
	public InterviewServiceImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		super.setDAO(interviewDAO);
	}
}
