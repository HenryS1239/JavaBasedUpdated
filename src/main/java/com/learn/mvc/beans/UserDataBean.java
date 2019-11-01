package com.learn.mvc.beans;

import java.sql.*;

public class UserDataBean
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "root";
	
	public void userDB(String acc_no, String option, String amt) {
		// TODO Auto-generated method stub
		
		String userDep = new String("Deposit");
        String userWith = new String("Withdraw");
        int amount = Integer.parseInt(amt);
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		
		try{
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			
			String sql = "SELECT acc_no, deposit, withdraw, balance FROM action where acc_no = ?";
			ps1 = conn.prepareStatement(sql);
			ps1.setString(1, acc_no);
			
			ResultSet rs = ps1.executeQuery();
			
			while(rs.next())
			{
				float balance = 0;
				balance = rs.getFloat("balance");
				
				if(option.equalsIgnoreCase(userDep)) 
				{
					balance = balance + amount;
					String query = "UPDATE action SET deposit = ?, balance = ? where acc_no = ?";
					ps = conn.prepareStatement(query);
					ps.setFloat(1, amount);
					ps.setFloat(2, balance);
					ps.setString(3, acc_no);
				}
				else if(option.equalsIgnoreCase(userWith))
				{
					balance = balance - amount;
					String query1 = "UPDATE action SET withdraw = ?, balance = ? where acc_no = ?";
					ps = conn.prepareStatement(query1);
					ps.setFloat(1, amount);
					ps.setFloat(2, balance);
					ps.setString(3, acc_no);
				}
					
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
		}
	}
}
