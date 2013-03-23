package com.ncteam.iviewer.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.domain.User;

@Controller
public class CandidateController{

	@RequestMapping(value = "candidate", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request) {
		
        return "candidate";
    }
	
	

	@RequestMapping("/candidate")
    public String registration(HttpSession session){
        return "/candidate";
    }
	
}