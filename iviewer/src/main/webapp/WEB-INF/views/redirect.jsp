<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/resources/design/header.jsp" %>
<%@ include file="/resources/design/center.jsp" %>

<center>
<big>
    <%=request.getAttribute("message")%>
</big><br><br>
    (вы будете автоматически перенаправлены через несколько секунд)
</center>
    <script>
        setTimeout("document.location.href='<%=request.getAttribute("target")%>'", 3000);
    </script>
<%@ include file="/resources/design/footer.jsp" %>