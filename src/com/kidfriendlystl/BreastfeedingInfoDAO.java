package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.kidfriendlystl.DatabaseUtils;

import javax.sql.DataSource;


public class BreastfeedingInfoDAO {

	private DataSource dataSource;

	public BreastfeedingInfoDAO(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}

	public List<BreastfeedingInfo> getAll() 
			throws Exception {
		
		// create empty list
		List<BreastfeedingInfo> theList = new ArrayList<>();
		
		// create JDBC objects
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.breastfeeding_information";
			stmt = conn.createStatement();
			
			// execute query
			rs = stmt.executeQuery(sql);
			
			// process result set
			while (rs.next()){
				//retrieve data from ResultSet row
				int businessID = rs.getInt("business_id");
				Boolean clean = rs.getBoolean("clean");
				if (rs.wasNull()){
					clean = null;
				}
				Boolean comfortable = rs.getBoolean("comfortable");
				if (rs.wasNull()){
					comfortable = null;
				}
				Boolean bottleWarmer = rs.getBoolean("bottle_warmer");
				if (rs.wasNull()){
					comfortable = null;
				}
				boolean lactationRoom = rs.getBoolean("lactation_room");
				boolean quietArea = rs.getBoolean("quiet_area");
				boolean grossOpts = rs.getBoolean("gross_opts");
				boolean nonSpecificOpts = rs.getBoolean("non_specific_opts");
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	
	public BreastfeedingInfo get(String theBusinessID) 
			throws Exception {
		
		// create empty BreastfeedingInfo and int businessID
		BreastfeedingInfo selectedRow = null;
		int businessID;
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// convert businessID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			conn = dataSource.getConnection();
			
			// prepare a sql statement
			String sql = "SELECT * FROM kid_friendly_stl.breastfeeding_information WHERE business_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, businessID);
			
			// execute the query
			rs = stmt.executeQuery();
			
			// process the ResultSet
			if (rs.next()){
				//retrieve data and assign to object params
				Boolean clean = rs.getBoolean("clean");
				if (rs.wasNull()){
					clean = null;
				}
				Boolean comfortable = rs.getBoolean("comfortable");
				if (rs.wasNull()){
					comfortable = null;
				}
				Boolean bottleWarmer = rs.getBoolean("bottle_warmer");
				if (rs.wasNull()){
					comfortable = null;
				}
				boolean lactationRoom = rs.getBoolean("lactation_room");
				boolean quietArea = rs.getBoolean("quiet_area");
				boolean grossOpts = rs.getBoolean("gross_opts");
				boolean nonSpecificOpts = rs.getBoolean("non_specific_opts");
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	
	public void add(BreastfeedingInfo newBreastfeedingInfo) 
			throws Exception {
		
		//create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
		//get connection
			conn = dataSource.getConnection();
			
		//create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.breastfeeding_information "
					+ "(business_id, clean, comfortable, bottle_warmer, lactation_room, quiet_area, gross_opts, non_specific_opts) " 
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			
		//set parameters for PreparedStatment
			stmt.setInt(1, newBreastfeedingInfo.getBusinessID());
			if (newBreastfeedingInfo.getClean() != null) {
				stmt.setBoolean(2, newBreastfeedingInfo.getClean());
			} else {
				stmt.setNull(2, java.sql.Types.TINYINT);
			}
			if (newBreastfeedingInfo.getComfortable() != null) {
				stmt.setBoolean(3, newBreastfeedingInfo.getComfortable());
			} else {
				stmt.setNull(3, java.sql.Types.TINYINT);
			}
			if (newBreastfeedingInfo.getBottleWarmer() != null) {
				stmt.setBoolean(4, newBreastfeedingInfo.getBottleWarmer());
			} else {
				stmt.setNull(4, java.sql.Types.TINYINT);
			}
			stmt.setBoolean(5, newBreastfeedingInfo.isLactationRoom());
			stmt.setBoolean(6, newBreastfeedingInfo.isQuietArea());
			stmt.setBoolean(7, newBreastfeedingInfo.isGrossOpts());
			stmt.setBoolean(8, newBreastfeedingInfo.isNonSpecificOpts());
			
		//execute query
			stmt.execute();
		}
		finally {
		//close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
	}
	
	public void update(BreastfeedingInfo updatedBreastfeedingInfo) throws Exception {
		
		//create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
		//get connection
			conn = dataSource.getConnection();
			
		//create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.breastfeeding_information "
					+ "SET clean=?, comfortable=?, bottle_warmer=?, lactation_room=?, quiet_area=?, gross_opts=?, non_specific_opts=? " 
					+ "WHERE business_id=?";

			stmt = conn.prepareStatement(sql);
			
		//set parameters for PreparedStatment
			if (updatedBreastfeedingInfo.getClean() != null) {
				stmt.setBoolean(1, updatedBreastfeedingInfo.getClean());
			} else {
				stmt.setNull(1, java.sql.Types.TINYINT);
			}
			if (updatedBreastfeedingInfo.getComfortable() != null) {
				stmt.setBoolean(2, updatedBreastfeedingInfo.getComfortable());
			} else {
				stmt.setNull(2, java.sql.Types.TINYINT);
			}
			if (updatedBreastfeedingInfo.getBottleWarmer() != null) {
				stmt.setBoolean(3, updatedBreastfeedingInfo.getBottleWarmer());
			} else {
				stmt.setNull(3, java.sql.Types.TINYINT);
			}
			stmt.setBoolean(4, updatedBreastfeedingInfo.isLactationRoom());
			stmt.setBoolean(5, updatedBreastfeedingInfo.isQuietArea());
			stmt.setBoolean(6, updatedBreastfeedingInfo.isGrossOpts());
			stmt.setBoolean(7, updatedBreastfeedingInfo.isNonSpecificOpts());
			stmt.setInt(8, updatedBreastfeedingInfo.getBusinessID());
			
		//execute query
			stmt.execute();
		}
		finally {
		//close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
	}
}
