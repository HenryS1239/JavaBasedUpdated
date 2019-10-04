package com.learn.mvc.beans;

import java.sql.*;

public class SqlSearchBean {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "root";

	public boolean searchDB(String userId, String grpId, String pword) {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
	
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM userinfo";
			ResultSet rs= stmt.executeQuery(sql);
	
			boolean check = false;
	
			while(rs.next()){
	
				String uID = rs.getString("userid");
				String gID = rs.getString("groupid");
				String pwd = rs.getString("password");
	
				if(userId.equals(uID) && grpId.equals(gID) && pword.equals(pwd)){
					check = true;
				}	
			}
	
			rs.close();
			stmt.close();
			conn.close();
			return check;
		}catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	      return false;
		}catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	      return false;
		}finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	    	  return false;
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	         return false;
	      }//end finally try
	   }//end try
}

}