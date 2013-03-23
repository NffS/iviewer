package com.ncteam.iviewer.web;

import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 08.02.13
 * Time: 12:26
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserEditController {

    @Autowired
    private UserServiceImpl tablesService;

    @RequestMapping("/user_edit")
    public String userEdit(Map<String, Object> map, HttpSession session) {
        //User user=tablesService.getRecordById((Integer)session.getAttribute("user"),User.class);
    	//	User user = tablesService.getRecordById((Integer)session.getAttribute("user"),User.class);
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

    @RequestMapping("/do_user_edit")
    public String userEditOk( HttpSession session, HttpServletRequest request,
			Map<String, Object> map) {

        if (Pattern.matches("^([a-zA-Z0-9_\\.\\-]{1,20})@([a-zA-Z0-9\\.\\-]{1,20})\\.([a-z]{2,4})$", request.getParameter("email")))
            // if (Pattern.matches("[a-zA-Zа-яА-Я]$",userEdit.getFirst_name()))
            //   if (Pattern.matches("[a-zA-Zа-яА-Я]$",userEdit.getSurname()))
            //     if (Pattern.matches("[a-zA-Zа-яА-Я]$",userEdit.getLast_name()))
            if (request.getParameter("password").length() > 0){
            	User userEdit = new User();
            	userEdit.setUserId(Integer.parseInt(request.getParameter("user_id")));
            	userEdit.setEmail(request.getParameter("email"));
            	userEdit.setSurname(request.getParameter("surname"));
            	userEdit.setFirstName(request.getParameter("first_name"));
            	userEdit.setLastName(request.getParameter("last_name"));
            	userEdit.setPassword(request.getParameter("password"));
            	if (request.getParameter("user_type_id")!=null && (int)session.getAttribute("user_type_id")==1) {
            		userEdit.setUserTypeId(Integer.parseInt(request.getParameter("user_type_id")));
            	} else { 
            		userEdit.setUserTypeId((int)session.getAttribute("user_type_id"));
            	}
                tablesService.updateRecord(userEdit);
                if((int)session.getAttribute("user_id")==userEdit.getUserId()){
                    session.setAttribute("user", userEdit);
                    session.setAttribute("user_id", userEdit.getUserId());
                    session.setAttribute("email", userEdit.getEmail());
                    session.setAttribute("first_name", userEdit.getFirstName());
                    session.setAttribute("surname", userEdit.getSurname());
                    session.setAttribute("last_name", userEdit.getLastName());
                    session.setAttribute("password", userEdit.getPassword());
                    session.setAttribute("foto", userEdit.getFoto());
                    session.setAttribute("user_type_id", userEdit.getUserTypeId());
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
