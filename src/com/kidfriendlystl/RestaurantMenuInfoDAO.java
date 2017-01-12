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

	public List<RestaurantMenuInfo> getAll() throws Exception {
		
		// create empty list
		List<RestaurantMenuInfo> theList = new ArrayList<>();
		
		// create JDBC objects
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
					
			// create a sql statement
			String sql = "SELECT * FROM kid_friendly_stl.restaurant_menu_information";
			stmt = conn.createStatement();
			
			// execute the query
			rs = stmt.executeQuery(sql);
			
			// process the ResultSet
			while (rs.next()) {
				
				// retrieve data and set params
				int businessID = rs.getInt("business_id");
				boolean highChair = rs.getBoolean("high_chair");
				boolean booster = rs.getBoolean("booster");
				boolean activities = rs.getBoolean("activities");
				boolean healthy = rs.getBoolean("healthy");
				boolean allergyFriendly = rs.getBoolean("allergy_friendly");
				boolean unhealthy = rs.getBoolean("unhealthy");
				boolean noKidsMenu = rs.getBoolean("no_kids_menu");
				boolean manyOpts = rs.getBoolean("many_opts");
				boolean someOpts = rs.getBoolean("some_opts");
				boolean fewOpts = rs.getBoolean("few_opts");
				boolean noOpts = rs.getBoolean("no_opts");
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	
	public RestaurantMenuInfo get(String theBusinessID) throws Exception {
		
		// create an empty object & create int id
		RestaurantMenuInfo selectedRow;
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
			String sql = "SELECT * FROM kid_friendly_stl.restaurant_menu_information "
					+ "WHERE business_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, businessID);
			
			// execute the query
			rs = stmt.executeQuery();
			
			//process the results
			if (rs.next()) {
				//retrieve data and assign to variables
				boolean highChair = rs.getBoolean("high_chair");
				boolean booster = rs.getBoolean("booster");
				boolean activities = rs.getBoolean("activities");
				boolean healthy = rs.getBoolean("healthy");
				boolean allergyFriendly = rs.getBoolean("allergy_friendly");
				boolean unhealthy = rs.getBoolean("unhealthy");
				boolean noKidsMenu = rs.getBoolean("no_kids_menu");
				boolean manyOpts = rs.getBoolean("many_opts");
				boolean someOpts = rs.getBoolean("some_opts");
				boolean fewOpts = rs.getBoolean("few_opts");
				boolean noOpts = rs.getBoolean("no_opts");
				
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
			DatabaseUtils.close(conn, stmt, rs);
		}
	}
	
	public void add(RestaurantMenuInfo newRestaurantMenuInfo) throws Exception {
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
					
			// create PreparedStatement for INSERT
			String sql = "INSERT INTO kid_friendly_stl.restaurant_menu_information "
					+ "(business_id, high_chair, booster, activities, healthy, allergy_friendly, unhealthy, no_kids_menu, many_opts, some_opts, few_opts, no_opts) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setInt(1, newRestaurantMenuInfo.getBusinessID());
			stmt.setBoolean(2, newRestaurantMenuInfo.isHighChair());
			stmt.setBoolean(3, newRestaurantMenuInfo.isBooster());
			stmt.setBoolean(4, newRestaurantMenuInfo.isActivities());
			stmt.setBoolean(5, newRestaurantMenuInfo.isHealthy());
			stmt.setBoolean(6, newRestaurantMenuInfo.isAllergyFriendly());
			stmt.setBoolean(7, newRestaurantMenuInfo.isUnhealthy());
			stmt.setBoolean(8, newRestaurantMenuInfo.isNoKidsMenu());
			stmt.setBoolean(9, newRestaurantMenuInfo.isManyOpts());
			stmt.setBoolean(10, newRestaurantMenuInfo.isSomeOpts());
			stmt.setBoolean(11, newRestaurantMenuInfo.isFewOpts());
			stmt.setBoolean(12, newRestaurantMenuInfo.isNoOpts());
			
			// execute INSERT
			stmt.execute();
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
	}
	
	public void update(RestaurantMenuInfo updatedRestaurantMenuInfo) throws Exception {
		// create JDBC objects
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get connection
			conn = dataSource.getConnection();
			
			// create PreparedStatement for UPDATE
			String sql = "UPDATE kid_friendly_stl.restaurant_menu_information "
					+ "SET high_chair=?, booster=?, activities=?, healthy=?, allergy_friendly=?, unhealthy=?, no_kids_menu=?, many_opts=?, some_opts=?, few_opts=?, no_opts=? "
					+ "WHERE business_id=?";
			
			stmt = conn.prepareStatement(sql);
			
			// set param values
			stmt.setBoolean(1, updatedRestaurantMenuInfo.isHighChair());
			stmt.setBoolean(2, updatedRestaurantMenuInfo.isBooster());
			stmt.setBoolean(3, updatedRestaurantMenuInfo.isActivities());
			stmt.setBoolean(4, updatedRestaurantMenuInfo.isHealthy());
			stmt.setBoolean(5, updatedRestaurantMenuInfo.isAllergyFriendly());
			stmt.setBoolean(6, updatedRestaurantMenuInfo.isUnhealthy());
			stmt.setBoolean(7, updatedRestaurantMenuInfo.isNoKidsMenu());
			stmt.setBoolean(8, updatedRestaurantMenuInfo.isManyOpts());
			stmt.setBoolean(9, updatedRestaurantMenuInfo.isSomeOpts());
			stmt.setBoolean(10, updatedRestaurantMenuInfo.isFewOpts());
			stmt.setBoolean(11, updatedRestaurantMenuInfo.isNoOpts());
			stmt.setInt(12, updatedRestaurantMenuInfo.getBusinessID());

			// execute UPDATE
			stmt.execute();
		}
		finally {
			// close JDBC objects
			DatabaseUtils.close(conn, stmt, null);
		}
	}
}
