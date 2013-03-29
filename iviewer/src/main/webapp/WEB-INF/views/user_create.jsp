<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/resources/design/header.jsp" %>
<%@ include file="/resources/design/admin_left_part.jsp" %>
<%@ include file="/resources/design/center.jsp" %>
<center>
    <form action="do_user_create" method="post">
	    <table width="250px">
		    <tr><td>Фамилия:</td>
		    	<td><input type="text" id="text-input" name="surname" value="" pattern="[A-ZА-ЯЁ][a-zа-яё]{1,40}$"></td></tr>
		    <tr><td>Имя:</td>
		    	<td><input type="text" id="text-input" name="first_name" value="" pattern="[A-ZА-ЯЁ][a-zа-яё]{1,40}$"></td></tr>
		    <tr><td>Отчество:</td>
		    	<td><input type="text" id="text-input" name="last_name" value="" pattern="[A-ZА-ЯЁ][a-zа-яё]{1,40}$"></td></tr>
		    <tr><td>Email:</td>
		    	<td><input type="text" id="text-input" name="email" value="" pattern="^([a-zA-Z0-9_\.\-]{1,20})@([a-zA-Z0-9\.\-]{1,20})\.([a-z]{2,4})$"></td></tr>
		    <tr><td>Пароль:</td>
		    	<td>
		    		<input type="password" id="text-input" name="password" value="" />
		    	</td></tr>
		    <tr><td>Тип:</td>
		        <td><select name="user_type_id">
						<c:forEach var="userType" items ="${userTypes }">
							<option value="${userType.userTypeId }">${userType.typeName }</option>
						</c:forEach>
					</select>
		        </td></tr>
		    <tr><td></td>
		    	<td><input class="btn btn-primary" type="submit" value="Сохранить" /></td></tr>
	    </table>
    </form>
</center>
<%@ include file="/resources/design/footer.jsp" %>