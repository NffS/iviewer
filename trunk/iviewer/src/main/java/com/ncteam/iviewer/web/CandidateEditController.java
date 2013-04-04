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

import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

@Controller
public class CandidateEditController{
	
	@Autowired
	private UserServiceImpl userService;
	
	Validator validator;
	
	@RequestMapping(value = "/edit_this_candidate", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request, HttpSession session, Map<String, Object> map) {
		
		
		
        return "candidate_edit";
    }
	
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
	
	protected void sendMail(User user, String host) throws MessagingException{
		
		Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        
        Session session = Session.getInstance(properties, authenticate("ncteam2013","qwertyshmerty"));
                
        Message mailMsg = new MimeMessage(session);
        InternetAddress senderAddress = new InternetAddress("ncteam2013@gmail.com");
        InternetAddress targetAddress = new InternetAddress(user.getEmail());
        mailMsg.setFrom(senderAddress);
        mailMsg.setRecipient(RecipientType.TO, targetAddress);
        mailMsg.setSubject("Учебный центр NetCracker");
        String link = host+"/registration_"+user.getUserId();
        mailMsg.setText("Спасибо за регистрацию, "+user.getFirstName()+". Для регистрации пройдите по ссылке "+link);
        
        Transport.send(mailMsg);
	}

	private Authenticator authenticate(final String userName, final String userPassword){
        Authenticator authenticator = new javax.mail.Authenticator()
       {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(userName, userPassword);
           }
       };
       return authenticator;
    }
	
	
	@RequestMapping("/candidate_edit")
    public String registration(){

        return "candidate_edit";
    
	}
}