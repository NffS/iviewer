package com.ncteam.iviewer.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import validators.Validator;


import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.TechMark;
import com.ncteam.iviewer.service.impl.FormServiceImpl;

@Controller
public class TechMarkController {

	@Autowired
	private FormServiceImpl formService;
	private Validator validator=new Validator();
	
	@RequestMapping("/tech_mark_{form_id}")
	public String techMark(HttpServletResponse response, HttpSession session,
			@PathVariable("form_id") Integer form_id,	Map<String, Object> map) {
			
		if(!validator.isUserTech(session)&&!validator.isUserHR(session)){
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
			Map<String, Object> map) {
		
		int progLang, oop, patterns, db, cs, experience, other;
		
		if(!validator.isUserTech(session)){
			return "redirect:/index";
		}
		
		try {
			progLang = Integer.parseInt(request.getParameter("prog_lang"));
			oop = Integer.parseInt(request.getParameter("oop"));
			patterns = Integer.parseInt(request.getParameter("patterns"));
			db = Integer.parseInt(request.getParameter("db"));
			cs = Integer.parseInt(request.getParameter("cs"));
			experience = Integer.parseInt(request.getParameter("experience"));
			other = Integer.parseInt(request.getParameter("other"));
			if (progLang<0 || progLang>100 || oop<0 || oop>100 || patterns<0 || patterns>100 || 
					db<0 || db>100 || cs<0 || cs>100 || experience<0 || experience>100 || other<0 || other>100){
				throw new Exception("Значение вне допустимого диапазона");
			}
		} catch(Exception e) {
			map.put("target", "tech_mark_"+request.getParameter("form_id"));
			map.put("message", "Ошибка сохранения оценки ("+e.getMessage()+")");
			return "redirect";
		}
		
		TechMark mark = null;
		
		if(request.getParameter("it_mark_id")==""){
			mark=new TechMark();
			mark.setFormId(Integer.parseInt(request.getParameter("form_id")));
		} else {
			mark=formService.getRecordById(Integer.parseInt(request.getParameter("tech_mark_id")), TechMark.class);
		}
		
		mark.setProgLang(progLang);
		mark.setOop(oop);
		mark.setPatterns(patterns);
		mark.setDb(db);
		mark.setCs(cs);
		mark.setExperience(experience);
		mark.setOther(other);
		mark.setGeneralMark(new String(request.getParameter("general")));
		
		if(request.getParameter("it_mark_id")==""){
			formService.addRecord(mark);
		} else {
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
