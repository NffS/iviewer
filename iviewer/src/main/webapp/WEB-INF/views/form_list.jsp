<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ncteam.iviewer.domain.FormInformation, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/resources/design/header.jsp" %>
<%@include file="/resources/design/hr_left_part.jsp" %>
<%@ include file="/resources/design/center.jsp" %>
<table>
	<tr><td align="center" colspan="2"><font size=5>Фильтр</font></td></tr>
	<tr>
	<td align="right">
		<select id="interview" onchange="filter('sf')">
			<option value="-1">Поиск по собеседованию</option>
			<c:forEach var="interviewDate" items ="${interviewsDates }">
				<option value="${interviewDate.substring(0,16) }">${interviewDate.substring(0,16) }</option>
			</c:forEach>
		</select>
	</td>
	<td  align="right"><input placeholder="Поиск по фамилии" id="surname" type="text"  onkeyup="filter('sf')"></td>
	</tr>
	<tr>
		<td align ="center" >
			<select id ="university" onchange="filter('sf')">
				<option value="-1">Поиск по университету</option>
				<c:forEach var="university" items="${universities }">
				 	<option value="${university.universityName }">${university.universityName }</option>
				</c:forEach>
			</select>
		</td>
		<td colspan="2" width=300 align="right">
			Только требующие подтверждения&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" onchange="filter('sf')" name="stateOnly" id="stateOnly"/>
		</td>
	</tr>
</table>
<br>
<c:set var="k" scope="page" value="${0}"/>
<table id="sf" border=2 align="center">
	<tr ALIGN=center bgcolor="9999FF">
		<td>№</td> <td  width=300>ФИО</td> <td width=150>Дата собеседования</td> <td width=60>Требует подтверждения</td> <td width=85>Просмотр</td><td>Оценивание</td><td style="display:none;"></td>
	</tr>
	<c:forEach var="form" items="${forms}">
		<tr ALIGN=center height=40>
		<c:set var="k" scope="page" value="${k+1}"/>
			<td>${k }</td> <td>${form.surname}  ${form.firstName} ${form.lastName}</td>
			<td>${form.startDate}</td> 
			<td><c:choose>
					<c:when test="${form.status.intValue()==1}">Да</c:when><c:otherwise>Нет</c:otherwise>
				</c:choose></td> 
			<td><a href="/form.jsp?form_id=${form.formId}" target="_blank">Просмотр</a></td>
			<td><a href="hr_mark_${form.formId}">Оценить</a></td>
			<td style="display:none;">${form.universityName}</td>
		</tr>
	</c:forEach>
</table>

<br><br><br><br>
<%@ include file="/resources/design/footer.jsp" %>

<script type="text/javascript">

function filter(_id){
    var surname = document.getElementById("surname").value.toLowerCase().split(" ");
    var interview = document.getElementById("interview").value.toLowerCase().split(" ");
    var university = document.getElementById("university").value.toLowerCase().split(" ");
    var state = document.getElementById("stateOnly");
    var table = document.getElementById(_id);
    var ele;
    for (var r = 1; r < table.rows.length; r++){
       table.rows[r].style.display = '';
    }
     for (var r = 1; r < table.rows.length; r++){
     	var displayStyle = '';
     	if(university!="-1"){
    		ele = table.rows[r].cells[6].innerHTML.replace(/<[^>]+>/g,"");
    		for (var i = 0; i < university.length; i++) {
         	   if (ele.toLowerCase().indexOf(university[i])>=0)
        	        continue;
         	   else {
         	       displayStyle = 'none';
         	       break;
         	   }
       		 
    		}
     	}
    	if(interview!="-1"){
        	ele = table.rows[r].cells[2].innerHTML.replace(/<[^>]+>/g,"");
        	for (var i = 0; i < interview.length; i++) {
            	if (ele.toLowerCase().indexOf(interview[i])>=0)
                	continue;
            	else {
                	displayStyle = 'none';
                	break;
            	}
        	}
    	}
        ele = table.rows[r].cells[1].innerHTML.replace(/<[^>]+>/g,"");
        for (var i = 0; i < surname.length; i++) {
            if (ele.toLowerCase().indexOf(surname[i])>=0)
                continue;
            else {
                displayStyle = 'none';
                break;
            }
        }
		
        if(state.checked){
        	if(table.rows[r].cells[3]!="Нет")
        		displayStyle = 'none';
        }
        
        table.rows[r].style.display = displayStyle;
    }
}
</script>
