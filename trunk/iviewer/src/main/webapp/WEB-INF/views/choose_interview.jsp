<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="/resources/design/header.jsp" %>

<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>
Приветствуем, <%=session.getAttribute("first_name") %>.
<br><br><br>
<h1>Доступные собеседования</h1>
<br>
			<table border=2 align="center">
				<tr ALIGN=center bgcolor="FFFF66">
					<th>Дата</th> <th>Начало</th> <th>Конец</th> <th>Доп. время (мин.)</th> <th>Количество мест</th> <th>Количество участников</th> <th>Редактирование</th><th>Удаление</th>
				</tr>
				<c:forEach var="interview" items="${interviews}">
				<tr ALIGN=center height=40>
				<form action="hr_red_${interview.interviewId}">
				<td width="50px"><input class="input-small" name="date" type="text" style="text-align:center" pattern="201[3-9]-([0][1-9]|[1][0-2])-([0-2][0-9]|[3][0-1])" value="${interview.stringStartDate.split(" ")[0]}"/></td> 
				<td ><input class="input-mini" name="startTime" type="text" style="text-align:center" pattern="([0-1][0-9]|2[0-4]):[0-5][0-9]" value="${interview.stringStartDate.split(" ")[1].substring(0,5)}"/></td>
				<td><input class="input-mini" name="endTime" type="text" style="text-align:center" pattern="([0-1][0-9]|2[0-4]):[0-5][0-9]" value="${interview.stringEndDate.split(" ")[1].substring(0,5)}"/></td>
				<td><input class="input-mini" name="extraTime" type="text" style="text-align:center" pattern="[0-9]+" value="${interview.extraTime }"/></td>
				<td><input class="input-mini" name="seats" type="text" style="text-align:center" pattern="[0-9]+" value="${interview.seats }"/></td>
				<td width=100>${interview.forms.size()}</td> <td><input type="submit" value="Сохранить изменения"/></td>
				</form>
				<form action="hr_delete_interview_${interview.interviewId}">
				<td align="center" width=100><input type="submit" value="Удалить"/></td>
				</form>
				</tr>
				</c:forEach>
			</table>
			<br>
			<br>
			<h1>Создать новое собеседование</h1>
			<br>
			<table border=2 align="center">
				<tr ALIGN=center bgcolor="FFFF66">
					<th>Дата</th> <th>Начало</th> <th>Конец</th> <th width=100>Доп. время (мин.)</th> <th width=150>Количество мест</th> <th width=80>Создание</th>
				</tr>
				<form action="hr_create_interview">
				<tr ALIGN=center>
				<td width="50px"><input class="input-small" id="createDate" name="newDate" type="text" style="text-align:center" pattern="(201[3-9]-([0][1-9]|[1][0-2])-([0-2][0-9]|[3][0-1])|)" /></td> 
				<td width=100><input class="input-mini" name="newStartTime" id="createStart" type="text" style="text-align:center" pattern="(([0-1][0-9]|2[0-4]):[0-5][0-9]|)" /></td>
				<td width=100><input class="input-mini" name="newEndTime" id="createEnd" type="text" style="text-align:center" pattern="(([0-1][0-9]|2[0-4]):[0-5][0-9]|)"/></td>
				<td><input class="input-mini" name="newExtraTime" type="text" value="0" style="text-align:center" pattern="[0-9]+"/></td>
				<td><input class="input-mini" name="newSeats" type="text" value="0" style="text-align:center" pattern="[0-9]+"/></td>
				<td align="center"><input type="submit" value="Создать"/></td>
				</tr>
				</form>
			</table>

<br><br>
<%@ include file="/resources/design/footer.jsp" %>