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
    public String showAdmin(Map<String, Object> map, HttpSession session) {
        if(((Integer)session.getAttribute("user_type_id")).equals(1)){

            List<User> users=tablesService.getAllRecords(User.class);
            List<Users_type> users_types=tablesService.getAllRecords(Users_type.class);

            map.put("users_types", users_types);
            map.put("users", users);

            return "admin";
        }
        map.put("message","<font color='red'>Ошибка доступа</font>");
        map.put("target","index");
        return "redirect";
    }

    @RequestMapping("/user_delete_{user_id}")
    public String delUser(@PathVariable("user_id")Integer user_id, Map<String, Object> map,
                          HttpSession session) {
        if(((Integer)session.getAttribute("user_type_id")).equals(1)){

            User usr = tablesService.getRecordById(user_id, User.class);

            if(((Integer)session.getAttribute("user_id")).equals(user_id)){

                map.put("message","<font color='red'>O_o АДМИН ТЫ КАМИКАДЗЕ??? Так делать нельзя!</font>");
                map.put("target","admin");
                return "redirect";
            }

            tablesService.deleteRecord(usr);

            map.put("message","Пользователь "+usr.getEmail()+" успешно удален!");
            map.put("target","admin");
            return "redirect";
        }

        map.put("message","<font color='red'>Ошибка доступа</font>");
        map.put("target","index");
        return "redirect";
    }

}
