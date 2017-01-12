package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.kidfriendlystl.DatabaseUtils;

import javax.sql.DataSource;


public class AgeRangeDAO {

	private DataSource dataSource;

	public AgeRangeDAO(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<AgeRange> getAll() 
			throws Exception {
		
		// create empty list
		List<AgeRange> ages = new ArrayList<>();
		
		// create JDBC objects
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.age_range";
			stmt = conn.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result set
			while (rs.next()){
				//retrieve data from ResultSet row
				int businessID = rs.getInt("business_id");
				boolean baby = rs.getBoolean("baby");
				boolean gradeSchooler = rs.getBoolean("grade_schooler");
				boolean preschooler = rs.getBoolean("preschooler");
				boolean teen = rs.getBoolean("teen");
				boolean toddler = rs.getBoolean("toddler");
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

	public AgeRange get(String theBusinessID) 
			throws Exception {
		
		// create empty AgeRange and int businessID
		AgeRange theAgeRange = null;
		int businessID;
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// convert theBusinesstID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theAgeRage
			String sql = "SELECT * FROM kid_friendly_stl.age_range WHERE business_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, businessID);
			
			// execute QUERY
			rs = stmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty AgeRange
			if (rs.next()) {
				boolean baby = rs.getBoolean("baby");
				boolean toddler = rs.getBoolean("toddler");
				boolean preschooler = rs.getBoolean("preschooler");
				boolean gradeSchooler = rs.getBoolean("grade_schooler");
				boolean teen = rs.getBoolean("teen");
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

	public void add(AgeRange newAgeRange) 
			throws Exception {
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.age_range "
					+ "(business_id, baby, toddler, preschooler, grade_schooler, teen) "
					+ "values (?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setInt(1, newAgeRange.getBusinessID());
			stmt.setBoolean(2, newAgeRange.isBaby());
			stmt.setBoolean(3, newAgeRange.isToddler());
			stmt.setBoolean(4, newAgeRange.isPreschooler());
			stmt.setBoolean(5, newAgeRange.isGradeSchooler());
			stmt.setBoolean(6, newAgeRange.isTeen());
			
			// execute SQL INSERT
			stmt.execute();			
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);			
		}
		
	}

	public void update(AgeRange updatedAgeRange) 
			throws Exception {
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.age_range "
					+ "SET baby=?, toddler=?, preschooler=?, grade_schooler=?, teen=? "
					+ "WHERE business_id=?";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setBoolean(1, updatedAgeRange.isBaby());
			stmt.setBoolean(2, updatedAgeRange.isToddler());
			stmt.setBoolean(3, updatedAgeRange.isPreschooler());
			stmt.setBoolean(4, updatedAgeRange.isGradeSchooler());
			stmt.setBoolean(5, updatedAgeRange.isTeen());
			stmt.setInt(6, updatedAgeRange.getBusinessID());
			
			// execute SQL INSERT
			stmt.execute();			
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);			
		}
	}
}
