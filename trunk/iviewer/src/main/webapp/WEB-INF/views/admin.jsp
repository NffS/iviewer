<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ncteam.iviewer.domain.UsersType"%>

<%@include file="/resources/table_sort.jsp" %>
<%@include file="/resources/design/header.jsp" %>

<button type="button" class="btn btn-primary" data-toggle="button">Редактировать</button>

<li><a href="#">Редактировать пользователя</a></li>
            <li><a href="#">что то еще</a></li>

<%@ include file="/resources/design/center.jsp" %>

<table width="100%" align="center">
    <tr align="center">
        <td>
            <br />
            <input placeholder="Фильтр по ФИО"  id="fio" type="text"  onkeyup="filter('sf')" >
        </td>
        <td>
            <br />
            <input placeholder="Фильтр по Email" id="email" type="text"  onkeyup="filter('sf')" >
        </td>
        <td>
            <br>
            <select id="types" onchange="filter('sf')">
                <option value="">Фильтр по типу</option>
                <c:forEach var="users_types" items="${users_types}">
                    <option value="${users_types.user_type_id}">${users_types.type_name}</option>
                </c:forEach>
            </select>
        </td>
     </tr>
</table>

<table id="sf" class="sort" width="100%" border=2 align="center">
    <thead>
        <tr ALIGN=center bgcolor="9999FF">
            <td>№</td> <td>ФИО</td>  <td>Email</td> <td>Тип</td> <td>Действие</td>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="users" items="${users}">
        <tr ALIGN=center height=40>
            <td>${users.user_id}</td> <td width=300>${users.surname}  ${users.first_name} ${users.last_name}</td>
            <td>${users.email}</td> <td>${users.user_type_id}</td>
            <td><input type="button" class="btn btn-primary" value="Редактировать" onclick="javascript:document.location='/iviewer/user_edit_${users.user_id}'"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="/resources/design/footer.jsp" %>

<script type="text/javascript">

    function filter(_id){
        var fio = document.getElementById("fio").value.toLowerCase().split(" ");
        var email = document.getElementById("email").value.toLowerCase().split(" ");
        var types = document.getElementById("types").value.toLowerCase().split(" ");
        //alert(words);
        var table = document.getElementById(_id);
        var ele;
        for (var r = 1; r < table.rows.length; r++){
           table.rows[r].style.display = '';
        }
        for (var r = 1; r < table.rows.length; r++){
            ele = table.rows[r].cells[3].innerHTML.replace(/<[^>]+>/g,"");
            var displayStyle = '';
            for (var i = 0; i < types.length; i++) {
                if (ele.toLowerCase().indexOf(types[i])>=0)
                   continue;
                else {
                    displayStyle = 'none';
                    break;
                }
            }
            ele = table.rows[r].cells[2].innerHTML.replace(/<[^>]+>/g,"");
            for (var i = 0; i < email.length; i++) {
                if (ele.toLowerCase().indexOf(email[i])>=0)
                    continue;
                else {
                    displayStyle = 'none';
                    break;
                }
            }
            ele = table.rows[r].cells[1].innerHTML.replace(/<[^>]+>/g,"");
            for (var i = 0; i < fio.length; i++) {
                if (ele.toLowerCase().indexOf(fio[i])>=0)
                    continue;
                else {
                    displayStyle = 'none';
                    break;
                }
            }

            table.rows[r].style.display = displayStyle;
        }
    }
</script>