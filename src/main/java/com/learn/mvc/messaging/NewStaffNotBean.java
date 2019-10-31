package com.learn.mvc.messaging;

import java.sql.*;

import com.learn.mvc.messaging.GenerateToken;
import com.learn.mvc.messaging.NotifyBean;

public class NewStaffNotBean {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "root";
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;


	public void registerNotify(NotifyBean Staff) {

		NotifyBean details = Staff;

		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM notifyreq";
			ResultSet rs = stmt.executeQuery(sql);

			String query = "INSERT INTO notifyreq VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, details.getUserid());
			ps.setString(2, details.getGroupid());
			ps.setString(3, details.getToken());
			ps.setString(4, details.getOption());
			ps.setString(5, details.getValue());

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

		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();

			} // end finally try
		} // end try

	}

	
	public String genToken() {
		return new GenerateToken().getToken();
	}
	
}

