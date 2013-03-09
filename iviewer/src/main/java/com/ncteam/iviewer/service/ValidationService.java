package com.ncteam.iviewer.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ncteam.iviewer.domain.Interview;

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
	
	public String checkInterviewsIntersection(Interview checkedInterview, List<Interview> allInterviews,
			boolean isCreating){
				
		long startTime=convertDateStringToItsLongValue(checkedInterview.getStringStart_date());
		
		long endTimePlusExtraTime=convertDateStringToItsLongValue(checkedInterview.getStringEnd_date())
				+checkedInterview.getExtra_time()*60000;
		
		
		for(Interview interview:allInterviews){
			if(endTimePlusExtraTime>convertDateStringToItsLongValue(interview.getStringStart_date())
					
					&&startTime<convertDateStringToItsLongValue(interview.getStringEnd_date())){
				if(!isCreating&&checkedInterview.getInterview_id().equals(interview.getInterview_id()))
					continue;
				
				return "Невозможно отредактировать или создать интервью:\n" +
						"Такое интервью пересекается с другим по времени.";
			}
		}
		return null;
	}
	
	private long convertDateStringToItsLongValue(String dateString){
		int year=Integer.parseInt(dateString.split(" ")[0].substring(0, 4));
		int month=Integer.parseInt(dateString.split(" ")[0].substring(5, 7));
		int day=Integer.parseInt(dateString.split(" ")[0].substring(8, 10));
		int hour=Integer.parseInt(dateString.split(" ")[1].substring(0, 2));
		int minute=Integer.parseInt(dateString.split(" ")[1].substring(3, 5));
		return new java.sql.Timestamp(year,month,day,hour,minute,0,0).getTime();
	}
}
