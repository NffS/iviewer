<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@include file="/resources/design/header.jsp" %>

<a href="index"><font size="3" color="000000">На главную</font></a>
<%@ include file="/resources/design/center.jsp" %>
<form  method="POST" action="edit_this_candidate" enctype="multipart/form-data">
	<table>
		<tr>
			<td width=110><font size=5>Фото:</font></td>
   			 <td><input name="data" type="file"><font color="#FF0000" >&nbsp;&nbsp;${fotoMessage}</font></td> 
   		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" style="height:30px; width:100px; font-size: 15px" value="Сохранить"></td>
</table>
</form>
<br><br><br><br>
<font color="#FF0000" id="error" size="12px">${message}</font>

<%@ include file="/resources/design/footer.jsp" %>