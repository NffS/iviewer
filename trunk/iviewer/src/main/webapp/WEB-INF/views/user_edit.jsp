<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02.02.13
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@include file="/resources/design/header.jsp" %>

<li>текст левого блока</li>

<%@ include file="/resources/design/center.jsp" %>
<center>
    <%User usr= (User) request.getAttribute("user");%>
<form:form  method="POST" commandName="userEdit" modelAttribute="userEdit" action="user_edit.do">
<table width="250px">
    <tr>
        <td>
            Имя:
        </td>
        <td>
            <form:input path="first_name" value="<%=usr.getFirst_name()%>"/>
        </td>
    </tr>
    <tr>
        <td>
            Фамилия:
        </td>
        <td>
            <form:input path="surname"  value="<%=usr.getSurname()%>"/>
        </td>
    </tr>
    <tr>
        <td>
            Отчество:
        </td>
        <td>
            <form:input path="last_name" value="<%=usr.getLast_name()%>"/>
        </td>
    </tr>
    <tr>
        <td>
            Email:
        </td>
        <td>
            <form:input path="email" value="<%=usr.getEmail()%>"/>
        </td>
    </tr>
    <tr>
        <td>
            Пароль:
        </td>
        <td>
            <form:input path="password"/>
        </td>
    </tr>
    <%  if((Integer)session.getAttribute("user_type_id")==1){%>
    <tr>
        <td>
            Тип:
        </td>
        <td>
            <form:input path="user_type_id" value="<%=usr.getUser_type_id()%>" />
        </td>
    </tr>
    <%}%>
    <tr>
        <td>

        </td>
        <td>
           <input type="submit" value="Кнопочка" />
        </td>
    </tr>

</table>

</form:form>
</center>

<%@ include file="/resources/design/footer.jsp" %>