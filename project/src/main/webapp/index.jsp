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
<form name="input" action="TestDB" method="post">
<input type="submit" value="See testing of DB tables">
<br>
<%--Приимер обращения к БД из JSP--%>
<br>=============All users========== 
<br>
<%
Locale.setDefault(Locale.ENGLISH);
List<User> usrs = Factory.getInstance().getUserDAO().getAllUsers();
List<String> strs=new ArrayList<String>();
for(int i = 0; i < usrs.size(); i++) {
	out.println("<br>"+i+". "+usrs.get(i).getFirst_name()+" "+usrs.get(i).getLast_name()+" "+usrs.get(i).getSurname()
		+", "+usrs.get(i).getEmail());
}
%>
</form>
</body>
</html>