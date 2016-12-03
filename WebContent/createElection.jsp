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
<title>Create Election</title>
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
        
        
        <center>
        <h1>Create Election</h1>
        <form action="CreateElection" method="POST" id="myForm">
        Election Name (Office Name):<br>
        <input type="text" name="OfficeName" value=""/>
        <br>
        Partisan:
        <br>
        True
        <input type ="radio" name ="RadioButton" value="True">
        <br>
        False
        <input type ="radio" name ="RadioButton" value="False">
        <br><br>
        <input type="submit" value="Create Election" onclick="return RadioValidator();"/>
        </form>
        <br>

        
 <script  type="text/javascript">
 var frmvalidator = new Validator("myform");
 frmvalidator.addValidation("OfficeName","req","Required");
 frmvalidator.addValidation("RadioButton","dontselect","Required");
 
 
 
 
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
        
        </center>
    </body>
</html>
