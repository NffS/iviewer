<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<a href="form"><font size="3" color="000000">Заполнить анкету</font></a>
<br><br>
<a href="choose"><font size="3" color="000000">Выбрать собеседование</font></a>
<br><br>
<a href="candidate_options"><font size="3" color="000000">Настройки кандидата</font></a>
<br><br>
<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>

Приветствуем, <%=session.getAttribute("first_name") %>.
<br><br>
<%@ include file="/resources/design/footer.jsp" %>
</body>
</html>