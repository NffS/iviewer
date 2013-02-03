<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="/resources/design/header.jsp" %>

<button type="button" class="btn btn-primary" data-toggle="button">Редактировать</button>

<li><a href="#">Редактировать пользователя</a></li>
<li><a href="#">что то еще</a></li>

<%@ include file="/resources/design/center.jsp" %>
<%int k=0; %>

<table width="100%" border=2 align="center">
    <tr ALIGN=center bgcolor="9999FF">
        <th>№</th> <th>ФИО</th> <th>Тип</th> <th>Действие</th>
    </tr>
    <c:forEach var="users" items="${users}">
        <%k++; %>
        <tr ALIGN=center height=40>
            <td><%=k %></td> <td width=300>${users.surname}  ${users.first_name} ${users.last_name}</td>
            <td>${users.user_type_id}</td> <td><input type="button" class="btn btn-primary" value="Редактировать" onclick="javascript:document.location='/user_edit_${users.user_id}'"></td>

        </tr>
    </c:forEach>
</table>

<%@ include file="/resources/design/footer.jsp" %>

