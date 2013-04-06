package com.ncteam.iviewer.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import validators.Validator;


import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.domain.University;
import com.ncteam.iviewer.service.impl.FormServiceImpl;
import com.ncteam.iviewer.service.impl.InterviewServiceImpl;

@Controller
public class TechController {

	 
	 @Autowired
	 private FormServiceImpl formService;
	 @Autowired
	 private Validator validator;
	
	@RequestMapping(value="/interview")
	public String it(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserTech(session)){
			return "redirect:/index";
		}
		map.put("interviewsDates", formService.getAllInterviewsDates());
		map.put("forms", formService.getFormsInformation());
		map.put("universities", formService.getAllRecords(University.class));
		return "tech";
	}
	
}
