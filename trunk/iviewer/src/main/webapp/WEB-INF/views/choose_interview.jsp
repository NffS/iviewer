<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@include file="/resources/design/header.jsp" %>

<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>
Приветствуем, <%=session.getAttribute("first_name") %>.
<br><br><br>
<h1>Доступные собеседования</h1>
<br>
<%int k=0; %>
			<table border=2 align="center">
				<tr ALIGN=center bgcolor="FFFF66">
					<th>№</th> <th>Дата</th> <th>Начало</th> <th>Конец</th> <th>Количество мест</th> <th>Количество участников</th> <th> </th>
				</tr>
				<c:forEach var="interview" items="${interviews}">
				<%k++; %>
				<tr ALIGN=center height=40>
				<form action="choose">
				<td><%=k %></td> 
				<td width="50px">${interview.stringStart_date.split(" ")[0]}</td> 
				<td >${interview.stringStart_date.split(" ")[1].substring(0,5)}</td>
				<td>${interview.stringEnd_date.split(" ")[1].substring(0,5)}</td>
				<td>${interview.seats}</td>
				<td width=100>${interview.forms.size()}</td> <td><input type="submit" value="Выбрать"/></td>
				</tr>
				</c:forEach>
			</table>

<br><br>
<%@ include file="/resources/design/footer.jsp" %>