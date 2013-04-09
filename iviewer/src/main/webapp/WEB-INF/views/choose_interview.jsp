<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="/resources/design/header.jsp" %>

<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>
Приветствуем, <%=session.getAttribute("first_name") %>. ${ThisIsMyInterview}
<br><br>
<h3>Выбери собеседования</h3>
<br>
			<table border=2 align="center" width="100%">
				<tr ALIGN=center bgcolor="1E90FF">
					<th>Дата</th> <th>Начало</th> <th>Конец</th> <th>Свободно мест</th>
				</tr>
				<c:forEach var="interview" items="${interviews}">
					<tr ALIGN=center height=40>
						<form action="choose">
							<td ALIGN=center>${interview.stringStartDate.split(" ")[0]}</td> 
							<td ALIGN=center>${interview.stringStartDate.split(" ")[1].substring(0,5)}</td>
							<td ALIGN=center>${interview.stringEndDate.split(" ")[1].substring(0,5)}</td>
							<td ALIGN=center>${interview.seats - interview.forms.size()}</td>				
						</form>
						<form action="choose_${interview.interviewId}">
							<td align="center" width=100><input type="submit" value="Выбрать"/></td>
						</form>
					</tr>
				</c:forEach>
			</table>
			

<br><br>
<%@ include file="/resources/design/footer.jsp" %>