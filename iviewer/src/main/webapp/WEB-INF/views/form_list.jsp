<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ page import="com.ncteam.iviewer.domain.Interview, java.util.List, com.ncteam.iviewer.domain.Form"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Список форм</title>
<%@include file="/resources/design/header.jsp" %>
</head>
<body>
<style>
   a { 
    text-decoration: none;
   } 
</style>
<a href="hr"><font size="3" color="000000">Просмотр собеседований</font></a>
<br><br>
<a href=""><font size="3" color="000000">Управление отчётами </font></a>
<br><br>
<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>
<table>
	<tr>
	<td align="center">
			<form:form method="POST" modelAttribute="formListFilter" action="form_listFilter">
			<font size=5>Фильтр</font>
			<br><br>
				<table>
					<tr>
						<td align="right">
						 <form:select class="input-large" path="interviewDate">
						 <form:option value="Поиск по собеседованию"/>
							<c:forEach var="interviewDate" items ="${interviewsDates }">
				 				<form:option value="${interviewDate.substring(0,16) }"/>
							</c:forEach>
							</form:select>
						</td>
						<td align="right"><form:input placeholder="Поиск по фамилии" path="lastName"/></td>
					</tr>
					<tr>
						<td align ="center" >
						<form:select path="university" class="input-large">
						 <form:option value="Поиск по университету"/>
							<c:forEach var="university" items="${universities }">
				 				<form:option value="${university }"/>
							</c:forEach>
							</form:select>
						</td>
						<td colspan="2" width=300 align="right">
						Только требующие подтверждения&nbsp;&nbsp;&nbsp;&nbsp;
						<form:checkbox path="requiredConfirmOnly"/>
						</td>
					</tr>
					<tr><td align ="center" colspan="2"><br><input type="submit" value="Выполнить фильтр"></td></tr>
				</table>
			</form:form>
		</td>
	</tr>
</table>
<table>
	<tr>
		<td align="center">
			<%int k=0; %>
			<table border=2 align="center">
				<tr ALIGN=center bgcolor="9999FF">
					<th>№</th> <th  width=300>ФИО</th> <th width=150>Дата собеседования</th> <th width=60>Статус</th> <th width=85>Просмотр</th> <th width=80>Экспорт</th>
				</tr>
				<c:forEach var="form" items="${forms}">
				<%k++; %>
				<tr ALIGN=center height=40>
				<td><%=k %></td> <td>${form.user.surname}  ${form.user.first_name} ${form.user.last_name}</td>
				<td>${form.interview.stringStart_date}</td> <td>${form.status}</td> <td><a href="/form.jsp?form_id=${form.form_id}">Просмотр</a></td>
				<td></td>
				</tr>
				</c:forEach>
			</table>
		</td>
</tr>
</table>
<%@ include file="/resources/design/footer.jsp" %>
</body>
</html>