package com.ncteam.iviewer.web;

import com.ncteam.iviewer.support.FormListFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.Interview;
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
		String university=formListFilter.getUniversity();
		boolean requiredConfirmOnly=formListFilter.isRequiredConfirmOnly();
		
		List<Form> forms=tablesService.getAllRecords(Form.class);
		List<String> allUniversities=getAllUniversities(forms);
		
		if(!lastName.isEmpty()){
			for(int i=0; i<forms.size(); i++){
				if(!forms.get(i).getUser().getSurname().equals(lastName)){
					forms.remove(i);
					i--;
				}
			}
		}
		if(!interviewDate.equals("Поиск по собеседованию")){
			for(int i=0; i<forms.size(); i++){
				if(!forms.get(i).getInterview().getStringStart_date().equals(interviewDate+":00")){
					forms.remove(i);
					i--;
				}
			}
		}
		if(!university.equals("Поиск по университету")){
			for(int i=0; i<forms.size(); i++){
				if(!forms.get(i).getUniversity().equals(university)){
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
		map.put("universities", allUniversities);
		return "form_list";
	}
	
	@RequestMapping("/form_list")
	public String form_list(Map<String, Object> map){
		
		
		ArrayList<Form> forms=(ArrayList<Form>) tablesService.getAllRecords(Form.class);
		Collections.sort(forms);
		map.put("interviewsDates", getAllInterviewsDates());
		map.put("forms", forms);
		map.put("universities", getAllUniversities(forms));
		return "form_list";
	}

	
	private List<String> getAllInterviewsDates(){
		
		List<Interview> interviews=tablesService.getAllRecords(Interview.class);
		
		List<String> interviewsDates=new ArrayList<String>();
		
		for(int i=0;i<interviews.size();i++){
			interviewsDates.add(interviews.get(i).getStringStart_date());
		}
		return interviewsDates;
	}
	
	private List<String> getAllUniversities(List<Form> forms){
		
		List<String> universities=new ArrayList<String>();
		for(int i=0; i<forms.size();i++){
			if(!universities.contains(forms.get(i).getUniversity())){
				universities.add(forms.get(i).getUniversity());
			}
		}
		return universities;
	}
	
	/*
	 * Метод используется для размещения объекта класса фильтра для списка форм.
	 */
	/*@ModelAttribute("formListFilter")
	public FormListFilter addFilter(){
		return new FormListFilter();
	}*/
}
