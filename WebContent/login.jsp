<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('#notEmptyForm').formValidation({
			framework : 'bootstrap',
			icon : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				fullName : {
					validators : {
						notEmpty : {
							message : 'The input is required'
						}
					}
				}
			}
		});
	});
</script>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand"
			href="${pageContext.request.contextPath}/index.jsp">
			Home</a>
	</div>

	<ul class="nav navbar-nav">
		<li class="active"><a
			href="${pageContext.request.contextPath}/registration.jsp">Register</a></li>
	</ul>
        	<ul class="nav navbar-nav">
		<li class="active"><a
			href="${pageContext.request.contextPath}/resetpassword.jsp">Forgot Password</a></li>
	</ul>
</div>
</nav>
</head>

        <%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("username")) userName = cookie.getValue();
}
}
if(userName != null) response.sendRedirect("loggedsuccess.jsp");
%>
    <body>
        
        
        <center>
        <h1>Login</h1>
        <form action="Login" method="POST">
        Username:<br>
        <input type="text" name="Username" value="" />
        <br>
        Password:<br>
        <input type="password" name="Password" value="" />
        <br><br>
        <input type="submit" value="Login" />
        </form>
        
        
        
        </center>
    </body>
</html>
