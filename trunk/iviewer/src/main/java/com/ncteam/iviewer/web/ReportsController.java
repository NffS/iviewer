package com.ncteam.iviewer.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncteam.iviewer.domain.Faculty;
import com.ncteam.iviewer.domain.University;
import com.ncteam.iviewer.service.ValidationService;
import com.ncteam.iviewer.service.impl.FormServiceImpl;

@Controller
public class ReportsController {
	
	@Autowired
	 private FormServiceImpl formService;
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
		
		
		return "hr_attendencies_report";
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
		return "hr_universities_report";
	}
	
	@RequestMapping(value="records_increase_report")
	public String recordsIncreaseReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		map.put("recordIncreaseForms", formService.getCandidatesRegistrationDates());
		return "hr_records_increase_report";
	}
	
	@RequestMapping(value="graphic_forms_report")
	public String graphicFormsReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		map.put("cameDoesntCameStudents", formService.getCameDoesntCameStudents());
		return "hr_graphic_forms_report";
	}
	
	@RequestMapping(value="graphic_pr_report")
	public String graphicPRReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		map.put("advertisementEfficiency", formService.getAdvertisementEfficiency());
		map.put("advertisementNames", formService.getAllAdvertisementNames());
		return "hr_graphic_pr_report";
	}
}
