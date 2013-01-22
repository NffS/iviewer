<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.hibernate.Session, java.util.Enumeration, test.User, test.News, DAO.Factory, java.util.Locale, java.util.List,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ include file="design/header.jsp" %>

<form name="testdb" action="TestDB" method="post">
<input type="submit" value="DB Test">
</form>
<br>

<%

Locale.setDefault(Locale.ENGLISH);
String text="";
Enumeration params = request.getParameterNames();
try{
	
	Factory factory = Factory.getInstance();	
try {
if (params.hasMoreElements()) {
	if(request.getParameter("news").equals("1")){
		News news=factory.getNewsDAO().getNewsById(1);
		text=news.getText();
	}else if(request.getParameter("news").equals("2")){
		News news=factory.getNewsDAO().getNewsById(2);
		text=news.getText();
	}else{
		News news=factory.getNewsDAO().getNewsById(4);
		text=news.getText();
	}
	
}else {
	News news=factory.getNewsDAO().getNewsById(4);
	text=news.getText();
	
}
}
finally {}
}catch(Exception e){
	e.printStackTrace();
}
%>
<%=text %>
<br><br>
 <%@ include file="design/left.jsp" %>
 <li>текст левого блока</li>
 <%@ include file="design/footer.jsp" %>

