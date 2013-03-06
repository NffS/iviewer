package com.ncteam.iviewer.service.impl;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncteam.iviewer.DAO.impl.UserDAOImpl;
import com.ncteam.iviewer.domain.User;

@Service
public class UserServiceImpl extends TablesServiceImpl<UserDAOImpl> {

	@Autowired
	private UserDAOImpl userDAO;
	
	public UserServiceImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		super.setDAO(userDAO);
	}
	
	public User getUserByEmail(String email) {
		return (User) userDAO.getUserByEmail(email);
	}
}
