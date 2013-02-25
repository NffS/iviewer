package com.ncteam.iviewer.service;

import org.springframework.transaction.annotation.Transactional;

import com.ncteam.iviewer.DAO.UserDAO;
import com.ncteam.iviewer.domain.User;


public class UserServiceImpl extends TablesServiceImpl {

	
	private UserDAO userDAO=new UserDAO();
	
	public UserServiceImpl(){
		super.setTablesDAO(userDAO);
	}
	
	@Transactional
	public User getUserByEmail(String email) {
		return (User) userDAO.getUserByEmail(email);
	}
}
