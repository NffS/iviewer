<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="/resources/design/header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<form action="do_change_password" method="post">
<table>
	<tr><td>Старый пароль:</td><td><input type="password" id="text-input" name="oldPassword" pattern="[a-zA-Z0-9]{4,16}$"/></td></tr>
	<tr><td>Новый пароль:</td><td><input type="password" id="text-input" name="newPassword" pattern="[a-zA-Z0-9]{4,16}$"/></td></tr>
	<tr><td>Подтвердите новый пароль:</td><td><input type="password" id="text-input" name="confirmPassword" pattern="[a-zA-Z0-9]{4,16}$"/></td></tr>
</table>
<br>
<input class="btn btn-primary" type="submit" value="Сохранить" />
</form>
<%@ include file="/resources/design/footer.jsp" %>