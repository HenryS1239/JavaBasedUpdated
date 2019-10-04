package com.learn.mvc.beans;

import java.sql.*;

public class SqlDeleteBean {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "root";

	public void deleteDB(String userId) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;

		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sql);

			String query = "DELETE FROM user WHERE userid = '" + userId + "'";
			ps = conn.prepareStatement(query);

			ps.executeUpdate();

			rs.close();
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