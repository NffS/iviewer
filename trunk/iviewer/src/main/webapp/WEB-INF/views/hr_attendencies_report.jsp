<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ncteam.iviewer.domain.Form, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Управление отчётами</title>
</head>
<body>
<%@include file="/resources/design/header.jsp" %>
<%@include file="/resources/design/hr_left_part.jsp" %>
<%@ include file="/resources/design/center.jsp" %>
<%@include file="/resources/design/hr_reports_references.jsp" %>
<% List<String[]> forms=(ArrayList<String[]>)request.getAttribute("attendances");
int i=-1;
int cameCount=0;
int doesntCameCount=0;%>
<table border=2 align="center">
	<tr align="center" bgcolor="64BFCD">
		<th  width=300>ФИО</th> <th width=100>Посещение</th>
	</tr>
	<c:forEach var="form" items ="${attendances }">
	<tr height=40 align="center">
		<td>${form[0]}  ${form[1]} ${form[2]}</td>	
		<td><%if(forms.get(i+1)[3].equals("1")){cameCount++; %>+<%}else{doesntCameCount++; %>-<%} %></td>
	</tr>
	</c:forEach>
</table>
<br><br>
&nbsp;&nbsp;Всего пришло: <%=cameCount %>.
<br><br>
&nbsp;&nbsp;Всего не пришло: <%=doesntCameCount %>.
<br><br><br><br>
<%@ include file="/resources/design/footer.jsp" %>