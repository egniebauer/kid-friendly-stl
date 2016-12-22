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

	public List<Category> getAll() 
			throws Exception {
		
		// create empty list
		List<Category> categories = new ArrayList<>();
		
		// create JDBC objects
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "SELECT * FROM kid_friendly_stl.category";
			myStmt = myConn.createStatement();

			// execute query
			myRS = myStmt.executeQuery(sql);

			// process result set
			while (myRS.next()){
				//retrieve data from ResultSet row
				int businessID = myRS.getInt("business_id");
				boolean activeLife = myRS.getBoolean("active_life");
				boolean artsEntertainment = myRS.getBoolean("arts_entertainment");
				boolean education = myRS.getBoolean("education");
				boolean foodRestaurant = myRS.getBoolean("food_restaurant");
				boolean healthMedical = myRS.getBoolean("health_medical");
				boolean hotelTravel = myRS.getBoolean("hotel_travel");
				boolean publicServiceGovernment = myRS.getBoolean("public_service_government");
				boolean religious = myRS.getBoolean("religious");
				boolean shopping = myRS.getBoolean("shopping");
				
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
			close(myConn, myStmt, myRS);
		}
	}

	public Category get(String theBusinessID) 
			throws Exception {
		
		// create empty Category and int businessID
		Category theCategory = null;
		int businessID;
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// convert theBusinessID to int
			businessID = Integer.parseInt(theBusinessID);
			
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement SELECT theCategory
			String sql = "SELECT * FROM kid_friendly_stl.category WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute QUERY
			myRS = myStmt.executeQuery();
			
			// retrieve data from ResultSet and assign to empty Category
			if (myRS.next()) {
				boolean activeLife = myRS.getBoolean("active_life");
				boolean artsEntertainment = myRS.getBoolean("arts_entertainment");
				boolean education = myRS.getBoolean("education");
				boolean foodRestaurant = myRS.getBoolean("food_restaurant");
				boolean healthMedical = myRS.getBoolean("health_medical");
				boolean hotelTravel = myRS.getBoolean("hotel_travel");
				boolean publicServiceGovernment = myRS.getBoolean("public_service_government");
				boolean religious = myRS.getBoolean("religious");
				boolean shopping = myRS.getBoolean("shopping"); 
				
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
			close(myConn, myStmt, myRS);
		}
	}

	public void add(Category newCategory) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.category "
					+ "(business_id, active_life, arts_entertainment, education, food_restaurant, health_medical, hotel_travel, public_service_government, religious, shopping) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setInt(1, newCategory.getBusinessID());
			myStmt.setBoolean(2, newCategory.isActiveLife());
			myStmt.setBoolean(3, newCategory.isArtsEntertainment());
			myStmt.setBoolean(4, newCategory.isEducation());
			myStmt.setBoolean(5, newCategory.isFoodRestaurant());
			myStmt.setBoolean(6, newCategory.isHealthMedical());
			myStmt.setBoolean(7, newCategory.isHotelTravel());
			myStmt.setBoolean(8, newCategory.isPublicServiceGovernment());
			myStmt.setBoolean(9, newCategory.isReligious());
			myStmt.setBoolean(10, newCategory.isShopping());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
		
	}

	public void update(Category updatedCategory) 
			throws Exception {
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.category "
					+ "SET active_life=?, arts_entertainment=?, education=?, food_restaurant=?, health_medical=?, hotel_travel=?, public_service_government=?, religious=?, shopping=? "
					+ "WHERE business_id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setBoolean(1, updatedCategory.isActiveLife());
			myStmt.setBoolean(2, updatedCategory.isArtsEntertainment());
			myStmt.setBoolean(3, updatedCategory.isEducation());
			myStmt.setBoolean(4, updatedCategory.isFoodRestaurant());
			myStmt.setBoolean(5, updatedCategory.isHealthMedical());
			myStmt.setBoolean(6, updatedCategory.isHotelTravel());
			myStmt.setBoolean(7, updatedCategory.isPublicServiceGovernment());
			myStmt.setBoolean(8, updatedCategory.isReligious());
			myStmt.setBoolean(9, updatedCategory.isShopping());
			myStmt.setInt(10, updatedCategory.getBusinessID());
			
			// execute SQL INSERT
			myStmt.execute();			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);			
		}
		
	}


}
