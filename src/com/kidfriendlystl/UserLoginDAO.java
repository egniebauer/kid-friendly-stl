package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserLoginDAO {

	private DataSource dataSource;

	public UserLoginDAO(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public boolean verifyEmail(String userEmail) throws SQLException {
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			// get connection
			conn = dataSource.getConnection();
			
			// create SQL String and PreparedStatement to SELECT userEmail, if name matches
			String sql = "SELECT * FROM kid_friendly_stl.user_login WHERE email LIKE ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userEmail);

			// execute SQL statement
			rs = stmt.executeQuery();
			
			// return boolean
			// if there's a ResultSet: true, else: false
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

	public boolean verifyPassword(String userEmail, String userPassword) throws SQLException {
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			// get connection
			conn = dataSource.getConnection();
			
			// create SQL String and PreparedStatement to SELECT userEmail, if name matches
			String sql = "SELECT * FROM kid_friendly_stl.user_login WHERE email LIKE ? AND password LIKE ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userEmail);
			stmt.setString(2, userPassword);

			// execute SQL statement
			rs = stmt.executeQuery();
			
			// return boolean
			// if there's a ResultSet: true, else: false
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	

	public User get(String userEmail, String userPassword) throws Exception{
				
		// create empty USER
		User theUser = null;
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theUser
			String sql = "SELECT * FROM kid_friendly_stl.user_login WHERE email LIKE ? AND password LIKE ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userEmail);
			stmt.setString(2, userPassword);
			
			// execute QUERY
			rs = stmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty User object
			if (rs.next()) {
				int userID = rs.getInt("id"); 
				boolean administrator = rs.getBoolean("admin"); 
				String email = rs.getString("email"); 
				String password = rs.getString("password");
								
				theUser = new User(userID, administrator, email, password);
			}
			else {
				throw new Exception("Could not find user: " + userEmail);
			}
			
			// return Business
			return theUser;
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

	public void increaseLoginAttempts(String userEmail) throws SQLException {
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.user_login "
					+ "SET login_attempts = login_attempts + 1 "
					+ "WHERE email = ?";
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setString(1, userEmail);
			
			// execute SQL UPDATE
			stmt.execute();

		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
	}
	
}
