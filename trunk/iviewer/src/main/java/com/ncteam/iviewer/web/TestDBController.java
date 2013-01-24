package com.ncteam.iviewer.web;

import java.util.Map;

import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.HR_mark;
import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.domain.Users_type;
import com.ncteam.iviewer.service.TablesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestDBController {

	 @Autowired
	 private TablesService tablesService;
	 
	 @RequestMapping("/index")
	 public String getAllUsers(Map<String, Object> map) {
		 
	        map.put("user", new User());
	        map.put("userList", tablesService.getAllRecords(User.class));

	        map.put("form", new Form());
	        map.put("formList", tablesService.getAllRecords(Form.class));
	        
	        map.put("HR_mark", new HR_mark());
	        map.put("HR_markList", tablesService.getAllRecords(HR_mark.class));
	        
	        map.put("interview", new Interview());
	        map.put("interviewList", tablesService.getAllRecords(Interview.class));
	        
	        map.put("users_type", new Users_type());
	        map.put("users_typeList", tablesService.getAllRecords(Users_type.class));
	        
	         
	        return "test";
	    }
	 
	 @RequestMapping("/")
	 public String home() {
	        return "redirect:/index";
	    }
	 
}
