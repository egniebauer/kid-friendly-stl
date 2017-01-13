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
	
	public List<RestroomInfo> getAll() throws Exception {
		// create empty list
		List<RestroomInfo> theList = new ArrayList<>();
		
		// create JDBC objects
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
					
			// create a sql statement
			String sql = "SELECT * FROM kid_friendly_stl.restroom_information";
			stmt = conn.createStatement();
			
			// execute the query
			rs = stmt.executeQuery(sql);
			
			// process the ResultSet
			while (rs.next()) {
				// retrieve data and set params
				int businessID = rs.getInt("business_id");
				Boolean clean = null;
				if (rs.getBoolean("clean") == true || rs.getBoolean("clean") == false) {
					clean = rs.getBoolean("clean");
				}
				Boolean toddlerSeat = rs.getBoolean("toddler_seat");
				Boolean handDryer = rs.getBoolean("hand_dryer");
				boolean womensRoom = rs.getBoolean("womens_room");
				boolean mensRoom = rs.getBoolean("mens_room");
				boolean familyRoom = rs.getBoolean("family_room");
				boolean noChangingTable = rs.getBoolean("no_changing_table");
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	
	public RestroomInfo get(String theBusinessID) throws Exception {
		// create an empty object & create int id
		RestroomInfo selectedRow;
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
			
			// create a PreparedStatement
			String sql = "SELECT * FROM kid_friendly_stl.restroom_information WHERE business_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, businessID);
			
			// execute the query
			rs = stmt.executeQuery();
			
			//process the results
			if (rs.next()) {
				//retrieve data and assign to variables
				businessID = rs.getInt("business_id");
				Boolean clean = rs.getBoolean("clean");
				Boolean toddlerSeat = rs.getBoolean("toddler_seat");
				Boolean handDryer = rs.getBoolean("hand_dryer");
				boolean womensRoom = rs.getBoolean("womens_room");
				boolean mensRoom = rs.getBoolean("mens_room");
				boolean familyRoom = rs.getBoolean("family_room");
				boolean noChangingTable = rs.getBoolean("no_changing_table");
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	
	public void add(RestroomInfo newRestroomInfo) throws Exception {
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.restroom_information "
					+ "(business_id, clean, toddler_seat, hand_dryer, womens_room, mens_room, family_room, no_changing_table) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setInt(1, newRestroomInfo.getBusinessID());
			if (newRestroomInfo.getClean() != null) {
				stmt.setBoolean(2, newRestroomInfo.getClean());
			} else {
				stmt.setNull(2, java.sql.Types.TINYINT);
			}
			if (newRestroomInfo.getToddlerSeat() != null) {
				stmt.setBoolean(3, newRestroomInfo.getToddlerSeat());
			} else {
				stmt.setNull(3, java.sql.Types.TINYINT);
			}
			if (newRestroomInfo.getHandDryer() != null) {
				stmt.setBoolean(4, newRestroomInfo.getHandDryer());
			} else {
				stmt.setNull(4, java.sql.Types.TINYINT);
			}
			stmt.setBoolean(5, newRestroomInfo.isWomensRoom());
			stmt.setBoolean(6, newRestroomInfo.isMensRoom());
			stmt.setBoolean(7, newRestroomInfo.isFamilyRoom());
			stmt.setBoolean(8, newRestroomInfo.isNoChangingTable());

			// execute INSERT
			stmt.execute();
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
	}
	
	public void update(RestroomInfo updatedRestroomInfo) throws Exception {
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.restroom_information "
					+ "SET clean=?, toddler_seat=?, hand_dryer=?, womens_room=?, mens_room=?, family_room=?, no_changing_table=? "
					+ "WHERE business_id=?";
			stmt = conn.prepareStatement(sql);
			
			// set params values
			if (updatedRestroomInfo.getClean() != null) {
				stmt.setBoolean(1, updatedRestroomInfo.getClean());
			} else {
				stmt.setNull(1, java.sql.Types.TINYINT);
			}
			if (updatedRestroomInfo.getToddlerSeat() != null) {
				stmt.setBoolean(2, updatedRestroomInfo.getToddlerSeat());
			} else {
				stmt.setNull(2, java.sql.Types.TINYINT);
			}
			if (updatedRestroomInfo.getHandDryer() != null) {
				stmt.setBoolean(3, updatedRestroomInfo.getHandDryer());
			} else {
				stmt.setNull(3, java.sql.Types.TINYINT);
			}
			stmt.setBoolean(4, updatedRestroomInfo.isWomensRoom());
			stmt.setBoolean(5, updatedRestroomInfo.isMensRoom());
			stmt.setBoolean(6, updatedRestroomInfo.isFamilyRoom());
			stmt.setBoolean(7, updatedRestroomInfo.isNoChangingTable());
			stmt.setInt(8, updatedRestroomInfo.getBusinessID());

			// execute UPDATE
			stmt.execute();
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
	}
}
