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
		List<BreastfeedingInfo> breastfeedingInfo = new ArrayList<>();
		
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
				BreastfeedingInfo currentBreastfeedingInfo = new BreastfeedingInfo(businessID, clean, comfortable, bottleWarmer,
						lactationRoom, quietArea, grossOpts, nonSpecificOpts);
				
				//add BreastfeedingInfo object to list
				breastfeedingInfo.add(currentBreastfeedingInfo);
			}
			// return list
			return breastfeedingInfo;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}
	
	public BreastfeedingInfo get(String theBusinessID) 
			throws Exception {
		
		// create empty BreastfeedingInfo and int businessID
		BreastfeedingInfo theBreastfeedingInfo = null;
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
				boolean clean = myRS.getBoolean("clean");
				boolean comfortable = myRS.getBoolean("comfortable");
				boolean bottleWarmer = myRS.getBoolean("bottle_warmer");
				boolean lactationRoom = myRS.getBoolean("lactation_room");
				boolean quietArea = myRS.getBoolean("quiet_area");
				boolean grossOpts = myRS.getBoolean("gross_opts");
				boolean nonSpecificOpts = myRS.getBoolean("non_specific_opts");
				
				// assign to empty BreastfeedingInfo object
				theBreastfeedingInfo = new BreastfeedingInfo(businessID, clean, comfortable, bottleWarmer,
						lactationRoom, quietArea, grossOpts, nonSpecificOpts);
			}
			else {
				throw new Exception("Could not find breastfeeding info id: " + businessID);
			}
			// return the BreastfeedingInfo object
			return theBreastfeedingInfo;
		}
		finally {
			// close our JDBC objects
		}
	}
	
	public void add(BreastfeedingInfo newBreastfeedingInfo) {
		//TODO
	}
	
	public void update(BreastfeedingInfo updatedBreastfeedingInfo) {
		//TODO
	}
}
