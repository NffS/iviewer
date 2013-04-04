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
import java.util.Map;

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
    private Validator validator=new Validator();

    @RequestMapping("/user_edit")
    public String userEdit(Map<String, Object> map, HttpSession session) {
    	if((session.getAttribute("user_type_id"))!=null){
        map.put("user", session.getAttribute("user"));
        return "user_edit";
    	}
    	else{
            map.put("message","<font color='red'>Ошибка доступа</font>");
            map.put("target","index");
            return "redirect";
    	}
    }

    @RequestMapping("/user_edit_{user_id}")
    public String userEditById(@PathVariable("user_id")Integer user_id,Map<String, Object> map, HttpSession session) {
        if((Integer)session.getAttribute("user_type_id")==1 ||
                session.getAttribute("user_id")==user_id){
            User user=tablesService.getRecordById(user_id,User.class);
            map.put("userTypes", tablesService.getAllRecords(UsersType.class));
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

    	if((session.getAttribute("user_type_id"))!=null){
            	User userEdit = tablesService.getRecordById(Integer.parseInt(request.getParameter("user_id")), User.class);
            	userEdit.setEmail(request.getParameter("email"));
            	/*if (validator.emailChangingFailCheck(request.getParameter("email"), session, tablesService, Integer.parseInt(request.getParameter("user_id")))) {
            		map.put("message","<font color='red'>Email "+ userEdit.getEmail() +" уже зарегистрирован</font>");
                    map.put("target","user_edit");
                    return "redirect";            	
            	}*/
            	userEdit.setSurname(request.getParameter("surname"));
            	userEdit.setFirstName(request.getParameter("first_name"));
            	userEdit.setLastName(request.getParameter("last_name"));
            	if((int)session.getAttribute("user_type_id")==1&&(int)session.getAttribute("user_id")!=1){
            		userEdit.setPassword(request.getParameter("password"));
            	}
            	if (request.getParameter("user_type_id")!=null && (int)session.getAttribute("user_type_id")==1) {
            		userEdit.setUserTypeId(Integer.parseInt(request.getParameter("user_type_id")));
            	}
            	if(validator.isUserDataCorrect(userEdit)){
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
                        
                        switch ((int)userEdit.getUserTypeId()){
                        case 1: map.put("target","admin"); break;
                        case 2: map.put("target","hr"); break;
                        case 3: map.put("target","interview"); break;
                        case 4: map.put("target","candidate"); break;
                        }
                        
                        map.put("message","Ваши данные успешно изменены");
                        return "redirect";
                    
                    }
                    
                    map.put("message","Пользователь изменён");
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
    
    @RequestMapping("/do_change_password")
    public String doChangePassword( HttpSession session, HttpServletRequest request,
			Map<String, Object> map) {
    	if((session.getAttribute("user_type_id"))!=null){
    		User changingUser=(User)session.getAttribute("user");
    		if(!changingUser.getPassword().equals(request.getParameter("oldPassword"))){
    			map.put("message", "<font color='red'>Старый пароль введён неверно</font>");
    			map.put("target","change_password");
       	     	return "redirect";
    		}
    		if(!request.getParameter("newPassword").equals(request.getParameter("confirmPassword"))){
    			map.put("message", "<font color='red'>Подтверждающий пароль не соответствует новому.</font>");
    			map.put("target","change_password");
       	     	return "redirect";
    		}
    		if(!validator.isPasswordCorrect(request.getParameter("newPassword"))){
    			map.put("message", "<font color='red'>Новый пароль введён некорректно.</font>");
    			map.put("target","change_password");
       	     	return "redirect";
    		}
    		changingUser.setPassword(request.getParameter("newPassword"));
    		tablesService.updateRecord(changingUser);
    		session.setAttribute("password", changingUser.getPassword());
    		map.put("message","Ваш пароль успешно изменён.");
    		
    		switch ((int)changingUser.getUserTypeId()){
            case 1: map.put("target","admin"); break;
            case 2: map.put("target","hr"); break;
            case 3: map.put("target","interview"); break;
            case 4: map.put("target","candidate"); break;
            }
   	     	return "redirect";
    	}
    	else{
    		 map.put("message","<font color='red'>Ошибка доступа</font>");
    	     map.put("target","index");
    	     return "redirect";
    	}
    }
    
    @RequestMapping("/change_password")
    public String changePassword( HttpSession session, HttpServletRequest request,
			Map<String, Object> map) {
    	if((session.getAttribute("user_type_id"))!=null){
    		return "change_password";
    	}
    	else{
   		 map.put("message","<font color='red'>Ошибка доступа</font>");
   	     map.put("target","index");
   	     return "redirect";
    	}
    }
    
}
