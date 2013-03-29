package com.ncteam.iviewer.web;



import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.domain.UsersType;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import validators.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    private UserServiceImpl tablesService;
    private Validator validator=new Validator();

    @RequestMapping("/admin")
    public String showAdmin(Map<String, Object> map, HttpSession session) {
        if(((Integer)session.getAttribute("user_type_id")).equals(1)){

            List<User> users=tablesService.getAllRecords(User.class);
            List<UsersType> users_types=tablesService.getAllRecords(UsersType.class);

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
    
    @RequestMapping("/user_create")
    public String createUser(Map<String, Object> map,
                          HttpSession session) {
    	
        if(((Integer)session.getAttribute("user_type_id")).equals(1)){

            map.put("userTypes", tablesService.getAllRecords(UsersType.class));
            return "user_create";
        }
        map.put("message","<font color='red'>Ошибка доступа</font>");
        map.put("target","index");
        return "redirect";
    }
    
    @RequestMapping("/do_user_create")
    public String doCreateUser(Map<String, Object> map,
                          HttpSession session, HttpServletRequest request) {
    	
        if(((Integer)session.getAttribute("user_type_id")).equals(1)){
        	
                	User newUser = new User();
                	newUser.setEmail(request.getParameter("email"));
                	newUser.setSurname(request.getParameter("surname"));
                	newUser.setFirstName(request.getParameter("first_name"));
                	newUser.setLastName(request.getParameter("last_name"));
                	newUser.setPassword(request.getParameter("password"));
                	newUser.setUserTypeId(Integer.parseInt(request.getParameter("user_type_id")));
                	newUser.setStringRegDate(new SimpleDateFormat("yyyy-MM-dd kk:mm").format(new Date()).toString());
                	newUser.setFoto("");
                	if(validator.isUserDataCorrect(newUser)){
                    tablesService.addRecord(newUser);
                    
                    map.put("message","Пользователь создан");
                    map.put("target","admin");
                    return "redirect";
                    }
                	else{
                		map.put("message","<font color='red'>Введены некорректные данные</font>");
                        map.put("target","user_create");
                        return "redirect";
                	}

                }

        map.put("message","<font color='red'>Ошибка доступа</font>");
        map.put("target","index");
        return "redirect";
        }

}
    
    


