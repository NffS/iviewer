<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@page import="java.util.List, com.ncteam.iviewer.domain.*" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title>User test</title>
</head>
<body>
Initializing test.
<br>
<br>
<form name="login" action="login" method="GET">
<input type="submit" value="login">
</form>
<%
if(request.getAttribute("userList")!=null){
	List<User> users=(List<User>)request.getAttribute("userList");%>
	<h1>==========All users==========</h1>
	<table class="data">
	<%for(int i=0; i<users.size();i++){%>
	<tr>
		<td><%=users.get(i).getLast_name() %> <%=users.get(i).getFirst_name() %></td>
		<td><%=users.get(i).getEmail()%></td>
	</tr>
<%	}%>
</table>
<%}%>
<br>
<br>
<br>
<%
if(request.getAttribute("formList")!=null){
	List<Form> forms=(List<Form>)request.getAttribute("formList");%>
	<h1>==========All forms==========</h1>
	<table class="data">
	<%for(int i=0; i<forms.size();i++){%>
	<tr>
		<td><%=i+1%>. Идентификатор абитуриента: <%=forms.get(i).getCandidate_id() %>.</td>
		<td> <%=forms.get(i).getUniversity()%>.</td><td> <%=forms.get(i).getFaculty()%>.</td>
	</tr>
<%	}%>
</table>
<%}
%>
<br>
<br>
<br>
<%
if(request.getAttribute("HR_markList")!=null){
	List<HR_mark> HR_marks=(List<HR_mark>)request.getAttribute("HR_markList");%>
	<h1>==========All HR marks==========</h1>
	<table class="data">
	<%for(int i=0; i<HR_marks.size();i++){%>
	<tr>
		<td>ID:<%=HR_marks.get(i).getHR_mark_id() %>. </td><td>Form id: <%=HR_marks.get(i).getForm_id() %>. </td>
		<td>HR id: <%=HR_marks.get(i).getHr_id()%>. </td>
		<td>Marks: <%=HR_marks.get(i).getEnglish()%>, <%=HR_marks.get(i).getMotivation()%>, <%=HR_marks.get(i).getGeneral_mark()%>. </td>
	</tr>
<%	}%>
</table>
<%}
%>
<br>
<br>
<br>
<%
if(request.getAttribute("interviewList")!=null){
	List<Interview> interviews=(List<Interview>)request.getAttribute("interviewList");%>
	<h1>==========All interviews==========</h1>
	<table class="data">
	<%for(int i=0; i<interviews.size();i++){%>
	<tr>
		<td>ID:<%=interviews.get(i).getInterview_id() %>. </td><td>Start:<%=interviews.get(i).getStart_date()%>. </td>
		<td>End: <%=interviews.get(i).getEnd_date()%>.</td>
	</tr>
<%	}%>
</table>
<%}
%>
<br>
<br>
<br>
<%
if(request.getAttribute("users_typeList")!=null){
	List<Users_type> users_types=(List<Users_type>)request.getAttribute("users_typeList");%>
	<h1>==========All user types==========</h1>
	<table class="data">
	<%for(int i=0; i<users_types.size();i++){%>
	<tr>
		<td>ID:<%=users_types.get(i).getUser_type_id() %>. </td><td>Name: <%=users_types.get(i).getType_name() %>. </td>
	</tr>
<%	}%>
</table>
<%}
%>
</body>
</html>