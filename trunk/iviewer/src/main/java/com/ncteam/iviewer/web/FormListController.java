package com.ncteam.iviewer.web;

import com.ncteam.iviewer.support.FormListFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.TablesService;


@Controller
public class FormListController {

	@Autowired
	 private TablesService tablesService;
	
	
	@RequestMapping(value="/form_listFilter",  method = RequestMethod.POST)
	public String form_listDoFilter(@ModelAttribute("formListFilter") FormListFilter formListFilter, 
			Map<String, Object> map){
		
		String lastName=formListFilter.getLastName();
		String interviewDate=formListFilter.getInterviewDate();
		boolean requiredConfirmOnly=formListFilter.isRequiredConfirmOnly();
		
		List<Form> forms=tablesService.getAllRecords(Form.class);
		
		if(!lastName.isEmpty()){
			for(int i=0; i<forms.size(); i++){
				if(!forms.get(i).getUser().getSurname().equals(lastName)){
					forms.remove(i);
					i--;
				}
			}
		}
		if(!interviewDate.isEmpty()){
			for(int i=0; i<forms.size(); i++){
				if(!forms.get(i).getInterview().getStringStart_date().equals(interviewDate)){
					forms.remove(i);
					i--;
				}
			}
		}
		if(requiredConfirmOnly){
			for(int i=0; i<forms.size(); i++){
				if(!forms.get(i).getStatus().equals(1)){
					forms.remove(i);
					i--;
				}
			}
		}
		
		map.put("interviewsDates", getAllInterviewsDates());
		map.put("forms", forms);
		return "form_list";
	}
	
	@RequestMapping("/form_list")
	public String form_list(Map<String, Object> map){
		
		
		List<Form> forms=tablesService.getAllRecords(Form.class);
		
		map.put("interviewsDates", getAllInterviewsDates());
		map.put("forms", forms);
		return "form_list";
	}
	
	/*
	 * Помещает в модель объект, несущий информацию о параметрах фильтра
	 */
	@ModelAttribute("formListFilter")
	public FormListFilter addUser(){
		return new FormListFilter();
	}
	
	private List<String> getAllInterviewsDates(){
		
		List<Interview> interviews=tablesService.getAllRecords(Interview.class);
		
		List<String> interviewsDates=new ArrayList<String>();
		
		for(int i=0;i<interviews.size();i++){
			interviewsDates.add(interviews.get(i).getStringStart_date());
		}
		return interviewsDates;
	}

}
