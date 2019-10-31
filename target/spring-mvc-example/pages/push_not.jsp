<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.util.*;" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="login_success_title" /></title>
<style>
	.button {
		background-color: green;
		border: none;
		color: white;
		padding: 10px 15px;
		margin-top: 10 px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 15px;
		margin: 15px 8px;
		cursor: pointer;
	}
	.button:disabled,
	.button[disabled]{
	  	border: 1px solid #999999;
	  	background-color: #cccccc;
	  	color: #666666;
	}
</style>
</head>

<body>

	<h1>Get Notified</h1>

	<form id="user-form" action="${pageContext.request.contextPath}/notify.html" method="post">
		<div class="box">
			<label>User ID: </label><br />
			<input type="text" id="userid" name="userid" autofocus/><br />
			<label>Group ID: </label><br /> 
			<input type="text" id="groupid" name="groupid" /><br />
			<label>Option:</label><br />
			<input type="text" id="option" name="option"/><br />
			<label>Value:</label><br /> 
			<input type="text" id="value" name="amount"/><br />
			<br />
			<div>
				<input type="button" class="button" id="notify" value="Notify Me" />
				
				<input type="submit" class="button" id="Back" value="Go Back" onclick="parent.location='update.html'"/>
			</div>

		</div>

	</form>

</body>
<script defer src="<%=request.getContextPath() %>/resources/js/main.js"></script>
<script>
var notifyButton = document.querySelector("#notify");
var token = localStorage.getItem("token");
var form = document.getElementById("user-form");
notifyButton.addEventListener('click', function(event) {
	var input = document.createElement('input');//prepare a new input DOM element
	input.setAttribute('name', 'token');//set the param name
    input.setAttribute('value', token);//set the value
    input.setAttribute('type', 'text');
    form.appendChild(input);
    console.log()
	console.log("Append Successful");
    form.submit();
});
</script>

</html>