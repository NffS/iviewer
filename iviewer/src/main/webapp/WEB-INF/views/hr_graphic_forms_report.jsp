<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ncteam.iviewer.domain.Form, java.util.List, java.util.ArrayList,
	java.util.Hashtable, com.ncteam.iviewer.domain.Faculty, com.ncteam.iviewer.domain.University"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Управление отчётами</title>
</head>
<body>
<%@include file="/resources/design/header.jsp" %>
<%@include file="/resources/design/hr_left_part.jsp" %>
<%@ include file="/resources/design/center.jsp" %>
<%@include file="/resources/design/hr_reports_references.jsp" %>

 <div id="chart_div" style="width: 600px; height: 500px;"></div>
 
<br><br><br><br>
<%@ include file="/resources/design/footer.jsp" %>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
<%byte[] cameDoesntCameStudents=(byte[])request.getAttribute("cameDoesntCameStudents");%>
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Вид', 'Количество'],
          ['Запланировано',  20],
          ['Зарегистрировано',  <%=cameDoesntCameStudents[0]+cameDoesntCameStudents[1]%>],
          ['Пришло',  <%=cameDoesntCameStudents[1]%>],
          ['Не пришло',  <%=cameDoesntCameStudents[0]%>]
        ]);

        var options = {
          title: 'Графический общий отчёт по анкетам',
          hAxis: {title: 'Вид', titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
</script>
