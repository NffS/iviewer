package com.ncteam.iviewer.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncteam.iviewer.domain.User;

@Controller
public class RegistrationController{

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request) {
		
		System.out.println(request.getParameter("first_name"));
        return "registration";
    }
	
	protected void sendMail(String name, String surname, String lastname, String email){
		
		
	}
	
	@RequestMapping("/registration")
    public String registration(HttpSession session){
        return "/reg";
    }
}