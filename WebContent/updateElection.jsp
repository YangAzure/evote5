<%@page import="java.util.*"%>
<%@page import="entity.*"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

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
	<h1>Update Election</h1>
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


<form method="post">

	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Election/Office Name</th>
                        <th>Partisan</th>
                        <th>Ballot ID</th>
                        <th>Total Count</th>
		</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://uml.cs.uga.edu/team5";
String username="team5";
String password="abstract";
String query="select * from Election";
Connection conn=DriverManager.getConnection(url, username, password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
<tr>
<td><%=rs.getInt("idElection") %></td>
<td><%=rs.getString("officeName") %></td>
<td><%=rs.getBoolean("isPartisan") %></td>
<td><%=rs.getInt("BallotID") %></td>
<td><%=rs.getInt("TotalCount") %></td>
</tr>

 <%

}
%>
</table>
<%
rs.close();
stmt.close();
conn.close();
}
catch(Exception e)
{
e.printStackTrace();
}
%>
</form>


       
        <h3>Update</h3>
        <form action="UpdateElections" method="POST" id="myForm">
        Election ID:   
        <input type="text" name="electionid" value=""/>
        &emsp;
        Election Name (Office Name):
        <input type="text" name="OfficeName" value=""/>
        &emsp;
        Partisan:
        True
        <input type ="radio" name ="RadioButton" value="True">
        
        False
        <input type ="radio" name ="RadioButton" value="False">
        &emsp;
        <input type="submit" value="Update Election" onclick="return RadioValidator();"/>
        </form>
        <br>

        
 <script  type="text/javascript">
 var frmvalidator = new Validator("myform");
 frmvalidator.addValidation("OfficeName","req","Required");
 frmvalidator.addValidation("electionid","req","Required");
 
 
 
 
 function RadioValidator()
{
    var ShowAlert = '';
    var AllFormElements = window.document.getElementById("myForm").elements;
    for (i = 0; i < AllFormElements.length; i++) 
    {
        if (AllFormElements[i].type == 'radio') 
        {
            var ThisRadio = AllFormElements[i].name;
            var ThisChecked = 'No';
            var AllRadioOptions = document.getElementsByName(ThisRadio);
            for (x = 0; x < AllRadioOptions.length; x++)
            {
                 if (AllRadioOptions[x].checked && ThisChecked == 'No')
                 {
                     ThisChecked = 'Yes';
                     break;
                 } 
            }   
            var AlreadySearched = ShowAlert.indexOf(ThisRadio);
            if (ThisChecked == 'No' && AlreadySearched == -1)
            {
            ShowAlert = ShowAlert + ThisRadio + ' True or False Input Needed\n';
            }     
        }
    }
    if (ShowAlert != '')
    {
    alert(ShowAlert);
    return false;
    }
    else
    {
    return true;
    }
}
 
</script>


</body>
</html>
