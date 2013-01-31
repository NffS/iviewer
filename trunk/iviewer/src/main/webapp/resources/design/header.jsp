<%@page session="true"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ncteam.iviewer.domain.User"%>

<html>
<head>
    <title>NetCracker</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="resources/design/style.css">
    </head>
<body>
	<div id="s" style="background:white; width:100%;height:70px;">
	</div>
	<div id="wrap">
		<div id="main">
			<div id="submain">
				<div id="out">
					<div id="header">
						<img src="resources/design/logo.jpg">
						<div id="menu">
						    <ul>
								<li><a href="index"><p>Главная</p></a></li>
								<li><a href="index?1"><p>О компании</p></a></li>
								<li><a href="index?2"><p>Контакты</p></a></li>
								<li><a href="testdb"><p>testDB</p></a></li>
							</ul>
						</div>
						<%if((Integer)session.getAttribute("user_type_id")==null){	%>
						<div id="log">
                          <form:form  method="POST" commandName="userProfile" modelAttribute="usr" action="loginCheck">

							   E-mail<form:input path="email"/><br>
							    Пароль:<form:password path="password" />
						
						        </div>
						        <div id="reg">
								<input type="submit" value="Войти">
								<a href="reg.jsp"><p>Регистрация</p></a>
                            </form:form>     
							
						</div>
						<%}else{
							String path="#";%>
						<div id="cabin">
							 Добро пожаловать, <%=session.getAttribute("first_name")%><br>
							<%if((Integer)session.getAttribute("user_type_id")==1){path="admin.jsp";}
  								else if((Integer)session.getAttribute("user_type_id")==2){path="hr.jsp";}
  								else if((Integer)session.getAttribute("user_type_id")==3){path="interview.jsp";}
   								else if((Integer)session.getAttribute("user_type_id")==4){path="candidate.jsp";}
  							%>

  							<input type="button" value="Личный кабинет"  onclick="javascript:document.location='<%=path%>'">
  							<input type="button" value="Выход" onclick="javascript:document.location='logout'">
  						<%}%>
						</div>
					</div>	
					<div id="info">
						<img src="resources/design/info.jpg">
					</div>
                    <div id="left">
                        <div id="left_block">
                            <ul>
