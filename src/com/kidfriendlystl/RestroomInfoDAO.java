package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class RestroomInfoDAO {

	private DataSource dataSource;

	public RestroomInfoDAO(DataSource theDataSource) {
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

	public List<RestroomInfo> getAll() throws Exception {
		// create empty list
		List<RestroomInfo> theList = new ArrayList<>();
		
		// create JDBC objects
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
					
			// create a sql statement
			String sql = "SELECT * FROM kid_friendly_stl.restroom_information";
			myStmt = myConn.createStatement();
			
			// execute the query
			myRS = myStmt.executeQuery(sql);
			
			// process the ResultSet
			while (myRS.next()) {
				// retrieve data and set params
				int businessID = myRS.getInt("business_id");
				boolean clean = myRS.getBoolean("clean");
				boolean toddlerSeat = myRS.getBoolean("toddler_seat");
				boolean handDryer = myRS.getBoolean("hand_dryer");
				boolean womensRoom = myRS.getBoolean("womens_room");
				boolean mensRoom = myRS.getBoolean("mens_room");
				boolean familyRoom = myRS.getBoolean("family_room");
				boolean noChangingTable = myRS.getBoolean("no_changing_table");
				
				// pass params to new object
				RestroomInfo currentRow = new RestroomInfo(businessID, clean, toddlerSeat, handDryer, womensRoom, mensRoom, familyRoom, noChangingTable);
				
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
	
	public RestroomInfo get(String theBusinessID) throws Exception {
		// create an empty object & create int id
		RestroomInfo selectedRow;
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
			
			// create a PreparedStatement
			String sql = "SELECT * FROM kid_friendly_stl.restroom_information WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute the query
			myRS = myStmt.executeQuery();
			
			//process the results
			if (myRS.next()) {
				//retrieve data and assign to variables
				businessID = myRS.getInt("business_id");
				boolean clean = myRS.getBoolean("clean");
				boolean toddlerSeat = myRS.getBoolean("toddler_seat");
				boolean handDryer = myRS.getBoolean("hand_dryer");
				boolean womensRoom = myRS.getBoolean("womens_room");
				boolean mensRoom = myRS.getBoolean("mens_room");
				boolean familyRoom = myRS.getBoolean("family_room");
				boolean noChangingTable = myRS.getBoolean("no_changing_table");
				
				// pass to empty object
				selectedRow = new RestroomInfo(businessID, clean, toddlerSeat, handDryer, womensRoom, mensRoom, familyRoom, noChangingTable);
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
	
	public void add(RestroomInfo newRestroomInfo) throws Exception {
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.restroom_information "
					+ "(business_id, clean, toddler_seat, hand_dryer, womens_room, mens_room, family_room, no_changing_table) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setInt(1, newRestroomInfo.getBusinessID());
			myStmt.setBoolean(2, newRestroomInfo.isClean());
			myStmt.setBoolean(3, newRestroomInfo.isToddlerSeat());
			myStmt.setBoolean(4, newRestroomInfo.isHandDryer());
			myStmt.setBoolean(5, newRestroomInfo.isWomensRoom());
			myStmt.setBoolean(6, newRestroomInfo.isMensRoom());
			myStmt.setBoolean(7, newRestroomInfo.isFamilyRoom());
			myStmt.setBoolean(8, newRestroomInfo.isNoChangingTable());

			// execute INSERT
			myStmt.execute();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
	}
	
	public void update(RestroomInfo updatedRestroomInfo) throws Exception {
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.restroom_information "
					+ "SET clean=?, toddler_seat=?, hand_dryer=?, womens_room=?, mens_room=?, family_room=?, no_changing_table=? "
					+ "WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			
			// set params values
			myStmt.setBoolean(1, updatedRestroomInfo.isClean());
			myStmt.setBoolean(2, updatedRestroomInfo.isToddlerSeat());
			myStmt.setBoolean(3, updatedRestroomInfo.isHandDryer());
			myStmt.setBoolean(4, updatedRestroomInfo.isWomensRoom());
			myStmt.setBoolean(5, updatedRestroomInfo.isMensRoom());
			myStmt.setBoolean(6, updatedRestroomInfo.isFamilyRoom());
			myStmt.setBoolean(7, updatedRestroomInfo.isNoChangingTable());
			myStmt.setInt(8, updatedRestroomInfo.getBusinessID());

			// execute UPDATE
			myStmt.execute();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
	}
}
