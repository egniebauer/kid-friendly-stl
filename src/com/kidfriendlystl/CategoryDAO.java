package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class CategoryDAO {

	private DataSource dataSource;

	public CategoryDAO(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}

	public List<Category> getAll() throws Exception {
		
		// create empty list
		List<Category> categories = new ArrayList<>();
		
		// create JDBC objects
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.category";
			stmt = conn.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			// process result set
			while (rs.next()){
				//retrieve data from ResultSet row
				int businessID = rs.getInt("business_id");
				boolean activeLife = rs.getBoolean("active_life");
				boolean artsEntertainment = rs.getBoolean("arts_entertainment");
				boolean education = rs.getBoolean("education");
				boolean foodRestaurant = rs.getBoolean("food_restaurant");
				boolean healthMedical = rs.getBoolean("health_medical");
				boolean hotelTravel = rs.getBoolean("hotel_travel");
				boolean publicServiceGovernment = rs.getBoolean("public_service_government");
				boolean religious = rs.getBoolean("religious");
				boolean shopping = rs.getBoolean("shopping");
				
				// create new Business object
				Category currentBusiness = new Category(businessID,  activeLife,  artsEntertainment,  education,
						 foodRestaurant,  healthMedical,  hotelTravel,  publicServiceGovernment,
						 religious,  shopping);
				
				// add Student object to list
				categories.add(currentBusiness);
			}
			// return list
			return categories;
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

	public Category get(String theBusinessID) 
			throws Exception {
		
		// create empty Category and int businessID
		Category theCategory = null;
		int businessID;
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// convert theBusinessID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theCategory
			String sql = "SELECT * FROM kid_friendly_stl.category WHERE business_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, businessID);
			
			// execute QUERY
			rs = stmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty Category
			if (rs.next()) {
				boolean activeLife = rs.getBoolean("active_life");
				boolean artsEntertainment = rs.getBoolean("arts_entertainment");
				boolean education = rs.getBoolean("education");
				boolean foodRestaurant = rs.getBoolean("food_restaurant");
				boolean healthMedical = rs.getBoolean("health_medical");
				boolean hotelTravel = rs.getBoolean("hotel_travel");
				boolean publicServiceGovernment = rs.getBoolean("public_service_government");
				boolean religious = rs.getBoolean("religious");
				boolean shopping = rs.getBoolean("shopping"); 
				
				theCategory = new Category(businessID, activeLife, artsEntertainment, education,
						foodRestaurant, healthMedical, hotelTravel, publicServiceGovernment,
						religious, shopping);
			}
			else {
				throw new Exception("Could not find category id: " + businessID);
			}
			
			// return Category
			return theCategory;
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, rs);
		}
	}

	public void add(Category newCategory) 
			throws Exception {
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.category "
					+ "(business_id, active_life, arts_entertainment, education, food_restaurant, health_medical, hotel_travel, public_service_government, religious, shopping) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setInt(1, newCategory.getBusinessID());
			stmt.setBoolean(2, newCategory.isActiveLife());
			stmt.setBoolean(3, newCategory.isArtsEntertainment());
			stmt.setBoolean(4, newCategory.isEducation());
			stmt.setBoolean(5, newCategory.isFoodRestaurant());
			stmt.setBoolean(6, newCategory.isHealthMedical());
			stmt.setBoolean(7, newCategory.isHotelTravel());
			stmt.setBoolean(8, newCategory.isPublicServiceGovernment());
			stmt.setBoolean(9, newCategory.isReligious());
			stmt.setBoolean(10, newCategory.isShopping());
			
			// execute SQL INSERT
			stmt.execute();			
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);			
		}
		
	}

	public void update(Category updatedCategory) 
			throws Exception {
		
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.category "
					+ "SET active_life=?, arts_entertainment=?, education=?, food_restaurant=?, health_medical=?, hotel_travel=?, public_service_government=?, religious=?, shopping=? "
					+ "WHERE business_id=?";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setBoolean(1, updatedCategory.isActiveLife());
			stmt.setBoolean(2, updatedCategory.isArtsEntertainment());
			stmt.setBoolean(3, updatedCategory.isEducation());
			stmt.setBoolean(4, updatedCategory.isFoodRestaurant());
			stmt.setBoolean(5, updatedCategory.isHealthMedical());
			stmt.setBoolean(6, updatedCategory.isHotelTravel());
			stmt.setBoolean(7, updatedCategory.isPublicServiceGovernment());
			stmt.setBoolean(8, updatedCategory.isReligious());
			stmt.setBoolean(9, updatedCategory.isShopping());
			stmt.setInt(10, updatedCategory.getBusinessID());
			
			// execute SQL UPDATE
			stmt.execute();			
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);			
		}
		
	}


}
