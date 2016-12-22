package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;


public class KidFriendlyDetailDAO {

	private DataSource dataSource;

	public KidFriendlyDetailDAO(DataSource theDataSource) {
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

	public KidFriendlyDetail get(String theBusinessID) 
			throws Exception {
		
		// create empty KidFriendlyDetail and int businessID
		KidFriendlyDetail theKidFriendlyDetail = null;
		int businessID;
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// convert theBusinesstID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theKidFriendlyDetail
			String sql = "SELECT * FROM kid_friendly_stl.kid_friendly_detail WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute QUERY
			myRS = myStmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty AgeRange
			if (myRS.next()) {
				boolean multipleFamilies = myRS.getBoolean("multiple_families");
				boolean allDay = myRS.getBoolean("all_day");
				boolean morning = myRS.getBoolean("morning");
				boolean afternoon = myRS.getBoolean("afternoon"); 
				boolean evening = myRS.getBoolean("evening"); 
				boolean kidsFreeDiscount = myRS.getBoolean("kids_free_discount");
				String kidsFreeDiscountDetail = myRS.getString("kids_free_discount_detail");
				
				theKidFriendlyDetail = new KidFriendlyDetail(businessID, multipleFamilies, allDay, morning,
						afternoon, evening, kidsFreeDiscount, kidsFreeDiscountDetail);
			}
			else {
				throw new Exception("Could not find kid friendly detail id: " + businessID);
			}
			
			// return AgeRage
			return theKidFriendlyDetail;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}

	public void add(KidFriendlyDetail newKidFriendlyDetail) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.kid_friendly_detail "
					+ "(business_id, multiple_families, all_day, morning, afternoon, evening, kids_free_discount, kids_free_discount_detail) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setInt(1, newKidFriendlyDetail.getBusinessID());
			myStmt.setBoolean(2, newKidFriendlyDetail.isMultipleFamilies());
			myStmt.setBoolean(3, newKidFriendlyDetail.isAllDay());
			myStmt.setBoolean(4, newKidFriendlyDetail.isMorning());
			myStmt.setBoolean(5, newKidFriendlyDetail.isAfternoon());
			myStmt.setBoolean(6, newKidFriendlyDetail.isEvening());
			myStmt.setBoolean(7, newKidFriendlyDetail.isKidsFreeDiscount());
			myStmt.setString(8, newKidFriendlyDetail.getKidsFreeDiscountDetail());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
		
	}
	
	public void update(KidFriendlyDetail updatedKidFriendlyDetail) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.kid_friendly_detail "
					+ "SET multiple_families=?, all_day=?, morning=?, afternoon=?, evening=?, kids_free_discount=?, kids_free_discount_detail=? "
					+ "WHERE business_id=? ";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setBoolean(1, updatedKidFriendlyDetail.isMultipleFamilies());
			myStmt.setBoolean(2, updatedKidFriendlyDetail.isAllDay());
			myStmt.setBoolean(3, updatedKidFriendlyDetail.isMorning());
			myStmt.setBoolean(4, updatedKidFriendlyDetail.isAfternoon());
			myStmt.setBoolean(5, updatedKidFriendlyDetail.isEvening());
			myStmt.setBoolean(6, updatedKidFriendlyDetail.isKidsFreeDiscount());
			myStmt.setString(7, updatedKidFriendlyDetail.getKidsFreeDiscountDetail());
			myStmt.setInt(8, updatedKidFriendlyDetail.getBusinessID());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
	}


}
