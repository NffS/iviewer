package com.ncteam.iviewer.web;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import validators.Validator;

import com.ncteam.iviewer.DAO.impl.TablesDAOImpl;
import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.MailService;
import com.ncteam.iviewer.service.impl.FormServiceImpl;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

@Controller
public class RegistrationController{
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private FormServiceImpl formService;
	private MailService mailService;
		
	@RequestMapping(value = "/registration_user", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request, HttpSession session, Map<String, Object> map) {

		User newUser = getUserByRequest(request);

		if(true){
		userService.addRecord(newUser);
			try {
				mailService = new MailService();
				mailService.sendMailForRegistration(newUser, request.getRequestURL().toString());
			} catch (MessagingException e) {
				map.put("message", "Неккоректный email, невозможно отправить письмо");
			}
			map.put("message", "Регистрация прошла успешно, проверьте почту");
		} else {
			//map = isUserDataCorrect(request, map);
		}
        return "registration";
    }
	
	User getUserByRequest(HttpServletRequest request){
		User newUser = new User();
		newUser.setFirstName(request.getParameter("firstname"));
		newUser.setSurname(request.getParameter("surname"));
		newUser.setLastName(request.getParameter("lastname"));
		newUser.setEmail(request.getParameter("email"));
		newUser.setPassword(request.getParameter("password"));
		newUser.setFoto(request.getRealPath("") + "/resources/files/fotos/defaut.jpg");
		newUser.setStringRegDate(new SimpleDateFormat("yyyy-MM-dd kk:mm").format(new Date()).toString());
		newUser.setUserTypeId(4);
		
		return newUser;
	}
	/*
	private  Map<String, Object> isUserDataCorrect (HttpServletRequest request, Map<String, Object> map){
		boolean isCorrect = true;
		if (!validator.isNameCorrect(request.getParameter("firstname"))){
			 map.put("firstnameMessage", "Ошибка в имени");
			 isCorrect = false;
		}
		if (!validator.isNameCorrect(request.getParameter("surname"))){
			 map.put("surnameMessage", "Ошибка в фамилии");
			 isCorrect = false;
		}
		if (!validator.isNameCorrect(request.getParameter("lastname"))){
			 map.put("lastnameMessage", "Ошибка в отчестве");
			 isCorrect = false;
		}
		if (!validator.isEmailCorrect(request.getParameter("email"))){
			 map.put("emailMessage", "Ошибка в email");
			 isCorrect = false;
		}
		if (!validator.isPasswordCorrect(request.getParameter("password"))){
			 map.put("passwordMessage", "Ошибка в пароле");
			 isCorrect = false;
		}
		
		if(!isCorrect){
			return map;
		} else {
			return null;
		}
	}
	*/

	@RequestMapping("/registration_user_{userid}")
    public String registrationFromEmail(HttpSession session, @PathVariable("userid") Integer userID){
		if (true) 
			;
		User user = userService.getRecordById(userID, User.class);
		Form newForm = formService.getFirstForm();
			newForm.setUserId(user.getUserId());
			newForm.setUser(user);
		formService.addRecord(newForm);
		user.setForm(newForm);
		userService.updateRecord(user);
        return "index";
    }
	
	@RequestMapping("/registration")
    public String registration(HttpServletRequest request){
        return "registration";
    }
}