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

<li>Текст левого блока</li>
<%@ include file="/resources/design/center.jsp" %>
<form:form  method="POST" commandName="userProfile" modelAttribute="user" action="loginCheck">

    E-mail<form:input path="email"/>   <br>
    Пароль:<form:password path="password"  /><br>


        <input type="submit" value="Войти"><br>

</form:form>

<%@ include file="/resources/design/footer.jsp" %>