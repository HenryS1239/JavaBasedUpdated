package com.learn.mvc.beans;

import java.sql.*;


public class SqlTransactionBean {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "root";
	
	public void transDB(String option, String amount) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		double value = Double.parseDouble(amount);
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM transaction";
			ResultSet rs= stmt.executeQuery(sql);
			
			if (option.equalsIgnoreCase("Deposit")) {
				String query = "INSERT INTO transaction (deposit, withdraw) VALUES(?,?)";
				ps = conn.prepareStatement(query);
				ps.setDouble(1, value);
				ps.setDouble(2, 0);
			}
			
			else if (option.equalsIgnoreCase("Withdraw")) {
				String query = "INSERT INTO transaction (deposit, withdraw) VALUES(?, ?)";
				ps = conn.prepareStatement(query);
				ps.setDouble(1,0);
				ps.setDouble(2, value);
			}
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
