package com.ncteam.iviewer.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.service.TablesService;
import com.ncteam.iviewer.service.ValidationService;

@Controller
public class ReportsController {
	
	@Autowired
	 private TablesService tablesService;
	 private ValidationService validator=new ValidationService();
	
	 
	 
	@RequestMapping(value="/hr_reports")
	public String hrReports(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		return "hr_reports";
	}

	@RequestMapping("/attendance_report")
	public String attendanceReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		
		ArrayList<Form> forms=(ArrayList<Form>) tablesService.getAllRecords(Form.class);
		Collections.sort(forms);
		map.put("attendances", forms);
		
		
		return "hr_reports";
	}
}
