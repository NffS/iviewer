package com.ncteam.iviewer.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import validators.Validator;


import com.ncteam.iviewer.domain.University;
import com.ncteam.iviewer.service.impl.FormServiceImpl;


@Controller
public class FormListController {

	@Autowired
	 private FormServiceImpl formService;
	 private Validator validator=new Validator();
	
	@RequestMapping("/form_list")
	public String form_list(HttpSession session, Map<String, Object> map){
			
		if(!validator.isUserHR(session)){
	        map.put("message","<font color='red'>Ошибка доступа</font>");
	        map.put("target","index");
	        return "redirect";
		}
		
		map.put("interviewsDates", formService.getAllInterviewsDates());
		map.put("forms", formService.getFormsInformation());
		map.put("universities", formService.getAllRecords(University.class));
		return "form_list";
	}

}
