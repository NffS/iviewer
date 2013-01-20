<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.hibernate.Session, java.util.Enumeration, test.User, test.News, DAO.Factory, java.util.Locale, java.util.List,java.util.ArrayList" %>
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
<%if((Integer)session.getAttribute("user_type_id")==null){
	%>
<form name="input" action="login.jsp" method="post">
Email<input type="text" name="emailField" value="" size="50" id="email" /><br>
Пароль<input type="password" name="passwordField" value="" size="50" id="password" /><br>
<input type="submit" value="Войти" name="loginButton" name="Вход"/>
</form>
<%}else{String path="#";%>
Добро пожаловать <%=session.getAttribute("first_name")%><br>
<%if((Integer)session.getAttribute("user_type_id")==1){path="admin.jsp";}
  else if((Integer)session.getAttribute("user_type_id")==2){path="hr.jsp";}
  else if((Integer)session.getAttribute("user_type_id")==3){path="interview.jsp";}
  else if((Integer)session.getAttribute("user_type_id")==4){path="candidate.jsp";}
%>
<a href="<%=path%>">Личный кабинет</a>
<%} %>
<br><br>

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

<input type="button" value="Вход" name="login" onclick="javascript:document.location='login.jsp'">

</body>
</html>