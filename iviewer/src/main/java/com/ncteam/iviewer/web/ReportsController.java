package com.ncteam.iviewer.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncteam.iviewer.domain.Faculty;
import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.University;
import com.ncteam.iviewer.service.FormService;
import com.ncteam.iviewer.service.TablesService;
import com.ncteam.iviewer.service.ValidationService;

@Controller
public class ReportsController {
	
	 private FormService formService=new FormService();
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
		
		map.put("attendances", formService.getShortFormInformation());
		
		
		return "hr_reports";
	}
	
	@RequestMapping(value="universities_report")
	public String universitiesReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		
		map.put("studentsInUniversitiesTable", formService.getStudentsInUniversities());
		map.put("studentsInFacultiesTable", formService.getStudentsInFaculties());
		map.put("universities", formService.getAllRecords(University.class));
		map.put("faculties", formService.getAllRecords(Faculty.class));
		return "hr_reports";
	}
	
	@RequestMapping(value="records_increase_report")
	public String recordsIncreaseReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		map.put("recordIncreaseForms", formService.getCandidatesRegistrationDates());
		return "hr_reports";
	}
}
