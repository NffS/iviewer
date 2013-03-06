package com.ncteam.iviewer.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ncteam.iviewer.service.ValidationService;
import com.ncteam.iviewer.service.impl.FormServiceImpl;


@Controller
public class FormListController {

	@Autowired
	 private FormServiceImpl formService;
	 private ValidationService validator=new ValidationService();
	
	@RequestMapping("/form_list")
	public String form_list(HttpSession session, Map<String, Object> map){
			
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		
		map.put("interviewsDates", formService.getAllInterviewsDates());
		map.put("forms", formService.getFormsInformation());
		map.put("universities", formService.getAllUniversityNames());
		return "form_list";
	}

}
