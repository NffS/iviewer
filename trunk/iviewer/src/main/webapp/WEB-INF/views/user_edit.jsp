<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02.02.13
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/resources/design/header.jsp" %>
<c:choose>
	<c:when test="${user.userTypeId==2}">
		<c:import url = "/resources/design/hr_left_part.jsp" />
    </c:when>
    <c:when test="${user.userTypeId==3}">
		<c:import url = "/resources/design/tech_left_part.jsp" />
    </c:when>
    <c:otherwise>
    	
    </c:otherwise>
</c:choose>
<%@ include file="/resources/design/center.jsp" %>
<center>
    <form action="do_user_edit" method="post">
	    <input type="hidden" name="user_id" value="${user.userId}">
	    <c:if test="${user.userId==3}">
	    test
	    </c:if>
	    <table width="250px">
		    <tr><td>Фамилия:</td>
		    	<td><input type="text" id="text-input" name="surname" value="${user.surname}" pattern="[a-zA-Zа-яА-ЯёЁ]{1,40}$"></td></tr>
		    <tr><td>Имя:</td>
		    	<td><input type="text" id="text-input" name="first_name" value="${user.firstName}" pattern="[a-zA-Zа-яА-ЯёЁ]{1,40}$"></td></tr>
		    <tr><td>Отчество:</td>
		    	<td><input type="text" id="text-input" name="last_name" value="${user.lastName}" pattern="[a-zA-Zа-яА-ЯёЁ]{1,40}$"></td></tr>
		    <tr><td>Email:</td>
		    	<td><input type="text" id="text-input" name="email" value="${user.email}" pattern="^([a-zA-Z0-9_\.\-]{1,20})@([a-zA-Z0-9\.\-]{1,20})\.([a-z]{2,4})$"></td></tr>
		    <tr><td>Пароль:</td>
		    	<td><c:if test="${user.userTypeId==1}">
		    			<input type="password" id="text-input" name="password" value="${user.password}" />
		    		</c:if>
		    		<c:if test="${user.userTypeId!=1}">
		    			<input type="password" id="text-input" name="password" />
		    		</c:if></td></tr>
		    <c:if test="${user.userTypeId==1}">
		    <tr><td>Тип:</td>
		        <td><input type="text" id="text-input" name="user_type_id" value="${user.userTypeId}" /></td></tr>
		    </c:if>    
		    <tr><td></td>
		    	<td><input class="btn btn-primary" type="submit" value="Сохранить" /></td></tr>
	    </table>
    </form>
</center>
 <br>
<c:if test="${user.userTypeId==1}">
    <div align="right"><input class="btn btn-warning" type="button" value="!Удалить!" onclick="javascript:document.location='/user_delete_${user.userId}'"/></div>
</c:if>

<%@ include file="/resources/design/footer.jsp" %>