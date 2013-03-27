package com.ncteam.iviewer.web;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

@Controller
public class RegistrationController{
	
	@Autowired
	private UserServiceImpl userService;
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request) {
		User newUser = new User();
			String firstname = request.getParameter("firstname");
			String surname = request.getParameter("surname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			newUser.setFoto("");
			newUser.setUserTypeId(4);
			newUser.setRegDate(new Date(12,12,12));
		userService.addRecord(newUser);
			
        return "reg";
    }
	
	protected void sendMail(String name, String surname, String lastname, String email){
		
		
	}
	
	@RequestMapping("/registration")
    public String registration(HttpSession session){
        return "/reg";
    }
}