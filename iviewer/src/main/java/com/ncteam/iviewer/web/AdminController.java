package com.ncteam.iviewer.web;

import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.domain.Users_type;
import com.ncteam.iviewer.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
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


        List<User> users=tablesService.getAllRecords(User.class);
        List<Users_type> users_types=tablesService.getAllRecords(Users_type.class);

        map.put("users_type", users_types);
        map.put("users", users);

        return "admin";
    }

    @RequestMapping("/user_edit")
    public String userEdit(Map<String, Object> map) {
        return "user_edit";
    }

    @ModelAttribute("edit_user")
    public User addUser(){
        return new User();
    }
}
