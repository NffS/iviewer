package com.ncteam.iviewer.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import validators.Validator;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

@Controller
public class CandidateEditController{
	
	@Autowired
	private UserServiceImpl userService;
	
	Validator validator;
	
	@RequestMapping(value = "/edit_this_candidate", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request, HttpSession session, Map<String, Object> map) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 
		// Создаём класс фабрику 
		DiskFileItemFactory factory = new DiskFileItemFactory();
 
		// Максимальный буфера данных в байтах,
		// при его привышении данные начнут записываться на диск во временную директорию
		// устанавливаем один мегабайт
		factory.setSizeThreshold(1024*1024);
		
		// устанавливаем временную директорию
		File tempDir = (File)session.getServletContext().getAttribute("javax.servlet.context.tempdir");

		factory.setRepository(tempDir);
 
		//Создаём сам загрузчик
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//максимальный размер данных который разрешено загружать в байтах
		//по умолчанию -1, без ограничений. Устанавливаем 10 мегабайт. 
		upload.setSizeMax(1024 * 1024 * 10);
 
		try {
			List items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			
			while (iter.hasNext()) {
			    FileItem item = (FileItem) iter.next();
 
			    if (item.isFormField()) {
			    	//если принимаемая часть данных является полем формы			    	
			        processFormField(item);
			    } else {
			    	//в противном случае рассматриваем как файл
			        processUploadedFile(item, request);
			        changeImageScale(request.getRealPath("") +"/resources/files/fotos/"+ item.getName());
			    }
			}			
		} catch (Exception e) {
			e.printStackTrace();
			
			return "candidate_edit";
		}
		
		
        return "candidate_edit";
    }
	private void processUploadedFile(FileItem item, HttpServletRequest request) throws Exception {
		File uploadetFile = null;
		//выбираем файлу имя пока не найдём свободное
		do{
			String path = request.getRealPath("") +"/resources/files/fotos/"+ item.getName();					
			uploadetFile = new File(path);		
		}while(uploadetFile.exists());
		
		//создаём файл
		uploadetFile.createNewFile();
		//записываем в него данные
		item.write(uploadetFile);
	}
 
	/**
	 * Выводит на консоль имя параметра и значение
	 * @param item
	 */
	private void processFormField(FileItem item) {
		System.out.println(item.getFieldName()+"="+item.getString());		
	}
	
	private void changeImageScale(String filename) throws IOException{
		BufferedImage originalImage = ImageIO.read(new File(filename));
	        int width = 180;
	        int height = 265;
        java.awt.Image image = originalImage.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
        BufferedImage changedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = changedImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        ImageIO.write(changedImage, "jpg", new File(filename));
		
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