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
<c:set var="cameCount" scope="page" value="${0}"/>
<c:set var="doesntCameCount" scope="page" value="${0}"/>
<table border=2 align="center">
	<tr align="center" bgcolor="64BFCD">
		<th  width=300>ФИО</th> <th width=100>Посещение</th>
	</tr>
	<c:forEach var="form" items ="${attendances }">
	<tr height=40 align="center">
		<td>${form[0]}  ${form[1]} ${form[2]}</td>	
		<td><c:if test="${form[3]==1}"><c:set var="cameCount" value="${cameCount+1 }"/>+</c:if>
		<c:if test="${form[3]==0}"><c:set var="doesntCameCount" value="${doesntCameCount+1 }"/>-</c:if>
		</td>
	</tr>
	</c:forEach>
</table>
<br><br>
&nbsp;&nbsp;Всего пришло: ${cameCount}.
<br><br>
&nbsp;&nbsp;Всего не пришло: ${doesntCameCount}.
<br><br><br><br>
<%@ include file="/resources/design/footer.jsp" %>