<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="test.User, DAO.Factory, java.util.Locale, java.util.List,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main page</title>
</head>
<body>
<body>
<form name="testdb" action="TestDB" method="post">
<input type="submit" value="See testing of DB tables">
</form>
<br> 
<input type="submit" value="Вход" name="login" onclick="javascript:document.location='login.jsp'">
</form>
</body>
</html>