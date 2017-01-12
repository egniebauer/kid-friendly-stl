package com.kidfriendlystl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class RestaurantMenuInfoDAO {

	private DataSource dataSource;

	public RestaurantMenuInfoDAO(DataSource theDataSource) {
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

	public List<RestaurantMenuInfo> getAll() throws Exception {
		
		// create empty list
		List<RestaurantMenuInfo> theList = new ArrayList<>();
		
		// create JDBC objects
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
					
			// create a sql statement
			String sql = "SELECT * FROM kid_friendly_stl.restaurant_menu_information";
			myStmt = myConn.createStatement();
			
			// execute the query
			myRS = myStmt.executeQuery(sql);
			
			// process the ResultSet
			while (myRS.next()) {
				
				// retrieve data and set params
				int businessID = myRS.getInt("business_id");
				boolean highChair = myRS.getBoolean("high_chair");
				boolean booster = myRS.getBoolean("booster");
				boolean activities = myRS.getBoolean("activities");
				boolean healthy = myRS.getBoolean("healthy");
				boolean allergyFriendly = myRS.getBoolean("allergy_friendly");
				boolean unhealthy = myRS.getBoolean("unhealthy");
				boolean noKidsMenu = myRS.getBoolean("no_kids_menu");
				boolean manyOpts = myRS.getBoolean("many_opts");
				boolean someOpts = myRS.getBoolean("some_opts");
				boolean fewOpts = myRS.getBoolean("few_opts");
				boolean noOpts = myRS.getBoolean("no_opts");
				
				// pass params to new object
				RestaurantMenuInfo currentRow = new RestaurantMenuInfo(businessID, highChair, booster, activities, healthy, allergyFriendly, unhealthy, noKidsMenu, manyOpts, someOpts, fewOpts, noOpts);
				
				// add object to list
				theList.add(currentRow);
			}
			// return list
			return theList;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}
	
	public RestaurantMenuInfo get(String theBusinessID) throws Exception {
		
		// create an empty object & create int id
		RestaurantMenuInfo selectedRow;
		int businessID;
		
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRS = null;
		
		try {
			// convert string to int for business id
			businessID = Integer.parseInt(theBusinessID);
			
			// get a connection
			myConn = dataSource.getConnection();
			
			// create a PreparedStatement
			String sql = "SELECT * FROM kid_friendly_stl.restaurant_menu_information "
					+ "WHERE business_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, businessID);
			
			// execute the query
			myRS = myStmt.executeQuery();
			
			//process the results
			if (myRS.next()) {
				//retrieve data and assign to variables
				boolean highChair = myRS.getBoolean("high_chair");
				boolean booster = myRS.getBoolean("booster");
				boolean activities = myRS.getBoolean("activities");
				boolean healthy = myRS.getBoolean("healthy");
				boolean allergyFriendly = myRS.getBoolean("allergy_friendly");
				boolean unhealthy = myRS.getBoolean("unhealthy");
				boolean noKidsMenu = myRS.getBoolean("no_kids_menu");
				boolean manyOpts = myRS.getBoolean("many_opts");
				boolean someOpts = myRS.getBoolean("some_opts");
				boolean fewOpts = myRS.getBoolean("few_opts");
				boolean noOpts = myRS.getBoolean("no_opts");
				
				//pass parameters to empty object
				selectedRow = new RestaurantMenuInfo(businessID, highChair, booster, activities, healthy, allergyFriendly, unhealthy, noKidsMenu, manyOpts, someOpts, fewOpts, noOpts);
			}
			else {
				throw new Exception ("Could not find play area id: " + businessID);
			}
			// return object
			return selectedRow;
		}
		finally{
			// close JDBC objects
			close(myConn, myStmt, myRS);
		}
	}
	
	public void add(RestaurantMenuInfo newRestaurantMenuInfo) throws Exception {
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
					
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.restaurant_menu_information "
					+ "(business_id, high_chair, booster, activities, healthy, allergy_friendly, unhealthy, no_kids_menu, many_opts, some_opts, few_opts, no_opts) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setInt(1, newRestaurantMenuInfo.getBusinessID());
			myStmt.setBoolean(2, newRestaurantMenuInfo.isHighChair());
			myStmt.setBoolean(3, newRestaurantMenuInfo.isBooster());
			myStmt.setBoolean(4, newRestaurantMenuInfo.isActivities());
			myStmt.setBoolean(5, newRestaurantMenuInfo.isHealthy());
			myStmt.setBoolean(6, newRestaurantMenuInfo.isAllergyFriendly());
			myStmt.setBoolean(7, newRestaurantMenuInfo.isUnhealthy());
			myStmt.setBoolean(8, newRestaurantMenuInfo.isNoKidsMenu());
			myStmt.setBoolean(9, newRestaurantMenuInfo.isManyOpts());
			myStmt.setBoolean(10, newRestaurantMenuInfo.isSomeOpts());
			myStmt.setBoolean(11, newRestaurantMenuInfo.isFewOpts());
			myStmt.setBoolean(12, newRestaurantMenuInfo.isNoOpts());
			
			// execute INSERT
			myStmt.execute();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
	}
	
	public void update(RestaurantMenuInfo updatedRestaurantMenuInfo) throws Exception {
		// create JDBC objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get connection
			myConn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.restaurant_menu_information "
					+ "SET high_chair=?, booster=?, activities=?, healthy=?, allergy_friendly=?, unhealthy=?, no_kids_menu=?, many_opts=?, some_opts=?, few_opts=?, no_opts=? "
					+ "WHERE business_id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set param values
			myStmt.setBoolean(1, updatedRestaurantMenuInfo.isHighChair());
			myStmt.setBoolean(2, updatedRestaurantMenuInfo.isBooster());
			myStmt.setBoolean(3, updatedRestaurantMenuInfo.isActivities());
			myStmt.setBoolean(4, updatedRestaurantMenuInfo.isHealthy());
			myStmt.setBoolean(5, updatedRestaurantMenuInfo.isAllergyFriendly());
			myStmt.setBoolean(6, updatedRestaurantMenuInfo.isUnhealthy());
			myStmt.setBoolean(7, updatedRestaurantMenuInfo.isNoKidsMenu());
			myStmt.setBoolean(8, updatedRestaurantMenuInfo.isManyOpts());
			myStmt.setBoolean(9, updatedRestaurantMenuInfo.isSomeOpts());
			myStmt.setBoolean(10, updatedRestaurantMenuInfo.isFewOpts());
			myStmt.setBoolean(11, updatedRestaurantMenuInfo.isNoOpts());
			myStmt.setInt(12, updatedRestaurantMenuInfo.getBusinessID());

			// execute UPDATE
			myStmt.execute();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}
	}
}
