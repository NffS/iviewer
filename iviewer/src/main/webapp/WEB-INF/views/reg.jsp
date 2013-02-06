<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@include file="/resources/design/header.jsp" %>

<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>
<form:form  method="POST" action="registration">
	<table>
		<tr>
			<td width=100><font size=5>Имя:</font></td>
   			 <td><input type=text style="height:30px" name="first_name"></td>
   		</tr>
   		<tr>
			<td width=100><font size=5>Фамилия:</font></td>
   			 <td><input type=text style="height:30px" name="surname"></td>
   		</tr>
   		<tr>
			<td width=100><font size=5>Отчество:</font></td>
   			 <td><input type=text style="height:30px" name="last_name"></td>
   		</tr>
   		<tr>
			
   		</tr>
		<tr>
			<td width=100><font size=5>E-mail:</font></td>
   			 <td><input type=text style="height:30px" name="email"/></td>
   		</tr>
    	<tr>
    		<td><font size=5>Пароль:</font></td>
    		<td><input type="password" style="height:30px" name="password" /></td>
		</tr>
		<tr>
		<br>
			<td colspan="2" align="center"><input type="submit" style="height:30px; width:100px; font-size: 15px" value="Регистрация"></td>
</table>
</form:form>
<br><br><br><br>
<font color="#FF0000" id="error" size="15px">${message }</font>

<%@ include file="/resources/design/footer.jsp" %>