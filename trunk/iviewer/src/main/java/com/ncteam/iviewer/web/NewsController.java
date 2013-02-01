package com.ncteam.iviewer.web;

import java.util.Map;

import com.ncteam.iviewer.domain.News;
import com.ncteam.iviewer.domain.User;


import com.ncteam.iviewer.service.TablesService;
import com.ncteam.iviewer.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 28.01.13
 * Time: 8:58
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class NewsController {

    @Autowired
    private TablesService tablesService;

    @RequestMapping(value = "/index_{news_id}")
    public String getNewsById(Model model,
                             @PathVariable("news_id") String news_id, Map<String, Object> map) {

        model.addAttribute("news_id", news_id);
        map.put("newsText", tablesService. getRecordById(Integer.parseInt(news_id),News.class).getText());

        return "index";
    }

    @RequestMapping("/index")
    public String getMainPage(Map<String, Object> map) {



        map.put("newsText", tablesService.getRecordById(4,News.class).getText());

        return "index";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }
    
    @ModelAttribute("user")
	public User addUser(){
		return new User();
	}


}
