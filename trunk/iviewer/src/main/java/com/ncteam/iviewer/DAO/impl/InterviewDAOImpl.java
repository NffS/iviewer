package com.ncteam.iviewer.DAO.impl;

import java.util.Locale;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InterviewDAOImpl extends TablesDAOImpl {

	static{
	  	  Locale.setDefault(Locale.ENGLISH);
		}
	@Autowired
	private SessionFactory sessionFactory;
	
	public InterviewDAOImpl(){
		super();
	}
}
