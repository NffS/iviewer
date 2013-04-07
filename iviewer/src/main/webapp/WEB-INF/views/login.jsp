<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02.02.13
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@include file="/resources/design/header.jsp" %>

<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>
<form  method="POST" action="loginCheck">
	<table>
		<tr>
			<td width=100><font size=5>E-mail:</font></td>
   			 <td><input class="input-large" type="text" style="height:30px" name="email" pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$" value="${email}"/></td><td><font color="#FF0000" >&nbsp;&nbsp;${emailMessage }</font> </td>
   		</tr>
    	<tr>
    		<td><font size=5>Пароль:</font></td>
    		<td><input class="input-large" type="password" style="height:30px" name="password" pattern="[A-Za-z0-9]+"/></td><td><font color="#FF0000" >&nbsp;&nbsp;${passwordMessage }</font></td>
		</tr>
		<tr>
		<br>
			<td colspan="2" align="center"><input type="submit" style="height:30px; width:100px; font-size: 15px" value="Войти"></td>
</table>
</form>
<br><br><br><br>
<%@ include file="/resources/design/footer.jsp" %>