<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HR оценка</title>
</head>
<%@include file="/resources/design/header.jsp" %>
<%@include file="/resources/design/hr_left_part.jsp" %>
<%@ include file="/resources/design/center.jsp" %>

<h1>HR оценка</h1>
<br><br>
<h3>${form.user.surname}  ${form.user.firstName} ${form.user.lastName}</h3>
<br>
<br>
<form action="hr_mark_save">
	<label><font size=4>Мотивация  (0-100) </font><input class="input-mini" type="text" name="motivation" value="${form.hrMark.motivation }"></label>
 	<label><font size=4>Английский (0-100) </font><input class="input-mini" type="text" name="english" value="${form.hrMark.english }"></label>
 	<br>
 	<label for="general"><font size=4>Общий отзыв</font></label>
    <textarea class="input-block-level" name="general" id="general" rows="10">${form.hrMark.generalMark }</textarea>
    <br>
    <button type="submit" class="btn btn-primary" >Сохранить оценку</button>
    <input type="hidden" name="form_id" value="${form.formId }">
    <input type="hidden" name="hr_mark_id" value="${form.hrMark.hrMarkId}">
</form>

<%@ include file="/resources/design/footer.jsp" %>