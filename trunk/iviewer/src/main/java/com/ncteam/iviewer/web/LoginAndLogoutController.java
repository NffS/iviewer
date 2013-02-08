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
		
		String passwordMessage="";
		String emailMessage="";
		String email=user.getEmail();
		String password=user.getPassword();
		
		if(!email.isEmpty()){
				if(!password.isEmpty()){
			
					User resultUser=userService.getUserByEmail(user.getEmail());
			
					if(resultUser!=null){
						if(resultUser.getPassword().equals(password)){
							session.setAttribute("user", resultUser);
							session.setAttribute("user_id", resultUser.getUser_id());
							session.setAttribute("email", resultUser.getEmail());
							session.setAttribute("first_name", resultUser.getFirst_name());
							session.setAttribute("surname", resultUser.getSurname());
							session.setAttribute("foto", resultUser.getFoto());
							session.setAttribute("user_type_id", resultUser.getUser_type_id());
							return "redirect:/index";
						}
						else{
							passwordMessage="Введён неверный пароль.";
						}
					}
					else{
						emailMessage="Пользователя с таким email'ом не существует.";
					}
				}
				else{
					passwordMessage="Заполните поле \"Пароль\".";
				}
		}
		else{
			emailMessage="Заполните поле \"Email\".";
			if(password.isEmpty()){
				passwordMessage="Заполните поле \"Пароль\".";
			}
		}
		map.put("email", email);
		map.put("password", password);
		map.put("emailMessage", emailMessage);
		map.put("passwordMessage", passwordMessage);		
		return "login";
	}
		
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
        session.removeAttribute("user_id");
		session.removeAttribute("email");
		session.removeAttribute("first_name");
		session.removeAttribute("surname");
		session.removeAttribute("foto");
		session.removeAttribute("user_type_id");
		return "redirect:/index";
	}

    @RequestMapping("/login")
    public String login(HttpSession session){
        return "login";
    }
	
	@ModelAttribute("user")
	public User addUser(){
		return new User();
	}

}
