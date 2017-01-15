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
	
	public List<PlayAreaInfo> getAll() 
			throws Exception {
		
		// create empty list
		List<PlayAreaInfo> theList = new ArrayList<>();
		
		// create JDBC objects
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
					
			// create a sql statement
			String sql = "SELECT * FROM kid_friendly_stl.play_area_information";
			stmt = conn.createStatement();
			
			// execute the query
			rs = stmt.executeQuery(sql);
			
			// process the ResultSet
			while (rs.next()) {
				// retrieve data and set params
				int businessID = rs.getInt("business_id");
				Boolean clean = rs.getBoolean("clean");
				if (rs.wasNull()) {
					clean = null;
				}
				boolean inside = rs.getBoolean("inside");
				boolean outside = rs.getBoolean("outside");
				Boolean gated = rs.getBoolean("gated");
				if (rs.wasNull()) {
					gated = null;
				}
				Boolean fun = rs.getBoolean("fun");
				if (rs.wasNull()) {
					fun = null;
				}
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	
	public PlayAreaInfo get(String theBusinessID) 
			throws Exception {
		
		// create an empty object & create int id
		PlayAreaInfo selectedRow;
		int businessID;
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// convert string to int for business id
			businessID = Integer.parseInt(theBusinessID);
			
			// get a connection
			conn = dataSource.getConnection();
			
			// create a PreparedStatement and set params
			String sql = "SELECT * FROM kid_friendly_stl.play_area_information WHERE business_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, businessID);
			
			// execute the query
			rs = stmt.executeQuery();
			
			//process the results
			if (rs.next()) {
				//retrieve data and assign to object params
				Boolean clean = rs.getBoolean("clean");
				if (rs.wasNull()) {
					clean = null;
				}
				boolean inside = rs.getBoolean("inside");
				boolean outside = rs.getBoolean("outside");
				Boolean gated = rs.getBoolean("gated");
				if (rs.wasNull()) {
					gated = null;
				}
				Boolean fun = rs.getBoolean("fun");
				if (rs.wasNull()) {
					fun = null;
				}
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	
	public void add(PlayAreaInfo newPlayAreaInfo) throws Exception {
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.play_area_information "
					+ "(business_id, clean, inside, outside, gated, fun) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setInt(1, newPlayAreaInfo.getBusinessID());
			if (newPlayAreaInfo.getClean() != null) {
				stmt.setBoolean(2, newPlayAreaInfo.getClean());
			} else {
				stmt.setNull(2, java.sql.Types.TINYINT);
			}
			stmt.setBoolean(3, newPlayAreaInfo.isInside());
			stmt.setBoolean(4, newPlayAreaInfo.isOutside());
			if (newPlayAreaInfo.getGated() != null) {
				stmt.setBoolean(5, newPlayAreaInfo.getGated());
			} else {
				stmt.setNull(5, java.sql.Types.TINYINT);
			}
			if (newPlayAreaInfo.getFun() != null) {
				stmt.setBoolean(6, newPlayAreaInfo.getFun());
			} else {
				stmt.setNull(6, java.sql.Types.TINYINT);
			}
			
			// execute INSERT
			stmt.execute();
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
	}
	
	public void update(PlayAreaInfo updatedPlayAreaInfo) throws Exception {
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.play_area_information "
					+ "SET clean=?, inside=?, outside=?, gated=?, fun=? "
					+ "WHERE business_id=?";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			if (updatedPlayAreaInfo.getClean() != null){
				stmt.setBoolean(1, updatedPlayAreaInfo.getClean());
			} else {
				stmt.setNull(1, java.sql.Types.TINYINT);
			}
			stmt.setBoolean(2, updatedPlayAreaInfo.isInside());
			stmt.setBoolean(3, updatedPlayAreaInfo.isOutside());
			if (updatedPlayAreaInfo.getGated() != null){
				stmt.setBoolean(4, updatedPlayAreaInfo.getGated());
			} else {
				stmt.setNull(4, java.sql.Types.TINYINT);
			}
			if (updatedPlayAreaInfo.getFun() != null){
				stmt.setBoolean(5, updatedPlayAreaInfo.getFun());
			} else {
				stmt.setNull(5, java.sql.Types.TINYINT);
			}
			stmt.setInt(6, updatedPlayAreaInfo.getBusinessID());
			
			// execute UPDATE
			stmt.execute();
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
	}
}
