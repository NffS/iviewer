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
		
		if(((Integer)session.getAttribute("user_type")).equals(2)){
		
		String updateStartDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("startTime"));
		
		String updateEndDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("endTime"));
		
		Interview redactedInterview=tablesService.getRecordById(interview_id, Interview.class);
		if(!redactedInterview.getStringStart_date().equals(updateStartDateString)
				||!redactedInterview.getStringEnd_date().equals(updateEndDateString)){
			
			redactedInterview.setStringStart_date(updateStartDateString);
			redactedInterview.setStringEnd_date(updateEndDateString);
		}
		tablesService.updateRecord(redactedInterview);
		map.put("interviews",tablesService.getAllRecords(Interview.class));
		return "hr";
		}
		else{
			return "redirect/index";
		}
	}
	
	
	@RequestMapping(value="hr_create_interview")
	public String createInterview(HttpServletRequest request, Map<String, Object> map){
		
		if(!((String)request.getParameter("date")).isEmpty()
				&&!((String)request.getParameter("startTime")).isEmpty()
				&&!((String)request.getParameter("endTime")).isEmpty()){
			
		String newStartDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("startTime"));
		
		String newEndDateString=((String)request.getParameter("date"))
				.concat(" "+(String)request.getParameter("endTime"));
		
		Interview newInterview=new Interview();
		newInterview.setStringEnd_date(newEndDateString);
		newInterview.setStringStart_date(newStartDateString);
		newInterview.setSeats(0);
		tablesService.addRecord(newInterview);
		}
		
		List<Interview> interviews=tablesService.getAllRecords(Interview.class);		
		map.put("interviews",interviews);
		return "hr";
	}
	
	@RequestMapping(value="hr_delete_interview_{interview_id}")
	public String deleteInterviewFromHRPage(HttpServletRequest request, HttpSession session,
			@PathVariable("interview_id") Integer interview_id,	Map<String, Object> map){
	
		if(((Integer)session.getAttribute("user_type")).equals(2)){
		tablesService.deleteRecord(tablesService.getRecordById(interview_id, Interview.class));
		
		map.put("interviews",tablesService.getAllRecords(Interview.class));
		return "hr";
		}
		else{
			return "redirect:/index";
		}
	}
}
