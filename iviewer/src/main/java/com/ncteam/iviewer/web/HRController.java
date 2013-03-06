package com.ncteam.iviewer.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.service.ValidationService;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

@Controller
public class HRController {

	 
	 @Autowired
	 private UserServiceImpl userService;
	 private ValidationService validator=new ValidationService();
	
	@RequestMapping(value="/hr")
	public String hr(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		
		List<Interview> interviews=userService.getAllRecords(Interview.class);		
		map.put("interviews",interviews);
		return "hr";
	}
	
	@RequestMapping(value="/hr_red_{interview_id}")
	public String redactInterviewFromHRPage(HttpServletRequest request, HttpSession session,
			@PathVariable("interview_id") Integer interview_id,	Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		
		String updateStartDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("startTime"));
		
		String updateEndDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("endTime"));
		
		if(validator.isInterviewDateStringValid(updateStartDateString)
				&&validator.isInterviewDateStringValid(updateEndDateString)){
			
			if(validator.isInterviewStartEarlierThanEnd((String)request.getParameter("startTime"),
					(String)request.getParameter("endTime"))){
				
		Interview redactedInterview=userService.getRecordById(interview_id, Interview.class);
		
		redactedInterview.setStringStart_date(updateStartDateString);
		redactedInterview.setStringEnd_date(updateEndDateString);
		redactedInterview.setSeats(Integer.parseInt((String)request.getParameter("seats")));
		
		userService.updateRecord(redactedInterview);
		}
		else{
			map.put("erroMessage", "Конец собеседования не может быть раньше его начала или совпадать с ним.");
		}
	}
	else{
		map.put("erroMessage","Введённые данные не соответствуют шаблону.");
	}

		map.put("interviews",userService.getAllRecords(Interview.class));
		return "hr";
	}
	
	
	@RequestMapping(value="hr_create_interview")
	public String createInterview(HttpServletRequest request, HttpSession session,
			Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
					
		String newStartDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("startTime"));
		
		String newEndDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("endTime"));
		
		if(validator.isInterviewDateStringValid(newStartDateString)
				&&validator.isInterviewDateStringValid(newEndDateString))
		{
			if(validator.isInterviewStartEarlierThanEnd((String)request.getParameter("startTime"),
					(String)request.getParameter("endTime"))){
				
		Interview newInterview=new Interview();
		
		newInterview.setStringEnd_date(newEndDateString);
		newInterview.setStringStart_date(newStartDateString);
		newInterview.setSeats(Integer.parseInt((String)request.getParameter("seats")));
		
		userService.addRecord(newInterview);
		}
			else{
				map.put("erroMessage", "Конец собеседования не может быть раньше его начала или совпадать с ним.");
			}
		}
		else{
			map.put("erroMessage","Введённые данные не соответствуют шаблону.");
		}
		
		
		List<Interview> interviews=userService.getAllRecords(Interview.class);		
		map.put("interviews",interviews);
		return "hr";
	}
	
	@RequestMapping(value="hr_delete_interview_{interview_id}")
	public String deleteInterviewFromHRPage(HttpSession session,
			@PathVariable("interview_id") Integer interview_id,	Map<String, Object> map){
	
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
			userService.deleteRecord(userService.getRecordById(interview_id, Interview.class));
		
		map.put("interviews",userService.getAllRecords(Interview.class));
		return "hr";
	}

}
