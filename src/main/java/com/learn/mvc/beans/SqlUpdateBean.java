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
	
	private boolean check = false;
	
	public boolean updateDB(String userId, String grpId, String pword) {
	
		try{
			
			Class.forName(JDBC_DRIVER);
	
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM userinfo";
			ResultSet rs= stmt.executeQuery(sql);
				
			String uID = rs.getString("userid");

			if(userId.equals(uID)) {
				String query = "UPDATE userinfo SET groupid = ?, password= ? WHERE ID = ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, grpId);
				ps.setString(2, pword);
				ps.setString(3, userId);
			}
			
			if(ps.executeUpdate() == 1)
				check = true;
	
			rs.close();
			stmt.close();
			conn.close();
			
			return check;

		}catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	      return check;
	
		}catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	      return check;
	     
		}
		
	}
		
}


