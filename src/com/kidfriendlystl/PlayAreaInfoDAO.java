package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class PlayAreaInfoDAO {

	private DataSource dataSource;

	public PlayAreaInfoDAO(DataSource theDataSource) {
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

	public List<PlayAreaInfo> getAll() 
			throws Exception {
		
		// create empty list
		List<PlayAreaInfo> theList = new ArrayList<>();
		
		// create JDBC objects
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
					
			// create a sql statement
			String sql = "SELECT * FROM kid_friendly_stl.play_area_information";
			myStmt = myConn.createStatement();
			
			// execute the query
			myRS = myStmt.executeQuery(sql);
			
			// process the ResultSet
			while (myRS.next()) {
				// retrieve data and set params
				int businessID = myRS.getInt("business_id");
				boolean clean = myRS.getBoolean("clean");
				boolean inside = myRS.getBoolean("inside");
				boolean outside = myRS.getBoolean("outside");
				boolean gated = myRS.getBoolean("gated");
				boolean fun = myRS.getBoolean("fun");
				
				// pass params to new object
				PlayAreaInfo currentRow = new PlayAreaInfo(businessID, clean, inside, outside, gated, fun);
				
				// add object to list
				theList.add(currentRow);
			}
			// return list
			return theList;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}
	
	public PlayAreaInfo get(String theBusinessID) 
			throws Exception {
		
		// create an empty object & create int id
		PlayAreaInfo selectedRow;
		int businessID;
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// convert string to int for business id
			businessID = Integer.parseInt(theBusinessID);
			
			// get a connection
			myConn = dataSource.getConnection();
			
			// create a PreparedStatement and set params
			String sql = "SELECT * FROM kid_friendly_stl.play_area_information WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute the query
			myRS = myStmt.executeQuery();
			
			//process the results
			if (myRS.next()) {
				//retrieve data and assign to object params
				boolean clean = myRS.getBoolean("clean");
				boolean inside = myRS.getBoolean("inside");
				boolean outside = myRS.getBoolean("outside");
				boolean gated = myRS.getBoolean("gated");
				boolean fun = myRS.getBoolean("fun");
				
				// pass params to empty object
				selectedRow = new PlayAreaInfo(businessID, clean, inside, outside, gated, fun); 
			}
			else {
				throw new Exception ("Could not find play area id: " + businessID);
			}
			// return object
			return selectedRow;
			
		}
		finally{
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}
	
	public void add(PlayAreaInfo newPlayAreaInfo) throws Exception {
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.play_area_information "
					+ "(business_id, clean, inside, outside, gated, fun) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setInt(1, newPlayAreaInfo.getBusinessID());
			myStmt.setBoolean(2, newPlayAreaInfo.isClean());
			myStmt.setBoolean(3, newPlayAreaInfo.isInside());
			myStmt.setBoolean(4, newPlayAreaInfo.isOutside());
			myStmt.setBoolean(5, newPlayAreaInfo.isGated());
			myStmt.setBoolean(6, newPlayAreaInfo.isFun());
			
			// execute INSERT
			myStmt.execute();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
	}
	
	public void update(PlayAreaInfo updatedPlayAreaInfo) throws Exception {
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.play_area_information "
					+ "SET clean=?, inside=?, outside=?, gated=?, fun=? "
					+ "WHERE business_id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setBoolean(1, updatedPlayAreaInfo.isClean());
			myStmt.setBoolean(2, updatedPlayAreaInfo.isInside());
			myStmt.setBoolean(3, updatedPlayAreaInfo.isOutside());
			myStmt.setBoolean(4, updatedPlayAreaInfo.isGated());
			myStmt.setBoolean(5, updatedPlayAreaInfo.isFun());
			myStmt.setInt(6, updatedPlayAreaInfo.getBusinessID());
			
			// execute UPDATE
			myStmt.execute();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
	}
}
