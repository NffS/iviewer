<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@page import="com.ncteam.iviewer.domain.User, java.util.Enumeration" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Enumeration names = request.getParameterNames();
if (names.hasMoreElements()&&request.getParameter("loguot")!=null) {
	session.removeAttribute("user");%>
	
	<jsp:forward page="/index"/>
<%
}
%>
<%
String password="";
String email="";
if(request.getAttribute("usr")!=null){
session.setAttribute("user_id", ((User)request.getAttribute("usr")).getUser_id());
session.setAttribute("email", ((User)request.getAttribute("usr")).getEmail());
session.setAttribute("first_name", ((User)request.getAttribute("usr")).getFirst_name());
session.setAttribute("surname", ((User)request.getAttribute("usr")).getSurname());
session.setAttribute("foto", ((User)request.getAttribute("usr")).getFoto());
session.setAttribute("user_type_id", ((User)request.getAttribute("usr")).getUser_type_id());
if((Integer)session.getAttribute("user_type_id")==1){%>
 <jsp:forward page="admin.jsp"/>
	
<%}
else if((Integer)session.getAttribute("user_type_id")==2){%>
	<jsp:forward page="hr.jsp"/>
<%}
else if((Integer)session.getAttribute("user_type_id")==3){%>
<jsp:forward page="interview.jsp"/>
<%}
else if((Integer)session.getAttribute("user_type_id")==4){%>
<jsp:forward page="candidate.jsp"/>
<%}
}
else{
	password=(String)request.getAttribute("password");
	email=(String)request.getAttribute("email");
}
String message="";
if(request.getAttribute("message")!=null){
	 message=(String)request.getAttribute("message");
}
%>
<html>
<head>
<title>Login</title>
</head>
<body>
<form:form method="POST"  modelAttribute="user" action="loginCheck">
 <table>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email"/></td>
    </tr>
    <tr>
        <td><form:label path="password">Пароль</form:label></td>
        <td><form:password path="password" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Войти"/>
        </td>
    </tr>
 </table>  
</form:form>
<br>
<br>
<a href="index" id="main">На главную</a>
<br>
<br>
<font color="#FF0000" id="error" size="20px"><%=message %></font>
</body>
</html>