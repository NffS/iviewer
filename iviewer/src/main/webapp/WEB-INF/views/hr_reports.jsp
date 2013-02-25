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
<% List<String[]> forms=(ArrayList<String[]>)request.getAttribute("attendances");
List<Faculty> faculties=(List<Faculty>)request.getAttribute("faculties");
List<University> universities=(List<University>)request.getAttribute("universities");
Hashtable<String, Long> studentsInUniversitiesTable=(Hashtable<String, Long>)request.getAttribute("studentsInUniversitiesTable");
Hashtable<Integer, Long> studentsInFacultiesTable=(Hashtable<Integer, Long>)request.getAttribute("studentsInFacultiesTable");
int i=-1;
int cameCount=0;
int doesntCameCount=0;
if(forms!=null){%>
<table border=2 align="center">
	<tr align="center" bgcolor="64BFCD">
		<th  width=300>ФИО</th> <th width=100>Посещение</th>
	</tr>
	<c:forEach var="form" items ="${attendances }">
	<tr height=40 align="center">
		<td>${form[0]}  ${form[1]} ${form[2]}</td>	
		<td><%if(forms.get(i+1)[3].equals("1")){cameCount++; %>+<%}else{doesntCameCount++; %>-<%} %></td>
	</tr>
	</c:forEach>
</table>
<br><br>
&nbsp;&nbsp;Всего пришло: <%=cameCount %>.
<br><br>
&nbsp;&nbsp;Всего не пришло: <%=doesntCameCount %>.
<%}else if(studentsInUniversitiesTable!=null){%>
<font size="4">Студентов зрегистрировано</font><br><br>
<table border=2 align="center">
	<tr align="center" bgcolor="64BFCD">
		<th colspan="2"  width=300 >Университет/факультет</th><th width=30>Количество</th>
	</tr>
<%for(University university :universities){%>
<tr align="center" height=40>
	<td colspan=2 width=300><%=university.getUniversity_name() %></td> <td><%=studentsInUniversitiesTable.get(university.getUniversity_name()) %></td>
</tr>
	<%for(Faculty faculty :faculties){%>
		<%if(faculty.getUniversity_id().equals(university.getUniversity_id())){%>
		<tr align="center" height=40>
		<td width=75/><td><%=faculty.getFaculty_name() %></td> 
		<td><%=studentsInFacultiesTable.get(faculty.getFaculty_id())%></td>
		</tr>
		<%}
	}%>
<%} %> 
<%} %>
</table>
<%if(request.getAttribute("recordIncreaseForms")!=null){ %>
 <div id="chart_div" style="width: 600px; height: 500px;"></div>
<%} %>
<br><br><br><br>
<%@ include file="/resources/design/footer.jsp" %>
 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
   <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      <% List<String> recordIncreaseForms=(List<String>)request.getAttribute("recordIncreaseForms");
          if(recordIncreaseForms!=null){%>
      function drawChart() {
          var numberAtDates = google.visualization.arrayToDataTable([
          ['Месяц', 'Всего студентов'],
          <% String date;
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
                hAxis: {title: 'Дни',  titleTextStyle: {color: 'red'},
                	dataColumnType:'string'}
              };

 		var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(numberAtDates, options);
      }
    <%}%>
</script>
 