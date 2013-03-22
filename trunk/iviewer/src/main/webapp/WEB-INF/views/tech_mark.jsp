<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@include file="/resources/design/header.jsp" %>
<%@include file="/resources/design/tech_left_part.jsp" %>
<%@ include file="/resources/design/center.jsp" %>

<h1>IT оценка</h1>
<br><br>
<h3>${form.user.surname}  ${form.user.firstName} ${form.user.lastName}</h3>
<br>
<br>
<form name="tech_mark" action="tech_mark_save" method="post">
	<table width="100%">
		<tr><td><label for="prog_lang"><font size=4>Языки программирования  (0-100) </font></label></td>
			<td><input pattern="^(100|0{0,}\d{1,2})$" class="input-mini" type="text" maxlength="3" id="prog_lang" name="prog_lang" value="${form.techMark.progLang}"></td>
		</tr>
		<tr><td><label for="oop"><font size=4>ООП  (0-100) </font></label></td>
			<td><input pattern="^(100|0{0,}\d{1,2})$" class="input-mini" type="text" maxlength="3" id="oop" name="oop" value="${form.techMark.oop }"></td>
		</tr>
		<tr><td><label for="patterns"><font size=4>Паттерны  (0-100) </font></label></td>
			<td><input pattern="^(100|0{0,}\d{1,2})$" class="input-mini" type="text" maxlength="3" id="patterns" name="patterns" value="${form.techMark.patterns }"></td>
		</tr>
		<tr><td><label for="db"><font size=4>БД  (0-100) </font></label></td>
			<td><input pattern="^(100|0{0,}\d{1,2})$" class="input-mini" type="text" maxlength="3" id="db" name="db" value="${form.techMark.db }"></td>
		</tr>
		<tr><td><label for="cs"><font size=4>Компьютерные науки (0-100) </font></label></td>
			<td><input pattern="^(100|0{0,}\d{1,2})$" class="input-mini" type="text" maxlength="3" id="cs" name="cs" value="${form.techMark.cs }"></td>
		</tr>
		<tr><td><label for="experience"><font size=4>Опыт  (0-100) </font></label></td>
			<td><input pattern="^(100|0{0,}\d{1,2})$" class="input-mini" type="text" maxlength="3" id="experience" name="experience" value="${form.techMark.experience }"></td>
		</tr>
		<tr><td><label for="other"><font size=4>Другое  (0-100) </font></label></td>
			<td><input pattern="^(100|0{0,}\d{1,2})$" class="input-mini" type="text" maxlength="3" id="other" name="other" value="${form.techMark.other }"></td>
		</tr>
	</table>
 	<br>
 	<label for="general"><font size=4>Общий отзыв</font></label>
    <textarea class="input-block-level" name="general" id="general" rows="10">${form.techMark.generalMark }</textarea>
    <br>
    <button type="submit" class="btn btn-primary">Сохранить оценку</button>
    <input type="hidden" name="form_id" value="${form.formId }">
    <input type="hidden" name="tech_mark_id" value="${form.techMark.techMarkId}">
</form>

<%@ include file="/resources/design/footer.jsp" %>