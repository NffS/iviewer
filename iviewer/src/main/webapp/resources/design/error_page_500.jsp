<%@page isErrorPage="true" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="h" %>
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
<h3>Ошибка сервера - 500</h3>
<p>Message: <%=exception.getMessage()%></p>
<%@ include file="/resources/design/footer.jsp" %>