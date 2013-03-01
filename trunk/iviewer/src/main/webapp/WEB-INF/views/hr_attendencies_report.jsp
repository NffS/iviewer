<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ncteam.iviewer.domain.Form, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HR reports page</title>
</head>
<body>
<%@include file="/resources/design/header.jsp" %>
<style>
   a { 
    text-decoration: none;
   } 
</style>
<a href="hr"><font size="3" color="000000">Просмотр собеседований</font></a>
<br><br>
<a href="form_list"><font size="3" color="000000">Просмотр анкет</font></a>
<br><br>
<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>

<a href="attendance_report"><font size="5" color="#0000FF">Отчёт посещаемости собеседований</font></a>
<br><br>
<a href="universities_report"><font size="5" color="#0000FF">Отчёт по институтам, факультетам</font></a>
<br><br>
<a href="records_increase_report"><font size="5" color="#0000FF">График увеличения записи студентов</font></a>
<br><br>
<a href="graphic_forms_report"><font size="5" color="#0000FF">Графический общий отчёт по анкетам</font></a>
<br><br>
<a href="graphic_pr_report"><font size="5" color="#0000FF">Графический отчёт эффективности видов рекламы</font></a>

<br><br>
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