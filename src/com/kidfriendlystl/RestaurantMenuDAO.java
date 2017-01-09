package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class RestaurantMenuDAO {

	private DataSource dataSource;

	public RestaurantMenuDAO(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRS) {
		try {
			if (myRS != null) {
				myRS.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();	// doesn't really close ... returns it to connection pool
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<RestaurantMenu> getAll() {
		//TODO
		return null;
	}
	
	public RestaurantMenu get(String theBusinessID) {
		//TODO
		return null;
	}
	
	public void add(RestaurantMenu newRestaurantMenu) {
		//TODO
	}
	
	public void update(RestaurantMenu updatedRestaurantMenu) {
		//TODO
	}
}
