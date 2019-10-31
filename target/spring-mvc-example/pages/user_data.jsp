<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	
  	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
 	<link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.indigo-pink.min.css">
  	<script defer src="https://code.getmdl.io/1.2.1/material.min.js"></script>
  	
    <title><spring:message code="login_success_title"/></title>
    <style>
    	table{
    		border-collapse: collapse;
    		width:100%;
    	}
    	th, td{
    		text-align:left;
    		padding:10px;
    	}
    	tr:nth-child(even){
    		background-color:#f2f2f2;
    	}
    	th{
    		background-color:#3498db;
    		color:white;
    	}
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
		.userid{
    		border:#000000 1px solid;
    		padding:5px;
    		width:250px;
    		margin-top:10px;
    		font-size:14px;
    		border-radius:4px;
    	}
    </style>
</head>

<body>
		<form:form id="user-form-json" modelAttribute="notifyForm" action="${pageContext.request.contextPath}/doData.html" method="post">
			<label for="userid">Insert your bank account number: </label>
			<input type="text" id="acc_no" name="acc_no" class="userid"/><br/>
			<label for="userid">Deposit / Withdraw: </label>
			<input type="text" id="option" name="option" class="userid"/><br/>
			<label for="userid">Amount: </label>	
			<input type="text" id="amount" name="amount" class="userid"/><br/>
		<div>
			<input type="submit" value="Submit" id="notify" class="button">
		</div>
		</form:form>
			
</body>

</html>