package com.ncteam.iviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncteam.iviewer.DAO.UserDAOImpl;
import com.ncteam.iviewer.domain.User;


public class UserServiceImpl extends TablesServiceImpl {

	
	private UserDAOImpl userDAO=new UserDAOImpl();
	
	@Transactional
	public User getUserByEmail(String email) {
		return (User) userDAO.getUserByEmail(email);
	}
}
