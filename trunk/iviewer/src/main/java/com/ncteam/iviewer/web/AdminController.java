package com.ncteam.iviewer.web;


import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.domain.Users_type;
import com.ncteam.iviewer.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;



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

        map.put("users_types", users_types);
        map.put("users", users);

        return "admin";
    }

    @RequestMapping("/user_delete_{user_id}")
    public String delUser(@PathVariable("user_id")Integer user_id, Map<String, Object> map,
                          HttpSession session) {

        User usr = tablesService.getRecordById(user_id, User.class);

        if((Integer)session.getAttribute("user_type_id") == 1
            && (Integer)session.getAttribute("user_id") == user_id){

            map.put("newsText","O_o АДМИН ТЫ КАМИКАДЗЕ??? Так делать нельзя!");
            return "index";
        }

        if((Integer)session.getAttribute("user_type_id") == 1)
            tablesService.deleteRecord(usr);

        map.put("newsText","ok");
        return "index";
    }

}
