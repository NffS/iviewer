package com.ncteam.iviewer.service;

import javax.servlet.http.HttpSession;

public class ValidationService {
	
	private String checkLength(String str, int max, int min){
		if (str.length()>max)
			return "too long";
		if (str.length()<min)
			return "too short";
		return "ok";
	}
	
	private String checkIsEmpty(String str){
		if (str.equals("") || str==null)
			return "is not entered";
		return ("ok");
	}
	
	public String checkEmail(String email){
		if (!email.matches("[A-Za-z0-9_]+@[A-Za-z0-9]+(.[A-Za-z0-9]+)*.[a-z]{2,4}"))
			return "invalid characters";
		if (!checkLength(email, 30, 6).equals("ok"))
			return checkLength(email, 30, 6)+" email";
		if (!checkIsEmpty(email).equals("ok"))
			return "email "+checkIsEmpty(email);
		return "ok";
	}
	
	public String checkEmail(String email, String pattern){
		if (!email.matches(pattern))
			return "invalid characters";
		if (!checkLength(email, 30, 6).equals("ok"))
			return checkLength(email, 30, 6)+" email";
		if (!checkIsEmpty(email).equals("ok"))
			return "email "+checkIsEmpty(email);
		return "ok";
	}
	
	public String checkPassword(String password){
		if (!password.matches("[A-Za-z0-9]+"))
			return "invalid characters";
		if (!checkLength(password, 16, 4).equals("ok"))
			return checkLength(password, 16, 4)+" email";
		if (!checkIsEmpty(password).equals("ok"))
			return "password "+checkIsEmpty(password);
		return "ok";
	}
	
	public String checkPassword(String password, String pattern){
		if (!password.matches(pattern))
			return "invalid characters";
		if (!checkLength(password, 16, 4).equals("ok"))
			return checkLength(password, 16, 4)+" email";
		if (!checkIsEmpty(password).equals("ok"))
			return "password "+checkIsEmpty(password);
		return "ok";
	}
	
	public String checkName(String name, String pattern){
		
		return "ok";
	}
	

	public boolean isInterviewDateStringValid(String interviewDateStrig){
		String pattern="201[3-9]-([0][1-9]|[1][0-2])-([0-2][0-9]|[3][0-1]) ([0-1][0-9]|2[0-4]):[0-5][0-9]";
		return interviewDateStrig.matches(pattern);
	}	

	
	public boolean isInterviewStartEarlierThanEnd(String start, String end){
		if(Integer.parseInt(start.substring(0,2))>Integer.parseInt(end.substring(0,2)))
			return false;
		if(Integer.parseInt(start.substring(0,2))<Integer.parseInt(end.substring(0,2)))
			return true;
		if(Integer.parseInt(start.substring(3))<Integer.parseInt(end.substring(3)))
			return true;
		else
			return false;
	}
	
	public boolean isUserHR(HttpSession session){
		if((Integer)session.getAttribute("user_type_id")==null
				||(Integer)session.getAttribute("user_type_id")!=2){
			return false;
		}
		else{
			return true;
		}
	}
}
