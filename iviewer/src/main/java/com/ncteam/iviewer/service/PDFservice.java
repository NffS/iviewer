package com.ncteam.iviewer.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import com.ncteam.iviewer.domain.Form;
import com.ncteam.iviewer.domain.User;

public class PDFservice {
	private int x;
    private int y; 
    private int tab;
    private BaseFont baseFont;
    private Document document;
    private PdfContentByte cb;
    
    public PDFservice(String filename, HttpServletRequest request) throws DocumentException, IOException{
    	moveX(20);
        moveY(775);
        setTab(0);
        baseFont = BaseFont.createFont(request.getRealPath("") + "/resources/times.ttf","cp1251",BaseFont.EMBEDDED);
        document = new Document(PageSize.A4,20,20,20,20);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        cb = writer.getDirectContent();
        Paragraph paragraph = new Paragraph("Анкета / IV набор в учебный центр NetCracker", 
                new Font(baseFont, 18, Font.NORMAL));
       paragraph.setAlignment(Element.ALIGN_CENTER);
       document.add(paragraph);
    }
    
    public void createPDF(User user, Form form) throws DocumentException, MalformedURLException, IOException{
    	
        addFoto(user.getFoto());
        addTitle("Персональная информация");
        setTab(30);
        addLine("Имя:", user.getFirstName(), 120);
        addLine("Фамилия:", user.getSurname(), 120);
        addLine("Отчество:", user.getLastName(), 120);
        addLine("Вуз:", form.getUniversity().getUniversityName(), 120);
        addLine("Факультет:", form.getFaculty().getFacultyName(), 120);
        addLine("Курс:", form.getCourse().toString(), 120);
        addLine("Год окончания:", form.getEndYear(), 120);
        setTab(20);
        addTitle("Контакты");
        setTab(90);
        addLine("email1:", user.getEmail(), 120);
        addLine("email2:", form.getEmail2(), 120);
        addLine("телефон:", form.getPhone(), 120);
        addLine("другое:", form.getAnotherContact(), 120);
        setTab(20);
        addTitle("Интересы");
        setTab(30);
        addLine("Что заинтересовало?", "", 120);
        setTab(90);
        addLine("учебный центр/стажировка:", form.getInterestTc(), 210);
        addLine("работа в компании NetCracker:", form.getInterestNc(), 210);
        setTab(30);
        addLine("Тип работы", "", 120);
        setTab(90);
        addLine("глубокая специализация", form.getJobArDeepSpec(), 210);
        addLine("разнообразная работа", form.getJobArVaried(), 210);
        addLine("руководство специалистами", form.getJobArManage(), 210);
        addLine("продажи", form.getJobArSales(), 210);
        addLine("другое", form.getJobArOther(), 210);
        setTab(20);
        addTitle("Достоинства");
        setTab(25);
        addLine("Владение языками программирования (по шкале от 1 до 5): 1 – писал простые ", "", 0);
        setTab(25);
        addLine("программы сo справкой; 3 – хорошо помню синтаксис; 5 – написал крупный проект", "", 0);
        addTable(form.getProgLangJava().toString(), form.getProgLangC().toString(), form.getProgLangOther());
        document.newPage();
        moveX(20);
        moveY(775);
        setTab(30);
        addLine("Как ты оцениваешь свои знания по разделам (по шкале от 0 до 5):", "", 0);
        setTab(90);
        addLine("сетевые технологии", form.getCsNetworkTech().toString(), 260);
        addLine("эффективные алгоритмы", form.getCsAlgorithms().toString(), 260);
        addLine("объектно-ориент. программирование", form.getCsOop().toString(), 260);
        addLine("графический интерфейс (не Web)", form.getCsGui().toString(), 260);
        addLine("базы данных", form.getCsDb().toString(), 260);
        addLine("Web", form.getCsWeb().toString(), 260);
        addLine("сетевое программирование", form.getCsNetworkProg().toString(), 260);
        addLine("проектирование программ", form.getCsDesign().toString(), 260);
        addLine("другой раздел ", form.getCsOther().toString(), 260);
        setTab(30);
        addLine("Уровень английского языка (от 1 = elementary до 5 = advanced):", "", 0);
        setTab(90);
        addEnglish(form.getEnglishRead().toString(), form.getEnglishWrite().toString(), form.getEnglishSpoken().toString());
        setTab(30);
        for (int i=0;i<19;i++)
        	document.add(new Paragraph(" "));

		        document.add(new Paragraph("Если у тебя уже есть опыт работы и/или выполненные учебные проекты, опиши их:", 
		                new Font(baseFont, 14, Font.BOLD)));
		        document.add(new Paragraph(form.getExperience(), 
		                new Font(baseFont, 12, Font.NORMAL)));
		        document.add(new Paragraph("Почему тебя обязательно надо взять в NetCracker (достоинства, обещания):", 
		                new Font(baseFont, 14, Font.BOLD)));
		        document.add(new Paragraph(form.getMotivation_comment(), 
		                new Font(baseFont, 12, Font.NORMAL)));
		        document.add(new Paragraph("Дополнительные сведения о себе: олимпиады, курсы, сертификаты, личные качества:", 
		                new Font(baseFont, 14, Font.BOLD)));
		        document.add(new Paragraph(form.getComment2(), 
		                new Font(baseFont, 12, Font.NORMAL))); 
		        document.add(new Paragraph("Я даю согласие на хранение, обработку и использование моих персональных данных с целью возможного обучения и трудоустройства в компании НЕТКРЕКЕР на данный момент и в будущем: ФИО, подпись _________________________", 
		                new Font(baseFont, 14, Font.BOLD)));
		        document.add(new Paragraph(" "));
		        document.add(new Paragraph("Интервьюер 1 _____________                                                   Интервьюер 2 _____________", 
		                new Font(baseFont, 14, Font.NORMAL)));
			
        closeDoc();
    }
    
