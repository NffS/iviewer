package com.ncteam.iviewer.web;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WritableCellFormat;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncteam.iviewer.domain.Faculty;
import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.HRMark;
import com.ncteam.iviewer.domain.Interview;
import com.ncteam.iviewer.domain.News;
import com.ncteam.iviewer.domain.Source;
import com.ncteam.iviewer.domain.TechMark;
import com.ncteam.iviewer.domain.University;
import com.ncteam.iviewer.domain.User;
import com.ncteam.iviewer.domain.UsersType;
import com.ncteam.iviewer.service.impl.FormServiceImpl;
import com.ncteam.iviewer.service.impl.InterviewServiceImpl;
import com.ncteam.iviewer.service.impl.NewsServiceImpl;
import com.ncteam.iviewer.service.impl.UserServiceImpl;

@Controller
public class ImportDatabaseController{
	
	@Autowired
	 private InterviewServiceImpl interviewService;
	@Autowired
	 private FormServiceImpl formService;
	@Autowired
	 private NewsServiceImpl newsService;
	@Autowired
	 private UserServiceImpl userService;

	Label label;
	WritableWorkbook workbook;
	WritableSheet sheet;
	
	@RequestMapping("/import_db")
    public String importDatabase(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, WriteException{
		
		
		workbook = Workbook.createWorkbook(new File(request.getRealPath("") +"/resources/files/database.xls"));
		int i=0;
		sheet = workbook.createSheet("User", i);
			initUserSheet(sheet); i++;
		sheet = workbook.createSheet("Form", i);
			initFormSheet(sheet); i++;	
		sheet = workbook.createSheet("UserType", i);
			initUserTypeSheet(sheet); i++;
		sheet = workbook.createSheet("Sources", i);
			initSourcesSheet(sheet); i++;
		sheet = workbook.createSheet("Universities", i);
			initUniversitiesSheet(sheet); i++;
		sheet = workbook.createSheet("Faculties", i);
			initFacultiesSheet(sheet); i++;
		sheet = workbook.createSheet("Interview", i);
			initInterviewSheet(sheet); i++;
		sheet = workbook.createSheet("HRmark", i);
			initHRmarkSheet(sheet); i++;
		sheet = workbook.createSheet("TechMark", i);
			initTechMarkSheet(sheet); i++;
		sheet = workbook.createSheet("News", i);
			initNewsSheet(sheet); i++;
			
		workbook.write();
        workbook.close();
        
        return "index";
    }
	
	void initUserSheet(WritableSheet sheet) throws RowsExceededException, WriteException, IOException{
		List<String> userTableHeaderNames = Arrays.asList("user_id", "email", "password", "first_name", "surname", 
				"last_name", "foto", "user_type_id", "reg_date");
		for(int i=0; i<userTableHeaderNames.size(); i++)
			sheet.addCell(new Label(i, 0, userTableHeaderNames.get(i)));
		
		List<User>userList = userService.getAllRecords(User.class);
		int i=1; int j=0;
		for(User user: userList){
			sheet.addCell(new Number(j, i, user.getUserId())); j++;
			sheet.addCell(new Label(j, i, user.getEmail())); j++;
			sheet.addCell(new Label(j, i, user.getPassword())); j++;
			sheet.addCell(new Label(j, i, user.getFirstName())); j++;
			sheet.addCell(new Label(j, i, user.getSurname())); j++;
			sheet.addCell(new Label(j, i, user.getLastName())); j++;
			sheet.addCell(new Label(j, i, user.getFoto())); j++;
			sheet.addCell(new Number(j, i, user.getUserTypeId())); j++;
			sheet.addCell(new Label(j, i, user.getRegDate().toString())); j++;
			i++; j=0;
		}
	}
	
	void initFormSheet(WritableSheet sheet) throws RowsExceededException, WriteException, IOException{
		List<String> formTableHeaderNames = Arrays.asList("form_id", "user_id", "university_id", "faculty_id", "course", 
				"end_year", "email2", "phone", "another_contact", "interest_tc", "interest_nc", "interest_area_po",
				 "interest_area_other", "job_ar_deep_spec", "job_ar_varied", "job_ar_manage", "job_ar_sales", "job_ar_other",
				 "prog_lang_c", "prog_lang_java", "prog_lang_other", "prog_lang_other_mark", "cs_network_tech", "cs_algorithms",
				 "cs_oop", "cs_gui", "cs_db", "cs_web", "cs_network_prog", "cs_design",
				 "cs_other", "cs_other_mark", "experience", "english_read", "english_write", "english_spoken", "source_id",
				 "motivation_comment", "comment2", "status", "interview_id", "visit_status");
		for(int i=0; i<formTableHeaderNames.size(); i++)
			sheet.addCell(new Label(i, 0, formTableHeaderNames.get(i).toString()));
		
		List<Form>formList = formService.getAllRecords(Form.class);
		int i=1; int j=0;
		for(Form form: formList){
			sheet.addCell(new Number(j, i, form.getFormId())); j++;
			sheet.addCell(new Number(j, i, form.getUserId())); j++;
			sheet.addCell(new Number(j, i, form.getUniversityId())); j++;
			sheet.addCell(new Number(j, i, form.getFacultyId())); j++;
			sheet.addCell(new Number(j, i, form.getCourse())); j++;
			sheet.addCell(new Label(j, i, form.getEndYear())); j++;
			sheet.addCell(new Label(j, i, form.getEmail2())); j++;
			sheet.addCell(new Label(j, i, form.getPhone())); j++;
			sheet.addCell(new Label(j, i, form.getAnotherContact())); j++;
			sheet.addCell(new Label(j, i, form.getInterestTc())); j++;
			sheet.addCell(new Label(j, i, form.getInterestNc())); j++;
			sheet.addCell(new Label(j, i, form.getInterestAreaPo())); j++;
			sheet.addCell(new Label(j, i, form.getInterestAreaOther())); j++;
			sheet.addCell(new Label(j, i, form.getJobArDeepSpec())); j++;
			sheet.addCell(new Label(j, i, form.getJobArVaried())); j++;
			sheet.addCell(new Label(j, i, form.getJobArManage())); j++;
			sheet.addCell(new Label(j, i, form.getJobArSales())); j++;
			sheet.addCell(new Label(j, i, form.getJobArOther())); j++;
			sheet.addCell(new Number(j, i, form.getProgLangC())); j++;
			sheet.addCell(new Number(j, i, form.getProgLangJava())); j++;
			sheet.addCell(new Label(j, i, form.getProgLangOther())); j++;
			sheet.addCell(new Number(j, i, form.getProgLangOtherMark())); j++;
			sheet.addCell(new Number(j, i, form.getCsNetworkTech())); j++;
			sheet.addCell(new Number(j, i, form.getCsAlgorithms())); j++;
			sheet.addCell(new Number(j, i, form.getCsOop())); j++;
			sheet.addCell(new Number(j, i, form.getCsGui())); j++;
			sheet.addCell(new Number(j, i, form.getCsDb())); j++;
			sheet.addCell(new Number(j, i, form.getCsWeb())); j++;
			sheet.addCell(new Number(j, i, form.getCsNetworkProg())); j++;
			sheet.addCell(new Number(j, i, form.getCsDesign())); j++;
			sheet.addCell(new Label(j, i, form.getCsOther())); j++;
			sheet.addCell(new Number(j, i, form.getCsOtherMark())); j++;
			sheet.addCell(new Label(j, i, form.getExperience())); j++;
			sheet.addCell(new Number(j, i, form.getEnglishRead())); j++;
			sheet.addCell(new Number(j, i, form.getEnglishWrite())); j++;
			sheet.addCell(new Number(j, i, form.getEnglishSpoken())); j++;
			sheet.addCell(new Number(j, i, form.getSourceId())); j++;
			sheet.addCell(new Label(j, i, form.getMotivation_comment())); j++;
			sheet.addCell(new Label(j, i, form.getComment2())); j++;
			sheet.addCell(new Number(j, i, form.getStatus())); j++;
			sheet.addCell(new Number(j, i, form.getInterviewId())); j++;
			sheet.addCell(new Number(j, i, form.getVisitStatus())); j++;
			i++; j=0;
		}
	}
	
	void initUserTypeSheet(WritableSheet sheet) throws RowsExceededException, WriteException, IOException{
		List<String> userTypeTableHeaderNames = Arrays.asList("user_type_id", "type_name");
		for(int i=0; i<userTypeTableHeaderNames.size(); i++)
			sheet.addCell(new Label(i, 0, userTypeTableHeaderNames.get(i).toString()));
		
		List<UsersType>userTypeList = userService.getAllRecords(UsersType.class);
		int i=1; int j=0;
		for(UsersType userType: userTypeList){
			sheet.addCell(new Number(j, i,userType.getUserTypeId())); j++;
			sheet.addCell(new Label(j, i, userType.getTypeName())); j++;
			i++; j=0;
		}
	}
	
	void initSourcesSheet(WritableSheet sheet) throws RowsExceededException, WriteException, IOException{
		List<String> sourcesTableHeaderNames = Arrays.asList("source_id", "source_name");
		for(int i=0; i<sourcesTableHeaderNames.size(); i++)
			sheet.addCell(new Label(i, 0, sourcesTableHeaderNames.get(i).toString()));
		
		List<Source>sourceList = formService.getAllRecords(Source.class);
		int i=1; int j=0;
		for(Source source: sourceList){
			sheet.addCell(new Number(j, i, source.getSourceId())); j++;
			sheet.addCell(new Label(j, i, source.getSourceName())); j++;

			i++; j=0;
		}
	}
	
	void initUniversitiesSheet(WritableSheet sheet) throws RowsExceededException, WriteException, IOException{
		List<String> universitiesTableHeaderNames = Arrays.asList("university_id", "university_name");
		for(int i=0; i<universitiesTableHeaderNames.size(); i++)
			sheet.addCell(new Label(i, 0, universitiesTableHeaderNames.get(i).toString()));
		
		List<University>universityList = formService.getAllRecords(University.class);
		int i=1; int j=0;
		for(University univer: universityList){
			sheet.addCell(new Number(j, i, univer.getUniversityId())); j++;
			sheet.addCell(new Label(j, i, univer.getUniversityName())); j++;

			i++; j=0;
		}
	}
	
	void initFacultiesSheet(WritableSheet sheet) throws RowsExceededException, WriteException, IOException{
		List<String> facultiesTableHeaderNames = Arrays.asList("faculty_id", "faculty_name", "university_id");
		for(int i=0; i<facultiesTableHeaderNames.size(); i++)
			sheet.addCell(new Label(i, 0, facultiesTableHeaderNames.get(i)));
		
		List<Faculty>facultyList = formService.getAllRecords(Faculty.class);
		int i=1; int j=0;
		for(Faculty faculty: facultyList){
			sheet.addCell(new Number(j, i, faculty.getFacultyId())); j++;
			sheet.addCell(new Label(j, i, faculty.getFacultyName())); j++;
			sheet.addCell(new Number(j, i, faculty.getUniversityId())); j++;
			
			i++; j=0;
		}
	}
	
	void initInterviewSheet(WritableSheet sheet) throws RowsExceededException, WriteException, IOException{
		List<String> interviewTableHeaderNames = Arrays.asList("interview_id", "start_date", "end_date", "extra_time", "seats");
		for(int i=0; i<interviewTableHeaderNames.size(); i++)
			sheet.addCell(new Label(i, 0, interviewTableHeaderNames.get(i)));
		
		List<Interview>interviewList = interviewService.getAllRecords(Interview.class);
		int i=1; int j=0;
		for(Interview interview: interviewList){
			sheet.addCell(new Number(j, i, interview.getInterviewId())); j++;
			sheet.addCell(new Label(j, i, interview.getStringStartDate())); j++;
			sheet.addCell(new Label(j, i, interview.getStringEndDate())); j++;
			sheet.addCell(new Number(j, i, interview.getExtraTime())); j++;
			sheet.addCell(new Number(j, i, interview.getSeats())); j++;

			i++; j=0;
		}
	}
	
	void initHRmarkSheet(WritableSheet sheet) throws RowsExceededException, WriteException, IOException{
		List<String> hrMarkTableHeaderNames = Arrays.asList("hr_mark_id", "user_id", "form_id", "motivation", "english", 
				"general_mark");
		for(int i=0; i<hrMarkTableHeaderNames.size(); i++)
			sheet.addCell(new Label(i, 0, hrMarkTableHeaderNames.get(i)));
		
		List<HRMark>hrMarkList = interviewService.getAllRecords(HRMark.class);
		int i=1; int j=0;
		for(HRMark hrMark: hrMarkList){
			sheet.addCell(new Number(j, i, hrMark.getHrMarkId())); j++;
			sheet.addCell(new Number(j, i, hrMark.getUserId())); j++;
			sheet.addCell(new Number(j, i, hrMark.getFormId())); j++;
			sheet.addCell(new Number(j, i, hrMark.getMotivation())); j++;
			sheet.addCell(new Number(j, i, hrMark.getEnglish())); j++;
			sheet.addCell(new Label(j, i, hrMark.getGeneralMark())); j++;

			i++; j=0;
		}
	}
	
	void initTechMarkSheet(WritableSheet sheet) throws RowsExceededException, WriteException, IOException{
		List<String> techMarkTableHeaderNames = Arrays.asList("tech_mark_id", "user_id", "form_id", "prog_lang", "oop", 
				"patterns", "db", "cs", "experience", "other", "general_mark");
		for(int i=0; i<techMarkTableHeaderNames.size(); i++)
			sheet.addCell(new Label(i, 0, techMarkTableHeaderNames.get(i)));
		
		List<TechMark>techMarkList = interviewService.getAllRecords(TechMark.class);
		int i=1; int j=0;
		for(TechMark techMark: techMarkList){
			sheet.addCell(new Number(j, i, techMark.getTechMarkId())); j++;
			sheet.addCell(new Number(j, i, techMark.getUserId())); j++;
			sheet.addCell(new Number(j, i, techMark.getFormId())); j++;
			sheet.addCell(new Number(j, i, techMark.getProgLang())); j++;
			sheet.addCell(new Number(j, i, techMark.getOop())); j++;
			sheet.addCell(new Number(j, i, techMark.getPatterns())); j++;
			sheet.addCell(new Number(j, i, techMark.getDb())); j++;
			sheet.addCell(new Number(j, i, techMark.getCs())); j++;
			sheet.addCell(new Number(j, i, techMark.getExperience())); j++;
			sheet.addCell(new Number(j, i, techMark.getOther())); j++;
			sheet.addCell(new Label(j, i, techMark.getGeneralMark())); j++;

			i++; j=0;
		}
	}
	
	void initNewsSheet(WritableSheet sheet) throws RowsExceededException, WriteException, IOException{
		List<String> newsTableHeaderNames = Arrays.asList("news_id", "text");
		for(int i=0; i<newsTableHeaderNames.size(); i++)
			sheet.addCell(new Label(i, 0, newsTableHeaderNames.get(i)));
		
		List<News>newsList = formService.getAllRecords(News.class);
		int i=1; int j=0;
		for(News news: newsList){
			sheet.addCell(new Number(j, i, news.getNewsId())); j++;
			sheet.addCell(new Label(j, i, news.getText())); j++;

			i++; j=0;
		}
	}
	
	
	
	
	
}