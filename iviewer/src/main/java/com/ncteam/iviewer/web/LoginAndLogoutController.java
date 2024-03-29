package com.ncteam.iviewer.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import validators.Validator;

import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

@Controller
public class LoginAndLogoutController {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private Validator validator;
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String checkUserLogin(@ModelAttribute("user") User user, Map<String, Object> map,
			HttpSession session){
		
		String email=user.getEmail();
		String password=user.getPassword();
		
		String emailMessage=validator.checkEmail(email);
		String passwordMessage=validator.checkPassword(password);
		
		if(emailMessage.isEmpty()&&passwordMessage.isEmpty()){
			
			User resultUser=userService.getUserByEmail(email);
			
					if(resultUser!=null){
						if(resultUser.getPassword().equals(password)){
							session.setAttribute("user", resultUser);
							session.setAttribute("user_id", resultUser.getUserId());
							session.setAttribute("email", resultUser.getEmail());
							session.setAttribute("first_name", resultUser.getFirstName());
							session.setAttribute("surname", resultUser.getSurname());
							session.setAttribute("foto", resultUser.getFoto());
							session.setAttribute("user_type_id", resultUser.getUserTypeId());

                            switch ((int)resultUser.getUserTypeId()){
                                case 1: map.put("target","admin"); break;
                                case 2: map.put("target","hr"); break;
                                case 3: map.put("target","interview"); break;
                                case 4: map.put("target","candidate"); break;
                            }

                            map.put("message","Рады снова Вас видеть "+resultUser.getFirstName());
                            return "redirect";
						}
						else{
							passwordMessage="Введён неверный пароль.";
						}
					}
					else{
						emailMessage="Пользователя с таким email'ом не существует.";
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