    void addLine(String title, String statement, int n){
        cb.beginText();
                cb.setFontAndSize(baseFont, 14);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, title, x+tab, y-=10, 0);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, statement, x+tab+n, y, 0);
        cb.endText();
        moveY(y-15);
    }
    
    void addTitle(String title){
        cb.beginText();
                cb.setFontAndSize(baseFont, 18);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, title, x, y-=10, 0);
        cb.endText();
        cb.setLineWidth(0f);
                cb.moveTo(x, y-=3);
                cb.lineTo(x+540, y-=3);
        cb.stroke();
        moveY(y-10);
    }
    
    void moveX(int newX){
        x=newX;
    }
    
    void moveY(int newY){
        y=newY;
    }
    
    void setTab(int newTab){
        tab=newTab;
    }
    
    void closeDoc(){
        document.close();
    }
    
    void addFoto(String filename) throws BadElementException, MalformedURLException, IOException, DocumentException{
        Image image = Image.getInstance(filename);
        image.setAbsolutePosition(400, 580);
        cb.addImage(image);
    }
    
    void addTable(String a, String b, String c) throws DocumentException{
            cb.beginText();
            cb.setFontAndSize(baseFont, 14);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "Java - "+a, 170, 95, 0);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "C++ - "+b, 270, 95, 0);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "Другой язык - "+c, 350, 95, 0);
            cb.endText();
    }
    
    void addEnglish(String a, String b, String c){
        moveY(y-10);
        cb.beginText();
                cb.setFontAndSize(baseFont, 14);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "чтение:     ", x+tab+30, y, 0);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, a, x+tab+50+30, y, 0);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "письмо:     ", x+tab+100+30, y, 0);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, b, x+tab+155+30, y, 0);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, "устная речь:", x+tab+200+30, y, 0);
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT, c, x+tab+280+30, y, 0);
        cb.endText();
        moveY(y-15);
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
    
    private String convertToDB(String input){
    	switch (input){
    	case "да": return "+";
    	case "возможно": return "+-";
    	case "нет": return "-";
    	case "хочу узнать больше": return "?";
    	}
    	return "";
    }
}
