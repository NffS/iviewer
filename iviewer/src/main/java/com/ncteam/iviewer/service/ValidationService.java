package com.ncteam.iviewer.service;

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
}
