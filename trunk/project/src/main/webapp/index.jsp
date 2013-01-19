<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration, test.User, test.News, DAO.Factory, java.util.Locale, java.util.List,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main page</title>
</head>
<body>
<body>
<form name="testdb" action="TestDB" method="post">
<input type="submit" value="DB Test">
</form>
<a href="index.jsp">Главная</a> | 
<a href="index.jsp?news=1">О компании</a> | 
<a href="index.jsp?news=2">Контакты</a> 

<br>

<%


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

<input type="button" value="Вход" name="login" onclick="javascript:document.location='login.jsp'">

</body>
</html>