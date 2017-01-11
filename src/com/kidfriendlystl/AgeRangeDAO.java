package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class AgeRangeDAO {

	private DataSource dataSource;

	public AgeRangeDAO(DataSource theDataSource) {
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

	public List<AgeRange> getAll() 
			throws Exception {
		
		// create empty list
		List<AgeRange> ages = new ArrayList<>();
		
		// create JDBC objects
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.age_range";
			myStmt = myConn.createStatement();

			// execute query
			myRS = myStmt.executeQuery(sql);

			// process result set
			while (myRS.next()){
				//retrieve data from ResultSet row
				int businessID = myRS.getInt("business_id");
				boolean baby = myRS.getBoolean("baby");
				boolean gradeSchooler = myRS.getBoolean("grade_schooler");
				boolean preschooler = myRS.getBoolean("preschooler");
				boolean teen = myRS.getBoolean("teen");
				boolean toddler = myRS.getBoolean("toddler");
				
				// create new AgeRange object
				AgeRange currentAgeRange = new AgeRange(businessID, baby, toddler, preschooler,
						 gradeSchooler, teen);
				
				// add AgeRange object to list
				ages.add(currentAgeRange);
			}
			// return list
			return ages;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}

	public AgeRange get(String theBusinessID) 
			throws Exception {
		
		// create empty AgeRange and int businessID
		AgeRange theAgeRange = null;
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
			
			// create PreparedStatement SELECT theAgeRage
			String sql = "SELECT * FROM kid_friendly_stl.age_range WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute QUERY
			myRS = myStmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty AgeRange
			if (myRS.next()) {
				boolean baby = myRS.getBoolean("baby");
				boolean toddler = myRS.getBoolean("toddler");
				boolean preschooler = myRS.getBoolean("preschooler");
				boolean gradeSchooler = myRS.getBoolean("grade_schooler");
				boolean teen = myRS.getBoolean("teen");
				
				theAgeRange = new AgeRange(businessID, baby, toddler, preschooler,
						gradeSchooler, teen);
			}
			else {
				throw new Exception("Could not find age rage id: " + businessID);
			}
			
			// return AgeRage
			return theAgeRange;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}

	public void add(AgeRange newAgeRange) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.age_range "
					+ "(business_id, baby, toddler, preschooler, grade_schooler, teen) "
					+ "values (?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setInt(1, newAgeRange.getBusinessID());
			myStmt.setBoolean(2, newAgeRange.isBaby());
			myStmt.setBoolean(3, newAgeRange.isToddler());
			myStmt.setBoolean(4, newAgeRange.isPreschooler());
			myStmt.setBoolean(5, newAgeRange.isGradeSchooler());
			myStmt.setBoolean(6, newAgeRange.isTeen());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
		
	}

	public void update(AgeRange updatedAgeRange) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.age_range "
					+ "SET baby=?, toddler=?, preschooler=?, grade_schooler=?, teen=? "
					+ "WHERE business_id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setBoolean(1, updatedAgeRange.isBaby());
			myStmt.setBoolean(2, updatedAgeRange.isToddler());
			myStmt.setBoolean(3, updatedAgeRange.isPreschooler());
			myStmt.setBoolean(4, updatedAgeRange.isGradeSchooler());
			myStmt.setBoolean(5, updatedAgeRange.isTeen());
			myStmt.setInt(6, updatedAgeRange.getBusinessID());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
		
	}


}
