package com.ncteam.iviewer.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

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


public class PDFservice {
	private int x;
    private int y; 
    private int tab;
    private BaseFont baseFont;
    private String FONT_LOCATION ="C://fonts//TIMCYR.ttf";
    private Document document;
    private PdfContentByte cb;
    
    PDFservice(String filename) throws DocumentException, IOException{
    	moveX(20);
        moveY(775);
        setTab(0);
        baseFont = BaseFont.createFont(FONT_LOCATION, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        document = new Document(PageSize.A4,20,20,20,20);
        filename = "d://test.pdf";
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        cb = writer.getDirectContent();
        Paragraph paragraph = new Paragraph("Анкета / IV набор в учебный центр NetCracker", 
                new Font(baseFont, 18, Font.NORMAL));
       paragraph.setAlignment(Element.ALIGN_CENTER);
       document.add(paragraph);
    }
    
    void createPDF(){
    	
        addFoto("d://zold.png");
        addTitle("Персональная информация");
        setTab(30);
        addLine("Имя:", "Тут будет имя", 120);
        addLine("Фамилия:", "Тут будет фамилия", 120);
        addLine("Отчество:", "Тут будет отчество", 120);
        addLine("Вуз:", "ОНУ им. Мечникова", 120);
        addLine("Факультет:", "Прикладная математика", 120);
        addLine("Курс:", "я не студент", 120);
        addLine("Год окончания:", "я не студент", 120);
        setTab(20);
        addTitle("Контакты");
        setTab(90);
        addLine("email1:", "Тут будет email1@gmail.com", 120);
        addLine("email2:", "Тут будет email2@gmail.com", 120);
        addLine("телефон:", "Тут будет номер телефона", 120);
        addLine("другое:", "Тут будет другой контакт, йцукенйцукен", 120);
        setTab(20);
        addTitle("Интересы");
        setTab(30);
        addLine("Что заинтересовало?", "", 120);
        setTab(90);
        addLine("учебный центр/стажировка:", "хочу узнать больше", 210);
        addLine("работа в компании NetCracker:", "хочу узнать больше", 210);
        setTab(30);
        addLine("Тип работы", "", 120);
        setTab(90);
        addLine("глубокая специализация", "хочу узнать больше", 210);
        addLine("разнообразная работа", "хочу узнать больше", 210);
        addLine("руководство специалистами", "хочу узнать больше", 210);
        addLine("продажи", "хочу узнать больше", 210);
        addLine("другое", "хочу узнать больше", 210);
        setTab(20);
        addTitle("Достоинства");
        setTab(25);
        addLine("Владение языками программирования (по шкале от 1 до 5): 1 – писал простые ", "", 0);
        setTab(25);
        addLine("программы сo справкой; 3 – хорошо помню синтаксис; 5 – написал крупный проект", "", 0);
        addTable("1", "2", "3");
        document.newPage();
        moveX(20);
        moveY(775);
        setTab(30);
        addLine("Как ты оцениваешь свои знания по разделам (по шкале от 0 до 5):", "", 0);
        setTab(90);
        addLine("сетевые технологии", "5", 260);
        addLine("эффективные алгоритмы", "5", 260);
        addLine("объектно-ориент. программирование", "5", 260);
        addLine("графический интерфейс (не Web)", "5", 260);
        addLine("базы данных", "5", 260);
        addLine("Web", "5", 260);
        addLine("сетевое программирование", "5", 260);
        addLine("проектирование программ", "5", 260);
        addLine("другой раздел ", "5", 260);
        setTab(30);
        addLine("Уровень английского языка (от 1 = elementary до 5 = advanced):", "", 0);
        setTab(90);
        addEnglish("3", "2", "1");
        setTab(30);
        for (int i=0;i<19;i++)
			try {
				document.add(new Paragraph(" "));
		        document.add(new Paragraph("Если у тебя уже есть опыт работы и/или выполненные учебные проекты, опиши их:", 
		                new Font(baseFont, 14, Font.BOLD)));
		        document.add(new Paragraph("Геометрическая прогрессия традиционно оправдывает эмпирический натуральный логарифм, таким образом сбылась мечта идиота - утверждение полностью доказано. Дифференциальное исчисление, конечно, осмысленно позиционирует нормальный критерий интегрируемости, что известно даже школьникам. Криволинейный интеграл масштабирует невероятный ротор векторного поля, что и требовалось доказать.:", 
		                new Font(baseFont, 12, Font.NORMAL)));
		        document.add(new Paragraph("Почему тебя обязательно надо взять в NetCracker (достоинства, обещания):", 
		                new Font(baseFont, 14, Font.BOLD)));
		        document.add(new Paragraph("Геометрическая прогрессия традиционно оправдывает эмпирический натуральный логарифм, таким образом сбылась мечта идиота - утверждение полностью доказано. Дифференциальное исчисление, конечно, осмысленно позиционирует нормальный критерий интегрируемости, что известно даже школьникам. Криволинейный интеграл масштабирует невероятный ротор векторного поля, что и требовалось доказать.:", 
		                new Font(baseFont, 12, Font.NORMAL)));
		        document.add(new Paragraph("Дополнительные сведения о себе: олимпиады, курсы, сертификаты, личные качества:", 
		                new Font(baseFont, 14, Font.BOLD)));
		        document.add(new Paragraph("Геометрическая прогрессия традиционно оправдывает эмпирический натуральный логарифм, таким образом сбылась мечта идиота - утверждение полностью доказано. Дифференциальное исчисление, конечно, осмысленно позиционирует нормальный критерий интегрируемости, что известно даже школьникам. Криволинейный интеграл масштабирует невероятный ротор векторного поля, что и требовалось доказать.:", 
		                new Font(baseFont, 12, Font.NORMAL))); 
		        document.add(new Paragraph("Я даю согласие на хранение, обработку и использование моих персональных данных с целью возможного обучения и трудоустройства в компании НЕТКРЕКЕР на данный момент и в будущем: ФИО, подпись _________________________", 
		                new Font(baseFont, 14, Font.BOLD)));
		        document.add(new Paragraph(" "));
		        document.add(new Paragraph("Интервьюер 1 _____________                                                   Интервьюер 2 _____________", 
		                new Font(baseFont, 14, Font.NORMAL)));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
}
