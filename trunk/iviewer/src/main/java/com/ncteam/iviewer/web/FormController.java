package com.ncteam.iviewer.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.ncteam.iviewer.DAO.impl.FormDAOImpl;
import com.ncteam.iviewer.DAO.impl.TablesDAOImpl;
import com.ncteam.iviewer.domain.Faculty;
import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.University;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.MailService;
import com.ncteam.iviewer.service.PDFservice;
import com.ncteam.iviewer.service.ValidationService;
import com.ncteam.iviewer.service.impl.FormServiceImpl;
import com.ncteam.iviewer.service.impl.TablesServiceImpl;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

@Controller
public class FormController{
	
	@Autowired
	 private UserServiceImpl userService;
	@Autowired
	 private FormServiceImpl formService;
	 
	@RequestMapping(value = "/getform_{userid}", method = RequestMethod.POST)
    public String getForm(HttpServletRequest request, @PathVariable("userid") Integer userID, HttpSession session, Map<String, Object> map) throws DocumentException, IOException, MessagingException{

		User user = userService.getRecordById(userID, User.class);
		Form newForm = formService.getFormByUserId(userID);
		newForm = getFormByRequest(request, newForm);

		formService.updateRecord(newForm);
		
		String path = request.getRealPath("") + "/resources/files/forms/"+user.getFirstName()+"_"+user.getSurname()+"_"+user.getUserId()+".pdf";
		PDFservice pdf = new PDFservice(path, request);
			pdf.createPDF(user, newForm);
		MailService mailService = new MailService();
			mailService.sendFormToCandidate(user, path);
		
		map.put("user", user);
		map.put("form", newForm);
		map.put("request", userID);
		map.put("interesttc", convertFromDB(newForm.getInterestTc()));
		map.put("interestnc", convertFromDB(newForm.getInterestNc()));
		map.put("interestpo", convertFromDB(newForm.getInterestAreaPo()));
		map.put("job_vj", convertFromDB(newForm.getJobArVaried()));
		map.put("job_man", convertFromDB(newForm.getJobArManage()));
		map.put("job_sales", convertFromDB(newForm.getJobArSales()));
		map.put("job_deep", convertFromDB(newForm.getJobArDeepSpec()));
		
        return "form";
    }

	Form getFormByRequest(HttpServletRequest request, Form newForm) throws DocumentException, IOException{
		University university = formService.getRecordById(1, University.class);
		Faculty faculty = formService.getRecordById(2, Faculty.class);
			newForm.setUniversity(university);
			newForm.setFaculty(faculty);
		
			newForm.setCourse(Integer.parseInt(request.getParameter("course")));
			newForm.setEndYear(request.getParameter("year"));
			newForm.setEmail2(request.getParameter("email2"));
			newForm.setPhone(request.getParameter("phone"));
			newForm.setAnotherContact(request.getParameter("another_contact"));
			
			newForm.setInterestTc(request.getParameter("interest_tc"));
			newForm.setInterestNc(request.getParameter("interest_job"));
			
			newForm.setInterestAreaPo(request.getParameter("interest_po"));
			newForm.setInterestAreaOther(request.getParameter("interest_another"));
			
			newForm.setJobArDeepSpec(request.getParameter("jobtype_ds"));
			newForm.setJobArVaried(request.getParameter("jobtype_vj"));
			newForm.setJobArManage(request.getParameter("jobtype_manage"));
			newForm.setJobArSales(request.getParameter("jobtype_sales"));
			newForm.setJobArOther(request.getParameter("jobtype_another"));
			
			newForm.setProgLangC(Integer.parseInt(request.getParameter("lan_c")));
			newForm.setProgLangJava(Integer.parseInt(request.getParameter("lan_java")));
			newForm.setProgLangOther(request.getParameter("lan_other"));
			newForm.setProgLangOther(Integer.parseInt(request.getParameter("lan_other_mark")));
			
			newForm.setCsNetworkTech(Integer.parseInt(request.getParameter("cs_net")));
			newForm.setCsAlgorithms(Integer.parseInt(request.getParameter("cs_algorithm")));
			newForm.setCsOop(Integer.parseInt(request.getParameter("cs_oop")));
			newForm.setCsGui(Integer.parseInt(request.getParameter("cs_bd")));
			newForm.setCsDb(Integer.parseInt(request.getParameter("cs_web")));
			newForm.setCsWeb(Integer.parseInt(request.getParameter("cs_gui")));
			newForm.setCsNetworkProg(Integer.parseInt(request.getParameter("cs_netprog")));
			newForm.setCsDesign(Integer.parseInt(request.getParameter("cs_design")));
			newForm.setCsOther(request.getParameter("cs_another"));
			newForm.setCsOtherMark(Integer.parseInt(request.getParameter("cs_another_mark")));
			
			newForm.setEnglishRead(Integer.parseInt(request.getParameter("eng_reading")));
			newForm.setEnglishWrite(Integer.parseInt(request.getParameter("eng_writting")));
			newForm.setEnglishSpoken(Integer.parseInt(request.getParameter("eng_speaking")));
			
			newForm.setSourceId(Integer.parseInt(request.getParameter("source")));
			
			newForm.setExperience(request.getParameter("experience"));
			newForm.setMotivation_comment(request.getParameter("promises"));
			newForm.setComment2(request.getParameter("more_information"));
			
		return newForm;
	}

