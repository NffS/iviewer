package com.ncteam.iviewer.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ncteam.iviewer.domain.Interview;

public class ValidationService {
	
	public String checkLength(String str, int max, int min){
		if (str.length()>max)
			return "too long";
		if (str.length()<min)
			return "too short";
		return "ok";
	}
	
	public String checkIsEmpty(String str){
		if (str.equals("") || str==null)
			return "is not entered";
		return ("ok");
	}
	
	public String checkEmail(String email){
		if (!email.matches("[A-Za-z0-9_]+@[A-Za-z0-9]+(.[A-Za-z0-9]+)*.[a-z]{2,4}"))
			return "invalid characters email";
		if (!checkLength(email, 30, 6).equals("ok"))
			return checkLength(email, 30, 6)+" email";
		if (!checkIsEmpty(email).equals("ok"))
			return "email "+checkIsEmpty(email);
		return "ok";
	}
	
	public String checkPassword(String password){
		if (!password.matches("[A-Za-z0-9]"))
			return "invalid characters password";
		if (!checkLength(password, 16, 4).equals("ok"))
			return checkLength(password, 16, 4)+" password";
		if (!checkIsEmpty(password).equals("ok"))
			return "password "+checkIsEmpty(password);
		return "ok";
	}

	
	public String checkName(String name, String prefix){
		if (!name.matches("[A-Za-zА-Яа-я]"))
			return "invalid characters for "+prefix+"name";
		if (!checkLength(name, 13, 1).equals("ok"))
			return checkLength(name, 13, 1)+" "+prefix+"name";
		if (!checkIsEmpty(name).equals("ok"))
			return prefix+"name "+checkIsEmpty(name);
		return "ok";
	}
	
	public String checkPhone(String phone){
		if (!checkLength(phone, 13, 1).equals("ok"))
			return checkLength(phone, 13, 1)+" phone number";
		if (!checkIsEmpty(phone).equals("ok"))
			return "phone number "+checkIsEmpty(phone);
		return "ok";
	}
	
	public String checkYear(String year){
		if (!year.matches("[0-9]"))
			return "invalid characters year of graduation";
		if (!checkLength(year, 5, 3).equals("ok"))
			return checkLength(year, 5, 3)+" year of graduation";
		if (!checkIsEmpty(year).equals("ok"))
			return "year of graduation "+checkIsEmpty(year);
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
	
	public boolean isUserTech(HttpSession session){
		if((Integer)session.getAttribute("user_type_id")==null
				||(Integer)session.getAttribute("user_type_id")!=3){
			return false;
		}
		else{
			return true;
		}
	}
	
	/*
	 * Checks, if the interview and its extra time intersects with any other interview. Uses long values
	 * of dates to compare them.
	 * 
	 * @param checkedInterview Interview to check.
	 * @param allInterviews List of all available interviews.
	 * @isCreating Shows, if the interview is creating or updating.
	 * @return If interview doesn't intersect other interviews, returns null. Otherwise returns the error message.
	 */
	public String checkInterviewsIntersection(Interview checkedInterview, List<Interview> allInterviews,
			boolean isCreating){
				
		long startTime=convertDateStringToItsLongValue(checkedInterview.getStringStartDate());
		
		long endTimePlusExtraTime=convertDateStringToItsLongValue(checkedInterview.getStringEndDate())
				+checkedInterview.getExtraTime()*60000;
		
		
		for(Interview interview:allInterviews){
			if(endTimePlusExtraTime>convertDateStringToItsLongValue(interview.getStringStartDate())
					
					&&startTime<convertDateStringToItsLongValue(interview.getStringEndDate())){
				if(!isCreating&&checkedInterview.getInterviewId().equals(interview.getInterviewId()))
					continue;
				
				return "Невозможно отредактировать или создать интервью:\n" +
						"Такое интервью пересекается с другим по времени.";
			}
		}
		return null;
	}
	
	/*
	 * Converts date string of a certain format to its long value.
	 * 
	 * @param dateString A string representing a date in format "yyyy-mm-dd hh:mi".
	 */
	private long convertDateStringToItsLongValue(String dateString){
		
		int year=Integer.parseInt(dateString.split(" ")[0].substring(0, 4));
		int month=Integer.parseInt(dateString.split(" ")[0].substring(5, 7));
		int day=Integer.parseInt(dateString.split(" ")[0].substring(8, 10));
		int hour=Integer.parseInt(dateString.split(" ")[1].substring(0, 2));
		int minute=Integer.parseInt(dateString.split(" ")[1].substring(3, 5));
		
		return new java.sql.Timestamp(year,month,day,hour,minute,0,0).getTime();
	}
}
