package com.ncteam.iviewer.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import validators.Validator;


import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.service.impl.InterviewServiceImpl;

@Controller
public class HRController {

	 
	 @Autowired
	 private InterviewServiceImpl interviewService;
	 private Validator validator=new Validator();
	
	@RequestMapping(value="/hr")
	public String hr(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
	        map.put("message","<font color='red'>Ошибка доступа</font>");
	        map.put("target","index");
	        return "redirect";
		}
		
		map.put("interviews",interviewService.getAllRecords(Interview.class));
		return "hr";
	}
	
	@RequestMapping(value="/hr_red_{interview_id}")
	public String redactInterviewFromHRPage(HttpServletRequest request, HttpSession session,
			@PathVariable("interview_id") Integer interview_id,	Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
	        map.put("message","<font color='red'>Ошибка доступа</font>");
	        map.put("target","index");
	        return "redirect";
		}
				
		String updateStartDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("startTime"));
		
		String updateEndDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("endTime"));
		
		if(validator.isInterviewDateStringValid(updateStartDateString)
				&&validator.isInterviewDateStringValid(updateEndDateString)){
			
			if(validator.isInterviewStartEarlierThanEnd((String)request.getParameter("startTime"),
					(String)request.getParameter("endTime"))){
				
		Interview redactedInterview=interviewService.getRecordById(interview_id, Interview.class);
				
		redactedInterview.setStringStartDate(updateStartDateString);
		redactedInterview.setStringEndDate(updateEndDateString);
		redactedInterview.setExtraTime(Integer.parseInt((String)request.getParameter("extraTime")));
		redactedInterview.setSeats(Integer.parseInt((String)request.getParameter("seats")));
		
		String errorMessage=validator.checkInterviewsIntersection(redactedInterview,
				interviewService.getAllRecords(Interview.class), false);
		
		if(errorMessage!=null){
			map.put("erroMessage",errorMessage);
			map.put("interviews",interviewService.getAllRecords(Interview.class));
			return "hr";
		}
		
		interviewService.updateRecord(redactedInterview);
		}
		else{
			map.put("erroMessage", "Конец собеседования не может быть раньше его начала или совпадать с ним.");
		}
	}
	else{
		map.put("erroMessage","Введённые данные не соответствуют шаблону.");
	}

		map.put("interviews",interviewService.getAllRecords(Interview.class));
		return "hr";
	}
	
	
	@RequestMapping(value="hr_create_interview")
	public String createInterview(HttpServletRequest request, HttpSession session,
			Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
	        map.put("message","<font color='red'>Ошибка доступа</font>");
	        map.put("target","index");
	        return "redirect";
		}
					
		String newStartDateString=((String)request.getParameter("newDate"))
				.concat(" "+(String)request.getParameter("newStartTime"));
		
		String newEndDateString=((String)request.getParameter("newDate"))
				.concat(" "+(String)request.getParameter("newEndTime"));
		
		if(validator.isInterviewDateStringValid(newStartDateString)
				&&validator.isInterviewDateStringValid(newEndDateString))
		{
			if(validator.isInterviewStartEarlierThanEnd((String)request.getParameter("newStartTime"),
					(String)request.getParameter("newEndTime"))){
				
		Interview newInterview=new Interview();
		
		newInterview.setStringEndDate(newEndDateString);
		newInterview.setStringStartDate(newStartDateString);
		newInterview.setExtraTime(Integer.parseInt((String)request.getParameter("newExtraTime")));
		newInterview.setSeats(Integer.parseInt((String)request.getParameter("newSeats")));
		
		String errorMessage=validator.checkInterviewsIntersection(newInterview,
				interviewService.getAllRecords(Interview.class), true);
		
		if(errorMessage!=null){
			map.put("erroMessage",errorMessage);
			map.put("interviews",interviewService.getAllRecords(Interview.class));
			return "hr";
		}
		
		interviewService.addRecord(newInterview);
		}
			else{
				map.put("erroMessage", "Конец собеседования не может быть раньше его начала или совпадать с ним.");
			}
		}
		else{
			map.put("erroMessage","Введённые данные не соответствуют шаблону.");
		}
		
		map.put("interviews",interviewService.getAllRecords(Interview.class));
		return "hr";
	}
	
	@RequestMapping(value="hr_delete_interview_{interview_id}")
	public String deleteInterviewFromHRPage(HttpSession session,
			@PathVariable("interview_id") Integer interview_id,	Map<String, Object> map){
	
		if(!validator.isUserHR(session)){
	        map.put("message","<font color='red'>Ошибка доступа</font>");
	        map.put("target","index");
	        return "redirect";
		}
		interviewService.deleteRecord(interviewService.getRecordById(interview_id, Interview.class));
		
		map.put("interviews",interviewService.getAllRecords(Interview.class));
		return "hr";
	}

}
