package com.ncteam.iviewer.web;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.TechMark;
import com.ncteam.iviewer.service.ValidationService;
import com.ncteam.iviewer.service.impl.FormServiceImpl;

@Controller
public class TechMarkController {

	@Autowired
	private FormServiceImpl formService;
	private ValidationService validator=new ValidationService();
	
	@RequestMapping("/tech_mark_{form_id}")
	public String techMark(HttpServletResponse response, HttpSession session,
			@PathVariable("form_id") Integer form_id,	Map<String, Object> map) throws UnsupportedEncodingException{
			
		if(!validator.isUserTech(session)){
			return "redirect:/index";
		}
		Form form=formService.getRecordById(form_id,Form.class);
		form.setTechMark(formService.getTechMarkByFormId(form_id));
		map.put("form", form);
		response.setCharacterEncoding("UTF-8");
		return "tech_mark";
	}
	
	@RequestMapping("/tech_mark_save")
	public String techMarkSave(HttpSession session, HttpServletRequest request,
			Map<String, Object> map) throws UnsupportedEncodingException{
		
		if(!validator.isUserTech(session)){
			return "redirect:/index";
		}
		TechMark mark = null;
		if(request.getParameter("it_mark_id")==""){
			mark=new TechMark();
			mark.setFormId(Integer.parseInt(request.getParameter("form_id")));
			mark.setProgLang(Integer.parseInt(request.getParameter("prog_lang")));
			mark.setOop(Integer.parseInt(request.getParameter("oop")));
			mark.setPatterns(Integer.parseInt(request.getParameter("patterns")));
			mark.setDb(Integer.parseInt(request.getParameter("db")));
			mark.setCs(Integer.parseInt(request.getParameter("computer_science")));
			mark.setExperience(Integer.parseInt(request.getParameter("experience")));
			mark.setOther(Integer.parseInt(request.getParameter("other")));
			mark.setGeneralMark(new String(request.getParameter("general")));
			formService.addRecord(mark);
		}
		else{
			mark=formService.getRecordById(Integer.parseInt(request.getParameter("tech_mark_id")), TechMark.class);
			mark.setProgLang(Integer.parseInt(request.getParameter("prog_lang")));
			mark.setOop(Integer.parseInt(request.getParameter("oop")));
			mark.setPatterns(Integer.parseInt(request.getParameter("patterns")));
			mark.setDb(Integer.parseInt(request.getParameter("db")));
			mark.setCs(Integer.parseInt(request.getParameter("cs")));
			mark.setExperience(Integer.parseInt(request.getParameter("experience")));
			mark.setOther(Integer.parseInt(request.getParameter("other")));
			mark.setGeneralMark(request.getParameter("general"));
			formService.updateRecord(mark);
		}
		
		Form markedForm=formService.getRecordById(Integer.parseInt(request.getParameter("form_id")), Form.class);
		markedForm.setVisitStatus(1);
		formService.updateRecord(markedForm);
		
		map.put("target", "interview");
		map.put("message", "Оценка сохранена.");
		return "redirect";
	}
}
