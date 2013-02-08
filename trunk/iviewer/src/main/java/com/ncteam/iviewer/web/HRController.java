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
import com.ncteam.iviewer.service.TablesService;

@Controller
public class HRController {

	 
	 @Autowired
	 private TablesService tablesService;
	
	@RequestMapping(value="/hr")
	public String hr(Map<String, Object> map){
		
		List<Interview> interviews=tablesService.getAllRecords(Interview.class);		
		map.put("interviews",interviews);
		return "hr";
	}
	
	@RequestMapping(value="/hr_red_{interview_id}")
	public String redactInterviewFromHRPage(HttpServletRequest request, HttpSession session,
			@PathVariable("interview_id") Integer interview_id,	Map<String, Object> map){
		
		if(((Integer)session.getAttribute("user_type_id")).equals(2)){
		
		String updateStartDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("startTime"));
		
		String updateEndDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("endTime"));
		
		if(isInterviewDateStringValid(updateStartDateString)
				&&isInterviewDateStringValid(updateEndDateString)){
			
			if(isInterviewStartEarlierThanEnd((String)request.getParameter("startTime"),
					(String)request.getParameter("endTime"))){
		Interview redactedInterview=tablesService.getRecordById(interview_id, Interview.class);
		if(!redactedInterview.getStringStart_date().equals(updateStartDateString)
				||!redactedInterview.getStringEnd_date().equals(updateEndDateString)){
			
			redactedInterview.setStringStart_date(updateStartDateString);
			redactedInterview.setStringEnd_date(updateEndDateString);
		}
		tablesService.updateRecord(redactedInterview);
		}
		else{
			map.put("erroMessage", "Конец собеседования не может быть раньше его начала или совпадать с ним.");
		}
	}
	else{
		map.put("erroMessage","Введённые данные не соответствуют шаблону.");
	}

		map.put("interviews",tablesService.getAllRecords(Interview.class));
		return "hr";
		}
		else{
			return "redirect/index";
		}
	}
	
	
	@RequestMapping(value="hr_create_interview")
	public String createInterview(HttpServletRequest request, HttpSession session,
			Map<String, Object> map){
		
		if(((Integer)session.getAttribute("user_type_id")).equals(2)){
		if(!((String)request.getParameter("date")).isEmpty()
				&&!((String)request.getParameter("startTime")).isEmpty()
				&&!((String)request.getParameter("endTime")).isEmpty()){
			
		String newStartDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("startTime"));
		
		String newEndDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("endTime"));
		
		if(isInterviewDateStringValid(newStartDateString)
				&&isInterviewDateStringValid(newEndDateString))
		{
			if(isInterviewStartEarlierThanEnd((String)request.getParameter("startTime"),
					(String)request.getParameter("endTime"))){
		Interview newInterview=new Interview();
		newInterview.setStringEnd_date(newEndDateString);
		newInterview.setStringStart_date(newStartDateString);
		newInterview.setSeats(0);
		tablesService.addRecord(newInterview);
		}
			else{
				map.put("erroMessage", "Конец собеседования не может быть раньше его начала или совпадать с ним.");
			}
		}
		else{
			map.put("erroMessage","Введённые данные не соответствуют шаблону.");
		}
		}
		
		List<Interview> interviews=tablesService.getAllRecords(Interview.class);		
		map.put("interviews",interviews);
		return "hr";
		}
		else{
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="hr_delete_interview_{interview_id}")
	public String deleteInterviewFromHRPage(HttpServletRequest request, HttpSession session,
			@PathVariable("interview_id") Integer interview_id,	Map<String, Object> map){
	
		if(((Integer)session.getAttribute("user_type_id")).equals(2)){
		tablesService.deleteRecord(tablesService.getRecordById(interview_id, Interview.class));
		
		map.put("interviews",tablesService.getAllRecords(Interview.class));
		return "hr";
		}
		else{
			return "redirect:/index";
		}
	}
	
	private boolean isInterviewDateStringValid(String interviewDateStrig){
		String pattern="201[3-9]-([0][1-9]|[1][0-2])-([0-2][0-9]|[3][0-1]) ([0-1][0-9]|2[0-4]):[0-5][0-9]";
		return interviewDateStrig.matches(pattern);
	}
	
	private boolean isInterviewStartEarlierThanEnd(String start, String end){
		if(Integer.parseInt(start.substring(0,2))>Integer.parseInt(end.substring(0,2)))
			return false;
		if(Integer.parseInt(start.substring(0,2))<Integer.parseInt(end.substring(0,2)))
			return true;
		if(Integer.parseInt(start.substring(3))<Integer.parseInt(end.substring(3)))
			return true;
		else
			return false;
	}
}
