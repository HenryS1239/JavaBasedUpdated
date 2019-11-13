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
    		width:50%;
       	}
    	th, td{
    		text-align:center;
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
			  margin-top: 10px;
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
		.logoutLblPos {

			position: fixed;
			right: 10px;
			top: 5px;
		}
    </style>
</head>

<body>
    <h2>Group Table: </h2>
   	<h3>${STATUS_MESSAGE}</h3>
   	
   		<form onclick="parent.location='index.html'">
			<label class="logoutLblPos">
				<input name="submit" type="button" id="logout" class="button" value="Log Out">
			</label>
		</form>
		
	   <table border="2">
		<tr>
			<th>User ID</th>
			<th>Group ID</th>
			
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
			<tr><td><%=rs.getString("userid") %></td>
				<td><%=rs.getString("groupid") %></td></tr>
				
		<%
		}
		%>
		</table>
		
		<div>
			<input type="submit" value="Delete" class="button" onclick="parent.location='doDelete.html'">
			
			<input type="submit" value="Update" class="button" onclick="parent.location='doUpdate.html'">

			<input type="submit" value="Dummy" class="button" id="blah">
			
			<input type="submit" id="notify" value="Notify Me" class="button" disabled onclick="parent.location='doNotify.html'">
		</div>


		<%
			rs.close();
			stmt.close();
			conn.close();
		%>
</body>
<script src="<%=request.getContextPath() %>/resources/js/sockjs.min.js"></script>
<script defer src="<%=request.getContextPath() %>/resources/js/stomp.min.js"></script>
<script defer src="<%=request.getContextPath() %>/resources/js/message.js"></script>


</html>