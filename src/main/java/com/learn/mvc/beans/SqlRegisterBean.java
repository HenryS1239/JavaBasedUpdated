package com.learn.mvc.beans;

import java.sql.*;


public class SqlRegisterBean {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "root";
	
	public void registerDB(String userId, String grpId, String pword) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM userinfo";
			ResultSet rs= stmt.executeQuery(sql);
	
			String query = "INSERT INTO userinfo VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2, grpId);
			ps.setString(3, pword);
			
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
	     
		}finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	    	 
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	       
	      }//end finally try
	   }//end try
		
	}

}
