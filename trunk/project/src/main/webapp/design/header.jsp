<html>
<head>
    <title>NetCracker</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="design/style.css">
    </head>
<body>
	<div id="s" style="background:white; width:100%;height:70px;">
	</div>	
	<div id="wrap">
		<div id="main">
			<div id="submain">
				<div id="out">
					<div id="header">
						<img src="design/logo.jpg">
						<div id="menu">
						    <ul>
								<li><a href="index.jsp"><p>Главная</p></a></li>
								<li><a href="index.jsp?news=1"><p>О компании</p></a></li>
								<li><a href="index.jsp?news=2"><p>Контакты</p></a></li>
								<li><a href="#"><p>Ссылка 4</p></a></li>
							</ul>
						</div>
						<%if((Integer)session.getAttribute("user_type_id")==null){	%>
						<div id="log">
						<form name="input" action="login.jsp" method="post">
							<p>E-mail:</p><input type="text" name="emailField"><br>
							<p style="margin-top:7px;">Pass:</p><input type="password" name="passwordField">
							
						
						</div>
						<div id="reg">				
						<input type="submit" value="Войти">	
						</form>			
							<a href="reg.jsp"><p>Регистрация</p></a>
						</div>
						<%}else{String path="#";%>
						<div id="cabin">
							 Добро пожаловать <%=session.getAttribute("first_name")%><br>
							<%if((Integer)session.getAttribute("user_type_id")==1){path="admin.jsp";}
  								else if((Integer)session.getAttribute("user_type_id")==2){path="hr.jsp";}
  								else if((Integer)session.getAttribute("user_type_id")==3){path="interview.jsp";}
   								else if((Integer)session.getAttribute("user_type_id")==4){path="candidate.jsp";}
  							%>

  							<input type="button" value="Личный кабинет"  onclick="javascript:document.location='<%=path%>'">
  							<input type="button" value="Выход" onclick="javascript:document.location='login.jsp'">
  						<%}%>
						</div>
					</div>	
					<div id="info">
						<img src="design/info.jpg">
					</div>
					<div id="center"><br>