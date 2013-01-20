<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@page import="org.hibernate.Session, util.HibernateUtil, test.User, test.Users_type, DAO.Factory, java.util.Locale, java.util.Enumeration, java.util.List,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
 <link rel="stylesheet" type="text/css" href="loginStyle.css" />
</head>
<body>
<form name="input" action="login.jsp" method="post">
<%
String message="";
String email="";
String password="";
Enumeration names = request.getParameterNames();
if (names.hasMoreElements()) {
	email=request.getParameter("emailField");
    password=request.getParameter("passwordField");
}
else{
	 email="defval";
	 password="defval";
}
if(!(email.isEmpty())&&!(password.isEmpty())){
	Locale.setDefault(Locale.ENGLISH);
	User user=new User();
	try{
		Session sess = HibernateUtil.getSessionFactory().openSession();
		String query="SELECT user_id, email, password,"
		+"first_name, surname, last_name, foto, user_type_id FROM Users WHERE email='"+email+"'";
		sess.getTransaction().begin();
		try{
		user = (User) sess.createSQLQuery(query).addEntity(User.class).list().get(0);
		sess.getTransaction().commit();
		sess.close();
		}
		catch(Exception e){
			sess.getTransaction().rollback();
			sess.close();
		}
	}catch(Exception e){
	}
	if(!email.equals("defval"))
	if(!(user.getPassword()==null)){
		if(user.getPassword().equals(password)){
			session.setAttribute("user_id", user.getUser_id());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("first_name", user.getFirst_name());
			session.setAttribute("surname", user.getSurname());
			session.setAttribute("foto", user.getFoto());
			session.setAttribute("user_type_id", user.getUser_type_id());
			if((Integer)session.getAttribute("user_type_id")==1){%>
			 <jsp:forward page="admin.jsp"/>
				
			<%}
			else if((Integer)session.getAttribute("user_type_id")==2){%>
				<jsp:forward page="hr.jsp"/>
			<%}
			else if((Integer)session.getAttribute("user_type_id")==3){%>
			<jsp:forward page="interview.jsp"/>
		<%}
			else if((Integer)session.getAttribute("user_type_id")==4){%>
			<jsp:forward page="candidate.jsp"/>
		<%}
		}
	else{
			message="Введённый неверный пароль.";
		}
	}
	else{
		message="Пользователя с таким email'ом не существует.";
	}
}
else{
	message="Поля \"Email\" и \"Пароль\" должны быть заполнены!";
}
if(email.equals("defval")||password.equals("defval")){
	email="";
	password="";
}	
%>
<font id="emailText">Email</font>
<input type="text" name="emailField" value="<%=email%>" size="50" id="email" />
<font id="passwordText">Пароль</font>
<input type="password" name="passwordField" value="<%=password%>" size="50" id="password" />
<input type="submit" value="Войти" name="loginButton" id="loginButton" name="login"/>
<font color="#FF0000" id="error"><%=message %></font>
<a href="index.jsp" id="main">На главную</a>
</body>
</html>