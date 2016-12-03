<%@page import="java.util.*"%>
<%@page import="entity.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.

Author: Yang SHI
-->
<html>
<head>
<title>Update a ED</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
			<li class="active"><form action="OfficerLogout" method="post">
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
	<h1>Update Electoral District</h1>
	<%-- 	<%
		Vector<ElectoralDistrict> edList = request.getAttribute("edList");
		for (ElectoralDistrict ed : edList) {
	%>
	<tr>
		<td><%=(String) ed.getDistrictName()%></td>
		<td><%=(String) ed.getIdElectoralDistrict()%></td>
	</tr>
	<%
		}
	%>
 --%>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<%
			Vector edList = (Vector) request.getAttribute("edList");
		%>
		<%
			for (int i = 0; i < edList.size(); i++) {
		%>
		<tr>
			<td><%=((ElectoralDistrict) edList.get(i))
						.getIdElectoralDistrict()%></td>
			<td><%=((ElectoralDistrict) edList.get(i)).getDistrictName()%></td>
		</tr>
		<%
			}
		%>
	</table>

	<form action="${pageContext.request.contextPath}/UpdateElectoralDistrict" method="POST">
		ElectoralDistrict ID <input type="text" name="idElectoralDistrict" value="" />
		ElectoralDistrict New name <input type="text" name="districtName" value="" /><br>
		<input type="submit" value="submit" name="submit" />
	</form>
</body>
</html>
