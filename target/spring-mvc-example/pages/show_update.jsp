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
    	
    	body{
    		font-family: 'Open Sans', sans-serif;
    		background: #3498db;
    		margin: 0 auto 0 auto;
    		width: 100%;
    		text-align:center;
    		margin: 20px 0px 20px 0px;
    	}
    	
    	p{
    		font-size:14ps;
    		text-decoration: none;
    		color: #ffffff;
    	}
    	
    	h1{
    		font-size: 2.2em;
    		font-weight: bold;
    		color: #080808; 
    	}
    	.box{
    		background: white;
    		width:300px;
    		border-radius:px;
    		margin: 0 auto 0 auto;
    		padding:0px 0px 70px 0px;
    		border: #2980b9 4px solid;
    	}
    	.userid{
    		background:#ecf0f1;
    		border:#ccc 1px solid;
    		border-bottom:#ccc 2px solid;
    		padding:8px;
    		width:250px;
    		columns:#5e5c5c;
    		margin-top:10px;
    		font-size:1em;
    		font-weight:bold;
    		color:#5e5c5c;
    		border-radius:4px;
    	}
    	.password{
    		border-radius:4px;
    		background:#ecf0f1;
    		border:#ccc 1px solid;
    		padding:8px;
    		width:250px;
    		margin-top:10px;
    		font-size:1em;
    		color:#5e5c5c;
    	}
    	
    	input[type=text], input[type=password]{
    		font-size:0.8em;
    		margin-bottom:5px;
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
	   <table border="2" align="center">
		<tr>
			<th>User ID</th>
			<th>Group ID</th>
			<th>Password</th>
		</tr>
	   <% 	
	   	Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username="root";
		String password="root";
		String query="select * from userinfo";
		Connection conn=DriverManager.getConnection(url, username, password);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
		%>
			<tr><td><%=rs.getInt("userid") %></td>
				<td><%=rs.getInt("groupid") %></td>
				<td><%=rs.getString("password") %></td>
				
		<%
		}
		%>
			</table>
		<%
			rs.close();
			stmt.close();
			conn.close();
		%>
		
		
		<div style="margin:10px">
	        <h2>${STATUS_MESSAGE}</h2>
	        <form onsubmit="return confirmDelete()" action="${pageContext.request.contextPath}/update.html" method="post">
			<div class="box">
				<h1>Update</h1>
		            <label for="userid">User ID: </label>
		            <input type="text" id="userid" name="userid" class="userid"/><br/>
		            <label for="userid">Group ID: </label>
		            <input type="text" id="groupid" name="groupid" class="userid"/><br/>
		            <label for="userid">Password: </label>
		            <input type="password" id="password" name="password" class="password"/><br/>
		
		        <div><input type = "submit" class="button" value = "Update"/></div>
		            
	        </div>
	        </form>
        </div>
</body>
<script>
	function confirmDelete(){
		if(confirm("Are you sure?")) {
			return true;
		}
			return false;
	}
</script>
</html>