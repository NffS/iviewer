package com.ncteam.iviewer.service;

import java.io.IOException;
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

import com.ncteam.iviewer.domain.User;

public class MailService {
	Properties properties;
	
	private final String SMTP_HOST = "smtp.gmail.com";
	private final String SMTP_PORT = "465";
	private final String SOCKET_FACTORY_CLASS = "javax.net.ssl.SSLSocketFactory";
	private final String SOCKET_FACTORY_PORT = "465";
	private final String SMTP_AUTHENTICATION = "true";
	
	private String mail = "ncteam2013@gmail.com";
	private String login = "ncteam2013";
	private String password = "qwertyshmerty";
	
	public void sendMailForRegistration(User user, String link) throws MessagingException{
		
		Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.socketFactory.port", SOCKET_FACTORY_PORT);
        properties.put("mail.smtp.socketFactory.class", SOCKET_FACTORY_CLASS);
        properties.put("mail.smtp.auth", SMTP_AUTHENTICATION);
        
		Session session = Session.getInstance(properties, authenticate(login, password));
                
        Message mailMsg = new MimeMessage(session);
        InternetAddress senderAddress = new InternetAddress(mail);
        InternetAddress targetAddress = new InternetAddress(user.getEmail());
        mailMsg.setFrom(senderAddress);
        mailMsg.setRecipient(RecipientType.TO, targetAddress);
        mailMsg.setSubject("Учебный центр NetCracker");
        link += "_"+user.getUserId();
        mailMsg.setText("Спасибо за регистрацию, "+user.getFirstName()+
        		". Ваш логин: "+user.getEmail()+" пароль: "+user.getPassword()+
        		". Для регистрации пройдите по ссылке "+link);
        
        Transport.send(mailMsg);
	}
	
	public void sendMailWhenYouGetInterview(String userMail, String text) throws MessagingException{
		
		Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.socketFactory.port", SOCKET_FACTORY_PORT);
        properties.put("mail.smtp.socketFactory.class", SOCKET_FACTORY_CLASS);
        properties.put("mail.smtp.auth", SMTP_AUTHENTICATION);
        
		Session session = Session.getInstance(properties, authenticate(login, password));
                
        Message mailMsg = new MimeMessage(session);
        InternetAddress senderAddress = new InternetAddress(mail);
        InternetAddress targetAddress = new InternetAddress(userMail);
        mailMsg.setFrom(senderAddress);
        mailMsg.setRecipient(RecipientType.TO, targetAddress);
        mailMsg.setSubject("Учебный центр NetCracker");

        mailMsg.setText(text);
        
        Transport.send(mailMsg);
	}
	
	public void sendFormToCandidate(User user, String filename) throws MessagingException, IOException{
        
		Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.socketFactory.port", SOCKET_FACTORY_PORT);
        properties.put("mail.smtp.socketFactory.class", SOCKET_FACTORY_CLASS);
        properties.put("mail.smtp.auth", SMTP_AUTHENTICATION);
        
        Session session = Session.getInstance(properties, authenticate(login, password));
                
        Message mailMsg = new MimeMessage(session);
        
        InternetAddress senderAddress = new InternetAddress(mail);
        InternetAddress targetAddress = new InternetAddress(user.getEmail());
        mailMsg.setFrom(senderAddress);
        mailMsg.setRecipient(RecipientType.TO, targetAddress);
        
        mailMsg.setSubject("Учебный центр NetCracker");
        
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Здравствуйте, ваша анкета обновлена.");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName("form.pdf");
        multipart.addBodyPart(messageBodyPart);
        mailMsg.setContent(multipart);
        
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
}
