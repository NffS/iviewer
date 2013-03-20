<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ncteam.iviewer.domain.FormInformation, java.util.List"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
List<FormInformation> forms=(List<FormInformation>)request.getAttribute("forms");
%>
<%@include file="/resources/design/header.jsp" %>
<%@include file="/resources/design/tech_left_part.jsp" %>
<%@ include file="/resources/design/center.jsp" %>
Приветствуем, <%=session.getAttribute("first_name") %>.
<br>
<h1>Список анкет</h1>
<table>
	<tr><td align="center" colspan="2"><font size=5>Фильтр</font></td></tr>
	<tr>
	<td align="right">
		<select id="interview" onchange="filter('sf')">
			<option value="-1">Поиск по собеседованию</option>
			<c:forEach var="interviewDate" items ="${interviewsDates }">
				<option value="${interviewDate.substring(0,16) }">${interviewDate.substring(0,16) }</option>
			</c:forEach>
		</select>
	</td>
	<td  align="right"><input placeholder="Поиск по фамилии" id="surname" type="text"  onkeyup="filter('sf')"></td>
	</tr>
	<tr>
		<td align ="center" >
			<select id ="university" onchange="filter('sf')">
				<option value="-1">Поиск по университету</option>
				<c:forEach var="university" items="${universities }">
				 	<option value="${university.universityName }">${university.universityName }</option>
				</c:forEach>
			</select>
		</td>
		<td colspan="2" width=300 align="right">
			Только требующие подтверждения&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" onchange="filter('sf')" name="stateOnly" id="stateOnly"/>
		</td>
	</tr>
</table>
<br>
<%int k=0; %>
<table id="sf" border=2 align="center">
	<tr ALIGN=center bgcolor="9999FF">
		<td>№</td> <td  width=300>ФИО</td> <td width=150>Дата собеседования</td><td>Оценивание</td><td style="display:none;"></td>
	</tr>
	<c:forEach var="form" items="${forms}">
	<%k++; %>
		<tr ALIGN=center height=40>
			<td><%=k %></td> <td>${form.surname}  ${form.firstName} ${form.lastName}</td>
			<td>${form.startDate}</td>
			<td><a href="tech_mark_${form.formId}">Оценить</a></td>
			<td style="display:none;">${form.universityName}</td>
		</tr>
	</c:forEach>
</table>

<font color="#FF0000">${erroMessage }</font>
<br><br>
<%@ include file="/resources/design/footer.jsp" %>
