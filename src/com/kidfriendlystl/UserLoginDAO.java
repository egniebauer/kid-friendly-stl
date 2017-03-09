package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

public class UserLoginDAO {

	private DataSource dataSource;

	public UserLoginDAO(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public boolean verifyUser(String userEmail, String userPassword) throws SQLException {
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
			if (rs.next()) {
				
				String hashed = rs.getString("password");
				// verify password
				if (BCrypt.checkpw(userPassword, hashed)) {
					return true;
				}
				else {
					// wrong password
					return false;
				}
			} else {
				// no user
				return false;
			}
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	

	public User get(String userEmail) throws Exception{
				
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
			String sql = "SELECT * FROM kid_friendly_stl.user_login WHERE email LIKE ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userEmail);
			
			// execute QUERY
			rs = stmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty User object
			if (rs.next()) {
				int userID = rs.getInt("id"); 
				boolean administrator = rs.getBoolean("admin"); 
				String email = rs.getString("email"); 
				String password = rs.getString("password");
				ArrayList<Integer> favorites = new ArrayList<Integer>(getFavorites(userID));
								
				theUser = new User(userID, administrator, email, password, favorites);
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

	private Collection<? extends Integer> getFavorites(int userID) throws SQLException {
				
		// create empty ArrayList
		ArrayList<Integer> favorites = new ArrayList<>();
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theUser
			String sql = "SELECT * FROM kid_friendly_stl.favorite WHERE id LIKE ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userID);
			
			// execute QUERY
			rs = stmt.executeQuery();

			// processes ResultSet
			while(rs.next()) {
				int businessID = rs.getInt("business_id");
				// add Student object to list
				favorites.add(businessID);
			}
			// return list
			return favorites;
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
