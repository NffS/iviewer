package com.ncteam.iviewer.web;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
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

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.ncteam.iviewer.DAO.impl.FormDAOImpl;
import com.ncteam.iviewer.domain.Faculty;
import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.University;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.impl.FormServiceImpl;
import com.ncteam.iviewer.service.impl.PDFservice;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

@Controller
public class FormController{
	
	@Autowired
	 private UserServiceImpl userService;
	@Autowired
	 private FormServiceImpl formService;
	
	@RequestMapping(value = "/getform", method = RequestMethod.POST)
    public String createForm(HttpServletRequest request, HttpSession session) throws DocumentException, IOException {
		
		Form newForm = new Form();
			User user = userService.getUserByEmail(session.getAttribute("email").toString());
			newForm.setUserId(user.getUserId());
			
			
			
		newForm.setUser(user);
			University university = new University();
			university.setUniversityId(1);
			university.setUniversityName(request.getParameter("univerid"));
		newForm.setUniversity(university);
			Faculty faculty = new Faculty();
			faculty.setFacultyId(1);
			faculty.setFacultyName(request.getParameter("faculty"));
			faculty.setUniversityId(1);
			faculty.setUniversity(university);
		
		newForm.setCourse(Integer.getInteger(request.getParameter("univerid")));
		newForm.setEndYear(request.getParameter("year"));
		
		newForm.setEmail2(request.getParameter("email2"));
		newForm.setPhone(request.getParameter("phone"));
		newForm.setAnotherContact(request.getParameter("another_contact"));
		
		newForm.setInterestNc("+");
		newForm.setInterestTc("+");
		newForm.setInterestAreaPo("+");
		newForm.setInterestAreaOther("+");
		
		newForm.setJobArDeepSpec("+");
		newForm.setJobArVaried("+");
		newForm.setJobArManage("+");
		newForm.setJobArSales("+");
		newForm.setJobArOther("+");
		
		newForm.setProgLangC(Integer.getInteger(request.getParameter("lan_c")));
		newForm.setProgLangJava(Integer.getInteger(request.getParameter("lan_java")));
		newForm.setProgLangOther("lan_another1");
		
		newForm.setCsNetworkTech(Integer.getInteger(request.getParameter("cs_net")));
		newForm.setCsAlgorithms(Integer.getInteger(request.getParameter("cs_algorithm")));
		newForm.setCsOop(Integer.getInteger(request.getParameter("cs_oop")));
		newForm.setCsDb(Integer.getInteger(request.getParameter("cs_bd")));
		newForm.setCsWeb(Integer.getInteger(request.getParameter("cs_web")));
		newForm.setCsGui(Integer.getInteger(request.getParameter("cs_gui")));
		newForm.setCsNetworkProg(Integer.getInteger(request.getParameter("cs_netprog")));
		newForm.setCsDesign(Integer.getInteger(request.getParameter("cs_design")));
		
		newForm.setEnglishRead(Integer.getInteger(request.getParameter("eng_reading")));
		newForm.setEnglishWrite(Integer.getInteger(request.getParameter("eng_writting")));
		newForm.setEnglishSpoken(Integer.getInteger(request.getParameter("eng_speaking")));
		
		newForm.setExperience(request.getParameter("experience"));
		newForm.setMotivation_comment(request.getParameter("promises"));
		newForm.setComment2(request.getParameter("more_information"));
		
		newForm.setStatus(1);
		newForm.setVisitStatus(1);
		
		
		
        return "form";
    }
	
    @RequestMapping(value = "/form")
    public String registration(HttpSession session, Map<String, Object> map){
		User user = userService.getUserByEmail(session.getAttribute("email").toString());
		Form form = formService.getFormByUserId(Integer.parseInt(session.getAttribute("user_id").toString()));
		
		map.put("user", user);
		map.put("form", form);
        return "form";
    }
    
  }