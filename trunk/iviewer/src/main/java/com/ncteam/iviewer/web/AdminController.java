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

        map.put("users_type", users_types);
        map.put("users", users);

        return "admin";
    }

    @RequestMapping("/user_edit")
    public String userEdit(Map<String, Object> map, HttpSession session) {
        //User user=tablesService.getRecordById((Integer)session.getAttribute("user"),User.class);
        map.put("user", session.getAttribute("user"));
        return "user_edit";
    }

    @RequestMapping("/user_edit_{user_id}")
    public String userEditById(@PathVariable("user_id")Integer user_id,Map<String, Object> map, HttpSession session) {
        if((Integer)session.getAttribute("user_type_id")==1 ||
                session.getAttribute("user_id")==user_id){
            User user=tablesService.getRecordById(user_id,User.class);
            map.put("user", user);
            return "user_edit";
        }else{
            map.put("newsText","Error!");
            return "index";
        }

    }

    @RequestMapping("/user_edit.do")
    public String userEditOk( @ModelAttribute("userEdit") User userEdit, Map<String, Object> map,
                              HttpSession session) {

        if (Pattern.matches("^([a-zA-Z0-9_\\.\\-]{1,20})@([a-zA-Z0-9\\.\\-]{1,20})\\.([a-z]{2,4})$",userEdit.getEmail()))
           // if (Pattern.matches("[a-zA-Zà-ÿÀ-ß]$",userEdit.getFirst_name()))
             //   if (Pattern.matches("[a-zA-Zà-ÿÀ-ß]$",userEdit.getSurname()))
               //     if (Pattern.matches("[a-zA-Zà-ÿÀ-ß]$",userEdit.getLast_name()))
                        if (userEdit.getPassword().length() > 0){
                            tablesService.updateRecord(userEdit);
                            if((Integer)session.getAttribute("user_id")==userEdit.getUser_id()){
                                session.setAttribute("user", userEdit);
                                session.setAttribute("user_id", userEdit.getUser_id());
                                session.setAttribute("email", userEdit.getEmail());
                                session.setAttribute("first_name", userEdit.getFirst_name());
                                session.setAttribute("surname", userEdit.getSurname());
                                session.setAttribute("foto", userEdit.getFoto());
                                session.setAttribute("user_type_id", userEdit.getUser_type_id());

                            }
                            map.put("newsText","Ok");
                            return "index";
                        }
        map.put("newsText","Error");
        return "index";
    }

    @ModelAttribute("userEdit")
    public User addUser(){
        return new User();
    }
}
