<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List, java.util.ArrayList, java.util.Hashtable, 
	com.ncteam.iviewer.domain.Faculty, com.ncteam.iviewer.domain.University"%>
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
<c:set var="k" scope="page" value="${0}"/>
<c:forEach var="university" items="${universities }">
	<c:set var="k" value="${k+studentsInUniversitiesTable.get(university.universityName)}"/>
</c:forEach>
<font size="4">Студентов зрегистрировано: ${k }</font>
<br><br>
<table border=2 align="center">
	<tr align="center" bgcolor="64BFCD">
		<th colspan="2"  width=300 >Университет/факультет</th><th width=30>Количество</th>
	</tr>
<c:forEach var="university" items="${universities}">
<tr align="center" height=40>
	<td colspan=2 width=300>${university.universityName }</td> <td>${studentsInUniversitiesTable.get(university.getUniversityName())}</td>
</tr>
	<c:forEach var="faculty" items="${faculties}">
		<c:if test="${faculty.universityId.equals(university.universityId) }">
		<tr align="center" height=40>
		<td width=75/><td>${faculty.facultyName}</td> 
		<td>${studentsInFacultiesTable.get(faculty.facultyId)}</td>
		</tr>
		</c:if>
	</c:forEach>
</c:forEach>
</table>
<br><br><br><br>
<%@ include file="/resources/design/footer.jsp" %>