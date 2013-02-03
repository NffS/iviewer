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
<form:form  method="POST" commandName="userProfile" modelAttribute="user" action="loginCheck">
	<table>
		<tr>
			<td width=100><font size=5>E-mail:</font></td>
   			 <td><form:input style="height:30px" path="email"/></td>
   		</tr>
    	<tr>
    		<td><font size=5>Пароль:</font></td>
    		<td><form:password style="height:30px" path="password" /></td>
		</tr>
		<tr>
		<br>
			<td colspan="2" align="center"><input type="submit" style="height:30px; width:100px; font-size: 15px" value="Войти"></td>
</table>
</form:form>
<br><br><br><br>
<font color="#FF0000" id="error" size="15px">${message }</font>

<%@ include file="/resources/design/footer.jsp" %>