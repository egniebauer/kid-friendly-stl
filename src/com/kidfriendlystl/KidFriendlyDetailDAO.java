package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kidfriendlystl.DatabaseUtils;

import javax.sql.DataSource;


public class KidFriendlyDetailDAO {

	private DataSource dataSource;

	public KidFriendlyDetailDAO(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}

	public List<KidFriendlyDetail> getAll() throws Exception {
		//create empty list
		List<KidFriendlyDetail> theList = new ArrayList<>();
		
		//create JDBC objects
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//get conn
			conn = dataSource.getConnection();
			
			//create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.kid_friendly_detail";
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process rs
			while(rs.next()) {
				//retrieve data from each row
				int businessID = rs.getInt("business_id");
				boolean multipleFamilies = rs.getBoolean("multiple_families");
				boolean morning = rs.getBoolean("morning");
				boolean afternoon = rs.getBoolean("afternoon");
				boolean evening = rs.getBoolean("evening");
				boolean kidsFreeDiscount = rs.getBoolean("kids_free_discount");
				String kidsFreeDiscountDetail = rs.getString("kids_free_discount_detail");
				 
				//pass to new object & add to list
				KidFriendlyDetail currentRow = new KidFriendlyDetail(businessID, multipleFamilies, morning, afternoon, evening, kidsFreeDiscount, kidsFreeDiscountDetail);
				theList.add(currentRow);
			}
			//return list
			return theList;
		}
		finally {
			//close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	
	public KidFriendlyDetail get(String theBusinessID) throws Exception {
		
		// create empty KidFriendlyDetail and int businessID
		KidFriendlyDetail theKidFriendlyDetail = null;
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
			
			// create PreparedStatement SELECT theKidFriendlyDetail
			String sql = "SELECT * FROM kid_friendly_stl.kid_friendly_detail WHERE business_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, businessID);
			
			// execute QUERY
			rs = stmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty AgeRange
			if (rs.next()) {
				boolean multipleFamilies = rs.getBoolean("multiple_families");
				boolean morning = rs.getBoolean("morning");
				boolean afternoon = rs.getBoolean("afternoon"); 
				boolean evening = rs.getBoolean("evening"); 
				boolean kidsFreeDiscount = rs.getBoolean("kids_free_discount");
				String kidsFreeDiscountDetail = rs.getString("kids_free_discount_detail");
				
				theKidFriendlyDetail = new KidFriendlyDetail(businessID, multipleFamilies, morning,
						afternoon, evening, kidsFreeDiscount, kidsFreeDiscountDetail);
			}
			else {
				throw new Exception("Could not find kid friendly detail id: " + businessID);
			}
			
			// return object
			return theKidFriendlyDetail;
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

	public void add(KidFriendlyDetail newKidFriendlyDetail) 
			throws Exception {
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.kid_friendly_detail "
					+ "(business_id, multiple_families, morning, afternoon, evening, kids_free_discount, kids_free_discount_detail) "
					+ "values (?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setInt(1, newKidFriendlyDetail.getBusinessID());
			stmt.setBoolean(2, newKidFriendlyDetail.isMultipleFamilies());
			stmt.setBoolean(3, newKidFriendlyDetail.isMorning());
			stmt.setBoolean(4, newKidFriendlyDetail.isAfternoon());
			stmt.setBoolean(5, newKidFriendlyDetail.isEvening());
			stmt.setBoolean(6, newKidFriendlyDetail.isKidsFreeDiscount());
			stmt.setString(7, newKidFriendlyDetail.getKidsFreeDiscountDetail());
			
			// execute SQL INSERT
			stmt.execute();			
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);			
		}
		
	}
	
	public void update(KidFriendlyDetail updatedKidFriendlyDetail) 
			throws Exception {
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.kid_friendly_detail "
					+ "SET multiple_families=?, morning=?, afternoon=?, evening=?, kids_free_discount=?, kids_free_discount_detail=? "
					+ "WHERE business_id=? ";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setBoolean(1, updatedKidFriendlyDetail.isMultipleFamilies());
			stmt.setBoolean(2, updatedKidFriendlyDetail.isMorning());
			stmt.setBoolean(3, updatedKidFriendlyDetail.isAfternoon());
			stmt.setBoolean(4, updatedKidFriendlyDetail.isEvening());
			stmt.setBoolean(5, updatedKidFriendlyDetail.isKidsFreeDiscount());
			stmt.setString(6, updatedKidFriendlyDetail.getKidsFreeDiscountDetail());
			stmt.setInt(7, updatedKidFriendlyDetail.getBusinessID());
			
			// execute SQL INSERT
			stmt.execute();			
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);			
		}
	}


}
