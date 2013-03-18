<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02.02.13
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ncteam.iviewer.domain.User"%>

<%@include file="/resources/design/header.jsp" %>

<%if(((Integer)session.getAttribute("user_type_id")).equals(new Integer(2))){ %>
<%@include file="/resources/design/hr_left_part.jsp" %>
<%} %>
<%@ include file="/resources/design/center.jsp" %>
<center>
    <%User usr= (User) request.getAttribute("user");%>
<form:form  method="POST" commandName="userEdit" modelAttribute="userEdit" action="do_user_edit">
<table width="250px">
     <form:hidden path="userId" value="<%=usr.getUserId()%>"></form:hidden>
    <tr>
        <td>
            Имя:
        </td>
        <td>
            <form:input path="firstName" value="<%=usr.getFirstName()%>" pattern="[a-zA-Zа-яА-Я]{1,40}$"/>
        </td>
    </tr>
    <tr>
        <td>
            Фамилия:
        </td>
        <td>
            <form:input path="surname"  value="<%=usr.getSurname()%>" pattern="[a-zA-Zа-яА-Я]{1,40}$"/>
        </td>
    </tr>
    <tr>
        <td>
            Отчество:
        </td>
        <td>
            <form:input path="lastName" value="<%=usr.getLastName()%>" pattern="[a-zA-Zа-яА-Я]{1,40}$"/>
        </td>
    </tr>
    <tr>
        <td>
            Email:
        </td>
        <td>
            <form:input path="email" value="<%=usr.getEmail()%>" pattern="^([a-zA-Z0-9_\.\-]{1,20})@([a-zA-Z0-9\.\-]{1,20})\.([a-z]{2,4})$" />
        </td>
    </tr>
    <tr>
        <td>
            Пароль:
        </td>
        <td><%
        	if((Integer)session.getAttribute("user_type_id")==1){
        %>
            <form:password  path="password" value="<%=usr.getPassword()%>"/>
            <%
            	}else{
            %>
            <form:password path="password"/>
            <%
            	}
            %>
        </td>
    </tr>
    <%
    	if((Integer)session.getAttribute("user_type_id")==1){
    %>
    <tr>
        <td>
            Тип:
        </td>
        <td>
            <form:input path="userTypeId" value="<%=usr.getUserTypeId()%>" />
        </td>
    </tr>
    <%
    	}
    %>
    <tr>
        <td>

        </td>
        <td>
           <input class="btn btn-primary" type="submit" value="Сохранить" />
        </td>
    </tr>

</table>

</form:form>
</center>
 <br>
<%
	if((Integer)session.getAttribute("user_type_id")==1){
%>
    <div align="right"><input class="btn btn-warning" type="button" value="!Удалить!" onclick="javascript:document.location='/user_delete_<%=usr.getUserId()%>'"/></div>
<%}%>

<%@ include file="/resources/design/footer.jsp" %>