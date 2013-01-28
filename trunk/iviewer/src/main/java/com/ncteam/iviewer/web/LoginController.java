package com.ncteam.iviewer.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.UserServiceImpl;

@Controller
public class LoginController {

	
	private UserServiceImpl userService=new UserServiceImpl();
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String checkUserLogin(@ModelAttribute("user") User user, Map<String, Object> map){
		
		String message="";
		String email=user.getEmail();
		String password=user.getPassword();
		
		if(!(email.isEmpty())&&!(password.isEmpty())){
			
			User resultUser=userService.getUserByEmail(user.getEmail());
			
			if(resultUser!=null){
				if(resultUser.getPassword().equals(password)){
					map.put("usr",resultUser);
					return "login";
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
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(Model model){
		//model.addAttribute("user", new User());
		return "login";
	}
	
	@ModelAttribute("user")
	public User addUser(){
		return new User();
	}

}
