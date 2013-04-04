<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@include file="/resources/design/header.jsp" %>

<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>
<form  method="POST" action="edit_this_candidate">
	<table>
		<tr>
   			 <td><input name="data" type="file"><br></td>
   		</tr>
		<tr>
			<td width=110><font size=5>Имя:</font></td>
   			 <td><input class="input-large" type="text" style="height:30px" name="firstname"  value="${firstname}"/></td><td><font color="#FF0000" >&nbsp;&nbsp;${firstnameMessage }</font> </td>
   		</tr>
   		<tr>
			<td width=110><font size=5>Фамилия:</font></td>
   			 <td><input class="input-large" type="text" style="height:30px" name="surname"  value="${surname}"/></td><td><font color="#FF0000" >&nbsp;&nbsp;${surnameMessage }</font> </td>
   		</tr>
   		<tr>
			<td width=110><font size=5>Отчество:</font></td>
   			 <td><input class="input-large" type="text" style="height:30px" name="lastname"  value="${lastname}"/></td><td><font color="#FF0000" >&nbsp;&nbsp;${lastnameMessage}</font> </td>
   		</tr>
		<tr>
			<td width=110><font size=5>E-mail:</font></td>
   			 <td><input class="input-large" type="text" style="height:30px" name="email"  value="${email}"/></td><td><font color="#FF0000" >&nbsp;&nbsp;${emailMessage }</font> </td>
   		</tr>
    	<tr>
    		<td width=110><font size=5>Пароль:</font></td>
    		<td><input class="input-large" type="password" style="height:30px" name="password" "/></td><td><font color="#FF0000" >&nbsp;&nbsp;${passwordMessage }</font></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" style="height:30px; width:100px; font-size: 15px" value="Регистрация"></td>
</table>
</form>
<br><br><br><br>
<font color="#FF0000" id="error" size="12px">${message}</font>

<%@ include file="/resources/design/footer.jsp" %>