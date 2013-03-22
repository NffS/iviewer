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
import com.ncteam.iviewer.domain.HRMark;
import com.ncteam.iviewer.service.ValidationService;
import com.ncteam.iviewer.service.impl.FormServiceImpl;

@Controller
public class HRMarkController {

	@Autowired
	private FormServiceImpl formService;
	private ValidationService validator=new ValidationService();
	
	@RequestMapping("/hr_mark_{form_id}")
	public String hrMark(HttpServletResponse response, HttpSession session,
			@PathVariable("form_id") Integer form_id,	Map<String, Object> map) throws UnsupportedEncodingException{
			
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		Form form=formService.getRecordById(form_id,Form.class);
		form.setHrMark(formService.getHRMarkByFormId(form_id));
		map.put("form", form);
		response.setCharacterEncoding("UTF-8");
		return "hr_mark";
	}
	
	@RequestMapping("/hr_mark_save")
	public String hrMarkSave(HttpSession session, HttpServletRequest request,
			Map<String, Object> map) throws UnsupportedEncodingException{
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		int english;
		int motivation;
		try{
			english=Integer.parseInt(request.getParameter("english"));
			motivation=Integer.parseInt(request.getParameter("motivation"));
			if(english>100||english<0||motivation>100||motivation<0){
				throw new Exception();
			}
		}
		catch(NumberFormatException e){
			map.put("target", "hr_mark_"+request.getParameter("form_id"));
			map.put("message", " Оценка не сохранена.\n Введённое значение оценки не является числом.");
			return "redirect";
		}
		catch(Exception e){
			map.put("target", "hr_mark_"+request.getParameter("form_id"));
			map.put("message", " Оценка не сохранена.\n Введённое значение оценки не соответствует формату поля (0-100).");
			return "redirect";
		}
		HRMark mark=null;
		if(request.getParameter("hr_mark_id")==""){
			mark=new HRMark();
			mark.setFormId(Integer.parseInt(request.getParameter("form_id")));
			mark.setEnglish(english);
			mark.setMotivation(motivation);
			mark.setGeneralMark(request.getParameter("general"));
			formService.addRecord(mark);
		}
		else{
			mark=formService.getRecordById(Integer.parseInt(request.getParameter("hr_mark_id")), HRMark.class);
			mark.setEnglish(Integer.parseInt(request.getParameter("english")));
			mark.setMotivation(Integer.parseInt(request.getParameter("motivation")));
			mark.setGeneralMark(request.getParameter("general"));
			formService.updateRecord(mark);
		}
		
		Form markedForm=formService.getRecordById(Integer.parseInt(request.getParameter("form_id")), Form.class);
		markedForm.setVisitStatus(1);
		formService.updateRecord(markedForm);
		
		map.put("target", "form_list");
		map.put("message", "Оценка сохранена.");
		return "redirect";
	}
}
