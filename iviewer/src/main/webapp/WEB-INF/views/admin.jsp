<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@include file="/resources/table_sort.jsp" %>
<%@include file="/resources/design/header.jsp" %>

<button type="button" class="btn btn-primary" data-toggle="button">Редактировать</button>

<li><a href="#">Редактировать пользователя</a></li>
<li><a href="#">что то еще</a></li>

<%@ include file="/resources/design/center.jsp" %>
<%int k=0; %>

Фильтр по ФИО<br />
<input type="text"  onkeyup="filter(this, 'sf')" >

<table id="sf" class="sort" width="100%" border=2 align="center">
    <thead>
        <tr ALIGN=center bgcolor="9999FF">
            <td>№</td> <td>ФИО</td> <td>Тип</td> <td>Действие</td>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="users" items="${users}">
        <%k++; %>
        <tr ALIGN=center height=40>

                <td><%=k %></td> <td width=300>${users.surname}  ${users.first_name} ${users.last_name}</td>


            <td>${users.user_type_id}</td> <td><input type="button" class="btn btn-primary" value="Редактировать" onclick="javascript:document.location='/user_edit_${users.user_id}'"></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="/resources/design/footer.jsp" %>

<script type="text/javascript">
    function filter (phrase, _id){
        var words = phrase.value.toLowerCase().split(" ");
        var table = document.getElementById(_id);
        var ele;
        for (var r = 1; r < table.rows.length; r++){
            ele = table.rows[r].cells[1].innerHTML.replace(/<[^>]+>/g,"");
            var displayStyle = 'none';
            for (var i = 0; i < words.length; i++) {
                if (ele.toLowerCase().indexOf(words[i])>=0)
                    displayStyle = '';
                else {
                    displayStyle = 'none';
                    break;
                }
            }
            table.rows[r].style.display = displayStyle;
        }
    }
</script>