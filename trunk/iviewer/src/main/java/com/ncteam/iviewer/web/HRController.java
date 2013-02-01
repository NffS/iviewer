package com.ncteam.iviewer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HRController {

	
	@RequestMapping(value="/hr")
	public String hr(){
		return "hr";
	}
}
