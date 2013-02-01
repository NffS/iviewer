package com.ncteam.iviewer.web;

import com.ncteam.iviewer.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 01.02.13
 * Time: 18:31
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AdminController {

    @Autowired
    private TablesService tablesService;

    @RequestMapping("/admin")
    public String showAdmin(Map<String, Object> map) {



        //map.put("newsText", tablesService.getRecordById(4,News.class).getText());

        return "admin";
    }
}
