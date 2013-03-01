package com.ncteam.iviewer.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lowagie.text.Document;
import com.ncteam.iviewer.domain.User;

@Controller
public class FormController{

	@RequestMapping(value = "form", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request) {
		
		
        return "form";
    }
	
	void createPDF(){
		Document document = new Document();
		
		
	}
	
	@RequestMapping("form")
    public String registration(HttpSession session){
        return "/form";
    }
}