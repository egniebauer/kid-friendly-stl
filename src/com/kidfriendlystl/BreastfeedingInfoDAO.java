package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class BreastfeedingInfoDAO {

	private DataSource dataSource;

	public BreastfeedingInfoDAO(DataSource theDataSource) {
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

	public List<BreastfeedingInfo> getAll() 
			throws Exception {
		
		// create empty list
		List<BreastfeedingInfo> theList = new ArrayList<>();
		
		// create JDBC objects
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.breastfeeding_information";
			myStmt = myConn.createStatement();
			
			// execute query
			myRS = myStmt.executeQuery(sql);
			
			// process result set
			while (myRS.next()){
				//retrieve data from ResultSet row
				int businessID = myRS.getInt("business_id");
				boolean clean = myRS.getBoolean("clean");
				boolean comfortable = myRS.getBoolean("comfortable");
				boolean bottleWarmer = myRS.getBoolean("bottle_warmer");
				boolean lactationRoom = myRS.getBoolean("lactation_room");
				boolean quietArea = myRS.getBoolean("quiet_area");
				boolean grossOpts = myRS.getBoolean("gross_opts");
				boolean nonSpecificOpts = myRS.getBoolean("non_specific_opts");
				
				//create my BreastfeedingInfo object
				BreastfeedingInfo currentRow = new BreastfeedingInfo(businessID, clean, comfortable, bottleWarmer,
						lactationRoom, quietArea, grossOpts, nonSpecificOpts);
				
				//add BreastfeedingInfo object to list
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
	
	public BreastfeedingInfo get(String theBusinessID) 
			throws Exception {
		
		// create empty BreastfeedingInfo and int businessID
		BreastfeedingInfo selectedRow = null;
		int businessID;
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// convert businessID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			myConn = dataSource.getConnection();
			
			// prepare a sql statement
			String sql = "SELECT * FROM kid_friendly_stl.breastfeeding_information WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute the query
			myRS = myStmt.executeQuery();
			
			// process the ResultSet
			if (myRS.next()){
				//retrieve data and assign to object params
				boolean clean = myRS.getBoolean("clean");
				boolean comfortable = myRS.getBoolean("comfortable");
				boolean bottleWarmer = myRS.getBoolean("bottle_warmer");
				boolean lactationRoom = myRS.getBoolean("lactation_room");
				boolean quietArea = myRS.getBoolean("quiet_area");
				boolean grossOpts = myRS.getBoolean("gross_opts");
				boolean nonSpecificOpts = myRS.getBoolean("non_specific_opts");
				
				// pass params to empty BreastfeedingInfo object
				selectedRow = new BreastfeedingInfo(businessID, clean, comfortable, bottleWarmer,
						lactationRoom, quietArea, grossOpts, nonSpecificOpts);
			}
			else {
				throw new Exception("Could not find breastfeeding info id: " + businessID);
			}
			// return the BreastfeedingInfo object
			return selectedRow;
		}
		finally {
			// close our JDBC objects
		}
	}
	
	public void add(BreastfeedingInfo newBreastfeedingInfo) 
			throws Exception {
		
		//create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get connection
			myConn = dataSource.getConnection();
			
		//create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.breastfeeding_information "
					+ "(business_id, clean, comfortable, bottle_warmer, lactation_room, quiet_area, gross_opts, non_specific_opts) " 
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);
			
		//set parameters for PreparedStatment
			myStmt.setInt(1, newBreastfeedingInfo.getBusinessID());
			myStmt.setBoolean(2, newBreastfeedingInfo.isClean());
			myStmt.setBoolean(3, newBreastfeedingInfo.isComfortable());
			myStmt.setBoolean(4, newBreastfeedingInfo.isBottleWarmer());
			myStmt.setBoolean(5, newBreastfeedingInfo.isLactationRoom());
			myStmt.setBoolean(6, newBreastfeedingInfo.isQuietArea());
			myStmt.setBoolean(7, newBreastfeedingInfo.isGrossOpts());
			myStmt.setBoolean(8, newBreastfeedingInfo.isNonSpecificOpts());
			
		//execute query
			myStmt.execute();
		}
		finally {
		//close JDBC objects
			close(myConn, myStmt, null);
		}
	}
	
	public void update(BreastfeedingInfo updatedBreastfeedingInfo) throws Exception {
		
		//create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get connection
			myConn = dataSource.getConnection();
			
		//create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.breastfeeding_information "
					+ "SET clean=?, comfortable=?, bottle_warmer=?, lactation_room=?, quiet_area=?, gross_opts=?, non_specific_opts=? " 
					+ "WHERE business_id=?";

			myStmt = myConn.prepareStatement(sql);
			
		//set parameters for PreparedStatment
			myStmt.setBoolean(1, updatedBreastfeedingInfo.isClean());
			myStmt.setBoolean(2, updatedBreastfeedingInfo.isComfortable());
			myStmt.setBoolean(3, updatedBreastfeedingInfo.isBottleWarmer());
			myStmt.setBoolean(4, updatedBreastfeedingInfo.isLactationRoom());
			myStmt.setBoolean(5, updatedBreastfeedingInfo.isQuietArea());
			myStmt.setBoolean(6, updatedBreastfeedingInfo.isGrossOpts());
			myStmt.setBoolean(7, updatedBreastfeedingInfo.isNonSpecificOpts());
			myStmt.setInt(8, updatedBreastfeedingInfo.getBusinessID());
			
		//execute query
			myStmt.execute();
		}
		finally {
		//close JDBC objects
			close(myConn, myStmt, null);
		}
	}
}
