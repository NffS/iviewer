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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

@Controller
public class ChooseInterviewController{

	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(value = "/choose")
    public String chooseInterview(HttpSession session, Map<String, Object> map) {
		
		List<Interview> interviews=userService.getAllRecords(Interview.class);
		map.put("interviews",interviews);
        return "/choose_interview";
    }
	


}