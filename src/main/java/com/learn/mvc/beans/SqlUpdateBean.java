package com.learn.mvc.beans;

import java.sql.*;


public class SqlUpdateBean {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "root";
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;
	
	public void updateDB(String userId, String grpId, String pword) {
	
		try{
			
			Class.forName(JDBC_DRIVER);
	
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM userinfo";
			ResultSet rs= stmt.executeQuery(sql);
		
			String query = "UPDATE userinfo SET groupid = ?, password= ? where userid = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, grpId);
			ps.setString(2, pword);
			ps.setString(3, userId);
			
		
			ps.executeUpdate();
	
			rs.close();
			stmt.close();
			conn.close();
			
			

		}catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	      
	
		}catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	      
	     
		}
		
	}
		
}


