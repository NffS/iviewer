package validators;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.service.impl.InterviewServiceImpl;

@Service
public class Validator {
	
	@Autowired
	private InterviewServiceImpl service;
	
	public boolean isEmailCorrect(String email){
		if(!Pattern.matches("^([a-zA-Z0-9_\\.\\-]{1,16})@([a-zA-Z0-9\\.\\-]{1,8})\\.([a-z]{2,4})$", email))
			return false;

		return true;
	}
	
	public boolean isPasswordCorrect(String password){
		if(password.length()<0||!Pattern.matches("[a-zA-Z0-9]{4,16}$",password))
			return false;
		
		return true;
	}
	
	public String checkEmail(String email){
		if(email.isEmpty())
			return "Заполните поле \"Email\".";
		if(!Pattern.matches("^([a-zA-Z0-9_\\.\\-]{1,16})@([a-zA-Z0-9\\.\\-]{1,8})\\.([a-z]{2,4})$", email))
			return "E-Mail не введён некорректно.";

		return "";
	}
	
	public String checkPassword(String password){
		if(password.isEmpty())
			return "Заполните поле \"Пароль\".";
		if(!Pattern.matches("[a-zA-Z0-9]{4,16}$",password))
			return "Пароль введён некорректно.";
		
		return "";
	}	
		
	public boolean isNameCorrect(String name){
		if(!Pattern.matches("[A-ZА-ЯЁ][a-zа-яё]{1,20}$", name))
			return false;
		
		return true;
	}
	
	public boolean isPhoneCorrect(String phone){
		if(!Pattern.matches("[0-9]{1,16}$", phone))
			return false;
		
		return true;
	}
	
	public boolean isYearCorrect(String year){
		if(!Pattern.matches("[1970-2020]$", year))
			return false;
		
		return true;
	}
	
	public boolean isFieldCorrect(String field){
		if(!Pattern.matches("[A-ZА-ЯЁ][a-zа-яё]{1,14}$", field))
			return false;
		
		return true;
	}

	public boolean isInterestFieldCorrect(String mark){
		if(!Pattern.matches("[+-?]{1,2}$", mark))
			return false;
		
		return true;
	}
	
	public boolean isAccomplishmentsFieldCorrect(String mark){
		if(!Pattern.matches("[0-5]$", mark))
			return false;
		
		return true;
	}
	
	public boolean isLanguageFieldCorrect(String mark){
		if(!Pattern.matches("[1-5]$", mark))
			return false;
		
		return true;
	}
	
	public String checkInterview(Interview interview, boolean isCreating){
		try{
			checkInterviewDateStringValid(interview.getStringStartDate());
			checkInterviewDateStringValid(interview.getStringEndDate());
			checkInterviewStartEarlierThanEnd(interview.getStringStartDate(), interview.getStringEndDate());
			checkInterviewsIntersection(interview,service.getAllRecords(Interview.class),isCreating);
			
		}
		catch(Exception e){
			return e.getMessage();
		}
		return "";		
	}
	
	private void checkInterviewDateStringValid(String interviewDateStrig) throws Exception{
		String pattern="201[3-9]-([0][1-9]|[1][0-2])-([0-2][0-9]|[3][0-1]) ([0-1][0-9]|2[0-4]):[0-5][0-9]";
		if(!interviewDateStrig.matches(pattern))
			throw new Exception("Введённые данные не соответствуют шаблону.");
	}	

	
	private void checkInterviewStartEarlierThanEnd(String start, String end) throws Exception{
		if(Integer.parseInt(start.substring(11,13))>Integer.parseInt(end.substring(11,13)))
			throw new Exception("Конец собеседования не может быть раньше его начала или совпадать с ним.");
		if(Integer.parseInt(start.substring(11,13))==Integer.parseInt(end.substring(11,13)))
		if(Integer.parseInt(start.substring(14))>=Integer.parseInt(end.substring(14)))
			throw new Exception("Конец собеседования не может быть раньше его начала или совпадать с ним.");
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
	
	public boolean isUserCandidate(HttpSession session){
		if((Integer)session.getAttribute("user_type_id")==null
				||(Integer)session.getAttribute("user_type_id")!=4){
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
	 * @isCreating Shows, if the interview is creating or updating. If true - interview is creating,
	 *  if false - updating.
	 * @return If interview doesn't intersect other interviews, returns null. Otherwise returns the error message.
	 */
	private void checkInterviewsIntersection(Interview checkedInterview, List<Interview> allInterviews,
			boolean isCreating) throws Exception{
				
		long startTime=convertDateStringToItsLongValue(checkedInterview.getStringStartDate());
		
		long endTimePlusExtraTime=convertDateStringToItsLongValue(checkedInterview.getStringEndDate())
				+checkedInterview.getExtraTime()*60000;
		
		
		for(Interview interview:allInterviews){
			if(endTimePlusExtraTime>convertDateStringToItsLongValue(interview.getStringStartDate())
					
					&&startTime<convertDateStringToItsLongValue(interview.getStringEndDate())){
				if(!isCreating&&checkedInterview.getInterviewId().equals(interview.getInterviewId()))
					continue;
				
				throw new Exception("Невозможно отредактировать или создать интервью:\n" +
						"Такое интервью пересекается с другим по времени.");
			}
		}
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
	
	public boolean isUserDataCorrect(User user){
		if(!Pattern.matches("^([a-zA-Z0-9_\\.\\-]{1,20})@([a-zA-Z0-9\\.\\-]{1,20})\\.([a-z]{2,4})$",user.getEmail()))
				return false;
		if(!Pattern.matches("[A-ZА-ЯЁ][a-zа-яё]{1,40}$",user.getFirstName()))
				return false;
		if(!Pattern.matches("[A-ZА-ЯЁ][a-zа-яё]{1,40}$",user.getSurname()))
			return false;
		if(!Pattern.matches("[A-ZА-ЯЁ][a-zа-яё]{1,40}$",user.getLastName()))
			return false;
		if(user.getPassword().length()<0||!Pattern.matches("[a-zA-Z0-9]{4,16}$",user.getPassword()))
			return false;
		
		return true;
	}
}
