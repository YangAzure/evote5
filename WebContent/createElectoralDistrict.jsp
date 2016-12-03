<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>createElectoralDistrict</title>
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
			href="${pageContext.request.contextPath}/choice.jsp">Officer Management</a></li>
	</ul>
        	<ul class="nav navbar-nav">
		<li class="active"> <form action="OfficerLogout" method="post">
<input type="submit" value="Logout" >
</form></li>
	</ul>
</div>
</nav>
</head>

        <%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("officerusername")) userName = cookie.getValue();
}
}
if(userName == null) response.sendRedirect("officerlogin.jsp");
%>
<body>

	<h2 class="text-center">Please input the Electoral District you
		want to Create</h2>
	<div class="container">
		<form class="form-horizontal" data-toggle="validator" role="form"
			method="post"
			action="${pageContext.request.contextPath}/CreateElectoralDistrict">
			<table class="table table-striped">
				<tbody>
					<tr>


						<th>District Name</th>
					</tr>
					<tr>

						<td>
							<div class="form-group col-xs-7">
								<input type="text" class="form-control" name="name" required>
							</div>
						</td>
					</tr>

				</tbody>
			</table>

			<button class="btn btn-custom btn-lg btn-block outline" name="submit"
				type="submit">Create Electoral District!</button>
		</form>

<%-- 		<div>
			<form class="form-horizontal" data-toggle="validator" role="form"
				method="post"
				action="${pageContext.request.contextPath}/ShowElectoralDistrict">
				<button class="btn btn-custom btn-lg btn-block outline"
					name="submit" type="submit">Check Electoral District List</button>
			</form>
		</div> --%>
</body>
</html>