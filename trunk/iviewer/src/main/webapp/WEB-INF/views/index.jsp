<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.01.13
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@page import="java.util.List, com.ncteam.iviewer.domain.*" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<%@include file="/resources/design/header.jsp" %>

<li>текст левого блока</li>

<%@ include file="/resources/design/center.jsp" %>

<%=request.getAttribute("newsText")%>

<%@ include file="/resources/design/footer.jsp" %>