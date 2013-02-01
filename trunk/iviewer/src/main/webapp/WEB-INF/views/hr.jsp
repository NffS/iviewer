<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Личный кабинет</title>
<%@include file="/resources/design/header.jsp" %>
</head>
<body>

<li>текст левого блока</li>
<%@ include file="/resources/design/center.jsp" %>

Приветствуем, <%=session.getAttribute("first_name") %>.
<br><br><br>
<a href="form_list"><font size="5">Список всех анкет</font></a>
<br><br>
<a href=""><font size="5">Редактирование собеседований</font></a>
<br><br>
<a href=""><font size="5">Управление отчётами </font></a>
<br><br><br><br>
<a href="index" id="main">На главную</a>

<%@ include file="/resources/design/footer.jsp" %>
</body>
</html>