	/*String getErrorMessage(HttpServletRequest request){
		String errorMessage="ok";
		ValidationService validationService = new ValidationService();
		if (!validationService.checkName(request.getParameter("firstname")).equals("ok"))
			return errorMessage=validationService.checkName(request.getParameter("firstname"));
		if (!validationService.checkName(request.getParameter("surname")).equals("ok"))
			return errorMessage=validationService.checkName(request.getParameter("surname"));
		if (!validationService.checkName(request.getParameter("lastname")).equals("ok"))
			return errorMessage=validationService.checkName(request.getParameter("lastname"));
		if (!validationService.checkYear(request.getParameter("year")).equals("ok"))
			return errorMessage=validationService.checkYear(request.getParameter("year"));
		
		
		if (!validationService.checkEmail(request.getParameter("email1")).equals("ok"))
			return errorMessage=validationService.checkEmail(request.getParameter("email1"));
		if (!validationService.checkEmail(request.getParameter("email2")).equals("ok"))
			return errorMessage=validationService.checkEmail(request.getParameter("email2"));
		if (!validationService.checkPhone(request.getParameter("phone")).equals("ok"))
			return errorMessage=validationService.checkPhone(request.getParameter("phone"));
		if (!validationService.checkLength(request.getParameter("another_contact"), 40, 1).equals("ok"))
			return errorMessage=validationService.checkPhone(request.getParameter("another_contact"));
		
		if (!validationService.checkLength(request.getParameter("interest_another"), 20, 1).equals("ok"))
			return errorMessage=validationService.checkPhone(request.getParameter("interest_another")); 
		if (!validationService.checkLength(request.getParameter("jobtype_another"), 20, 1).equals("ok"))
			return errorMessage=validationService.checkPhone(request.getParameter("jobtype_another"));
		if (!validationService.checkLength(request.getParameter("lan_other"), 12, 1).equals("ok"))
			return errorMessage=validationService.checkPhone(request.getParameter("lan_other"));
		if (!validationService.checkLength(request.getParameter("cs_another"), 20, 1).equals("ok"))
			return errorMessage=validationService.checkPhone(request.getParameter("cs_another"));
		
		if (!validationService.checkLength(request.getParameter("form.getExperience()"), 420, 1).equals("ok"))
			return errorMessage=validationService.checkPhone(request.getParameter("form.getExperience()"));
		if (!validationService.checkLength(request.getParameter("promises"), 420, 1).equals("ok"))
			return errorMessage=validationService.checkPhone(request.getParameter("promises"));
		if (!validationService.checkLength(request.getParameter("more_information"), 420, 1).equals("ok"))
			return errorMessage=validationService.checkPhone(request.getParameter("more_information"));
		
		return errorMessage;
	}*/
	
    @RequestMapping(value = "/form_{userid}")
    public String form(HttpSession session, @PathVariable("userid") Integer userID, Map<String, Object> map){
    	
		User user = userService.getRecordById(userID, User.class);
		Form form = formService.getFormByUserId(userID);
		map.put("user", user);
		map.put("form", form);
		map.put("request", userID);
		map.put("interesttc", convertFromDB(form.getInterestTc()));
		map.put("interestnc", convertFromDB(form.getInterestNc()));
		map.put("interestpo", convertFromDB(form.getInterestAreaPo()));
		map.put("job_vj", convertFromDB(form.getJobArVaried()));
		map.put("job_man", convertFromDB(form.getJobArManage()));
		map.put("job_sales", convertFromDB(form.getJobArSales()));
		map.put("job_deep", convertFromDB(form.getJobArDeepSpec()));
        return "form";
    }
    
    private String convertFromDB(String input){
    	switch (input){
    	case "+": return "да";
    	case "+-": return "возможно";
    	case "-": return "нет";
    	case "?": return "хочу узнать больше";
    	}
    	return "";
    }
  }