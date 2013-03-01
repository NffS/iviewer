<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ncteam.iviewer.domain.Form, java.util.List, java.util.ArrayList,
	java.util.Hashtable, com.ncteam.iviewer.domain.Faculty, com.ncteam.iviewer.domain.University"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HR reports page</title>
</head>
<body>
<%@include file="/resources/design/header.jsp" %>
<style>
   a { 
    text-decoration: none;
   } 
</style>
<a href="hr"><font size="3" color="000000">Просмотр собеседований</font></a>
<br><br>
<a href="form_list"><font size="3" color="000000">Просмотр анкет</font></a>
<br><br>
<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>

<a href="attendance_report"><font size="5" color="#0000FF">Отчёт посещаемости собеседований</font></a>
<br><br>
<a href="universities_report"><font size="5" color="#0000FF">Отчёт по институтам, факультетам</font></a>
<br><br>
<a href="records_increase_report"><font size="5" color="#0000FF">График увеличения записи студентов</font></a>
<br><br>
<a href="graphic_forms_report"><font size="5" color="#0000FF">Графический общий отчёт по анкетам</font></a>
<br><br>
<a href="graphic_pr_report"><font size="5" color="#0000FF">Графический отчёт эффективности видов рекламы</font></a>
<br><br>

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
