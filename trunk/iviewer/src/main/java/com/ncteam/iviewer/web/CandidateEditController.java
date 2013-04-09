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
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
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
	
	private final int MAX_IMAGE_SIZE = 300 * 1024;
	
	@Autowired
	private UserServiceImpl userService;
	
	Validator validator = new Validator();
	
	@RequestMapping(value = "/edit_this_candidate", method = RequestMethod.POST)
    public String updateUser(HttpServletRequest request, HttpSession session, Map<String, Object> map) throws ServletException, IOException {
		
	
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		User user = userService.getUserByEmail(session.getAttribute("email").toString());
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setSizeThreshold(MAX_IMAGE_SIZE);
		
		File tempDir = (File)session.getServletContext().getAttribute("javax.servlet.context.tempdir");

		factory.setRepository(tempDir);
 
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setSizeMax(MAX_IMAGE_SIZE);
 
		try {
			List items = upload.parseRequest(request);
			Iterator iter = items.iterator();

			while (iter.hasNext()) {
			    FileItem item = (FileItem) iter.next();
			    if (item.isFormField()) {		    	
			    	//user = processFormField(item, user);
			    } else {
			        changeImageScale(processUploadedFile(item, request, user));
			        user.setFoto(user.getFirstName()+"_"+user.getSurname()+"_"+user.getUserId());
			    }
			}			
		} catch (SizeLimitExceededException e) {
			e.printStackTrace();
			map.put("message", "размер файла превышает 300 килобайт");
			return "candidate_edit";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "candidate_edit";
		}
		
			userService.updateRecord(user);
        return "candidate_edit";
    }
	
	private String processUploadedFile(FileItem item, HttpServletRequest request, User user) throws Exception {
		File uploadetFile = null;
			String path = request.getRealPath("") +"/resources/files/fotos/"+ user.getFirstName()+"_"+user.getSurname()+"_"+user.getUserId()+".jpg";					
			uploadetFile = new File(path);		
		uploadetFile.createNewFile();
		item.write(uploadetFile);
		return path;
	}
 
	private User processFormField(FileItem item, User user) {
		switch(item.getFieldName()){
			case "firstname": user.setFirstName(item.getString()); 
			case "surname": user.setSurname(item.getString());
			case "lastname": user.setLastName(item.getString());
			case "email": user.setEmail(item.getString());
			case "password": user.setPassword(item.getString());
		}
		return user;	
	}
	
	private void changeImageScale(String filename) throws IOException{
		BufferedImage originalImage = ImageIO.read(new File(filename));
	        int width = 120;
	        int height = 180;
        java.awt.Image image = originalImage.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
        BufferedImage changedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = changedImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        ImageIO.write(changedImage, "jpg", new File(filename));
		
	}

	@RequestMapping("/candidate_edit")
    public String candidateEdit(HttpSession session, Map<String, Object> map){

	
		
        return "candidate_edit";
    
	}
}