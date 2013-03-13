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

 <div id="chart_div" style="width: 700px; height: 800px;"></div>
 <%@ include file="/resources/design/footer.jsp" %>
 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
   <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      <% List<String> recordIncreaseForms=(List<String>)request.getAttribute("recordIncreaseForms");%>
      function drawChart() {
          var numberAtDates = google.visualization.arrayToDataTable([
          ['Месяц', 'Всего студентов'],
          <% String date;
          int i;
          int studentsCount=0;
          for(i=4; i<5;i++)
          for(int j=1; (j<31&&i==3)||(j<7&&i==4); j++){ 
        	  if(j<10){
          		date="2013-0"+i+"-0"+j;
        	  }
          	else{
          		date="2013-0"+i+"-"+j;
          		}%>
          ['<%=date%>',
          <%for(String record:recordIncreaseForms){
          		if(date.equals(record)) studentsCount++; 
          	}%>
          <%=studentsCount %>]
          <%if((j<31&&i==3)||(j<6&&i==4)){%>,<%}}%>
        ]);
        
        var options = {
                title: 'График увеличения записи студентов',
                hAxis: {title: 'Дни',  titleTextStyle: {color: 'red'}},
                vAxis: {format:'#', maxValue:10}
              };

 		var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(numberAtDates, options);
      }
</script>