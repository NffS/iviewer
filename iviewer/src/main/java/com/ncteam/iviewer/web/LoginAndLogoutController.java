package com.ncteam.iviewer.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.UserServiceImpl;

@Controller
public class LoginAndLogoutController {

	
	private UserServiceImpl userService=new UserServiceImpl();
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String checkUserLogin(@ModelAttribute("user") User user, Map<String, Object> map,
			HttpSession session){
		
		String message="";
		String email=user.getEmail();
		String password=user.getPassword();
		
		if(!(email.isEmpty())&&!(password.isEmpty())){
			
			User resultUser=userService.getUserByEmail(user.getEmail());
			
			if(resultUser!=null){
				if(resultUser.getPassword().equals(password)){
					session.setAttribute("user", resultUser);
					session.setAttribute("email", resultUser.getEmail());
					session.setAttribute("first_name", resultUser.getFirst_name());
					session.setAttribute("surname", resultUser.getSurname());
					session.setAttribute("foto", resultUser.getFoto());
					session.setAttribute("user_type_id", resultUser.getUser_type_id());
					return "redirect:/index";
				}
			else{
					message="Введённый неверный пароль.";
				}
			}
			else{
				message="Пользователя с таким email'ом не существует.";
			}
		}
		else{
			message="Поля \"Email\" и \"Пароль\" должны быть заполнены!";
		}
		map.put("email", email);
		map.put("password", password);
		map.put("message", message);
		return "index";
	}
		
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		session.removeAttribute("email");
		session.removeAttribute("first_name");
		session.removeAttribute("surname");
		session.removeAttribute("foto");
		session.removeAttribute("user_type_id");
		return "redirect:/index";
	}
	
	@ModelAttribute("user")
	public User addUser(){
		return new User();
	}

}
