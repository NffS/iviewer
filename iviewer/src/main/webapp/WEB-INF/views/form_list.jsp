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
</head>
<body>
<table>
	<tr>
		<td width=300/>
		<td align="center">
			<%int k=0; %>
			<table border=2 align="center">
				<tr ALIGN=center bgcolor="9999FF">
					<th>№</th> <th>ФИО</th> <th>Дата собеседования</th> <th>Статус</th> <th>Просмотр</th> <th>Экспорт</th>
				</tr>
				<c:forEach var="form" items="${forms}">
				<%k++; %>
				<tr ALIGN=center height=40>
				<td><%=k %></td> <td width=300>${form.user.surname}  ${form.user.first_name} ${form.user.last_name}</td>
				<td>${form.interview.stringStart_date}</td> <td>${form.status}</td> <td><a href="/form.jsp?form_id=${form.form_id}">Просмотр</a></td>
				<td></td>
				</tr>
				</c:forEach>
			</table>
		</td>
	<%List<String> interviewsDates=(List<String>)request.getAttribute("interviewsDates");%>
	<td width=300/>
		<td align="center">
			<form:form method="POST" modelAttribute="formListFilter" action="form_listFilter">
			<h1>Фильтр</h1>
				<table>
					<tr>
						<td><form:label path="lastName">Поиск по фамилии</form:label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><form:label path="interviewDate">Поиск по дате собеседования</form:label></td>
						<td>
						 <form:select path="interviewDate">
						 <form:option value=""/>
							<%for(int i=0; i<interviewsDates.size();i++){ %>
				 				<form:option value="<%=interviewsDates.get(i)%>"/>
							<%} %>
							</form:select>
						</td>
					</tr>
					<tr>
						<td><form:label path="requiredConfirmOnly">Только требующие подтверждения</form:label></td>
						<td>
							<form:checkbox path="requiredConfirmOnly"/>
						</td>
					</tr>
					<tr><td align ="center" colspan="2"><br><input type="submit" value="Выполнить фильтр"></td></tr>
				</table>
			</form:form>
		</td>
</tr>
</table>
</body>
</html>