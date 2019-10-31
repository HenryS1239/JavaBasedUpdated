package com.learn.mvc.messaging;

import java.sql.*;

public class ClientInputBean {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "root";

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;
	String option;
	Double val;
	
	
	ResultSet results = null;
	Array users = null;
	
	public Array getUsers() {
		return users;
	}
	
	public ResultSet getResults() {
		return results;
	}

	public void searchUsers(String option, String value) {

		val = Double.parseDouble(value);
		Array users = null;
		try {

			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			String sql = "SELECT * FROM notifyreq WHERE option = ? and value >= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, option);
			ps.setDouble(2, val);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				users = rs.getArray("token");
			}
			results = rs;

			rs.close();
			stmt.close();
			conn.close();

			this.users = users;

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		}

	}

}
