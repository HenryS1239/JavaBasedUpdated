<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="login_success_title"/></title>
    <style>
    	.button {
			  background-color: green;
			  border: none;
			  color: white;
			  padding: 10px 15px;
			  margin-top: 10	px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 15px;
			  margin: 15px 8px;
			  cursor: pointer;
		}
    </style>
</head>

<body>
	<h2>Get Notified </h2>

	<form onsubmit="return confirmDelete()" action="${pageContext.request.contextPath}/register.html" method="post">
		<div class="box">
		<h1>Register</h1>
            <label for="userid">User ID: </label>
            <input type="text" id="userid" name="userid" class="userid"/><br/>
            <label for="userid">Group ID: </label>
            <input type="text" id="groupid" name="groupid" class="userid"/><br/>
            <div>
				<input type="radio" id="notetype" value="reccuring"> Notify after time<br>
				<input type="radio" id="notetype" value="sentinel"> Notify on action<br>
				<!--<input type="radio" name="notetype" value=""> Other-->
			</div>
            <label for="userid">Custom Message: </label>
            <input type="text" id="custommsg" name="customMsg" class="userid"/><br/>

        <div><input type = "submit" class = "button" value = "Notify Me"/></div>
            
        </div>

        </form>

	

</body>
<script src = "scripts/main.js"></script>
</html>