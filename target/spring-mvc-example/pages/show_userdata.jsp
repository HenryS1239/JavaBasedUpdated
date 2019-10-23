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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	
  	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
 	<link rel="stylesheet" href="https://code.getmdl.io/1.2.1/material.indigo-pink.min.css">
  	<script defer src="https://code.getmdl.io/1.2.1/material.min.js"></script>
  	<spring:url value="js/main.js" var="mainJs"/>
  	<!-- <script defer src="/js/main.js"></script> -->
  	
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
    </style>
</head>

<body>
    <h2>Group Table: </h2>
   	<h3>${STATUS_MESSAGE}</h3>
	   <table border="2">
		<tr>
			<th>Account No</th>
			<th>Deposit</th>
			<th>Withdraw</th>
			<th>Balance</th>
		</tr>
	   <% 	
	   	Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username="root";
		String password="root";
		String query = "SELECT acc_no, deposit, withdraw, balance FROM action";
		Connection conn=DriverManager.getConnection(url, username, password);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
		%>
			<tr><td><%=rs.getString("acc_no") %></td>
				<td><%=rs.getInt("deposit") %></td>
				<td><%=rs.getInt("withdraw") %></td>
				<td><%=rs.getString("balance") %></td></tr>
		<%
		}
		%>
			</table>
		<%
			rs.close();
			stmt.close();
			conn.close();
		%>	
</body>
</html>