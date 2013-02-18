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
	
	@RequestMapping(value="universities_report")
	public String universitiesReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		
		List<Form> forms=tablesService.getAllRecords(Form.class);
		List<University> universities=tablesService.getAllRecords(University.class);
		List<Faculty> faculties=tablesService.getAllRecords(Faculty.class);
		
		Hashtable<String, Integer> studentsInUniversitiesTable=new Hashtable<String, Integer>();
		Hashtable<Hashtable<Integer, Integer>, Integer> studentsInFacultiesTable=new Hashtable<Hashtable<Integer, Integer>, Integer>();
		
		int universityCount = 0;
		int facultyCount = 0;
		
		for(University university : universities){
			universityCount = 0;
			for(Form form : forms){
				if(form.getUniversity_id().equals(university.getUniversity_id())){
					universityCount++;
				}
			}
			studentsInUniversitiesTable.put(university.getUniversity_name(), universityCount);
		}
		for(Faculty faculty : faculties){
			facultyCount = 0;
			for(Form form : forms){
				if(faculty.getUniversity_id().equals(form.getUniversity_id())
						&&faculty.getFaculty_id().equals(form.getFaculty_id())){
					facultyCount++;
				}
			}
			Hashtable<Integer, Integer> facultiesInUniversitiesTable=new Hashtable<Integer, Integer>();
			facultiesInUniversitiesTable.put(faculty.getUniversity_id(),faculty.getFaculty_id());
			studentsInFacultiesTable.put(facultiesInUniversitiesTable, facultyCount);
		}
		map.put("studentsInUniversitiesTable", studentsInUniversitiesTable);
		map.put("studentsInFacultiesTable", studentsInFacultiesTable);
		map.put("universities", universities);
		map.put("faculties", faculties);
		return "hr_reports";
	}
	
	@RequestMapping(value="records_increase_report")
	public String recordsIncreaseReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		map.put("recordIncreaseForms", tablesService.getAllRecords(Form.class));
		return "hr_reports";
	}
}
