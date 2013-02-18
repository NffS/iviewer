package com.ncteam.iviewer.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.service.TablesService;


@Controller
public class FormListController {

	 @Autowired
	 private TablesService tablesService;
	
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
			if(!universities.contains(forms.get(i).getUniversity().getUniversity_name())){
				universities.add(forms.get(i).getUniversity().getUniversity_name());
			}
		}
		return universities;
	}

}
