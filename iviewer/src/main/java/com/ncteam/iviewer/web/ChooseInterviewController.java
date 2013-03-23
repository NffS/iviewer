package com.ncteam.iviewer.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.impl.FormServiceImpl;
import com.ncteam.iviewer.service.impl.InterviewServiceImpl;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

@Controller
public class ChooseInterviewController{

	 @Autowired
	 private InterviewServiceImpl interviewService;
	 @Autowired
	 private FormServiceImpl formService;
	 
	@RequestMapping(value = "/choose")
    public String chooseInterview(HttpSession session, Map<String, Object> map) {
		List<Interview> allInterviews = interviewService.getAllRecords(Interview.class);
		List<Interview> interviews = interviewService.getAllRecords(Interview.class);
		interviews.clear();
		for (int i=0;i<allInterviews.size();i++)
			if(allInterviews.get(i).getSeats()>allInterviews.get(i).getForms().size())
				interviews.add(allInterviews.get(i));
					
		map.put("interviews",interviews);
        return "choose_interview";
    }
	
	@RequestMapping(value="/choose_{interview_id}")
	public String chooseInterviewByID(HttpSession session,
			@PathVariable("interview_id") Integer interview_id,	Map<String, Object> map){
		Form form = formService.getFormByUserId(Integer.parseInt((String) session.getAttribute("user_id")));
		form.setInterviewId(interview_id);
		formService.updateRecord(form);
		return "choose_interview";
	}
}