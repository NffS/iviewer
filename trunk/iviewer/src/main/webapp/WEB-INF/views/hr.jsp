<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Личный кабинет</title>
<%@include file="/resources/design/header.jsp" %>
</head>
<body>
 <style>
   a { 
    text-decoration: none;
   } 
  </style>

<a href="form_list"><font size="3" color="000000">Просмотр анкет</font></a>
<br><br>
<a href=""><font size="3" color="000000">Управление отчётами </font></a>
<br><br>
<a href="index"><font size="3" color="000000">На главную</font></a>

<%@ include file="/resources/design/center.jsp" %>

Приветствуем, <%=session.getAttribute("first_name") %>.
<br><br><br>
<h1>Доступные собеседования</h1>
<br>
<%int k=0; %>
			<table border=2 align="center">
				<tr ALIGN=center bgcolor="FFFF66">
					<th>№</th> <th>Дата</th> <th>Начало</th> <th>Конец</th> <th>Количество участников</th> <th>Редактирование</th><th>Удаление</th>
				</tr>
				<c:forEach var="interview" items="${interviews}">
				<%k++; %>
				<tr ALIGN=center height=40>
				<form action="hr_red_${interview.interview_id}">
				<td><%=k %></td> <td width="50px"><input class="input-small" name="date" type="text" style="text-align:center" pattern="201[3-9]-([0][1-9]|[1][0-2])-([0-2][0-9]|[3][0-1])" value="${interview.stringStart_date.split(" ")[0]}"/></td> 
				<td width=100 ><input class="input-small" name="startTime" type="text" style="text-align:center" pattern="([0-1][0-9]|2[0-4]):[0-5][0-9]" value="${interview.stringStart_date.split(" ")[1].substring(0,5)}"/></td>
				<td width=100><input class="input-small" name="endTime" type="text" style="text-align:center" pattern="([0-1][0-9]|2[0-4]):[0-5][0-9]" value="${interview.stringEnd_date.split(" ")[1].substring(0,5)}"/></td>
				<td width=100>${interview.forms.size()}</td> <td><input type="submit" value="Сохранить изменения"/></td>
				</form>
				<form action="hr_delete_interview_${interview.interview_id}">
				<td align="center" width=100><input type="submit" value="Удалить"/></td>
				</form>
				</tr>
				</c:forEach>
				<form action="hr_create_interview">
				<tr>
				<td></td> <td width="50px"><input class="input-small" name="date" type="text" style="text-align:center" pattern="(201[3-9]-([0][1-9]|[1][0-2])-([0-2][0-9]|[3][0-1])|)" /></td> 
				<td width=100><input class="input-small" name="startTime" type="text" style="text-align:center" pattern="(([0-1][0-9]|2[0-4]):[0-5][0-9]|)" /></td>
				<td width=100><input class="input-small" name="endTime" type="text" style="text-align:center" pattern="(([0-1][0-9]|2[0-4]):[0-5][0-9]|)"/></td>
				<td width=50 style="text-align:center">-</td> <td align="center"><input type="submit" value="Создать"/></td>
				</tr>
				</form>
			</table>

<br><br><br><br>
<%@ include file="/resources/design/footer.jsp" %>
</body>
</html>
