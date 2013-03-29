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
    <c:when test="${sessionScope.user.userTypeId==1}">
		<c:import url = "/resources/design/admin_left_part.jsp" />
    </c:when>
	<c:when test="${sessionScope.user.userTypeId==2}">
		<c:import url = "/resources/design/hr_left_part.jsp" />
    </c:when>
    <c:when test="${sessionScope.user.userTypeId==3}">
		<c:import url = "/resources/design/tech_left_part.jsp" />
    </c:when>
    <c:otherwise>
    	
    </c:otherwise>
</c:choose>
<%@ include file="/resources/design/center.jsp" %>
<center>
    <form action="do_user_edit" method="post">
	    <input type="hidden" name="user_id" value="${user.userId}">
	    <table width="250px">
		    <tr><td>Фамилия:</td>
		    	<td><input type="text" id="text-input" name="surname" value="${user.surname}" pattern="[A-ZА-ЯЁ][a-zа-яё]{1,40}$"></td></tr>
		    <tr><td>Имя:</td>
		    	<td><input type="text" id="text-input" name="first_name" value="${user.firstName}" pattern="[A-ZА-ЯЁ][a-zа-яё]{1,40}$"></td></tr>
		    <tr><td>Отчество:</td>
		    	<td><input type="text" id="text-input" name="last_name" value="${user.lastName}" pattern="[A-ZА-ЯЁ][a-zа-яё]{1,40}$"></td></tr>
		    <tr><td>Email:</td>
		    	<td><input type="text" id="text-input" name="email" value="${user.email}" pattern="^([a-zA-Z0-9_\.\-]{1,20})@([a-zA-Z0-9\.\-]{1,20})\.([a-z]{2,4})$"></td></tr>
		    <c:if test="${sessionScope.user.userTypeId==1}">
		    <td>Тип:</td>
		        <td><select name="user_type_id">
		        		<option value="${user.usersType.userTypeId }">${user.usersType.typeName}</option>
						<c:forEach var="userType" items ="${userTypes }">
							<c:if test="${userType.userTypeId!=user.usersType.userTypeId }">
							<option value="${userType.userTypeId }">${userType.typeName }</option>
							</c:if>
						</c:forEach>
					</select>
		        </td>
		    </c:if>    
    		<tr><td></td><td style="padding-bottom: 10px"><a href="change_password">Сменить пароль</a></td><tr>
		    <tr><td></td>
		    	<td><input class="btn btn-primary" type="submit" value="Сохранить" /></td></tr>
	    </table>
    </form>
</center>
 <br>
<c:if test="${sessionScope.user.userTypeId==1}">
    <div align="right"><input class="btn btn-warning" type="button" value="!Удалить!" onclick="javascript:document.location='/iviewer/user_delete_${user.userId}'"/></div>
</c:if>

<%@ include file="/resources/design/footer.jsp" %>