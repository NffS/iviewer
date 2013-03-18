package com.ncteam.iviewer.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncteam.iviewer.domain.Faculty;
import com.ncteam.iviewer.domain.FormInformation;
import com.ncteam.iviewer.domain.University;
import com.ncteam.iviewer.service.ValidationService;
import com.ncteam.iviewer.service.impl.FormServiceImpl;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class ReportsController {
	
	@Autowired
	 private FormServiceImpl formService;
	 private ValidationService validator=new ValidationService();
	
	 
	 
	@RequestMapping(value="/hr_reports")
	public String hrReports(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		return "hr_reports";
	}

	@RequestMapping("/attendance_report")
	public String attendanceReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		
		map.put("attendances", formService.getShortFormInformation());
		
		
		return "hr_attendencies_report";
	}
	
	@RequestMapping(value="universities_report")
	public String universitiesReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		
		map.put("studentsInUniversitiesTable", formService.getStudentsInUniversities());
		map.put("studentsInFacultiesTable", formService.getStudentsInFaculties());
		map.put("universities", formService.getAllRecords(University.class));
		map.put("faculties", formService.getAllRecords(Faculty.class));
		return "hr_universities_report";
	}
	
	@RequestMapping(value="records_increase_report")
	public String recordsIncreaseReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		map.put("recordIncreaseForms", formService.getCandidatesRegistrationDates());
		return "hr_records_increase_report";
	}
	
	@RequestMapping(value="graphic_forms_report")
	public String graphicFormsReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		map.put("cameDoesntCameStudents", formService.getCameDoesntCameStudents());
		return "hr_graphic_forms_report";
	}
	
	@RequestMapping(value="graphic_pr_report")
	public String graphicPRReport(HttpSession session, Map<String, Object> map){
		
		if(!validator.isUserHR(session)){
			return "redirect:/index";
		}
		map.put("advertisementEfficiency", formService.getAdvertisementEfficiency());
		map.put("advertisementNames", formService.getAllAdvertisementNames());
		return "hr_graphic_pr_report";
	}
	
	@RequestMapping(value="pdf_report")
	public String pdfReport(HttpServletRequest request,HttpSession session) throws DocumentException, IOException{
		
		String file =request.getRealPath("") + "/resources/files/hr_reports/report.pdf";
		Document document = new Document();
	    PdfWriter.getInstance(document, new FileOutputStream(file));
	    
	    document.open();
	    
	    Paragraph preface = new Paragraph();
	    preface.add(new Paragraph(" "));
	    BaseFont times =
	    		BaseFont.createFont(request.getRealPath("") + "/resources/times.ttf","cp1251",BaseFont.EMBEDDED);
	    Paragraph title=new Paragraph("Отчёт по по всем зарегистрированным абитуриентам", new Font(times, 18));
	    title.setAlignment(Element.ALIGN_CENTER);
	    preface.add(title);
	    preface.add(new Paragraph(" "));
	    preface.add(new Paragraph(" "));
	    document.add(preface);
	    
	    PdfPTable table = new PdfPTable(4);

	    PdfPCell numberCell = new PdfPCell(new Phrase("№",new Font(times,14, Font.BOLD)));
	    numberCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    numberCell.setBackgroundColor(BaseColor.YELLOW);
	    table.addCell(numberCell);
	    
	    PdfPCell nameCell = new PdfPCell(new Phrase("ФИО",new Font(times,14, Font.BOLD)));
	    nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    nameCell.setBackgroundColor(BaseColor.YELLOW);
	    table.addCell(nameCell);
	    
	    PdfPCell interviewCell = new PdfPCell(new Phrase("Собеседование",new Font(times,14, Font.BOLD)));
	    interviewCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    interviewCell.setBackgroundColor(BaseColor.YELLOW);
	    table.addCell(interviewCell);
	    
	    PdfPCell comeStatusCell = new PdfPCell(new Phrase("Посещение",new Font(times,14, Font.BOLD)));
	    comeStatusCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    comeStatusCell.setBackgroundColor(BaseColor.YELLOW);
	    table.addCell(comeStatusCell);
	    
	    List<FormInformation> forms=formService.getFormsInformation();
	    for(int i=0; i<forms.size();i++){
	    	
	    	table.addCell(""+(i+1));
	    	
	    	nameCell=new PdfPCell(new Phrase(forms.get(i).getSurname()+" "
	    			+forms.get(i).getFirstName()+" "+forms.get(i).getLastName(),new Font(times,14)));
	    	nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	table.addCell(nameCell);
	    	
	    	table.addCell(forms.get(i).getStartDate());
	    	
	    	if(forms.get(i).getVisitStatus().equals(new Integer(0)))
	    		comeStatusCell=new PdfPCell(new Phrase("Не пришёл",new Font(times,14)));
	    	else
	    		comeStatusCell=new PdfPCell(new Phrase("Пришёл",new Font(times,14)));
	    	comeStatusCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	table.addCell(comeStatusCell);
	    }
	    float[] columnWidths = new float[] {8f, 100f, 43f, 40f};
	    table.setTotalWidth(columnWidths);
	    table.setHeaderRows(1);
	    document.add(table);
	    document.close();
	    return "redirect:/resources/files/hr_reports/report.pdf";
	}
}
