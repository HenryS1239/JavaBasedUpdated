<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

	<form id="push-form-json" action="${pageContext.request.contextPath}/notify.html" method="post">

		<div class="box">
			<label>User ID: </label><br />
			<input type="text" id="userid" name="userid" autofocus/><br />
			<label>Group ID: </label><br /> 
			<input type="text" id="groupid" name="groupid" /><br />
			<label>Account No.: </label><br /> 
			<input type="text" id="clientT" name="acc_no"/><br /> 
			<label>Option:</label><br />
			<input type="text" id="option" name="option"/><br />
			<label>Value:</label><br /> 
			<input type="text" id="value" name="amount"/><br />
			<br />

			<div>
				<input type="submit" class="button" disabled id="notify" value="Notify Me" />
				
				<input type="submit" class="button" id="Back" value="Go Back" onclick="parent.location='update.html'"/>
			</div>

		</div>

	</form>

</body>


<script src="https://www.gstatic.com/firebasejs/7.2.1/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.2.1/firebase-messaging.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/localfb.js"></script>

<script defer src="<%=request.getContextPath() %>/resources/js/main.js"></script>
<script defer src="<%=request.getContextPath() %>/resources/js/json-form.js"></script>


</html>