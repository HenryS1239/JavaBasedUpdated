package com.learn.mvc.messaging;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientInputBean {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "root";

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;

	ResultSet results = null;
	String[] users = null;
	List<String> usertokens = new ArrayList<String>();

	public String[] getUsers() {
		return users;
	}

	public ResultSet getResults() {
		return results;
	}

	public List<String> searchUsers(String option, String value) {
		
		double val = Double.parseDouble(value);
		val++;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			String sql = "SELECT token FROM notifyreq WHERE actiontype = ? AND value < ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, option);
			ps.setDouble(2, val);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				usertokens.add(rs.getString(1));
			}
			
			for (int i = 0; rs.next(); i++) {
				users[i] = rs.getString(1);
			}

			results = rs;

			rs.close();
			stmt.close();
			conn.close();
			return usertokens;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			return null;

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return null;

		}

	}
	
	public void deleteRecord(String token) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;

		try {

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			String query = "DELETE FROM notifyreq WHERE token = ? ";
			ps = conn.prepareStatement(query);
			ps.setString(1, token);

			ps.executeUpdate();

			stmt.close();
			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		} 

	}

}
